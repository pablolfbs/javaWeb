package br.com.alura;

import java.util.Iterator;
import java.util.Set;

public class TestaCursoComAluno {

	public static void main(String[] args) {

		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");

		javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
		javaColecoes.adiciona(new Aula("Modelando Coleções", 22));
		
		Aluno a1 = new Aluno("Pablo", 123);
		Aluno a2 = new Aluno("Ingrid", 456);
		Aluno a3 = new Aluno("Alice", 789);
		
		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		javaColecoes.matricula(a3);
		
		System.out.println("Todos os alunos matriculados");
		javaColecoes.getAlunos().forEach (aluno -> System.out.println(aluno));
		
		Set<Aluno> alunos = javaColecoes.getAlunos();
		
		Iterator<Aluno> it = alunos.iterator();
		while (it.hasNext()) {
			Aluno a = it.next();
			System.out.println(a);
		}
		
		
		System.out.println("O aluno " + a1.getNome() + " está matriculado.");
		System.out.println(javaColecoes.estaMatriculado(a1));
		
		Aluno pablo = new Aluno("Pablo", 123);
		System.out.println(pablo.getNome() + " está matriculado?");
		System.out.println(javaColecoes.estaMatriculado(pablo));
		
		System.out.println("O a1 é equals ao pablo?");
		System.out.println(a1.equals(pablo));
		
		// obrigatoriamente o seguinte é true
		System.out.println(a1.hashCode() == pablo.hashCode());
	}

}
