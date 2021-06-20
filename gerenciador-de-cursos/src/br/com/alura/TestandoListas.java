package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestandoListas {

	public static void main(String[] args) {
		
		String aula1 = "Conhecendo mais de listas";
		String aula2 = "Modelando a classe Aula";
		String aula3 = "Trabalhando com Cursos e Sets";
		
		List<String> aulas = new ArrayList<String>();
		aulas.add(aula1);
		aulas.add(aula2);
		aulas.add(aula3);
		
		aulas.remove(0);
		
		System.out.println(aulas);
		
		for (int i = 0; i < aulas.size(); i++) {
			System.out.println(aulas.get(i));
		}
		
		for (String aula : aulas) {
			System.out.println(aula);
		}
		
		aulas.forEach(aula -> {
			System.out.println(aula);
		});
		
		aulas.add("Aumentando nosso conhecimento");
		
		Collections.sort(aulas);
		System.out.println(aulas);
		
	}

}
