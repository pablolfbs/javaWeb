package com.pablo.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Agenda {

	private List<Contato> contatos = new ArrayList<Contato>();

	public void adicionaContato(Contato contato) {
		this.contatos.add(contato);
	}

	public Contato atualizaContato(Integer id, Contato contato) {
		Contato c = buscarPorId(id);
		c.setNome(contato.getNome());
		c.setTelefones(contato.getTelefones());
		return c;
	}
	
	public void apagaContato(int id) {
		Contato c = buscarPorId(id);
		this.contatos.remove(c);
	}

	public Contato buscarPorId(Integer id) {
		for (Contato contato : contatos) {
			if (contato.getId().equals(id)) {
				return contato;
			}
		}
		return null;
	}
	
	public Contato buscarPorNome(String nome) {
		for (Contato contato : contatos) {
			if (contato.getNome().equals(nome)) {
				return contato;
			}
		}
		return null;
	}

	public List<Contato> listarContatos() {
		return this.contatos;
	}

}
