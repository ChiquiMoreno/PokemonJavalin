package edu.masanz.da.cw.dao;

import edu.masanz.da.cw.db.ConnectionManager;
import edu.masanz.da.cw.model.Jugador;
import edu.masanz.da.cw.model.Liga;
import edu.masanz.da.cw.model.Usuario;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class LigaDaoDb {


    public LigaDaoDb() {
        ConnectionManager.conectar("pokemon_db", "proy", "password");

    }

    public Liga getLiga(int idLiga){
        String sql = "select * from liga where id=?";

        Object[] params = {idLiga};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        String lugar = (String) resultado[0][1];
        String rondas = (String) resultado[0][2];
        String fecha = (String) resultado[0][3];
        String descripcion = (String) resultado[0][4];
        String tipo = (String) resultado[0][5];
        int estado = (int) resultado[0][6];
        Liga liga = new Liga(idLiga, tipo, fecha, lugar, rondas, descripcion, estado);
        return liga;
    }

    public ArrayList<Liga> getAllLigas() {
        List<Liga> listaLigas = new ArrayList<>();
        String sql ="select * from liga";
        Object[] params = new Object[0];
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        for (int i = 0; i < resultado.length ; i++) {
            int id = (int) resultado[i][0];
            String lugar = (String) resultado[i][1];
            String rondas = (String) resultado[i][2];
            String fecha = (String) resultado[i][3];
            String descripcion = (String) resultado[i][4];
            String tipo = (String) resultado[i][5];
            int estado = (int) resultado[i][6];
            Liga liga = new Liga(id,tipo,fecha,lugar,rondas,descripcion, estado);
            listaLigas.add(liga);
        }
        System.out.println(listaLigas.toString());
        return (ArrayList<Liga>) listaLigas;
    }

    public static void crearliga(@NotNull Context ctx) {
        ctx.render("/templates/crearliga.ftl");
    }

    public static int cantidadJugadores(int idLiga){
        String sql = "select count(*) from jugador where liga = ?;";

        Object[] params = {idLiga};

        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);

        return 0;
    }

    public Collection<Usuario> listarUsuariosAJugadores() {
        return usuarios.values();
    }

    private Map<Integer, Usuario> usuarios = Map.of(
        //TODO
    );

    public static void nuevaLiga(Liga liga){
        String sql = "INSERT into liga (lugar, rondas, fecha, descripcion, tipo) values (?,?,?,?,?);";

        Object[] params = {
                liga.getLugar(),
                liga.getRondas(),
                liga.getFecha(),
                liga.getDescripcion(),
                liga.getTipo()};
        liga.setIdLiga((int) ConnectionManager.ejecutarInsertSQL(sql, params));
    }

    public static List<Jugador> obtenerJugadoresLiga(int idliga){
        //TODO: implementar
        List<Jugador> jugadores = new ArrayList<>();

        String sql = "select * from jugadores where idLiga = ?;";
        Object[] params = {idliga};
        ConnectionManager.ejecutarSelectSQL(sql,params);
        return jugadores;
    }

    public static void updateEstadoLiga(int id){
        if(LigaDaoDb.getEstadoEnCurso() == 0){
            String sql = "update liga set estado = estado + 1 where = ?;";
            Object[] params = {id};
            ConnectionManager.ejecutarSelectSQL(sql,params);
        }
    }

    public static int getEstadoEnCurso(){
        String sql = "select count(*) from liga where estado = ?;";
        Object[] params = {1};
        ConnectionManager.ejecutarSelectSQL(sql,params);
        Object resultado = ConnectionManager.ejecutarSelectSQL(sql,params);
        return (int) resultado;
    }


}
