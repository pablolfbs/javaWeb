package com.pablo.teste;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class TestePredicate1 {
	
	public static void main(String[] args) {
		
		List<String> lista = Arrays.asList("Santa Catarina", "Paraná", "São Paulo", "Rio de Janeiro", "Brasília", "Ceará");
		// lista.stream().filter(l -> l.equalsIgnoreCase("Rio de Janeiro")).forEach(System.out::println);
		
		System.out.println("Estados que iniciam com a letra s:");
		// filtro(lista, s -> s.startsWith("S"));
		filtro(lista, comecaComS());
		
		System.out.println("Estados que terminan com a letra a:");
		filtro(lista, terminaComA());
		
		System.out.println("Imprime todos os estados:");
		filtro(lista, imprimeTodaALista());
		
		System.out.println("Não imprime nada:");
		filtro(lista, naoImprimeNada());
		
		System.out.println("Imprime os nomes com mais de 10 caracteres:");
		filtro(lista, mais10Caracteres());
	}


	private static Predicate<String> comecaComS() {
		return l -> l.startsWith("S");
	}
	
	private static Predicate<String> terminaComA() {
		return l -> l.endsWith("a");
	}
	
	private static Predicate<String> imprimeTodaALista() {
		return l -> true;
	}
	
	private static Predicate<String> naoImprimeNada() {
		return l -> false;
	}
	
	private static Predicate<String> mais10Caracteres() {
		return l -> l.length() > 10;
	}
	
	public static void filtro(List<String> lista, Predicate<String> condicao) {
//		lista.forEach(s -> {
//			if (condicao.test(s)) {
//				System.out.println(s);
//			}
//		});
		lista.stream().filter(condicao).forEach(System.out::println);
	}

}
