package com.pablo.teste;

public class TesteEnum {
	
	public static void main(String[] args) {
		
		// double calculo = CalculadoraEnum.valueOf(CalculadoraEnum.class, "MULTIPLICACAO").calcula(4, 3);
		// double calculo = CalculadoraEnum.MULTIPLICACAO.calcula(4, 3);
		// System.out.println(calculo);
		
		for (CalculadoraEnum calc : CalculadoraEnum.values()) {
			System.out.println(calc.calcula(12, 3));
		}
		
	}

}
