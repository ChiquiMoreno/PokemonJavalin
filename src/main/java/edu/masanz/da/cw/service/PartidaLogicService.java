package edu.masanz.da.cw.service;

import edu.masanz.da.cw.model.Jugador;
import edu.masanz.da.cw.model.Mesa;
import edu.masanz.da.cw.model.Partida;
import edu.masanz.da.cw.model.Usuario;

import javax.naming.Context;
import java.util.*;

public  class PartidaLogicService {


    private static final int GANA = 300;
    private static final int EMPATE = 100;
    private static final int PIERDE = 0;

    private static final int BONUS = 5;

    private int calcularBonusRival(int rivalGanadasAntes) {
        if (rivalGanadasAntes <= 0) return 0;
        return rivalGanadasAntes * BONUS;
    }

    public boolean calcularEnfrentamiento(Mesa mesa) {
        try {
            if (mesa == null) return false;
            if (mesa.getJugadorA() == null || mesa.getJugadorB() == null) return false;

            Jugador jugadorA = mesa.getJugadorA();
            Jugador jugadorB = mesa.getJugadorB();

            // Guarda partidas ganadas PREVIAS
            int jugadorBGanadas = jugadorB.getGanadas();
            int jugadorAGanadas = jugadorA.getGanadas();

            // Empate
            if (mesa.isEmpate()) {
                jugadorA.setEmpates(jugadorA.getEmpates() + 1);
                jugadorB.setEmpates(jugadorB.getEmpates() + 1);

                jugadorA.setPuntaje(jugadorA.getPuntaje() + EMPATE);
                jugadorB.setPuntaje(jugadorB.getPuntaje() + EMPATE);
                return true;
            }

            String ganador = mesa.getGanadorMesa();
            if (ganador == null) return false;

            // Gana A
            if (ganador.equals(jugadorA.getAliasJugador())) {
                int bonusA = calcularBonusRival(jugadorBGanadas);

                jugadorA.setGanadas(jugadorA.getGanadas() + 1);
                jugadorA.sumarPuntaje(GANA + bonusA);

                jugadorB.setPerdidas(jugadorB.getPerdidas() + 1);
                jugadorB.sumarPuntaje(PIERDE);
                return true;
            }

            // Gana B
            if (ganador.equals(jugadorB.getAliasJugador())) {
                int bonusB = calcularBonusRival(jugadorAGanadas);

                jugadorB.setGanadas(jugadorB.getGanadas() + 1);
                jugadorB.sumarPuntaje(GANA + bonusB);

                jugadorA.setPerdidas(jugadorA.getPerdidas() + 1);
                jugadorA.sumarPuntaje(PIERDE);
                return true;
            }

            return false;

        } catch (Exception e) {
            return false;
        }

    }

    public void runPartida(Partida partida){

    }

    public void asignarJugadoresAMesa(Jugador jugadorA, Jugador jugadorB, Mesa mesa){
        if(jugadorA.getPuntaje() > jugadorB.getPuntaje()){
            mesa.setJugadorA(jugadorA);
            mesa.setJugadorB(jugadorB);
        } else {
            mesa.setJugadorA(jugadorB);
            mesa.setJugadorB(jugadorA);
        }
    }


    public Partida iniciarPartida(List<Jugador> jugadores) {

        Partida partida = new Partida();

        if (jugadores == null || jugadores.size() < 2 || jugadores.size() > 20) {
            return partida;
        }

        Iterator<Jugador> it = jugadores.iterator();

        int numMesas = jugadores.size() / 2;

        for (int i = 1; i <= numMesas; i++) {
            Mesa mesa = new Mesa();

            //Jugadores en orden
            Jugador jugadorA = it.next();
            Jugador jugadorB = it.next();

            mesa.setJugadorA(jugadorA);
            mesa.setJugadorB(jugadorB);

            partida.agregarMesa(i, mesa);

        }
        return partida;
    }

    // Verificado :)
    public List<Jugador> ordenarJugadores(List<Jugador> jugadores){
        for (int i = 0; i < jugadores.size(); i++) {
            for (int j = i + 1; j < jugadores.size(); j++) {
                if(jugadores.get(i).getPuntaje() < jugadores.get(j).getPuntaje()){
                    Collections.swap(jugadores, i, j);
                }
            }
        }

        return jugadores;
    }

    public static void main(String[] args) {

    }




}
