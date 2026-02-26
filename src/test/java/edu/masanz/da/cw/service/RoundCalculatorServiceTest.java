package edu.masanz.da.cw.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoundCalculatorServiceTest {

    private final RoundCalculatorService service = new RoundCalculatorService();

    @Test
    void calculateOptimalRounds_borde2a20() {
        assertEquals(1, service.calculateOptimalRounds(2, 1, 10));
        assertEquals(2, service.calculateOptimalRounds(3, 1, 10));
        assertEquals(2, service.calculateOptimalRounds(4, 1, 10));
        assertEquals(3, service.calculateOptimalRounds(5, 1, 10));
        assertEquals(3, service.calculateOptimalRounds(8, 1, 10));
        assertEquals(4, service.calculateOptimalRounds(9, 1, 10));
        assertEquals(4, service.calculateOptimalRounds(16, 1, 10));
        assertEquals(5, service.calculateOptimalRounds(17, 1, 10));
        assertEquals(5, service.calculateOptimalRounds(20, 1, 10));
    }

    @Test
    void calculateOptimalRounds_respetaLimites() {
        assertEquals(3, service.calculateOptimalRounds(2, 3, 8));
        assertEquals(4, service.calculateOptimalRounds(20, 1, 4));
    }

    @Test
    void byeYPartidasPorRonda() {
        assertTrue(service.hasBye(3));
        assertFalse(service.hasBye(4));
        assertEquals(1, service.matchesPerRound(3));
        assertEquals(2, service.matchesPerRound(4));
        assertEquals(10, service.totalMatches(5, 5));
    }

    @Test
    void validaRangos() {
        assertThrows(IllegalArgumentException.class, () -> service.calculateOptimalRounds(1, 1, 5));
        assertThrows(IllegalArgumentException.class, () -> service.calculateOptimalRounds(21, 1, 5));
        assertThrows(IllegalArgumentException.class, () -> service.calculateOptimalRounds(8, 0, 5));
        assertThrows(IllegalArgumentException.class, () -> service.calculateOptimalRounds(8, 4, 3));
    }
}
