package edu.masanz.da.cw.service;

/**
 * Configuración de puntuación de liga.
 */
public class ScoringConfig {

    private final int winPoints;
    private final int drawPoints;
    private final int lossPoints;
    private final int byePoints;
    private final boolean streakBonusEnabled;
    private final int streakBonusValue;
    private final int streakCap;

    public ScoringConfig(int winPoints,
                         int drawPoints,
                         int lossPoints,
                         int byePoints,
                         boolean streakBonusEnabled,
                         int streakBonusValue,
                         int streakCap) {
        if (winPoints < 0 || drawPoints < 0 || lossPoints < 0 || byePoints < 0) {
            throw new IllegalArgumentException("Los puntos base no pueden ser negativos");
        }
        if (streakBonusValue < 0 || streakBonusValue > 2) {
            throw new IllegalArgumentException("streakBonusValue debe estar entre 0 y 2");
        }
        if (streakCap < 0 || streakCap > 2) {
            throw new IllegalArgumentException("streakCap debe estar entre 0 y 2");
        }
        this.winPoints = winPoints;
        this.drawPoints = drawPoints;
        this.lossPoints = lossPoints;
        this.byePoints = byePoints;
        this.streakBonusEnabled = streakBonusEnabled;
        this.streakBonusValue = streakBonusValue;
        this.streakCap = streakCap;
    }

    public static ScoringConfig defaultConfig() {
        return new ScoringConfig(3, 1, 0, 3, false, 1, 1);
    }

    public int getWinPoints() {
        return winPoints;
    }

    public int getDrawPoints() {
        return drawPoints;
    }

    public int getLossPoints() {
        return lossPoints;
    }

    public int getByePoints() {
        return byePoints;
    }

    public boolean isStreakBonusEnabled() {
        return streakBonusEnabled;
    }

    public int getStreakBonusValue() {
        return streakBonusValue;
    }

    public int getStreakCap() {
        return streakCap;
    }
}
