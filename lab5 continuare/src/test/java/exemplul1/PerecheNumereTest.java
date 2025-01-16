package exemplul1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerecheNumereTest {
    @Test
    void testSuntConsecutiveFibonacci() {
        assertTrue(new PerecheNumere(5, 8).suntConsecutiveFibonacci());
        assertFalse(new PerecheNumere(5, 10).suntConsecutiveFibonacci());
    }

    @Test
    void testCmmc() {
        assertEquals(12, new PerecheNumere(4, 6).cmmc());
    }

    @Test
    void testAuSumaCifrelorEgala() {
        assertTrue(new PerecheNumere(123, 132).auSumaCifrelorEgala());
        assertFalse(new PerecheNumere(123, 3211).auSumaCifrelorEgala());
    }

    @Test
    void testAuAcelasiNumarDeCifrePare() {
        assertTrue(new PerecheNumere(246, 862).auAcelasiNumarDeCifrePare());
        assertFalse(new PerecheNumere(246, 135).auAcelasiNumarDeCifrePare());
    }
}

