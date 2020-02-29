package br.senac.rj.model;

import java.io.Serializable;

public class Cliente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6232503354224000775L;
	
	private int id;
	private String nome;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
