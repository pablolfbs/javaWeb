package com.alura.dao;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Teste2HttpDAO {

	public void testarConexaoHttp() throws IOException, URISyntaxException, InterruptedException {
		URI uri = new URI("https://www.google.com.br");
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest req = HttpRequest.newBuilder(uri).GET().build();
		
		HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
		
		System.out.println(resp.body());
		
		
	}

}
