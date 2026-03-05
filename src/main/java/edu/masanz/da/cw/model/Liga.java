package edu.masanz.da.cw.model;

import java.util.*;

public class Liga {

    Map<Integer, Partida> partidas;
    List<Jugador> jugadoresApuntados;
    private int idLiga;
    private String fecha;
    private String lugar;
    private String rondas;
    private String descripcion;
    private String tipo;

    private int numPartidas;

    public Liga(int id) {
        partidas = new HashMap<>();
        jugadoresApuntados = new ArrayList<>();
        numPartidas = 0;
        this.idLiga = id;
    }

    public void definirDatos(String tipo, String fecha, String lugar, String rondas, String descripcion){
        this.tipo = tipo;
        this.fecha = fecha;
        this.lugar = lugar;
        this.rondas = rondas;
        this.descripcion = descripcion;
    }

    public boolean agregarJugador(Jugador jugador){
        if(jugadoresApuntados.size() > 20){
            return false;
        }
        jugadoresApuntados.add(jugador);
        return true;
    }

    // region getters and setters


    public Map<Integer, Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(Map<Integer, Partida> partidas) {
        this.partidas = partidas;
    }

    public void setIdLiga(int idLiga) {
        this.idLiga = idLiga;
    }

    public List<Jugador> getJugadoresApuntados() {
        return jugadoresApuntados;
    }

    public void setJugadoresApuntados(List<Jugador> jugadoresApuntados) {
        this.jugadoresApuntados = jugadoresApuntados;
    }

    public int getNumPartidas() {
        return numPartidas;
    }

    public void setNumPartidas(int numeroPartidas) {
        this.numPartidas = numeroPartidas;

    }

    public int getIdLiga() {
        return idLiga;
    }

//    public void setIdLiga(int idLiga) {
//        this.idLiga = idLiga;
//    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getRondas() {
        return rondas;
    }

    public void setRondas(String rondas) {
        this.rondas = rondas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //endregion getters and setters

}
