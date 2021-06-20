package com.pablo.ex5;

public class Aluno extends Pessoa {

	private int matricula;

	public Aluno(String nome, int matricula) {
		super(nome);
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return super.toString() + "\nMatricula: " + matricula;
	}

}
