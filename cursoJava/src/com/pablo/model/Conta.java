package com.pablo.model;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

public class Conta {
	
	@Getter
	private int numero;
	
	@Getter
	@Setter
	private String nomeTitular;
	
	@Getter
	private double saldo;
	
	private boolean depositoInicial;
	
	Scanner in = new Scanner(System.in);

	public void abrirConta() {
		
		criaConta();
		
		System.out.println("Digite o seu nome: ");
		this.nomeTitular = in.nextLine();
		System.out.println("O nome que vc digitou é " + this.nomeTitular);
		
		depositoInicial();
		
		mensagemDadosContaCriada();
		
		in.close();
	}
	
	public void deposita(double valorDepositado) {
		System.out.println("Depositar " + valorDepositado);
		this.saldo += valorDepositado;
		System.out.println("Saldo " + this.saldo);
	}
	
	public void saca(double valorSacado) {
		System.out.println("Sacar " + valorSacado);
		this.saldo -= valorSacado + 5;
		System.out.println("Saldo: " + this.saldo);
	}

	private void criaConta() {
		Random rand = new Random();
		this.numero = rand.nextInt(1000);
		System.out.println("O número da sua conta é: " + this.numero);
	}

	private void mensagemDadosContaCriada() {
		System.out.println("Dados da conta: ");
		System.out.println("Número da conta: " + this.numero);
		System.out.println("Nome do titular: " + this.nomeTitular);
		if (this.depositoInicial) {
			System.out.println("Valor inicial: " + new DecimalFormat("0.00").format(this.saldo));
		}
	}

	private void depositoInicial() {
		int num;
		do {
			System.out.println("Você quer fazer um depósito inicial? Digite 1 para sim ou 2 para não.");
			num  = in.nextInt();
			if (num == 1) {
				this.depositoInicial = true;
				System.out.println("Qual valor inicial vc deseja depositar?");
				this.saldo = in.nextDouble();
			} else if (num == 2) {
				this.depositoInicial = false;
			}
		} while(num > 2 || num < 1);
	}

}
