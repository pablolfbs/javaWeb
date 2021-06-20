package com.pablo.teste;

import java.text.DecimalFormat;
import java.util.Scanner;

import com.pablo.util.CurrencyConverter;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		System.out.println("Qual o preço do dólar? ");
		double cotacao = in.nextDouble();
		
		System.out.println("Quantos dolares vc vai comprar?");
		double quantidade = in.nextDouble();
		
		System.out.println("Qual o preço do dólar? " + new DecimalFormat("0.00").format(cotacao));
		System.out.println("Quantos dolares vc vai comprar? " + new DecimalFormat("0.00").format(quantidade));
		
		double aPagar = CurrencyConverter.aPagar(cotacao, quantidade);
		System.out.println("Você terá que pagar em reais = " + new DecimalFormat("0.00").format(aPagar));
		
//		Aluno a = new Aluno();
//		a.calculaNotaFinal(new double[] {15, 25,10});

//		Funcionario f = new Funcionario("Pablo", 6000, 1000);
//
//		System.out.println("Nome: " + f.getNome());
//		System.out.println("Salário: " + f.calculaSalarioLiquido());
//		System.out.println("Taxa: " + f.getImposto());
//
//		System.out.println("Funcionário: " + f.getNome() + ", " + f.calculaSalarioLiquido());
//
//		System.out.println("Qual a porcentagem para aumentar o salário?");
//		f.aumentarSalario(in.nextDouble());
//
//		Retangulo r = new Retangulo();
//		
//		System.out.println("Dê a largura do retângulo: ");
//		r.setWidth(in.nextDouble());
//		
//		System.out.println("Dê a altura do retângulo: ");
//		r.setHeight(in.nextDouble());
//		
//		System.out.println(r.area());
//		System.out.println(r.perimeter());
//		System.out.println(r.diagonal());
		
		in.close();
		
	}
	
}
