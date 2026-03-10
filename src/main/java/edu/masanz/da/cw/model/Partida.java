package edu.masanz.da.cw.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Partida {

    Map<Integer, Mesa> partida;
    List<String> ganadores;
    int cantidadMesa;

    public Partida() {
        partida = new HashMap<>();
        cantidadMesa = 0;
    }

    public Map<Integer, Mesa> getPartida() {
        return partida;
    }

    public void setPartida(Map<Integer, Mesa> partida) {
        this.partida = partida;
        this.cantidadMesa = partida == null ? 0 : partida.size();
    }

    public Mesa getMesaById(int id) {
        return partida.get(id);
    }

    public void agregarMesa(int i, Mesa mesa){
        partida.put(i, mesa);
        cantidadMesa = partida.size();
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

    public int getCantidadMesa() {
        return cantidadMesa;
    }

    public void setCantidadMesa(int cantidadMesa) {
        this.cantidadMesa = cantidadMesa;
    }
}
