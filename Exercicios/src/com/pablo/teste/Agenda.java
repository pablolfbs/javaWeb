package com.pablo.teste;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
	
	private List<Contato> contatos = new ArrayList<>();
	
	public void adicionaContato(Contato contato) {
		contatos.add(contato);
	}
	
	public Contato buscaContato(String nome) {
		for (int i = 0; i < contatos.size(); i++) {
			if (nome.equals(contatos.get(i).getNome())) {
				return contatos.get(i);
			}
		}
		return null;
	}
	
	public void listaContatos() {
		for (Contato contato : contatos) {
			System.out.println(contato.toString());
		}
	}
	
	public void excluiContato(Contato contato) {
		for (int i = 0; i < contatos.size(); i++) {
			if (contato.getNome().equals(contatos.get(i).getNome())) {
				contatos.remove(contato);
			}
		}
	}
}
