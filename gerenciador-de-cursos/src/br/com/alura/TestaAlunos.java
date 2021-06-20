package br.com.alura;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class TestaAlunos {

	public static void main(String[] args) {
		
		Collection<String> alunos = new HashSet<String>();
		alunos.add("Pablo");
		alunos.add("Ingrid");
		alunos.add("Alice");
		alunos.add("Antonio Luiz");
		alunos.add("Nadja");
		alunos.add("Marcello");
		
		boolean pabloEstaMatriculado = alunos.contains("Pablo");
		System.out.println(pabloEstaMatriculado);
		
		alunos.remove("Antonio Luiz");
		
		System.out.println(alunos);
		
		alunos.forEach(a -> System.out.println(a));
		
		List<String> alunosEmLista = new ArrayList<String>(alunos);
		alunosEmLista.get(5);
		
		
	}

}
 