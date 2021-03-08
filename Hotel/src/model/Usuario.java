package model;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = -6093944336957320306L;
	
	private Integer id;
	private String email;
	private String senha;

	public Usuario() {
	}
	
	public Usuario(String email) {
		this.email = email;
	}

	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
