package com.pablo.model;

public class Endereco {

	private String logradouro;
	private String nome;
	private int numero;
	private String complemento;

	public Endereco(String logradouro, String nome, int numero, String complemento) {
		super();
		this.logradouro = logradouro;
		this.nome = nome;
		this.numero = numero;
		this.complemento = complemento;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getNome() {
		return nome;
	}

	public int getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}
	
	@Override
	public String toString() {
		return "[Logradouro: " + this.logradouro + ", Nome: " + this.getNome() + 
				", Número: " + this.numero + ", Complemento: " + this.complemento + "]";
	}

}
