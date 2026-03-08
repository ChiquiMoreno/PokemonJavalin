package edu.masanz.da.cw.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Partida {

    Map<Integer, Mesa> partida;
    List<String> ganadores;

    public Partida() {
        partida = new HashMap<>();
    }

    public Map<Integer, Mesa> getPartida() {
        return partida;
    }

    public void setPartida(Map<Integer, Mesa> partida) {
        this.partida = partida;
    }

    public Mesa getMesaById(int id) {
        return partida.get(id);
    }

    public void agregarMesa(int i, Mesa mesa){
        partida.put(i, mesa);
    }

    public List<String> getGanadores() {
        return ganadores;
    }

    public void setGanadores(List<String> ganadores) {
        this.ganadores = ganadores;
    }

    public void setGanadorMesa(String nombreJugador, int mesa){
        partida.get(mesa).setGanadorMesa(nombreJugador);
    }

}
