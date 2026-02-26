package edu.masanz.da.cw.model;

import java.util.List;

public class Liga {

    List<Partidas> liga;
    List<Jugador> jugadoresApuntados;

    public Liga(List<Partidas> liga, List<Jugador> jugadoresApuntados) {
        this.liga = liga;
        this.jugadoresApuntados = jugadoresApuntados;
    }

    public List<Partidas> getLiga() {
        return liga;
    }

    public void setLiga(List<Partidas> liga) {
        this.liga = liga;
    }

    public List<Jugador> getJugadoresApuntados() {
        return jugadoresApuntados;
    }

    public void setJugadoresApuntados(List<Jugador> jugadoresApuntados) {
        this.jugadoresApuntados = jugadoresApuntados;
    }
}
