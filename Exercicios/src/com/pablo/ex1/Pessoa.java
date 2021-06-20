package com.pablo.ex1;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Pessoa {

	private String nome;
	private Date dataNasc;
	private float altura;

	public Pessoa() {
		super();
	}

	public Pessoa(String nome, Date dataNasc, float altura) {
		super();
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.altura = altura;
	}

	public int calculaIdade() {
		Calendar dateOfBirth = new GregorianCalendar();
		dateOfBirth.setTime(this.dataNasc);

		Calendar today = Calendar.getInstance();
		int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

		dateOfBirth.add(Calendar.YEAR, age);

		return today.before(dateOfBirth) ? age - 1 : age;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", dataNasc=" + dataNasc + ", altura=" + altura + "]";
	}

}
