package edu.masanz.da.cw.dao;

import edu.masanz.da.cw.db.ConnectionManager;
import edu.masanz.da.cw.model.Liga;
import edu.masanz.da.cw.model.Usuario;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class LigaDaoDb {


    public LigaDaoDb() {
        ConnectionManager.conectar("pokemon_db", "proy", "password");

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
            Liga liga = new Liga(id, tipo,fecha,lugar,rondas,descripcion, estado);
            //liga.definirDatos(tipo,fecha,lugar,rondas,descripcion, estado);
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

    // TODO
    public Liga getLiga(int idLiga) {
        Liga liga = new Liga();
        return liga;
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
        liga.setIdLiga((int)ConnectionManager.ejecutarInsertSQL(sql, params));
    }


}
