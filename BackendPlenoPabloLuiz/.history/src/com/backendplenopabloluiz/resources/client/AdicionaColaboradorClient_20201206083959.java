package com.backendplenopabloluiz.resources.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import com.backendplenopabloluiz.model.Colaborador;
import com.google.gson.Gson;

/**
 * Classe cliente do webservice de colaborador para inserir um novo colaborador.
 * 
 * @author pablo
 *
 */
public class AdicionaColaboradorClient {

	private AdicionaColaboradorClient() {

	}

	/**
	 * Webservice Client que adiciona colaborador.
	 * 
	 * @param colaborador
	 */
	public static void adicionaColaborador(Colaborador colaborador) {

		String url = "http://localhost:8080/BackendPlenoPabloLuiz-0.0.1-SNAPSHOT/colaborador/adicionar";
		String json = new Gson().toJson(colaborador);

		try {
			HttpURLConnection request = (HttpURLConnection) new URL(url).openConnection();

			try {
				request.setDoOutput(true);
				request.setDoInput(true);
				request.setRequestProperty("Content-Type", "application/json");
				request.setRequestMethod("POST");
				request.connect();

				try (OutputStream outputStream = request.getOutputStream()) {
					outputStream.write(json.getBytes(StandardCharsets.UTF_8));
				}

				System.out.println(request.getResponseCode());
				int response = request.getResponseCode();

				if (response == 201)
					System.out.println("Colaborador adicionado com sucesso!");

				if (response == 500)
					System.err.println("O colaborador n�o foi adicionado!");

//				return readResponse(request);
			} finally {
				request.disconnect();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	private static String readResponse(HttpURLConnection request) throws IOException {
//		ByteArrayOutputStream os;
//		try (InputStream is = request.getInputStream()) {
//			os = new ByteArrayOutputStream();
//			int b;
//			while ((b = is.read()) != -1) {
//				os.write(b);
//			}
//		}
//		return new String(os.toByteArray());
//	}

}
