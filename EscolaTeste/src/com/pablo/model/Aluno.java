package com.pablo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Aluno extends Pessoa {
	
	public Aluno(Long id, String nome, String cpf, String matricula) {
		super(id, nome, cpf, matricula);
	}
	

}
