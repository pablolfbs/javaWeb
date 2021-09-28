package com.pablo.test;

import java.math.BigDecimal;
import java.util.Scanner;

import com.pablo.model.Aluno;
import com.pablo.model.Professor;

public class Teste {
	
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		System.out.println("Escolha uma opção:");
		System.out.println("1 - cadastrar aluno");
		System.out.println("2 - cadastrar professor");
		
		int valor = in.nextInt();
		switch (valor) {
			case 1 -> System.out.println(cadastraAluno());
			case 2 -> System.out.println(cadastraProfessor());
		}
		
		in.close();
		
	}

	private static Professor cadastraProfessor() {
		System.out.println("Digite o id do professor: ");
		long id = in.nextLong();
		in.nextLine();
		System.out.println("Digite o nome do professor: ");
		String nome = in.nextLine();
		System.out.println("Digite a matrícula do professor: ");
		String matricula = in.nextLine();
		System.out.println("Digite o cpf do professor: ");
		String cpf = in.nextLine();
		System.out.println("Digite o salário do professor: ");
		BigDecimal salario = in.nextBigDecimal();
		
		return new Professor(id, nome, matricula, cpf, salario);
	}

	private static Aluno cadastraAluno() {
		System.out.println("Digite o id do aluno: ");
		long id = in.nextLong();
		in.nextLine();
		System.out.println("Digite o nome do aluno: ");
		String nome = in.nextLine();
		System.out.println("Digite a matrícula do aluno: ");
		String matricula = in.nextLine();
		System.out.println("Digite o cpf do aluno: ");
		String cpf = in.nextLine();
		
		return new Aluno(id, nome, matricula, cpf);
	}

}
