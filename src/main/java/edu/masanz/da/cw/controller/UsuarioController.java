package edu.masanz.da.cw.controller;

import edu.masanz.da.cw.model.Usuario;
import edu.masanz.da.cw.service.LigaLogicService;
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

        String alias = context.sessionAttribute("alias");
        if (alias == null){
            context.redirect("/");
        }
    }


    public static void mostrarRegistro(@NotNull Context ctx) {
        Map<String,Object> model = new HashMap<>();
        ctx.render("/templates/registro.ftl",model);
    }

    public static void perfil(@NotNull Context ctx) {
        String alias = ctx.sessionAttribute("alias");
        Map<String,Object> model = new HashMap<>();
        String titulo = "Perfil";
        Usuario usuario = usuarioService.getUsuarioByAlias(alias);
        String nombreApellido = usuario.getNombre()+" "+usuario.getApellido() ;
        model.put("titulo", titulo);
        model.put("nombreApellido", nombreApellido);
        model.put("alias", alias);
        model.put("ligas", LigaLogicService.getLigasAlias(alias));
        ctx.render("/templates/infousuario-competiciones.ftl",model);
    }


    public static void maestros(@NotNull Context ctx) {
        String alias = ctx.sessionAttribute("alias");
        String titulo = "Maestros";
        Map<String,Object> model = new HashMap<>();
        Usuario usuario = usuarioService.getUsuarioByAlias(alias);
        String nombreApellido = usuario.getNombre()+" "+usuario.getApellido() ;
        model.put("usuarios", usuarioService.getAllUsuarios(alias));
        model.put("titulo", titulo);
        model.put("nombreApellido", nombreApellido);
        ctx.render("/templates/maestros.ftl",model);


    }

    public static void mostrarEditarPerfil(@NotNull Context context) { //TODO  mostrar editar perfil
        String alias = context.sessionAttribute("alias");
        Map<String,Object> model = new HashMap<>();
        model.put("alias",alias);
        context.render("/templates/editarperfil.ftl",model);
    }

    public static void editarPerfil(@NotNull Context context) {//TODO ditar perfil
        String alias = context.sessionAttribute("alias");
        Map<String,Object> model = new HashMap<>();
        String nuevoNombre= context.formParam("nombre");
        String nuevoApellido= context.formParam("apellido");
        String password= context.formParam("password");
        String opcion = context.formParam("opcion");
        if (!opcion.equalsIgnoreCase("Modificar")){context.redirect("./perfil");};
        if (usuarioService.autenticar(alias,password)!=null){
            usuarioService.editarPerfil(nuevoNombre,nuevoApellido,alias);
            context.redirect("./perfil");
        }else {
            String error = "error, contraseña invalida";
            model.put("eror",error);
            context.render("/templates/editarperfil.ftl",model);
        }

    }

    public static void eliminarUsuario(@NotNull Context context) {//todo eliminar usuario
        String alias = context.pathParam("alias");
        usuarioService.eliminarUsuario(alias);
        context.redirect("/logueado/maestros");
    }

    public static void validateAdmin(@NotNull Context context) {

        String alias = context.sessionAttribute("alias");

        if (!usuarioService.usuarioEsAdmin(alias)){
            context.redirect("/logueado/torneos");
        }

    }

    public static void verPerfilConcreto(@NotNull Context context) {
        String alias = context.pathParam("alias");
        Map<String,Object> model = new HashMap<>();
        String titulo = "Perfil";
        Usuario usuario = usuarioService.getUsuarioByAlias(alias);
        String nombreApellido = usuario.getNombre()+" "+usuario.getApellido() ;
        model.put("titulo", titulo);
        model.put("nombreApellido", nombreApellido);
        model.put("alias", alias);
        model.put("ligas", LigaLogicService.getLigasAlias(alias));
        context.render("/templates/usuario-concreto.ftl",model);
    }
}

