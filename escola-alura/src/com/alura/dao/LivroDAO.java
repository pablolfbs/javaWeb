package com.alura.dao;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class LivroDAO {
	
	public HttpClient criarHttpClient() {
		return HttpClient.newBuilder().followRedirects(HttpClient.Redirect.ALWAYS).build();
	}
	
	public HttpRequest criarRequisicao() {
		try {
			return HttpRequest.newBuilder().uri(new URI("https://turini.github.io/livro-java-9/books.csv")).GET().build();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
//	public HttpResponse<String> criarRequisicao() throws URISyntaxException, IOException, InterruptedException {
//		HttpClient httpClient = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.ALWAYS).build();
//		
//		HttpRequest request = HttpRequest.newBuilder(new URI("https://turini.github.io/livro-java-9/books.csv")).GET().build();
//		
//		return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//	}
	
	public HttpResponse<String> listarSincrono() {
		try {
			return criarHttpClient().send(criarRequisicao(), HttpResponse.BodyHandlers.ofString());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public CompletableFuture<HttpResponse<String>> listarAssincrono() {
		try {
			return criarHttpClient().sendAsync(criarRequisicao(), HttpResponse.BodyHandlers.ofString())
					.whenComplete((r, s) -> System.out.println(r.body()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
