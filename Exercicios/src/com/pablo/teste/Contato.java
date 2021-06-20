package com.pablo.teste;

import java.util.ArrayList;
import java.util.List;

public class Contato {

	private String nome;
	private String email;

	private List<Telefone> telefones = new ArrayList<>();

	public Contato(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}

	public void adicionaTelefones(Telefone telefone) {
		telefones.add(telefone);
	}

	public Contato() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	@Override
	public String toString() {
		return "Contato [nome=" + nome + ", email=" + email + ", telefones=" + telefones + "]";
	}

}
