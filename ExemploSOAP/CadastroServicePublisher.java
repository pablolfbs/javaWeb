import javax.xml.ws.Endpoint;

import br.senac.rj.service.CadastroServiceImpl;

public class CadastroServicePublisher {

	public static void main(String[] args) {

		System.out.println("Iniciando...");

		Endpoint.publish("http://localhost:9905/CadastroService", new CadastroServiceImpl());

		System.out.println("Iniciado!");
		
	}

}