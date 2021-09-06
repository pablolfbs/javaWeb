package com.pablo.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Contato {

	private Integer id;
	private String nome;
	
	private List<String> telefones = new ArrayList<>();
	
	private List<Endereco> enderecos = new ArrayList<>();

	public Contato(String nome) {
		super();
		this.nome = nome;
	}

	public Contato(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Contato(Integer id, String nome, List<String> telefones) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefones = telefones;
	}
	
	public void adicionaEndereco(Endereco endereco) {
		this.enderecos.add(endereco);
	}

	public Contato() {
		super();
	}

}
