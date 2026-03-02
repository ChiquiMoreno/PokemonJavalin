package edu.masanz.da.cw.model;

import java.util.HashMap;
import java.util.Map;

public class Partida {

    Map<Integer, Mesa> partidas;

    public Partida() {
        partidas = new HashMap<>();
    }

    public Map<Integer, Mesa> getPartidas() {
        return partidas;
    }

    public void setPartidas(Map<Integer, Mesa> partidas) {
        this.partidas = partidas;
    }

    public Mesa getMesaById(int id) {
        return partidas.get(id);
    }

}
