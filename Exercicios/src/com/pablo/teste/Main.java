package com.pablo.teste;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

	static DecimalFormat df = new DecimalFormat("#.##");

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

//		exponenciacaoInformadaPeloUsuario();
//		crescimentoAnos();
//		intervaloNumerosComSomaTotal();
		fibonacci();
//		tabuadaPersonalizada();
//		fatorial();

		in.close();
	}

//	private static void fatorial() {
//		System.out.println("Digite um número: ");
//		int num = in.nextInt();
//		
//		double total = 1;
//		for (int i = num; i > 0; i--) {
//			total += total * (i - 1);
//		}
//		System.out.println(df.format(total));
//	}
//
//	private static void tabuadaPersonalizada() {
//		System.out.println("Informe o valor da tabuada: ");
//		int num = in.nextInt();
//
//		System.out.println("A tabuada deve iniciar por qual valor? ");
//		int ini = in.nextInt();
//
//		System.out.println("Até qual valor vai a tabuada? ");
//		int fim = in.nextInt();
//
//		for (int i = ini; i <= fim; i++) {
//			System.out.println(num + "  x " + (i < 10 ? "  " + i : i < 100 ? " " + i : i) + "  =  " + num * i);
//		}
//	}
//
	private static void fibonacci() {
		System.out.println("Digite um número: ");
		int num = in.nextInt();
		System.out.print("0  1  ");

		double anterior = 0;
		double atual = 1;
		for (int i = 0; i < num - 2; i++) {
			atual += anterior;
			anterior = atual - anterior;
			System.out.print(df.format(atual) + "  ");
		}
	}
//
//	private static void exponenciacaoInformadaPeloUsuario() {
//		System.out.println("Digite o valor da base: ");
//		int base = in.nextInt();
//		System.out.println("Digite o valor do expoente: ");
//		int expoente = in.nextInt();
//
//		DecimalFormat df = new DecimalFormat("#.##");
//
//		double res = Math.pow(base, expoente);
//		System.out.println(df.format(res));
//	}
//
//	private static void crescimentoAnos() {
//		double a = 80000;
//		double b = 200000;
//
//		double crescA = 80000 * 3 / 100;
//		double crescB = 200000 * 1.5 / 100;
//
//		int anos = 0;
//
//		while (b > a) {
//			a += crescA;
//			b += crescB;
//
//			anos++;
//		}
//		System.out.println(anos);
//	}
//
//	private static void intervaloNumerosComSomaTotal() {
//		System.out.println("Informe um número: ");
//		int a = in.nextInt();
//
//		System.out.println("Informe outro número: ");
//		int b = in.nextInt();
//
//		int soma = 0;
//		if (a < b) {
//			for (int i = a; i <= b; i++) {
//				soma += i;
//				System.out.println(i);
//			}
//			System.out.println(soma);
//		} else {
//			for (int i = a; i >= b; i--) {
//				soma += i;
//				System.out.println(i);
//			}
//			System.out.println(soma);
//		}
//	}
}
