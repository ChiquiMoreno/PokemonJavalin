package edu.masanz.da.cw.controller;

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
//        List<Liga> listaLigas= ;

        Map<String,Object> model = new HashMap<>();
        model.put("nombreApellido", nombreApellido);
        model.put("listaLigas", ligaLogicService.getAllLigas());
        ctx.render("/templates/torneos.ftl", model);
    }

    public static void procesarLiga(Context ctx) {
        int idLiga;
//        LigaLogicService.comprobarCantidadLiga(idLiga);

    }

    public static void servirCrearLiga(@NotNull Context ctx) {
        ctx.render("/templates/crearliga.ftl");
    }

    public static void mostrarTorneo(@NotNull Context context) {
        int idLiga = Integer.parseInt(context.pathParam("idLiga"));
        Map<String, Object> model = new HashMap<>();
        Liga liga = LigaLogicService.getLiga(idLiga);
    }

    public static void listarUsuarios(Context ctx) {
        String idLiga = obtenerLiga(ctx);
        //TODO
        ctx.render("/templates/inscripcion.ftl",
                Map.of(
                        "idLiga", idLiga,
                        "usuarios", ligaLogicService.listarUsuarios()
                )
        );
    }

    public static String obtenerLiga(Context ctx) {
        String idLiga = ctx.sessionAttribute("idLiga");
        return idLiga != null ? idLiga : "";
    }

}
