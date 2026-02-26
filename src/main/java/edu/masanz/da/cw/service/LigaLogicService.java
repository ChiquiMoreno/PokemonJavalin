package edu.masanz.da.cw.service;

import edu.masanz.da.cw.model.Liga;

public class LigaLogicService {

    private static final int MIN_JUGADORES = 2;
    private static final int MAX_JUGADORES = 20;
    private static final int MIN_ROUNDS = 2;
    private static final int MAX_ROUNDS = 6;

    private static final int PUNTAJE_GANA = 3;
    private static final int PUNTAJE_EMPATE = 1;
    private static final int PUNTAJE_PIERDE = 0;

    public boolean calculoRondas(Liga liga) {
        try {
            if (liga == null || liga.getJugadoresApuntados() == null) {
                return false;
            }

            int numJugadores = liga.getJugadoresApuntados().size();
            if (numJugadores < MIN_JUGADORES || numJugadores > MAX_JUGADORES) {
                return false;
            }

            int rounds = ceilLog2(numJugadores);
            if (rounds < MIN_ROUNDS) {
                rounds = MIN_ROUNDS;
            }
            if (rounds > MAX_ROUNDS) {
                rounds = MAX_ROUNDS;
            }

            liga.setNumeroRondas(rounds);
            liga.setPartidasPorRonda(numJugadores / 2);
            liga.setSonImpares((numJugadores % 2) == 1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* Esta función calcula el menor exponente entero n tal que 2^n ≥ value */
    private int ceilLog2(int value) {
        int result = 0;
        int current = 1;
        while (current < value) {
            current <<= 1;
            result++;
        }
        return result;
    }

    public boolean hayImpar(int numPlayers) {
        if(validarNumJugadores(numPlayers)) {
            return (numPlayers & 1) == 1;
        }
        else return false;
    }

    private boolean validarNumJugadores(int numPlayers) {
        return numPlayers >= MIN_JUGADORES && numPlayers <= MAX_JUGADORES;
    }





}
