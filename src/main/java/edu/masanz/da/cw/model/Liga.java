package edu.masanz.da.cw.model;

import java.util.*;

public class Liga {

    Map<Integer, Partida> partidas;
    List<Jugador> jugadoresApuntados;
    Map<Integer, String> podio;
    private int idLiga;
    private String fecha;
    private String lugar;
    private String rondas;
    private String descripcion;
    private String tipo;
    private int estado;
    private String estadoStr;

    private int numPartidas;
    public static final int EN_CONSTRUCCION = -1;
    public static final int INCIAR = 0;
    public static final int EN_CURSO = 1;
    public static final int FINALIZADO = 2;

    public Liga(){
        partidas = new HashMap<>();
        jugadoresApuntados = new ArrayList<>();
        numPartidas = 0;
        estado = EN_CONSTRUCCION;
    }

    public Liga(int id, String tipo, String fecha, String lugar, String rondas, String descripcion, int estado) {
        partidas = new HashMap<>();
        jugadoresApuntados = new ArrayList<>();
        numPartidas = 0;
        this.idLiga = id;
        this.tipo = tipo;
        this.fecha = fecha;
        this.lugar = lugar;
        this.rondas = rondas;
        this.descripcion = descripcion;
        setEstado(estado);
    }
/*
    public void definirDatos(String tipo, String fecha, String lugar, String rondas, String descripcion, int estado){
        this.tipo = tipo;
        this.fecha = fecha;
        this.lugar = lugar;
        this.rondas = rondas;
        this.descripcion = descripcion;
        setEstado(estado);
    }
*/
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
        this.descripcion = "LO QUe Sea";
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

    public int getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Liga{" +
                "idLiga=" + idLiga +
                ", fecha='" + fecha + '\'' +
                ", lugar='" + lugar + '\'' +
                ", rondas='" + rondas + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tipo='" + tipo + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }

    //endregion getters and setters

    public Map<Integer, String> getPodio() {
        return podio;
    }

    public void setPodio(Map<Integer, String> podio) {
        this.podio = podio;
    }

    public void setEstado(int estado) {
        this.estado = estado;
        switch (estado){
            case EN_CONSTRUCCION:
                this.estadoStr = "EN CONSTRUCCIóN"; break;
            case INCIAR:
                this.estadoStr = "INICIAR"; break;
            case EN_CURSO:
                this.estadoStr = "EN CURSO"; break;
            case FINALIZADO:
                this.estadoStr = "FINALIZADO"; break;
        }

    }
}
