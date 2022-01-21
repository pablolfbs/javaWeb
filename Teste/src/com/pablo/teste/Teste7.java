package com.pablo.teste;

import java.util.Arrays;

public class Teste7 {
	
	public static void main(String[] args) {
		
		int[] arrayInteiros = {10, 15, 2, -1, 0, 5, 55, 20};
		
		somaValoresArray(arrayInteiros);
		
		somaValoresArrayStream(arrayInteiros);
	}

	private static void somaValoresArrayStream(int[] arrayInteiros) {
		System.out.println(Arrays.stream(arrayInteiros).sum());
	}

	private static void somaValoresArray(int[] arrayInteiros) {
		int res = 0;
		for (int i = 0; i < arrayInteiros.length; i++) {
			res += arrayInteiros[i];
		}
		System.out.println(res);
	}

}
