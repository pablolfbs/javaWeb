package com.pablo.teste;

public class Main7 {

	public static void main(String[] args) {

		// maiorNumero(2, 23);
		// numeroDecrescente(5);
		// operacoes0A30();
		System.out.println(numeroDeDigitos(18));

	}

	private static int numeroDeDigitos(int n) {
		if (n == 0)
			return 1;

		int count = 0;
		while (n != 0) {
			n = n / 10;
			count++;
		}
		return count;
	}

//	private static void operacoes0A30() {
//		int soma = 0;
//		int multiplicacao = 0;
//		for (int i = 0; i <= 30; i++) {
//			if (i % 2 != 0) {
//				soma += i;
//			} else {
//				multiplicacao *= i;
//			}
//		}
//		System.out.println(soma);
//		System.out.println(multiplicacao);
//	}

//	private static void numeroDecrescente(int n) {
//		for (int i = n; i >= 0; i--) {
//			System.out.println(i);
//		}
//
//	}

//	private static void maiorNumero(int a, int b) {
//		System.out.println(a > b ? a : b);
//
//	}

}
