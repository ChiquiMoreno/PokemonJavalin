package edu.masanz.da.cw.service;

import edu.masanz.da.cw.model.Jugador;
import edu.masanz.da.cw.model.Liga;
import edu.masanz.da.cw.model.Mesas;
import edu.masanz.da.cw.model.Standing;

import java.util.Map;

/**
 * Lógica simple para rondas y puntos.
 */
public class LeagueLogicService {

    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 20;
    private static final int MIN_ROUNDS = 2;
    private static final int MAX_ROUNDS = 6;

    private static final int POINTS_WIN = 3;
    private static final int POINTS_DRAW = 1;
    private static final int POINTS_LOSS = 0;
    private static final int POINTS_BYE = 3;

    public boolean tryCalculateRounds(Liga liga) {
        try {
            if (liga == null || liga.getJugadoresApuntados() == null) {
                return false;
            }

            int numPlayers = liga.getJugadoresApuntados().size();
            if (numPlayers < MIN_PLAYERS || numPlayers > MAX_PLAYERS) {
                return false;
            }

            int rounds = ceilLog2(numPlayers);
            if (rounds < MIN_ROUNDS) {
                rounds = MIN_ROUNDS;
            }
            if (rounds > MAX_ROUNDS) {
                rounds = MAX_ROUNDS;
            }

            liga.setNumeroRondas(rounds);
            liga.setPartidasPorRonda(numPlayers / 2);
            liga.setHayBye((numPlayers % 2) == 1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean tryApplyMatchResult(Mesas match, Map<Jugador, Standing> standings) {
        try {
            if (match == null || standings == null) {
                return false;
            }

            Jugador jugadorA = match.getJugadorA();
            Jugador jugadorB = match.getJugadorB();

            if (jugadorA == null) {
                return false;
            }

            Standing standingA = standings.get(jugadorA);
            if (standingA == null) {
                return false;
            }

            // Bye: solo jugadorA
            if (jugadorB == null) {
                int bonusA = calculateRivalBonus(0, 0) + calculateStreakBonus(standingA.getWinStreak());
                standingA.incrementWins();
                standingA.incrementWinStreak();
                standingA.addPoints(POINTS_BYE + bonusA);
                return true;
            }

            Standing standingB = standings.get(jugadorB);
            if (standingB == null) {
                return false;
            }

            // snapshot simple ANTES de modificar
            int rivalWinsForA = standingB.getWins();
            int rivalLossesForA = standingB.getLosses();
            int rivalWinsForB = standingA.getWins();
            int rivalLossesForB = standingA.getLosses();

            if (match.isEmpate()) {
                standingA.incrementDraws();
                standingB.incrementDraws();
                standingA.resetWinStreak();
                standingB.resetWinStreak();
                standingA.addPoints(POINTS_DRAW);
                standingB.addPoints(POINTS_DRAW);
                return true;
            }

            String ganador = match.getGanadorMesa();
            if (ganador == null || ganador.isBlank()) {
                return false;
            }

            if (ganador.equals(jugadorA.getNombreJugador())) {
                int bonusA = calculateRivalBonus(rivalWinsForA, rivalLossesForA)
                        + calculateStreakBonus(standingA.getWinStreak());

                standingA.incrementWins();
                standingA.incrementWinStreak();
                standingA.addPoints(POINTS_WIN + bonusA);

                standingB.incrementLosses();
                standingB.resetWinStreak();
                standingB.addPoints(POINTS_LOSS);
                return true;
            }

            if (ganador.equals(jugadorB.getNombreJugador())) {
                int bonusB = calculateRivalBonus(rivalWinsForB, rivalLossesForB)
                        + calculateStreakBonus(standingB.getWinStreak());

                standingB.incrementWins();
                standingB.incrementWinStreak();
                standingB.addPoints(POINTS_WIN + bonusB);

                standingA.incrementLosses();
                standingA.resetWinStreak();
                standingA.addPoints(POINTS_LOSS);
                return true;
            }

            return false;
        } catch (Exception e) {
            return false;
        }
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

    private int calculateRivalBonus(int rivalWins, int rivalLosses) {
        if (rivalLosses == 0 && rivalWins >= 2) {
            return 2;
        }
        if (rivalWins > rivalLosses) {
            return 1;
        }
        return 0;
    }

    private int calculateStreakBonus(int streak) {
        if (streak >= 2) {
            return 1;
        }
        return 0;
    }
}
