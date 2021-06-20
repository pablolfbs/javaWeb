package com.pablo.lambdas;

public class CalculoTeste2 {
	
	public static void main(String[] args) {
		
		Calculo calculo = (a, b) -> a + b;
		
		System.out.println(calculo.executar(2, 3));
		
	}

}
