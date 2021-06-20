package com.alura.principal;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.alura.dao.Teste1HttpDAO;
import com.alura.dao.Teste2HttpDAO;
import com.alura.model.Turma;
import com.alura.service.AlunoServico;
import com.alura.service.LivroServico;
import com.alura.service.TurmaServico;

public class Principal {

	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

		var alunoServico = new AlunoServico();
		var turmaServico = new TurmaServico();
		var livroServico = new LivroServico();
		
		livroServico.listar();
		
		var dao1 = new Teste1HttpDAO();
		var dao2 = new Teste2HttpDAO();

		var alunos = alunoServico.listar().stream()
				.flatMap(a -> Stream.ofNullable(a.getNome()))
				.map(s -> s.toUpperCase())
				.collect(Collectors.toList());
		
		System.out.println(alunos);
		
		
//		var turmasPorCurso = turmaServico.listar().stream()
//				.filter(a -> LocalDate.of(2019, 06, 04).equals(a.getInicio()))
//				.collect(Collectors.groupingBy(Turma::getCurso));
		
		var turmasPorCurso = turmaServico.listar().stream()
				.collect(Collectors.groupingBy(Turma::getCurso,
						Collectors.filtering(a -> a.getInicio().equals(LocalDate.of(2019, 06, 10)), Collectors.toList())));
		
		System.out.println("Relação de turmas por curso: " + turmasPorCurso);
		
		// alunoServico.listarPorCpf(123L).ifPresentOrElse(System.out::println, () -> System.out.println("Não há aluno cadastrado!"));
		
		var aluno = alunoServico.listarPorCpf(123L);
		aluno.ifPresentOrElse(System.out::println, () -> System.out.println("Não há aluno cadastrado!"));
		
		var alunoRecuperado = alunoServico.listarPorCpf(123L)
				.or(() -> alunoServico.listarPorCpf(000L))
				.or(() -> alunoServico.listarPorCpf(123L));
		
		System.out.println("Aluno recuperado: " + alunoRecuperado.get());
		
//		dao2.testarConexaoHttp();
	}

}
