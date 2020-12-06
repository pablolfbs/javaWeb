package com.backendplenopabloluiz.resources.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.backendplenopabloluiz.model.Colaborador;
import com.backendplenopabloluiz.util.Util;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Classe cliente para buscar colaboradores.
 * 
 * @author pablo
 *
 */
public class ColaboradorListar {

	private ColaboradorListar() {

	}

	/**
	 * M�todo de cliente do webservice de colaborador que devolve uma lista de colaboradores.
	 * 
	 * @return
	 */
	public static List<Colaborador> listar() {

		final int sucesso = 200;
		String servico = "http://localhost:8080-0.0.1-SNAPSHOT/BackendPlenoPabloLuiz/colaborador/listar";
		String jsonEmString = null;
		Type collectionType = null;

		try {
			URL url = new URL(servico);

			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

			if (conexao.getResponseCode() != sucesso) {
				throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
			}

			BufferedReader resposta = new BufferedReader(
					new InputStreamReader(conexao.getInputStream(), StandardCharsets.UTF_8));
			jsonEmString = Util.converteJsonEmString(resposta);

			collectionType = new TypeToken<List<Colaborador>>() {
			}.getType();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Gson().fromJson(jsonEmString, collectionType);

	}

}
