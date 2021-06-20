package com.pablo.lambdas;

import java.util.Arrays;
import java.util.List;

public class Foreach {
	
	public static void main(String[] args) {
		
		List<String> aprovados = Arrays.asList("Ana", "Bia", "Lia", "Gui");
		
		aprovados.forEach(System.out::println);
		
		aprovados.forEach(Foreach::meuImprimir);
		
	}
	
	private static void meuImprimir(String nome) {
		System.out.println("Oi! Meu nome é " + nome);
	}

}
