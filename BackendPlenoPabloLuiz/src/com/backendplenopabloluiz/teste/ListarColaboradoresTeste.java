package com.backendplenopabloluiz.teste;

import java.util.List;

import com.backendplenopabloluiz.model.Colaborador;
import com.backendplenopabloluiz.resources.client.ColaboradorListar;

/**
 * Classe de teste para listar colaboradores.
 * 
 * @author pablo
 *
 */
public class ListarColaboradoresTeste {

	public static void main(String[] args) {

		List<Colaborador> listaColaboradores = ColaboradorListar.listar();

		int count = 0;
		for (Colaborador col : listaColaboradores) {

			System.out.println("Colaborador " + ++count + ":");
			System.out.println("Nome: " + col.getNome());
			System.out.println("E-mail: " + col.getEmail());
			System.out.println("Idade: " + col.getIdade());
			System.out.println("Setor: " + col.getSetor().getDescricao());
			System.out.println();
		}
	}
}
