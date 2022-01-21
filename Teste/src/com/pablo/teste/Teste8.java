package com.pablo.teste;

public class Teste8 {
	
	public static void main(String[] args) {
		
		int[] arrayInteiros = {10, 15, 2, -1, 0, 5, 55, 20};
		
		int[] arr = insert(arrayInteiros, 8, 1);
		for (int i : arr) {
			System.out.println(i);
		}
		
	}
	
	private static int[] insert(int[] array, int num, int index) {
		for (int i = 0; i < array.length; i++) {
			if (i == index) {
				array[i] = num;
			}
		}
		return array;
	}

}
