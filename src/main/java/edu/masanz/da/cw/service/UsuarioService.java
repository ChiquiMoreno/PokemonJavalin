package edu.masanz.da.cw.service;

import edu.masanz.da.cw.dao.UsuarioDaoDb;
import edu.masanz.da.cw.model.Jugador;
import edu.masanz.da.cw.model.Usuario;

import java.util.List;

public class UsuarioService {
    private static UsuarioDaoDb dao = new UsuarioDaoDb();

    public static List<Jugador> getJugadoresTorneo(int idLiga) {
        return dao.getJugadoresTorneo(idLiga);
    }


    public void crearUsuario(String alias, String password, String nombre, String apellido) {
        dao.crearUsuario(alias, password,nombre,apellido);
    }
//    private Map<String, Usuario> usuarios = Map.of(

    public Usuario autenticar(String alias, String password) {
        return dao.autenticar(alias,password);
    }


    public Usuario getUsuarioByAlias(String alias) {
        return dao.getUsuarioByAlias(alias);
    }


    public List<Usuario> getAllUsuarios() {
        return dao.getAllUsuarios();
    }

    public void editarPerfil(String nuevoNombre, String nuevoApellido, String alias) {
        dao.editarUsuario(nuevoNombre,nuevoApellido,alias);
    }

    public boolean usuarioEsAdmin(String alias) {
        return dao.usuarioEsAdmin(alias);
    }

    public void eliminarUsuario(String alias) {
        dao.eliminarUsuario(alias);
    }
}