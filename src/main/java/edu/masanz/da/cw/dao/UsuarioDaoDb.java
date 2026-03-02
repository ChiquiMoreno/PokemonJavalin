package edu.masanz.da.cw.dao;

import edu.masanz.da.cw.db.ConnectionManager;
import edu.masanz.da.cw.model.Usuario;

public class UsuarioDaoDb {

    public UsuarioDaoDb() {
        ConnectionManager.conectar("pokemon_db", "proy", "password");
    }

    public Usuario autenticar(String alias, String password) {
        Usuario usuario = null;
        String sql = "select nombre, apellido from usuario where alias=? and passwd=?";

        Object[] params = {alias, password};

        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql,params);

        if(resultado != null && resultado.length ==1){
            String nombre = (String) resultado[0][0];
            String apellido = (String) resultado[0][1];
            usuario = new Usuario(alias, password, nombre, apellido);
        }

        return usuario;
    }

    public Usuario getUsuarioByAlias(String alias) {
        Usuario usuario = null;
        String sql = "select nombre, apellido, passwd from usuario where alias=?";

        Object[] params = {alias};

        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql,params);

        if(resultado != null && resultado.length ==1){
            String nombre = (String) resultado[0][0];
            String apellido = (String) resultado[0][1];
            String password = (String) resultado [0][2];
            usuario = new Usuario(alias, password, nombre, apellido);
        }


        return usuario;
    }

    public void crearUsuario(String alias, String password, String nombre, String apellido) {
        String sql = "insert into usuario (alias,passwd,nombre,apellido) values(?,?,?,?)";
        Object[] params = {alias,password,nombre,apellido};
        ConnectionManager.ejecutarInsertSQL(sql,params);

    }
}
