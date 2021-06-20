package com.pablo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Funcionario {

	
	private String nome;
	private double salarioBruto;
	private double imposto;
	
	public void aumentarSalario(double porcentagem) {
		this.salarioBruto += this.salarioBruto * porcentagem / 100;
		System.out.println("Salário atualizado: " + nome + ", " + calculaSalarioLiquido());
	}
	
	public double calculaSalarioLiquido() {
		return this.salarioBruto - this.imposto;
	}
	
}
