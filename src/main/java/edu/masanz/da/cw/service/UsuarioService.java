package edu.masanz.da.cw.service;

import edu.masanz.da.cw.dao.UsuarioDaoDb;
import edu.masanz.da.cw.model.Usuario;

public class UsuarioService {
    private UsuarioDaoDb dao = new UsuarioDaoDb();

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


}