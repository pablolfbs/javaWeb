package com.pablo.teste;

public class Telefone {

	private String numero;

	public Telefone() {
		super();
	}

	public Telefone(String numero) {
		super();
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Telefone [numero=" + numero + "]";
	}

}
