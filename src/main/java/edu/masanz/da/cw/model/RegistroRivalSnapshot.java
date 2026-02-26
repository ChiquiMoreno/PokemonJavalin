package edu.masanz.da.cw.model;

/**
 * Snapshot inmutable del estado de un rival antes del match.
 */
public class RegistroRivalSnapshot {

    private final int wins;
    private final int losses;

    public RegistroRivalSnapshot(int wins, int losses) {
        if (wins < 0 || losses < 0) {
            throw new IllegalArgumentException("wins y losses del rival deben ser >= 0");
        }
        this.wins = wins;
        this.losses = losses;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }
}
