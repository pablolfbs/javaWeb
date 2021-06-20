package com.alura.model;

import java.time.LocalDate;
import java.util.List;

public class Turma {

	private LocalDate inicio;
	private LocalDate fim;
	private Curso curso;

	private List<Aluno> alunos;

	public Turma(LocalDate inicio, LocalDate fim, Curso curso, Aluno... aluno) {
		super();
		this.inicio = inicio;
		this.fim = fim;
		this.curso = curso;
		this.alunos = List.of(aluno);
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFim() {
		return fim;
	}

	public void setFim(LocalDate fim) {
		this.fim = fim;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public String toString() {
		return "\nInício da turma: " + inicio 
				+ System.lineSeparator() + "Fim da turma: " + fim 
				+ System.lineSeparator() + "Curso: " + curso.nome 
				+ System.lineSeparator() + "Livro: " + curso.livro.getNome()
				+ System.lineSeparator() + "Aluno: " + alunos;
	}

}
