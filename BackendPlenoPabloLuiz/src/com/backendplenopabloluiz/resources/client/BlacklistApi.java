package com.backendplenopabloluiz.resources.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.backendplenopabloluiz.model.ColaboradorBlacklist;
import com.backendplenopabloluiz.util.Util;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Classe cliente da api blacklist.
 * 
 * @author pablo
 *
 */
public class BlacklistApi {
	
	private BlacklistApi() {
		
	}

	/**
	 * Método que faz a requisição da API blacklist e devolve a lista dos colaboradores.
	 * 
	 * @return
	 */
	public static List<ColaboradorBlacklist> listar() {

		String servico = "https://5e74cb4b9dff120016353b04.mockapi.io/api/v1/blacklist";

		try {
			URL url = new URL(servico);
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

			if (conexao.getResponseCode() != 200) {
				throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
			}

			BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
			String jsonEmString = Util.converteJsonEmString(resposta);

			Type collectionType = new TypeToken<List<ColaboradorBlacklist>>(){}.getType();
			
			return new Gson().fromJson(jsonEmString, collectionType);

		} catch (Exception e) {
			throw new RuntimeException("ERRO: " + e);
		}

	}

}
