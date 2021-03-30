package model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Usuario implements Serializable {

	private static final long serialVersionUID = -6093944336957320306L;
	
	private Integer id;
	private String email;
	private String senha;

	public Usuario(String email) {
		this.email = email;
	}

	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

}
