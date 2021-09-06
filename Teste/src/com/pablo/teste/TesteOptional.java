package com.pablo.teste;

import java.util.Optional;

public class TesteOptional {

	public static Optional<Integer> converteEmNumero(String s) {
		try {
			Integer num = Integer.valueOf(s);
			return Optional.of(num);
		} catch (Exception e) {
			return Optional.empty();
		}

	}

	public static void main(String[] args) {
		String str = "2";
		System.out.println(converteEmNumero(str).orElse(0));
	}

}
