package com.alura.service;

import java.util.List;
import java.util.Optional;

import com.alura.model.Aluno;

public class AlunoServico {
	
	Aluno pablo = new Aluno("Pablo", 123L);
	Aluno ingrid = new Aluno("Ingrid", 456L);
	Aluno aluno = new Aluno(null, 0000L);
	
	public List<Aluno> listar() {
		List<Aluno> alunos = List.of(pablo, ingrid, aluno);
		
		return alunos;
	}
	
	public Optional<Aluno> listarPorCpf(Long cpf) {
		Optional<Aluno> aluno = listar().stream()
				.filter(a -> a.getCpf().equals(cpf))
				.findAny();
		return aluno;
	}
	
}
