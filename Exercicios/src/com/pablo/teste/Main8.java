package com.pablo.teste;


public class Main8 {

	public static void main(String[] args) {
		
		// System.out.println("Simplificando expressões para reduzir o número de
		// linhas");

		// System.out.println("O número digitado é " + (new Scanner(System.in).nextInt()
		// > 10 ? "maior do que 10" : "menor ou igual a 10"));

//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		
//		for (int i = 10; i >= 0; i--) {
//			System.out.println(n + " x " + i + " = " + n * i);
//		}

		int[] vetor = new int[] { 2, 4, 6, 8, 10, 12 };
		for (int i = 0; i <= 12; i++) {
			System.out.println(vetor[i]);
			if (i == vetor.length - 1)
				throw new RuntimeException("O vetor acabou!");
		}

	}

}
