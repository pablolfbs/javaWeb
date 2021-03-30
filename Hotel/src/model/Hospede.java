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
public class Hospede implements Serializable {

	private static final long serialVersionUID = -8298978815260548333L;

	private int id;
	private String nome;
	private String cpf;
	private String email;

	public Hospede(int id) {
		this.id = id;
	}

	public Hospede(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}

}
