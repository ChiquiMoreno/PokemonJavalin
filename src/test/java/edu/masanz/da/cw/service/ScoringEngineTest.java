package edu.masanz.da.cw.service;

import edu.masanz.da.cw.model.Jugador;
import edu.masanz.da.cw.model.RegistroRivalSnapshot;
import edu.masanz.da.cw.model.ResultadoPartida;
import edu.masanz.da.cw.model.Standing;
import edu.masanz.da.cw.model.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoringEngineTest {

    @Test
    void bonusRivalSegunRegla() {
        ScoringEngine engine = new ScoringEngine(ScoringConfig.defaultConfig());

        assertEquals(0, engine.opponentStrengthBonus(new RegistroRivalSnapshot(0, 0)));
        assertEquals(0, engine.opponentStrengthBonus(new RegistroRivalSnapshot(1, 1)));
        assertEquals(1, engine.opponentStrengthBonus(new RegistroRivalSnapshot(2, 1)));
        assertEquals(2, engine.opponentStrengthBonus(new RegistroRivalSnapshot(2, 0)));
        assertEquals(1, engine.opponentStrengthBonus(new RegistroRivalSnapshot(1, 0)));
    }

    @Test
    void bonusRachaConCap() {
        ScoringConfig config = new ScoringConfig(3, 1, 0, 3, true, 2, 1);
        ScoringEngine engine = new ScoringEngine(config);

        assertEquals(0, engine.streakBonus(0));
        assertEquals(0, engine.streakBonus(1));
        assertEquals(1, engine.streakBonus(2));
        assertEquals(1, engine.streakBonus(5));
    }

    @Test
    void aplicaResultadosYReseteaRachaEnDrawLoss() {
        ScoringConfig config = new ScoringConfig(3, 1, 0, 3, true, 1, 1);
        ScoringEngine engine = new ScoringEngine(config);
        Standing standing = new Standing(nuevoJugador("ash"));

        engine.applyResult(standing, ResultadoPartida.WIN, new RegistroRivalSnapshot(0, 0));
        assertEquals(1, standing.getWins());
        assertEquals(1, standing.getWinStreak());
        assertEquals(3, standing.getPoints());

        engine.applyResult(standing, ResultadoPartida.WIN, new RegistroRivalSnapshot(2, 0));
        assertEquals(2, standing.getWins());
        assertEquals(2, standing.getWinStreak());
        assertEquals(8, standing.getPoints());

        engine.applyResult(standing, ResultadoPartida.DRAW, new RegistroRivalSnapshot(2, 1));
        assertEquals(1, standing.getDraws());
        assertEquals(0, standing.getWinStreak());
        assertEquals(9, standing.getPoints());

        engine.applyResult(standing, ResultadoPartida.LOSS, new RegistroRivalSnapshot(3, 0));
        assertEquals(1, standing.getLosses());
        assertEquals(0, standing.getWinStreak());
        assertEquals(9, standing.getPoints());
    }

    @Test
    void bonusSoloEnWinOBye() {
        ScoringConfig config = new ScoringConfig(3, 1, 0, 3, true, 2, 2);
        ScoringEngine engine = new ScoringEngine(config);
        Standing standing = new Standing(nuevoJugador("misty"));

        engine.applyResult(standing, ResultadoPartida.WIN, new RegistroRivalSnapshot(2, 0));
        assertEquals(5, standing.getPoints());

        engine.applyResult(standing, ResultadoPartida.BYE_WIN, null);
        assertEquals(8, standing.getPoints());

        engine.applyResult(standing, ResultadoPartida.DRAW, new RegistroRivalSnapshot(2, 0));
        assertEquals(9, standing.getPoints());
    }

    private Jugador nuevoJugador(String id) {
        Usuario usuario = new Usuario(id, "1234");
        usuario.setNombre(id);
        return new Jugador(usuario);
    }
}
