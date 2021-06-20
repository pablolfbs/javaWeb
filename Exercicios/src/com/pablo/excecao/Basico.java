package com.pablo.excecao;

public class Basico {
	
	public static void main(String[] args) {
		
		Aluno a1 = null;
		try {
			imprimeNomeDoAluno(a1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println(7 / 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Fim :)");
		
	}
	
	private static void imprimeNomeDoAluno(Aluno aluno) {
		System.out.println(aluno.nome);
	}

}
