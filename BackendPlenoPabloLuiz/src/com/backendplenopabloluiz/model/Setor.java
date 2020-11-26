package com.backendplenopabloluiz.model;

import java.io.Serializable;

/**
 * Classe de modelo de setor.
 * 
 * @author pablo
 *
 */
public class Setor implements Serializable {

	private static final long serialVersionUID = -5090874618517097149L;

	private Integer id;
	private String descricao;

	public Setor() {
	}

	public Setor(Integer id) {
		this.id = id;
	}

	public Setor(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
