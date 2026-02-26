package edu.masanz.da.cw.service;

/**
 * Servicio para calcular parámetros de rondas tipo Swiss.
 */
public class RoundCalculatorService {

    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 20;

    /**
     * Calcula el número óptimo de rondas Swiss como ceil(log2(numPlayers))
     * y lo acota entre minRounds y maxRounds.
     *
     * @param numPlayers número de jugadores (2..20)
     * @param minRounds  mínimo de rondas permitido
     * @param maxRounds  máximo de rondas permitido
     * @return rondas óptimas acotadas
     */
    public int calculateOptimalRounds(int numPlayers, int minRounds, int maxRounds) {
        validateNumPlayers(numPlayers);
        if (minRounds < 1) {
            throw new IllegalArgumentException("minRounds debe ser >= 1");
        }
        if (maxRounds < minRounds) {
            throw new IllegalArgumentException("maxRounds debe ser >= minRounds");
        }

        int swissRounds = ceilLog2(numPlayers);
        return Math.max(minRounds, Math.min(maxRounds, swissRounds));
    }

    /**
     * Indica si existe bye en una ronda.
     */
    public boolean hasBye(int numPlayers) {
        validateNumPlayers(numPlayers);
        return (numPlayers & 1) == 1;
    }

    /**
     * Número de partidas por ronda (sin contar bye como partida).
     */
    public int matchesPerRound(int numPlayers) {
        validateNumPlayers(numPlayers);
        return numPlayers / 2;
    }

    /**
     * Número total de partidas de toda la liga.
     */
    public int totalMatches(int numPlayers, int rounds) {
        validateNumPlayers(numPlayers);
        if (rounds < 1) {
            throw new IllegalArgumentException("rounds debe ser >= 1");
        }
        return matchesPerRound(numPlayers) * rounds;
    }

    private int ceilLog2(int value) {
        int result = 0;
        int current = 1;
        while (current < value) {
            current <<= 1;
            result++;
        }
        return result;
    }

    private void validateNumPlayers(int numPlayers) {
        if (numPlayers < MIN_PLAYERS || numPlayers > MAX_PLAYERS) {
            throw new IllegalArgumentException("numPlayers debe estar entre 2 y 20");
        }
    }
}
