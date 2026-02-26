package edu.masanz.da.cw.model;

import java.util.List;

public class Liga {

    List<Partidas> liga;
    List<Jugador> jugadoresApuntados;
    private int numeroRondas;
    private int partidasPorRonda;
    private boolean sonImpares;

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

    public int getNumeroRondas() {
        return numeroRondas;
    }

    public void setNumeroRondas(int numeroRondas) {
        this.numeroRondas = numeroRondas;

    }

    public int getPartidasPorRonda() {
        return partidasPorRonda;
    }

    public void setPartidasPorRonda(int partidasPorRonda) {
        this.partidasPorRonda = partidasPorRonda;
    }

    public boolean isSonImpares() {
        return sonImpares;
    }

    public void setSonImpares(boolean sonImpares) {
        this.sonImpares = sonImpares;
    }
}
