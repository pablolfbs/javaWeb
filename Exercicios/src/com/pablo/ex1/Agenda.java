package com.pablo.ex1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Agenda {

	List<Pessoa> pessoas = new ArrayList<>();

	public void armazenaPessoa(String nome, Date dataNasc, float altura) {
		Pessoa p = new Pessoa();
		p.setNome(nome);
		p.setDataNasc(dataNasc);
		p.setAltura(altura);
		
		if (pessoas.size() <= 10) {
			this.pessoas.add(p);
		} else {
			System.out.println("Agenda cheia!");
		}
	}

	public void removePessoa(String nome) {
		for (int i = 0; i < this.pessoas.size(); i++) {
			if (this.pessoas.get(i).getNome().equals(nome)) {
				this.pessoas.remove(i);
			}
		}
	}

	public int buscaPessoa(String nome) {
		for (int i = 0; i < this.pessoas.size(); i++) {
			if (this.pessoas.get(i).getNome().equals(nome)) {
				return i;
			}
		}
		return -1;
	}

	public void imprimeAgenda() {
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa);
		}
	}

	public void imprimePessoa(int index) {
		for (int i = 0; i < this.pessoas.size(); i++) {
			if (this.pessoas.get(index) == this.pessoas.get(i)) {
				System.out.println(pessoas.get(i).toString());
			}
		}
	}
}
