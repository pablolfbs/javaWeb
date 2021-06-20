package com.pablo.lambdas;

import java.util.function.Function;

public class Funcao {
	
	public static void main(String[] args) {
		
		Function<Integer, String> parOuImpar = num -> num % 2 == 0 ? "Par" : "Ímpar";
		System.out.println(parOuImpar.apply(543));
		
		Function<String, String> oResultadoE = valor -> "O resultado é: " + valor;
		System.out.println(parOuImpar.andThen(oResultadoE).apply(35));
		
	}

}
