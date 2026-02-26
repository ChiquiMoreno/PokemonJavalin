package edu.masanz.da.cw.model;

public class Jugador {

    private Usuario jugador;
    private int puntaje;
    private int idJugador;

    public Jugador(Usuario jugador) {
        this.puntaje = 0;
        this.jugador = jugador;
    }

    public String getNombreJugador(){
        return jugador.getNombre();
    }

    public Usuario getJugador() {
        return jugador;
    }

    public void setJugador(Usuario jugador) {
        this.jugador = jugador;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
