package br.com.alura;

public class TestaBuscaAlunosNoCurso {
	
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
		
		System.out.println("Quem é o aluno com matrícula 123");
		Aluno aluno = javaColecoes.buscaMatriculado(123);
		System.out.println(aluno);
	}

}
