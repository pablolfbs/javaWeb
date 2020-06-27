package model;

public class Usuario {

	private Integer id;
	private String email;
	private String senha;

	public Usuario() {
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

	public boolean validate(String email, String senha) {
		if (!this.email.equals(email) && !this.senha.equals(senha)) {
			return false;
		} else {
			return true;
		}
	}
}
