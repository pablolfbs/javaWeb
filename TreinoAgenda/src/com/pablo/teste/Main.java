package com.pablo.teste;

import java.util.Arrays;

import com.pablo.model.Agenda;
import com.pablo.model.Contato;
import com.pablo.model.Endereco;

public class Main {
	
	public static void main(String[] args) {
		
		Endereco e1 = new Endereco("Rua", "Ubiraci", "423", "cs 2", "21051-040", "Higienópolis", "Rio de Janeiro", "RJ");
		Endereco e2 = new Endereco("Rua", "Ubiraci", "220", "ap 502", "21051-040", "Higienópolis", "Rio de Janeiro", "RJ");
		
		Agenda a = new Agenda();
		a.adicionaContato(new Contato(1, "Pablo"));
		a.adicionaContato(new Contato(2, "Ingrid"));
		
		System.out.println(a.buscarPorId(2));
		
		Contato c = new Contato(3, "Alice");
		c.setTelefones(Arrays.asList("123", "456"));
		c.setEnderecos(Arrays.asList(e1, e2));
		a.adicionaContato(c);
		
		System.out.println(a.listarContatos());
		
		a.atualizaContato(2, new Contato("Ingrid Lima"));
		
		System.out.println(a.buscarPorId(3));
		
		System.out.println();
		
		System.out.println(a.buscarPorId(1));
		a.apagaContato(1);
		
		System.out.println(a.buscarPorId(1));
		System.out.println(a.buscarPorId(2));
		System.out.println(a.buscarPorId(3));
		
		System.out.println(a.buscarPorNome("Alice"));
		System.out.println(a.buscarPorNome("João"));
		
	}

}
