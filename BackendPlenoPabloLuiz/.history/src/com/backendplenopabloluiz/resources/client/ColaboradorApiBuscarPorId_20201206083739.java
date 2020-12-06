package com.backendplenopabloluiz.resources.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.backendplenopabloluiz.model.Colaborador;
import com.backendplenopabloluiz.util.Util;
import com.google.gson.Gson;

/**
 * Classe client para buscar colaborador por id.
 * 
 * @author pablo
 *
 */
public class ColaboradorApiBuscarPorId {
	
	private ColaboradorApiBuscarPorId() {
		
	}

	/**
	 * M�todo de cliente do webservice de colaborador que devolve o colaborador, pesquisado pelo id.
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public static Colaborador buscarPorId(int id) throws Exception {

		String servico = "http://localhost:8080-0.0.1-SNAPSHOT/BackendPlenoPabloLuiz/colaborador/buscar/" + id;

		try {
			URL url = new URL(servico);
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
			
			if (conexao.getResponseCode() != 200) {
				throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
			}

			BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
			String jsonEmString = Util.converteJsonEmString(resposta);
			
			return new Gson().fromJson(jsonEmString, Colaborador.class);

		} catch (Exception e) {
			throw new Exception("ERRO: " + e);
		}

	}
	
}
