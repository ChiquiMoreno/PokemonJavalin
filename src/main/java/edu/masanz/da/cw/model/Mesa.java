package edu.masanz.da.cw.model;

import java.util.ArrayList;
import java.util.List;

public class Mesa {

    private String ganadorMesa;
    private boolean empate;
    private Jugador jugadorA;
    private Jugador jugadorB;

    public Mesa() {

    }

    public boolean asignarGanador(String alias) {
        if(alias.equalsIgnoreCase(jugadorA.getAliasJugador())){
            ganadorMesa = jugadorA.getAliasJugador();
            return true;
        } else if (alias.equalsIgnoreCase(jugadorB.getAliasJugador())) {
            ganadorMesa = jugadorB.getAliasJugador();
            return true;
        }
        else {return false;}
    }

    public int consultarPuntaje(Jugador jugador){
        if (jugador == null) {
            return 0;
        }
        return jugador.getPuntaje();
    }

    //region getters and setters

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
        return jugadorA;
    }

    public Jugador getJugadorB() {
        return jugadorB;
    }

    public void setJugadorB(Jugador jugadorB) {
        this.jugadorB = jugadorB;
    }

    public void setJugadorA(Jugador jugadorA) {
        this.jugadorA = jugadorA;
    }

    public String getAliasJugadorA(){return jugadorA.getAliasJugador();}

    public String getAliasJugadorB(){return jugadorB.getAliasJugador();}
}
