package edu.masanz.da.cw.service;

import edu.masanz.da.cw.model.RegistroRivalSnapshot;
import edu.masanz.da.cw.model.ResultadoPartida;
import edu.masanz.da.cw.model.Standing;

/**
 * Motor de puntuación para standings.
 */
public class ScoringEngine {

    private final ScoringConfig config;

    public ScoringEngine(ScoringConfig config) {
        if (config == null) {
            throw new IllegalArgumentException("config no puede ser null");
        }
        this.config = config;
    }

    /**
     * Aplica un resultado sobre el standing usando snapshot pre-partida del rival.
     */
    public void applyResult(Standing standing, ResultadoPartida resultado, RegistroRivalSnapshot rivalSnapshot) {
        if (standing == null) {
            throw new IllegalArgumentException("standing no puede ser null");
        }
        if (resultado == null) {
            throw new IllegalArgumentException("resultado no puede ser null");
        }

        int winStreakBeforeMatch = standing.getWinStreak();

        switch (resultado) {
            case WIN -> {
                int bonusRival = opponentStrengthBonus(rivalSnapshot);
                int bonusRacha = streakBonus(winStreakBeforeMatch);
                standing.incrementWins();
                standing.incrementWinStreak();
                standing.addPoints(config.getWinPoints() + bonusRival + bonusRacha);
            }
            case BYE_WIN -> {
                int bonusRacha = streakBonus(winStreakBeforeMatch);
                standing.incrementWins();
                standing.incrementWinStreak();
                standing.addPoints(config.getByePoints() + bonusRacha);
            }
            case DRAW -> {
                standing.incrementDraws();
                standing.resetWinStreak();
                standing.addPoints(config.getDrawPoints());
            }
            case LOSS -> {
                standing.incrementLosses();
                standing.resetWinStreak();
                standing.addPoints(config.getLossPoints());
            }
            default -> throw new IllegalArgumentException("resultado no soportado");
        }
    }

    /**
     * Bonus por fuerza del rival usando su estado ANTES de jugar.
     */
    public int opponentStrengthBonus(RegistroRivalSnapshot rivalSnapshot) {
        if (rivalSnapshot == null) {
            return 0;
        }

        int wins = rivalSnapshot.getWins();
        int losses = rivalSnapshot.getLosses();

        if (wins >= 2 && losses == 0) {
            return 2;
        }
        if (wins > losses) {
            return 1;
        }
        return 0;
    }

    /**
     * Bonus opcional por racha propia previo al match.
     */
    public int streakBonus(int winStreakBeforeMatch) {
        if (!config.isStreakBonusEnabled()) {
            return 0;
        }
        if (winStreakBeforeMatch < 2) {
            return 0;
        }
        return Math.min(config.getStreakBonusValue(), config.getStreakCap());
    }
}
