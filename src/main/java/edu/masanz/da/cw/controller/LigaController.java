package edu.masanz.da.cw.controller;

import edu.masanz.da.cw.db.ConnectionManager;
import edu.masanz.da.cw.model.*;
import edu.masanz.da.cw.service.*;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LigaController {
    private static UsuarioService usuarioService = new UsuarioService();
    private static LigaLogicService ligaLogicService = new LigaLogicService();

    public static void torneos(@NotNull Context ctx) {
        LigaLogicService ligaLogicService = new LigaLogicService();

        String alias = ctx.sessionAttribute("alias");
        Usuario usuario = usuarioService.getUsuarioByAlias(alias);
        String nombreApellido = usuario.getNombre()+" "+usuario.getApellido() ;
        String titulo = "Torneos";
        Map<String,Object> model = new HashMap<>();
        model.put("titulo", titulo);
        model.put("nombreApellido", nombreApellido);
        model.put("listaLigas", ligaLogicService.getAllLigas());

        ctx.render("/templates/torneos.ftl", model);
    }

    public static void procesarLiga(Context ctx) {
        int idLiga = 0;
        LigaLogicService.comprobarCantidadLiga(idLiga);

    }

    public static void servirCrearLiga(@NotNull Context ctx) {
        ctx.render("/templates/crearliga.ftl");
    }

    public static void nuevaLiga(@NotNull Context ctx) {
        //TODO: Crear la liga en bbdd
        //Construir la liga con lo que viene
        Liga nuevaLiga = new Liga();
        switch (ctx.formParam("tipo")){
            case "1": nuevaLiga.setTipo("Competitivo estándar"); break;
            case "2": nuevaLiga.setTipo("Expandido"); break;
            case "3": nuevaLiga.setTipo("Desafío líder de gimnasio"); break;
            case "4": nuevaLiga.setTipo("Amistoso"); break;
        }
        nuevaLiga.setFecha(ctx.formParam("dia") + " " + ctx.formParam("hora"));
        nuevaLiga.setLugar(ctx.formParam("lugar"));
        nuevaLiga.setRondas(ctx.formParam("rondas"));

        //Pasar a crear en base datos
        ligaLogicService.nuevaLiga(nuevaLiga);
        Map<String,Object> model = new HashMap<>();
        model.put("liga", nuevaLiga);
        ctx.render("/templates/inscripcion.ftl", model);
    }

    public static void mostrarTorneo(@NotNull Context context) {
        UsuarioService usuarioService = new UsuarioService();
        System.out.println(context.pathParam("idLiga"));
        int idLiga = Integer.parseInt(context.pathParam("idLiga"));
        Map<String, Object> model = new HashMap<>();
        model.put("liga",LigaLogicService.getLiga(idLiga));
        model.put("jugadores", UsuarioService.getJugadoresTorneo(idLiga));
        Usuario usuario = usuarioService.getUsuarioByAlias(context.sessionAttribute("alias"));
        String nombreApellido = usuario.getNombre()+ " "+ usuario.getApellido();
        model.put("nombreApellido", nombreApellido);
        context.render("templates/torneo.ftl",model);
    }



    public static String obtenerLiga(Context ctx) {
        String idLiga = ctx.sessionAttribute("idLiga");
        return idLiga != null ? idLiga : "";
    }

    public static void mostrarSinPartida(@NotNull Context ctx) {
        ctx.render("/templates/sin-partida.ftl");
    }



}
