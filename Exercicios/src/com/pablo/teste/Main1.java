package com.pablo.teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Main1 {

	public static void main(String[] args) {

//		Turma.listar().forEach(a -> System.out.println(a.getNome()));

		Optional.ofNullable(Turma.listar()).orElse(Collections.emptyList())
				.forEach(a -> System.out.println(a.getNome()));

//		 Turma.listar().ifPresentOrElse(a -> System.out.println(a.get(0).getNome()),
//		 () -> System.out.println("Não tem alunos para listar!"));
//
//		Turma.listar().filter(a -> a.get(0).getNome().equals("Pablo"))
//				.ifPresentOrElse(a -> System.out.println(a.get(0).getNome()), () -> System.out.println("Teste"));

		Aluno a1 = new Aluno();
		Aluno a2 = new Aluno();
		a1.setNome("Ingrid");
		a2.setNome("Alice");

		System.out.println(a1.getNome().compareTo(a2.getNome()));

	}

}

class Turma {

	private int num;
	static List<Aluno> alunos = new ArrayList<Aluno>();

	public static List<Aluno> listar() {

		Aluno a1 = new Aluno(10L, "Pablo");
		Aluno a2 = new Aluno(20L, "Ingrid");
		alunos.add(a1);
		alunos.add(a2);

		return alunos;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public List<Aluno> getAlunos() {
		return Turma.alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		Turma.alunos = alunos;
	}

}

class Aluno implements Comparable<Aluno> {

	private long matricula;
	private String nome;

	public Aluno() {
		super();
	}

	public Aluno(long matricula, String nome) {
		this.matricula = matricula;
		this.nome = nome;
	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int compareTo(Aluno aluno) {
		return this.nome.compareTo(aluno.nome);
	}

}
