package com.backendplenopabloluiz.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.backendplenopabloluiz.model.Colaborador;
import com.backendplenopabloluiz.model.Setor;
import com.backendplenopabloluiz.resources.client.AdicionaColaboradorClient;

/**
 * Classe de teste para inserir colaborador.
 * 
 * @author pablo
 *
 */
public class AdicionaColaboradorTeste {

	public static void main(String[] args) {
		
		Colaborador colaborador = new Colaborador();
		colaborador.setCpf("123456789");
		colaborador.setNome("Teste");
		colaborador.setTelefone("9999-99999");
		colaborador.setEmail("teste@teste.com");
		try {
			colaborador.setDtNascimento(new SimpleDateFormat("yyyy-MM-dd").parse("2000-10-31"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		colaborador.setSetor(new Setor(2));
		
		AdicionaColaboradorClient.adicionaColaborador(colaborador);
		
		
	}

	/*
	 * Modelo de json para teste de envio de requisição no postman ou soapui
	 * {
	 * 		"cpf":"123456789",
	 * 		"nome":"Teste",
	 * 		"telefone":"9999-99999",
	 * 		"email":"teste@teste.com",
	 * 		"dtNascimento":"Oct 31, 2000, 12:00:00 AM",
	 * 		"setor":{
	 * 					"id":2
	 * 				}
	 * } 
	 */
	
}
