package edu.masanz.da.cw.model;

/**
 * Estado de clasificación de un jugador dentro de una liga.
 */
public class Standing {

    private final Jugador jugador;
    private int wins;
    private int draws;
    private int losses;
    private int winStreak;
    private int points;

    public Standing(Jugador jugador) {
        if (jugador == null) {
            throw new IllegalArgumentException("jugador no puede ser null");
        }
        this.jugador = jugador;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public int getWins() {
        return wins;
    }

    public void incrementWins() {
        wins++;
    }

    public int getDraws() {
        return draws;
    }

    public void incrementDraws() {
        draws++;
    }

    public int getLosses() {
        return losses;
    }

    public void incrementLosses() {
        losses++;
    }

    public int getWinStreak() {
        return winStreak;
    }

    public void incrementWinStreak() {
        winStreak++;
    }

    public void resetWinStreak() {
        winStreak = 0;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount debe ser >= 0");
        }
        points += amount;
    }
}
