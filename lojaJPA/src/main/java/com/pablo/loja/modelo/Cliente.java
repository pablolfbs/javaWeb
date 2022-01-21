package com.pablo.loja.modelo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Embedded
	private DadosPessoais dadosPessoais;

	public Cliente() {
		super();
	}

	public Cliente(@NonNull String nome, @NonNull String cpf) {
		this.dadosPessoais = new DadosPessoais(nome, cpf);
	}

	public String getNome() {
		return this.getDadosPessoais().getNome();
	}
	
	public String getCpf() {
		return this.getDadosPessoais().getCpf();
	}

}
