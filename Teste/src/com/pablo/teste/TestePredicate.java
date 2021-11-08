package com.pablo.teste;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestePredicate {
	
	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList(1, 5, 15, -52, 90, 8, 14, 18, 123, -1);
		
		Predicate<Integer> maiorQueCinco = p -> p > 5;
		
		System.out.println(filterInteiros(lista, maiorQueDez()));
		System.out.println(filterInteiros(lista, negativos()));
		System.out.println(filterInteiros(lista, maiorQueCinco));
	}
	
	private static Predicate<Integer> maiorQueDez() {
		return p -> p > 10;
	}
	
	private static Predicate<Integer> negativos() {
		return p -> p < 0;
	}
	
	private static List<Integer> filterInteiros(List<Integer> inteiros, Predicate<Integer> predicate) {
		boolean test = predicate.test(6);
		System.out.println(test);
		return inteiros.stream().filter(predicate).sorted().collect(Collectors.<Integer>toList());
	}

}
