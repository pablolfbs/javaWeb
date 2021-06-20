package com.pablo.teste;

import java.text.DecimalFormat;
import java.util.Scanner;

import com.pablo.util.CurrencyConverter;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		System.out.println("Qual o pre�o do d�lar? ");
		double cotacao = in.nextDouble();
		
		System.out.println("Quantos dolares vc vai comprar?");
		double quantidade = in.nextDouble();
		
		System.out.println("Qual o pre�o do d�lar? " + new DecimalFormat("0.00").format(cotacao));
		System.out.println("Quantos dolares vc vai comprar? " + new DecimalFormat("0.00").format(quantidade));
		
		double aPagar = CurrencyConverter.aPagar(cotacao, quantidade);
		System.out.println("Voc� ter� que pagar em reais = " + new DecimalFormat("0.00").format(aPagar));
		
//		Aluno a = new Aluno();
//		a.calculaNotaFinal(new double[] {15, 25,10});

//		Funcionario f = new Funcionario("Pablo", 6000, 1000);
//
//		System.out.println("Nome: " + f.getNome());
//		System.out.println("Sal�rio: " + f.calculaSalarioLiquido());
//		System.out.println("Taxa: " + f.getImposto());
//
//		System.out.println("Funcion�rio: " + f.getNome() + ", " + f.calculaSalarioLiquido());
//
//		System.out.println("Qual a porcentagem para aumentar o sal�rio?");
//		f.aumentarSalario(in.nextDouble());
//
//		Retangulo r = new Retangulo();
//		
//		System.out.println("D� a largura do ret�ngulo: ");
//		r.setWidth(in.nextDouble());
//		
//		System.out.println("D� a altura do ret�ngulo: ");
//		r.setHeight(in.nextDouble());
//		
//		System.out.println(r.area());
//		System.out.println(r.perimeter());
//		System.out.println(r.diagonal());
		
		in.close();
		
	}
	
}
