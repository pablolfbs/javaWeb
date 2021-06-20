package com.pablo.ex3;

import java.text.DecimalFormat;

public class ContaCorrente {

	private int numero;
	private float saldo;
	private String status;
	private float limite;

	public ContaCorrente(int numero, float saldo, String status, float limite) {
		super();
		this.numero = numero;
		this.saldo = saldo;
		this.status = status;
		this.limite = limite;
	}

	public void realizaSaque(float valor) {
		if (this.saldo + this.limite > valor)
			this.saldo -= valor;
		else
			System.out.println("Saldo Insuficiente!");
	}

	public void deposita(float valor) {
		this.saldo += valor;
	}

	public void consultaSaldo() {
		System.out.println("R$ " + new DecimalFormat("0.00").format(this.saldo));
		System.out.print("Limite utilizado: R$ ");
		System.out.println(this.saldo < 0 ? new DecimalFormat("0.00").format(this.saldo) : "R$ 0,00");
		System.out.print("Limite Cheque especial disponível: R$ ");
		System.out.println(this.saldo < 0 ? new DecimalFormat("0.00").format(this.limite + (this.saldo)) : this.limite);
	}

	public boolean utilizaChequeEspecial() {
		return this.saldo < 0;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

}
