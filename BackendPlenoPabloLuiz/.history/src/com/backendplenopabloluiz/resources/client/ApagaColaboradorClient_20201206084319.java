package com.backendplenopabloluiz.resources.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.backendplenopabloluiz.model.Colaborador;

/**
 * Classe cliente para apagar colaborador.
 * 
 * @author pablo
 *
 */
public class ApagaColaboradorClient {

	/**
	 * Client para remover colaborador.
	 */
	public void removeColaborador() {
		
		Client client = ClientBuilder.newClient();

		int id = 111;
		WebTarget webTarget = client.target("http://localhost:8080/BackendPlenoPabloLuiz-0.0.1-SNAPSHOT/colaborador/remover/" + id);

		Response response = webTarget.request().accept(MediaType.APPLICATION_JSON).delete();

		try {
			Colaborador col = ColaboradorApiBuscarPorId.buscarPorId(id);
			
			if (col.getId() == null) {
				System.out.println("Colaborador n�o existe!");
				
			} else {
				if (response.getStatus() == 200) {
					System.out.println("Colaborador apagado com sucesso!");
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

}
