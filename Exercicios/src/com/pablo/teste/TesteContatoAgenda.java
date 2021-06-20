package com.pablo.teste;

public class TesteContatoAgenda {
	
	public static void main(String[] args) {
		
		Contato c1 = new Contato("Pablo", "pablo@pablo.com");
		Contato c2 = new Contato("Ingrid", "ingrid@ingrid.com");
		Contato c3 = new Contato("Alice", "alice@alice.com");
		
		Telefone t1 = new Telefone("21 99876-1112");
		Telefone t2 = new Telefone("21 99826-1988");
		
		c1.adicionaTelefones(t1);
		c1.adicionaTelefones(t2);
		
		c2.adicionaTelefones(t2);
		
		Agenda agenda = new Agenda();
		
		System.out.println(c1.getNome());
		System.out.println(c2.getNome());
		System.out.println();
		
		agenda.adicionaContato(c1);
		agenda.adicionaContato(c2);
		agenda.adicionaContato(c3);
		
		agenda.listaContatos();
		
		System.out.println();
		
		Contato cBuscado = agenda.buscaContato("Pablo");
		System.out.println(cBuscado.getNome() + " - " + cBuscado.getEmail());
		System.out.println();
		
		c3.adicionaTelefones(t1);
		
		agenda.excluiContato(c1);
		
		agenda.listaContatos();
		
	}

}
