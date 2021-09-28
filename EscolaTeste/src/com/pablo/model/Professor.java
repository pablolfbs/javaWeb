package com.pablo.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Professor extends Pessoa {
	
	private BigDecimal salario;

	public Professor(Long id, String nome, String cpf, String matricula, BigDecimal salario) {
		super(id, nome, cpf, matricula);
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "id=" + super.getId() + ", nome=" + super.getNome() + ", cpf=" + super.getCpf() + ", matricula=" + super.getMatricula() + ", salario=" + salario;
	}
	
	

}
