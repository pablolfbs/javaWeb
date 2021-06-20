package com.pablo.test;

import java.util.ArrayList;
import java.util.List;

import com.pablo.model.Endereco;
import com.pablo.model.Pessoa;

public class Teste {

	public static void main(String[] args) {
		
		Pessoa p = new Pessoa("Pablo", "123");
		p.adiciona(new Endereco("Rua", "Ubiraci", 423, "casa2"));
		p.adiciona(new Endereco("Rua", "Henrique Scheid", 27, "bloco 1 ap 1407"));
		
		List<Endereco> enderecos = p.getEnderecos();
		List<Endereco> enderecos2 = new ArrayList<Endereco>(enderecos);
		enderecos2.add(new Endereco("Rua", "Ubiraci", 423, "casa2"));
		
		System.out.println(p.getNome());
		System.out.println(enderecos);
		System.out.println(p);
		
	}

}
