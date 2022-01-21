package com.pablo.teste;

import java.util.Arrays;

public class TesteSort {
	
	public static void main(String[] args) {
		int[] arrayInteiros = {10, 15, 2, -1, 0, 5, 55, 20};
		String[] arrayStrings = {"Pablo", "Ingrid", "Alice", "Marcello", "Rosa", "Nadja", "Antonio Luiz"};
		
//		Arrays.stream(arrayInteiros).sorted().forEach(System.out::println);
		
//		Arrays.sort(arrayInteiros, 0, 8);
//		for (int num : arrayInteiros) {
//			System.out.println(num);
//		}
		
		Arrays.stream(arrayStrings).sorted().forEach(System.out::println);
		
//		Arrays.sort(arrayStrings);
//		for (String string : arrayStrings) {
//			System.out.println(string);
//		}
	}

}
