package edu.masanz.da.cw.model;

import java.util.ArrayList;
import java.util.List;

public class Mesa {

    private final int CANT_JUGADORES = 2;
    ArrayList<Jugador> jugadoresMesa;
    private String ganadorMesa;
    private boolean empate;

    public Mesa() {
        this.jugadoresMesa = new ArrayList<Jugador>();
    }

    public boolean agregarJugador (Jugador jugador){
        if(jugadoresMesa.size() >= 2 || jugador == null){
            return false;
        }
        jugadoresMesa.add(jugador);
        return true;
    }

    public void asignarGanador(Jugador jugador) {
        if (jugador != null) {
            ganadorMesa = jugador.getNombreJugador();
            empate = false;
        }
    }

    public int consultarPuntaje(Jugador jugador){
        if (jugador == null) {
            return 0;
        }
        return jugador.getPuntaje();
    }

    public List<Jugador> getJugadoresMesa() {
        return jugadoresMesa;
    }

    public void setJugadoresMesa(List<Jugador> jugadoresMesa) {
        this.jugadoresMesa = (ArrayList<Jugador>) jugadoresMesa;
    }

    public String getGanadorMesa() {
        return ganadorMesa;
    }

    public void setGanadorMesa(String ganadorMesa) {
        this.ganadorMesa = ganadorMesa;
    }

    public boolean isEmpate() {
        return empate;
    }

    public void setEmpate(boolean empate) {
        this.empate = empate;
    }

    public Jugador getJugadorA() {
        if (jugadoresMesa == null || jugadoresMesa.isEmpty()) {
            return null;
        }
        return jugadoresMesa.get(0);
    }

    public Jugador getJugadorB() {
        if (jugadoresMesa == null || jugadoresMesa.size() < 2) {
            return null;
        }
        return jugadoresMesa.get(1);
    }

}
