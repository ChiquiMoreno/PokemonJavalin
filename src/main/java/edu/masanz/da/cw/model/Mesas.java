package edu.masanz.da.cw.model;

import java.util.List;
import java.util.Set;

public class Mesas {

    List<Jugador> jugadoresMesa;
    private String ganadorMesa;

    public boolean anadirJugador(Jugador jugador){
        if(jugadoresMesa.size() >= 2){
            return false;
        }
        jugadoresMesa.add(jugador);
        return true;
    }

    private void asignarGanador(Jugador jugador){
       ganadorMesa = jugador.getNombreJugador();
    }

    private int consultarPuntaje(Jugador jugador){
        return jugador.getPuntaje();
    }


}
