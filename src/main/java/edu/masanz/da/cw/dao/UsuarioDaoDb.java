package edu.masanz.da.cw.dao;

import edu.masanz.da.cw.db.ConnectionManager;
import edu.masanz.da.cw.model.Jugador;
import edu.masanz.da.cw.model.Usuario;
import edu.masanz.da.cw.service.UsuarioService;

import java.util.ArrayList;
import java.util.List;

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

    public List<Jugador> getJugadoresTorneo(int idLiga) {
        UsuarioService usuarioService = new UsuarioService();
        String sql = "select aliasUsuario from jugador where idLiga = ?";
        Object [] params = {idLiga};
        Object [][] resultado = ConnectionManager.ejecutarSelectSQL(sql,params);
        List<Jugador> jugadores = new ArrayList<>();
        for (int i = 0; i < resultado.length ; i++) {
            Jugador jugador = new Jugador(usuarioService.getUsuarioByAlias((String) resultado[i][0]), idLiga);
            jugadores.add(jugador);
        }
        return jugadores;
    }

    public List<Usuario> getAllUsuarios() {
        String sql = "select * from usuario";
        Object [] params = new Object[0];
        Object [][] resultado = ConnectionManager.ejecutarSelectSQL(sql,params);
        List<Usuario> usuarios = new ArrayList<>();
        for (int i = 0; i < resultado.length; i++) {
            String alias = (String) resultado[i][0];
            String passwd = (String) resultado[i][1];
            String nombre = (String) resultado[i][2];
            String apellido = (String) resultado[i][3];

            Usuario usuario = new Usuario(alias,passwd,nombre,apellido);
            usuarios.add(usuario);
        }
        return usuarios;
    }

    public void editarUsuario(String nuevoNombre, String nuevoApellido, String alias) {
        String sql = "update usuario set nombre = ? and apellido = ? where alias = ?";
        Object [] params = {nuevoNombre,nuevoApellido,alias};
        ConnectionManager.ejecutarUpdateSQL(sql,params);
    }
}
