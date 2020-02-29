package teste;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Test;
import org.junit.Test;

import exemplo.Calculadora;

class CalculadoraTeste {
	Calculadora calculadora = new Calculadora();

	@Test
	public void testarASomaEntreInteiros() {
		assertEquals(calculadora .somar(2, 2), 4);
		assertEquals(calculadora.somar(1, 1), 2);
		assertEquals(calculadora.somar(-5, 2), -3);
	}
	
	@Test
	public void testarSubtracaoEntreInteiros() {
		assertTrue(calculadora.subtrair(2, 2) == 0);
		assertTrue(calculadora.subtrair(-2, -2) == 0);
		assertTrue(calculadora.subtrair(5, 3) == 2);
	}
	
	@Test(expected = ArithmeticException.class)
	public void testarDivisaoEntreInteiros() {
		assertEquals(calculadora.dividir(5, 2), 2);
		assertEquals(calculadora.dividir(5, 0), 0);
	}

}
