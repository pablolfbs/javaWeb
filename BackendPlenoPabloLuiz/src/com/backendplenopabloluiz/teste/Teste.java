package com.backendplenopabloluiz.teste;

import java.util.List;

import com.backendplenopabloluiz.model.Setor;
import com.backendplenopabloluiz.model.dao.SetorDAO;

public class Teste {
	
	public static void main(String[] args) {
		
		SetorDAO sDAO = new SetorDAO();
		
		List<Setor> lista = sDAO.listar();
		
		for (Setor setor : lista) {
			System.out.println(setor.getDescricao());
		}
	}

}
