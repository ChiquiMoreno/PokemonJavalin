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

    public static Optional<Integer> getLigaEnCursoId() {
        String sql = "select id from liga where estado = ? order by id asc limit 1;";
        Object[] params = {Liga.EN_CURSO};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        if (resultado == null || resultado.length == 0) {
            return Optional.empty();
        }
        return Optional.of((int) resultado[0][0]);
    }

    public static boolean existeLigaEnCursoExcluyendo(int idLiga) {
        String sql = "select count(*) from liga where estado = ? and id <> ?;";
        Object[] params = {Liga.EN_CURSO, idLiga};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        if (resultado == null || resultado.length == 0) {
            return false;
        }
        return ((Number) resultado[0][0]).intValue() > 0;
    }

    public static boolean actualizarEstadoLiga(int idLiga, int nuevoEstado) {
        String sql = "update liga set estado = ? where id = ?;";
        Object[] params = {nuevoEstado, idLiga};
        int filasAfectadas = ConnectionManager.ejecutarUpdateSQL(sql, params);
        return filasAfectadas > 0;
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
        actualizarEstadoLiga(id, Liga.EN_CURSO);
    }

    public static int getEstadoEnCurso(){
        String sql = "select count(*) from liga where estado = ?;";
        Object[] params = {Liga.EN_CURSO};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql,params);
        if (resultado == null || resultado.length == 0) {
            return 0;
        }
        return ((Number) resultado[0][0]).intValue();
    }


    public void eliminarLiga(String liga) {
        String sql = "delete from liga where id = ?";
        Object[] params = {liga};
        ConnectionManager.ejecutarUpdateSQL(sql,params);
    }

    /**
     * Asociar usuarios a ligas, esto crea jugadores
     * @param idLiga
     * @param usuarios lista de alias de usuarios
     */
    public static boolean crearJugadores(String idLiga, List<String> usuarios){
        String sql = "INSERT IGNORE INTO pokemon_db.jugador (idLiga, aliasUsuario, puntaje, posicion) VALUES (?, ?, 0, 0);";
        try {
            for (String usuario : usuarios) {
                Object[] params = {idLiga, usuario};
                ConnectionManager.ejecutarInsertSQL(sql, params);
            }
        }catch (Exception ex){
            return false;
        }
        return true;
    }

}
