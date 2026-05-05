package Calculadora;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCalculo {

    @Test
    void testeSoma() {
        Soma soma = new Soma();
        assertEquals(5, soma.calcularS(2, 3));
    }

    @Test
    void testeSubtracao() {
        Subtracao sub = new Subtracao();
        assertEquals(3, sub.calcularS(5, 2));
    }

    @Test
    void testeMultiplicacao() {
        Multiplicacao mult = new Multiplicacao();
        assertEquals(12, mult.calcularM(4, 3));
    }

    @Test
    void testeDivisao() {
        Divisao div = new Divisao();
        assertEquals(5, div.calcularD(10, 2));
    }

    @Test
    void testeDivisaoPorZero() {
        Divisao div = new Divisao();

        assertThrows(ArithmeticException.class, () -> {
            div.calcularD(10, 0);
        });
    }

    @Test
    void testeNumerosNegativos() {
        Soma soma = new Soma();
        assertEquals(1, soma.calcularS(-2, 3));
    }

    @Test
    void testeNumerosDecimais() {
        Multiplicacao mult = new Multiplicacao();
        assertEquals(5.0, mult.calcularM(2.5, 2));
    }
}