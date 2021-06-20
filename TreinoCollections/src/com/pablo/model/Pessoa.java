package com.pablo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pessoa {
	
	private String nome;
	private String cpf;
	
	private List<Endereco> enderecos = new ArrayList<Endereco>();

	public Pessoa(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public List<Endereco> getEnderecos() {
		return Collections.unmodifiableList(enderecos);
	}
	
	public void adiciona(Endereco endereco) {
		this.enderecos.add(endereco);
	}
	
	@Override
	public String toString() {
		return "[Nome: " + this.nome + ", " + this.enderecos + "]";
	}
}
