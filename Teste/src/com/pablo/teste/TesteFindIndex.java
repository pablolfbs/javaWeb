package com.pablo.teste;

public class TesteFindIndex {
	
	public static void main(String[] args) {
		
		int[] arrayInteiros = {10, 15, 2, -1, 0, 5, 55, 20};
		
		System.out.println(findIndex(arrayInteiros, 10));
		
	}
	
	private static int findIndex(int[] arrayInteiros, int valor) {
		
		for (int i = 0; i < arrayInteiros.length; i++) {
			if (arrayInteiros[i] == valor) {
				return i;
			}
		}
		return -1;
	}

}
