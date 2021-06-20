package com.alura.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.alura.dao.LivroDAO;
import com.alura.model.Curso;
import com.alura.model.Livro;

public class CursoServico {
	
	LivroDAO dao = new LivroDAO();
	
	public List<Livro> buscarLivros() throws URISyntaxException, IOException, InterruptedException {
		HttpResponse<String> livros = dao.listarSincrono();
		
		return Stream.of(livros.body().split("\n"))
				.map(LivroServico::criar)
				.collect(Collectors.toList());
	}
	
	public List<Curso> listar() throws URISyntaxException, IOException, InterruptedException {
		List<Livro> livros = this.buscarLivros();
		Curso java = new Curso("Java OO", "Conceitos básicos de OO", "12 horas", livros.get(0));
		Curso spring = new Curso("Spring", "Novidades do spring", "12 horas", livros.get(2));
		Curso ejb = new Curso("EJB", "EJB avançado", "16 horas", livros.get(5));
		
		List<Curso> cursos = List.of(java, spring, ejb);

		return cursos;
	}

}
