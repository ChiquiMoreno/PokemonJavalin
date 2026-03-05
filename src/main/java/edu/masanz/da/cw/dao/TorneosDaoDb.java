package edu.masanz.da.cw.dao;

import edu.masanz.da.cw.db.ConnectionManager;
import edu.masanz.da.cw.model.Liga;

import java.util.ArrayList;

public class TorneosDaoDb {

    public TorneosDaoDb() {
        ConnectionManager.conectar("pokemon_db", "proy", "password");

    }

    public ArrayList<Liga> getAllLigas() {
        String sql ="select * from torneo";
        Object[] params = new Object[0];
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        for (int i = 0; i < resultado.length ; i++) {
            int id = (int) resultado[i][0];
//            String
            Liga liga = new Liga(id);
        }
        return null;
    }
}
