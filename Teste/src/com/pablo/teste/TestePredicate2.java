package com.pablo.teste;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class TestePredicate2 {
	
	public static void main(String[] args) {
		
		Predicate<String> predicate = p -> p.length() > 10;
		stringList().stream().filter(predicate).forEach(System.out::println);
		
//		não compila
//		Function<String, Boolean> function1 = p -> p.length() > 10;
//		Stream<String> stream2 = stringList().stream().filter(function1).forEach(System.out::println);
		
//		compila
		Function<String, Boolean> function2 = p -> p.length() > 10;
		stringList().stream().map(function2).forEach(System.out::println);
		
	}

	private static List<String> stringList() {
		return Arrays.asList("Santa Catarina", "Paraná", "São Paulo", "Rio de Janeiro", "Brasília", "Ceará");
	}

}
