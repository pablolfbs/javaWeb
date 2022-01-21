package com.pablo.teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Teste9 {
	
	public static void main(String[] args) {
		
		List<String> lista = new ArrayList<>(Arrays.asList("Azul", "Vermelho", "Amarelo", "Verde", "Roxo"));
		lista.add(0, "Preto");
		
		System.out.println(lista);
		System.out.println(lista.get(1));
		lista.set(2, "Laranja");
		System.out.println(lista);
		lista.remove(2);
		System.out.println(lista);
		System.out.println(lista.contains("Verde"));
		
		List<String> lista1 = new ArrayList<>();
		lista1.add("Marrom");
		System.out.println(lista1);
		
		Collections.copy(lista, lista1);
		System.out.println(lista);
		System.out.println(lista1);
		
		Collections.reverse(lista);
		System.out.println(lista);
		
		lista1.addAll(lista);
		System.out.println(lista1);
		
	}

}
