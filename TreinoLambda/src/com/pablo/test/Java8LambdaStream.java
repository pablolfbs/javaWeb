package com.pablo.test;

import java.util.Optional;
import java.util.stream.Stream;

public class Java8LambdaStream {
	
	public static void main(String[] args) {
		
		String s = "d";
		Integer numero = converteEmNumero(s).orElseGet(() -> 5);
		System.out.println(numero);
		
		Stream.of(1, 2, 3).findFirst().ifPresent(System.out::println);
	}
	
	public static Optional<Integer> converteEmNumero(String numeroStr) {
		try {
			Integer integer = Integer.valueOf(numeroStr);
			return Optional.of(integer);
		} catch (Exception e) {
			return Optional.empty();
		}
	}
}
