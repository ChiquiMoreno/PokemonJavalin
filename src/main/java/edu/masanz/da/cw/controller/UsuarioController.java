package edu.masanz.da.cw.controller;

import edu.masanz.da.cw.model.Usuario;
import edu.masanz.da.cw.service.UsuarioService;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;


public class UsuarioController {

    private static UsuarioService usuarioService = new UsuarioService();

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

    public static void validateLogin(Context context) {
        System.out.println("Validando");

        String alias = context.sessionAttribute("alias");
        System.out.println("alias = " + alias);

        if (alias == null){
            context.redirect("/");
            System.out.println("Validacion fallida");
        }
        System.out.println("Validado");
    }


    public static void mostrarRegistro(@NotNull Context ctx) {
        Map<String,Object> model = new HashMap<>();
        ctx.render("/templates/registro.ftl",model);
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


    public static void maestros(@NotNull Context ctx) {
        String alias = ctx.sessionAttribute("alias");
        Map<String,Object> model = new HashMap<>();
        Usuario usuario = usuarioService.getUsuarioByAlias(alias);
        String nombreApellido = usuario.getNombre()+" "+usuario.getApellido() ;
        model.put("nombreApellido", nombreApellido);
        ctx.render("/templates/maestros.ftl",model);


    }
}
