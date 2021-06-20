package com.pablo.ex7;

public class Empregado {

	private String nome;
	private String sobrenome;
	private double salario;

	public Empregado(String nome, String sobrenome, double salario) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.salario = salario > 0 ? salario : 0.0;
	}

	public double salarioAnual() {
		return getSalario() * 12;
	}

	public double salarioComAumento() {
		return (getSalario() + getSalario() * 0.1) * 12;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Empregado [nome=" + nome + ", sobrenome=" + sobrenome + ", salario=" + salario + "]";
	}

}
