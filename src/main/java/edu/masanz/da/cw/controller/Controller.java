package edu.masanz.da.cw.controller;

import edu.masanz.da.cw.model.Usuario;
import edu.masanz.da.cw.service.UsuarioService;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class Controller {
    private static UsuarioService usuarioService = new UsuarioService();

    public static void torneos(@NotNull Context ctx) {
        String alias = ctx.sessionAttribute("alias");
        Map<String,Object> model = new HashMap<>();
        Usuario usuario = usuarioService.getUsuarioByAlias(alias);
        String nombreApellido = usuario.getNombre()+" "+usuario.getApellido() ;

        model.put("nombreApellido", nombreApellido);
        ctx.render("/templates/torneos.ftl", model);
    }

    public static void maestros(@NotNull Context ctx) {
        String alias = ctx.sessionAttribute("alias");
        Map<String,Object> model = new HashMap<>();
        Usuario usuario = usuarioService.getUsuarioByAlias(alias);
        String nombreApellido = usuario.getNombre()+" "+usuario.getApellido() ;
        model.put("nombreApellido", nombreApellido);
        ctx.render("/templates/maestros.ftl",model);


    }

    public static void crearliga(@NotNull Context ctx) {
        ctx.render("/templates/crearliga.ftl");
    }

    public static void perfil(@NotNull Context ctx) {
        String alias = ctx.sessionAttribute("alias");
        Map<String,Object> model = new HashMap<>();
        Usuario usuario = usuarioService.getUsuarioByAlias(alias);
        String nombreApellido = usuario.getNombre()+" "+usuario.getApellido() ;
        model.put("nombreApellido", nombreApellido);
        model.put("alias", alias);
        ctx.render("/templates/maestros.ftl",model);
    }

    public static void registro(@NotNull Context ctx) {
        Map<String,Object> model = new HashMap<>();
        ctx.render("/templates/registro.ftl",model);
    }
}
