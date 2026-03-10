package edu.masanz.da.cw.model;

public class Jugador {

    private int puntaje;
    private int idLiga;
    private String aliasJugador;
    private String nombreJugador;

    private int ganadas;
    private int empates;
    private int perdidas;

    public Jugador(Usuario usuario, int idLiga ) {
        this.puntaje = 0;
        this.aliasJugador = usuario.getAlias();
        this.nombreJugador = usuario.getNombre();
        this.idLiga = idLiga;
    }

    public int getIdLiga() {
        return idLiga;
    }

    public void setIdLiga(int idLiga) {
        this.idLiga = idLiga;
    }

    public void setAliasJugador(String aliasJugador) {
        this.aliasJugador = aliasJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getAliasJugador(){
        return aliasJugador;
    }

    public int getGanadas() {
        return ganadas;
    }

    public void setGanadas(int ganadas) {
        this.ganadas = ganadas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getPerdidas() {
        return perdidas;
    }

    public void setPerdidas(int perdidas) {
        this.perdidas = perdidas;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void sumarPuntaje(int puntajeNuevo) {
        puntaje += puntajeNuevo;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "jugador=" + aliasJugador +
                ", puntaje=" + puntaje +
                '}';
    }
}
