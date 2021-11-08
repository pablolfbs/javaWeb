package com.pablo.teste;

public class TesteMatriz {
	
	public static void main(String[] args) {
		
		int[][] array = {
							 { 10 , 8 , 15, 12 },
							 { 21 , 8          },
							 { 8  , 5 , 15, 19 },
							 { 8  , 8 , 50, 8  },
							 { 800, 80, 50, 80 },
							 { 8               },
							 { 42 , 90, 33, 73 }
						 };
		
		int x = 15;
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == x) {
					if (j > 0)
						System.out.println(array[i][j - 1]);
					if (i > 0)
						System.out.println(array[i - 1][j]);
					if (j < array[i].length - 1 && array[i - 1].length >= array[i].length)
						System.out.println(array[i][j + 1]);
					if (i < array.length - 1 && array[i + 1].length >= array[i].length)
						System.out.println(array[i + 1][j]);
				}
			}
		}
	}
}
