package com.pablo.ex11;

import junit.framework.TestCase;

public class CalculoTest extends TestCase {
	
	public void testeExecutaCalculo() {
		
		float v1 = 10;
		float v2 = 6;
		float retornEsperado = 15;
		
		float retornoFeito = Calculo.executaCalculo(v1, v2);
		
		assertEquals(retornEsperado, retornoFeito, 0);
	}

}
