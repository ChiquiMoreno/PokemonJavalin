package edu.masanz.da.cw.controller;

import edu.masanz.da.cw.model.Usuario;
import edu.masanz.da.cw.service.UsuarioService;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class AuthController {

    private static UsuarioService usuarioService = new UsuarioService();

    public static void login(Context ctx) {
        ctx.render("/templates/index.ftl");
    }

    public static void procesarLogin(Context ctx) {

        String idUser = ctx.formParam("idUser");
        String password = ctx.formParam("password");

        Usuario usuario = usuarioService.autenticar(idUser, password);

        if (usuario != null) {
            ctx.sessionAttribute("idUser", idUser);
            ctx.redirect("/torneos");
        } else {
            ctx.render("/templates/index.ftl",
                    Map.of("error", "Credenciales inválidas"));
        }
    }

    public static void logout(Context ctx) {
//        ctx.req().getSession().invalidate();// invalidamos la sesión, eliminar todos los atributos
        ctx.req().getSession().removeAttribute("ºz");// eliminamos solo el atributo iduser
        ctx.redirect("/");
    }

}
