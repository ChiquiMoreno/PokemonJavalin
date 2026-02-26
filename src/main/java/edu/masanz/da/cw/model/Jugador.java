package edu.masanz.da.cw.model;

public class Jugador {

    private Usuario jugador;
    private int puntaje;
    private int ganadas;
    private int empates;
    private int perdidas;
    private int racha;

    public Jugador(Usuario jugador) {
        this.puntaje = 0;
        this.jugador = jugador;
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

    public int getRacha() {
        return racha;
    }

    public void setRacha(int racha) {
        this.racha = racha;
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

    public boolean sumarPuntaje(int puntajeNuevo) {
        if (puntajeNuevo < 0) {
            return false;
        }
        puntaje += puntajeNuevo;
        return true;
    }
}
