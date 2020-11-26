package com.backendplenopabloluiz.model;

import java.io.Serializable;

/**
 * Classe de entidades de colaboradores da blacklist.
 * 
 * @author pablo
 *
 */
public class ColaboradorBlacklist implements Serializable {

	private static final long serialVersionUID = -5937819905097870231L;
	
	private Integer id;
	private String name;
	private String cpf;

	public Integer getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}


}
