package com.backendplenopabloluiz.teste;

import com.backendplenopabloluiz.resources.client.ApagaColaboradorClient;

/**
 * Classe de teste para apagar colaborador.
 * 
 * @author pablo
 *
 */
public class ApagarColaboradorTeste {
	
	public static void main(String[] args) {
		
		ApagaColaboradorClient client = new ApagaColaboradorClient();
		
		client.removeColaborador(105);
	    
	}

}
