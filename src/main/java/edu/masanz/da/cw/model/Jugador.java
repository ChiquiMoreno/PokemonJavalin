package edu.masanz.da.cw.model;

public class Jugador {

    private int puntaje;
    private int idLiga;
    private String aliasJugador;

    private int ganadas;
    private int empates;
    private int perdidas;

    public Jugador(Usuario usuario) {
        this.puntaje = 0;
        this.aliasJugador = usuario.getAlias();
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
