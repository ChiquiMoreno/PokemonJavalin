package edu.masanz.da.cw.controller;

import edu.masanz.da.cw.model.*;
import edu.masanz.da.cw.service.LigaLogicService;
import edu.masanz.da.cw.service.PartidaLogicService;
import edu.masanz.da.cw.service.UsuarioService;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class LigaController {
    private static final UsuarioService usuarioService = new UsuarioService();
    private static final LigaLogicService ligaLogicService = new LigaLogicService();
    private static final PartidaLogicService partidaLogicService = new PartidaLogicService();

    private static final Map<Integer, EstadoPartida> partidasPorLiga = new HashMap<>();

    private static class EstadoPartida {
        private int rondaActual;
        private int rondasTotales;
        private List<Jugador> jugadores;
        private Partida partida;
    }

    public static void torneos(@NotNull Context ctx) {
        Map<String, Object> model = crearModeloBase(ctx);
        model.put("titulo", "Torneos");
        model.put("listaLigas", ligaLogicService.getAllLigas());
        ctx.render("/templates/torneos.ftl", model);
    }

    public static void servirCrearLiga(@NotNull Context ctx) {
        Map<String, Object> model = crearModeloBase(ctx);
        ctx.render("/templates/crearliga.ftl", model);
    }

    public static void nuevaLiga(@NotNull Context ctx) {
        Liga nuevaLiga = new Liga();
        switch (ctx.formParam("tipo")) {
            case "1":
                nuevaLiga.setTipo("Competitivo estándar");
                break;
            case "2":
                nuevaLiga.setTipo("Expandido");
                break;
            case "3":
                nuevaLiga.setTipo("Desafío líder de gimnasio");
                break;
            case "4":
                nuevaLiga.setTipo("Amistoso");
                break;
        }
        nuevaLiga.setFecha(ctx.formParam("dia") + " " + ctx.formParam("hora"));
        nuevaLiga.setLugar(ctx.formParam("lugar"));
        nuevaLiga.setRondas(ctx.formParam("rondas"));

        ligaLogicService.nuevaLiga(nuevaLiga);
        Map<String, Object> model = crearModeloBase(ctx);
        model.put("liga", nuevaLiga);
        ctx.render("/templates/inscripcion.ftl", model);
    }

    public static void mostrarTorneo(@NotNull Context context) {
        int idLiga = Integer.parseInt(context.pathParam("idLiga"));
        Map<String, Object> model = crearModeloBase(context);
        model.put("liga", LigaLogicService.getLiga(idLiga));
        model.put("jugadores", UsuarioService.getJugadoresTorneo(idLiga));
        context.render("templates/infotorneo.ftl", model);
    }

    public static String obtenerLiga(Context ctx) {
        String idLiga = ctx.sessionAttribute("idLiga");
        return idLiga != null ? idLiga : "";
    }

    public static void mostrarSinPartida(@NotNull Context ctx) {
        String alias = ctx.sessionAttribute("alias");
        Usuario usuario = usuarioService.getUsuarioByAlias(alias);
        String nombreApellido = usuario.getNombre()+" "+usuario.getApellido() ;
        String titulo = "Liga activa";
        Map<String,Object> model = new HashMap<>();
        model.put("nombreApellido", nombreApellido);
        model.put("titulo",titulo);
        ctx.render("/templates/sin-partida.ftl",model);
    }

    public static void redirigirPartidaEnCurso(@NotNull Context ctx) {
        Optional<Integer> ligaEnCursoId = LigaLogicService.getLigaEnCursoId();
        if (ligaEnCursoId.isPresent()) {
            ctx.redirect("/logueado/partidas/" + ligaEnCursoId.get());
            return;
        }
        ctx.redirect("/logueado/sin-partida");
    }

    public static void mostrarPartidas(@NotNull Context ctx) {
        int idLiga = Integer.parseInt(ctx.pathParam("idLiga"));
        EstadoPartida estado = partidasPorLiga.get(idLiga);

        if (estado == null) {
            estado = inicializarEstadoPartida(idLiga);
            if (estado == null || estado.partida == null) {
                ctx.redirect("/logueado/sin-partida");
                return;
            }
            partidasPorLiga.put(idLiga, estado);
        }

        Map<String, Object> model = crearModeloPartida(ctx, estado, idLiga);
        ctx.render("/templates/partidas.ftl", model);
    }

    public static void guardarResultadoMesa(@NotNull Context ctx) {
        int idLiga = Integer.parseInt(ctx.pathParam("idLiga"));
        int mesaId = Integer.parseInt(Objects.requireNonNull(ctx.formParam("mesaId")));
        String resultado = Objects.requireNonNull(ctx.formParam("resultado"));

        EstadoPartida estado = partidasPorLiga.get(idLiga);
        if (estado == null || estado.partida == null) {
            ctx.redirect("/logueado/partidas/" + idLiga);
            return;
        }

        Mesa mesa = estado.partida.getMesaById(mesaId);
        if (mesa != null) {
            mesa.setEmpate(false);
            if ("A".equalsIgnoreCase(resultado) && mesa.getJugadorA() != null) {
                mesa.setGanadorMesa(mesa.getJugadorA().getAliasJugador());
            } else if ("B".equalsIgnoreCase(resultado) && mesa.getJugadorB() != null) {
                mesa.setGanadorMesa(mesa.getJugadorB().getAliasJugador());
            } else if ("E".equalsIgnoreCase(resultado)) {
                mesa.setGanadorMesa(null);
                mesa.setEmpate(true);
            }
        }

        ctx.redirect("/logueado/partidas/" + idLiga);
    }

    public static void siguienteRonda(@NotNull Context ctx) {
        int idLiga = Integer.parseInt(ctx.pathParam("idLiga"));
        EstadoPartida estado = partidasPorLiga.get(idLiga);
        if (estado == null || estado.partida == null) {
            ctx.redirect("/logueado/partidas/" + idLiga);
            return;
        }

        List<String> ganadoresRonda = new ArrayList<>();
        int totalMesas = estado.partida.getCantidadMesa();

        for (int mesaId = 1; mesaId <= totalMesas; mesaId++) {
            Mesa mesa = estado.partida.getMesaById(mesaId);
            if (mesa == null) {
                continue;
            }
            String resultadoMesa = ctx.formParam("resultadoMesa_" + mesaId);
            mesa.setEmpate(false);
            if ("A".equalsIgnoreCase(resultadoMesa) && mesa.getJugadorA() != null) {
                mesa.setGanadorMesa(mesa.getJugadorA().getAliasJugador());
                ganadoresRonda.add(mesa.getJugadorA().getAliasJugador());
            } else if ("B".equalsIgnoreCase(resultadoMesa) && mesa.getJugadorB() != null) {
                mesa.setGanadorMesa(mesa.getJugadorB().getAliasJugador());
                ganadoresRonda.add(mesa.getJugadorB().getAliasJugador());
            } else {
                mesa.setGanadorMesa(null);
                mesa.setEmpate(true);
            }
        }

        estado.partida.setGanadores(ganadoresRonda);

        for (int mesaId = 1; mesaId <= totalMesas; mesaId++) {
            Mesa mesa = estado.partida.getMesaById(mesaId);
            if (mesa != null) {
                partidaLogicService.calcularEnfrentamiento(mesa);
            }
        }

        if (estado.rondaActual >= estado.rondasTotales) {
            LigaLogicService.finalizarLiga(idLiga);
            partidasPorLiga.remove(idLiga);
            ctx.redirect("/logueado/torneos/" + idLiga);
            return;
        }

        estado.jugadores = partidaLogicService.ordenarJugadores(estado.jugadores);
        estado.partida = partidaLogicService.iniciarPartida(estado.jugadores);
        estado.rondaActual++;

        ctx.redirect("/logueado/partidas/" + idLiga);
    }

    private static EstadoPartida inicializarEstadoPartida(int idLiga) {
        if (!LigaLogicService.iniciarLiga(idLiga)) {
            return null;
        }

        List<Jugador> jugadores = UsuarioService.getJugadoresTorneo(idLiga);
        if (jugadores == null || jugadores.size() < 2 || jugadores.size() % 2 == 1) {
            LigaLogicService.marcarLigaComoPendiente(idLiga);
            return null;
        }

        Liga liga = LigaLogicService.getLiga(idLiga);
        liga.setJugadoresApuntados(jugadores);
        boolean ok = ligaLogicService.calculoPartidas(liga);
        if (!ok) {
            LigaLogicService.marcarLigaComoPendiente(idLiga);
            return null;
        }

        EstadoPartida estado = new EstadoPartida();
        estado.rondaActual = 1;
        estado.rondasTotales = liga.getNumPartidas();
        estado.jugadores = new ArrayList<>(jugadores);
        estado.partida = partidaLogicService.iniciarPartida(estado.jugadores);
        return estado;
    }

    private static Map<String, Object> crearModeloPartida(Context ctx, EstadoPartida estado, int idLiga) {
        Map<String, Object> model = crearModeloBase(ctx);
        model.put("partida", estado.partida);
        model.put("numRondaActual", estado.rondaActual);
        model.put("numRondasTotales", estado.rondasTotales);
        model.put("idLiga", idLiga);
        return model;
    }

    private static Map<String, Object> crearModeloBase(Context ctx) {
        Map<String, Object> model = new HashMap<>();
        String alias = ctx.sessionAttribute("alias");
        if (alias != null) {
            Usuario usuario = usuarioService.getUsuarioByAlias(alias);
            if (usuario != null) {
                model.put("nombreApellido", usuario.getNombre() + " " + usuario.getApellido());
            }
        }
        model.put("ligaEnCursoId", LigaLogicService.getLigaEnCursoId().orElse(null));
        return model;
    }

    public static void eliminarLiga(@NotNull Context context) {//todo eliminar liga
        String liga = context.pathParam("idLiga");
        ligaLogicService.eliminarLiga(liga);
        context.redirect("/logueado/torneos");
    }

    private static void cargarNombreUsuarioSesion(Context ctx, Map<String, Object> model) {
        String alias = ctx.sessionAttribute("alias");
        Usuario usuario = usuarioService.getUsuarioByAlias(alias);
        if (usuario != null) {
            model.put("nombreApellido", usuario.getNombre() + " " + usuario.getApellido());
        }
    }
}
