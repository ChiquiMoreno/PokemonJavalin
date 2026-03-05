package edu.masanz.da.cw.controller;

import edu.masanz.da.cw.service.UsuarioService;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;



public class UsuarioController {
    public static void registro(@NotNull Context ctx) {
        String alias= ctx.formParam("alias");
        String password= ctx.formParam("password");
        String nombre= ctx.formParam("nombre");
        String apellido= ctx.formParam("apellido");
        UsuarioService usuarioService = new UsuarioService();
        usuarioService.crearUsuario(alias,password,nombre,apellido);

        ctx.sessionAttribute("alias", alias);
        ctx.redirect("/logueado/torneos");


    }
}
