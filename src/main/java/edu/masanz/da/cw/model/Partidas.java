package edu.masanz.da.cw.model;

import java.util.HashMap;
import java.util.Map;

public class Partidas {

    Map<Integer, Mesas> partidas;
    private int numPartida;

    public Partidas() {
        partidas = new HashMap<>();
        this.numPartida = 0;
    }

    public int getNumPartida() {
        return numPartida;
    }

    public void setNumPartida(int numPartida) {
        this.numPartida = numPartida;
    }

    public Map<Integer, Mesas> getPartidas() {
        return partidas;
    }

    public void setPartidas(Map<Integer, Mesas> partidas) {
        this.partidas = partidas;
    }
}
