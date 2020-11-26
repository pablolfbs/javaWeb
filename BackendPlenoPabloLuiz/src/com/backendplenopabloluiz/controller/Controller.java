package com.backendplenopabloluiz.controller;

import java.util.ArrayList;
import java.util.List;

import com.backendplenopabloluiz.exception.BlacklistColaboradorException;
import com.backendplenopabloluiz.exception.LimiteDeIdadeException;
import com.backendplenopabloluiz.model.Colaborador;
import com.backendplenopabloluiz.model.ColaboradorBlacklist;
import com.backendplenopabloluiz.model.dao.ColaboradorDAO;
import com.backendplenopabloluiz.resources.client.BlacklistApi;
import com.backendplenopabloluiz.util.Util;

public class Controller {
	
	private static ColaboradorDAO cDAO = new ColaboradorDAO();
	
	
	/**
	 * Construtor privado para classe de não ser instanciada.
	 */
	private Controller() {
		throw new IllegalStateException("Utility class");
	}
	
	/**
	 * Retorna a quantidade de colaboradores maiores de 65 anos existem cadastrados.
	 * 
	 * @param lista
	 * @return
	 */
	public static int maior65(List<Colaborador> lista) {
		int maior65 = 0;
		for (int i = 0; i < lista.size(); i++) {
			lista.get(i).setIdade(Util.calculaIdade(lista.get(i).getDtNascimento()));
			if (lista.get(i).getIdade() >= 65) {
				maior65++;
			}
		}
		return maior65;
	}

	/**
	 * Retorna a quantidade de colaboradores menores de 18 anos existem cadastrados.
	 * 
	 * @param lista
	 * @return
	 */
	public static int menor18(List<Colaborador> lista) {
		int menor18 = 0;
		for (int i = 0; i < lista.size(); i++) {
			lista.get(i).setIdade(Util.calculaIdade(lista.get(i).getDtNascimento()));
			if (lista.get(i).getIdade() < 18)
				menor18++;
		}
		return menor18;
	}
	
	/**
	 * Consulta a blacklist e retorna uma lista com todos os colaboradores inseridos nela.
	 * 
	 * @return
	 */
	public static List<String> listaNomes() {
		List<ColaboradorBlacklist> blacklist = BlacklistApi.listar();
		List<String> listaNomes = new ArrayList<>();
		
		for (ColaboradorBlacklist colaboradorBlacklist : blacklist) {
			listaNomes.add(colaboradorBlacklist.getName());
		}
		return listaNomes;
	}
	
	/**
	 * Verifica se o colaborador a ser cadastrado, está na blacklist.
	 * 
	 * @param listaNomes
	 * @param colaborador
	 * @return
	 */
	public static boolean isNotBlacklist(List<String> listaNomes, Colaborador colaborador) {
		return !listaNomes.contains(colaborador.getNome());
	}
	
	/**
	 * Verifica se há vagas para menores de 18 anos.
	 * 
	 * @param lista
	 * @param menor18
	 * @return
	 */
	public static boolean isVagaParaMenores18(List<Colaborador> lista, int menor18) {
		return menor18 <= lista.size() * 0.2;
	}
	
	/**
	 * Verifica se há vagas para maiores de 65 anos.
	 * 
	 * @param lista
	 * @param maior65
	 * @return
	 */
	public static boolean isVagaParaMaiores65(List<Colaborador> lista, int maior65) {
		return maior65 <= lista.size() * 0.2;
	}
	
	/**
	 * Valida o colaborador para ser inserido.
	 * 
	 * @param listaNomes
	 * @param colaborador
	 * @param lista
	 * @param menor18
	 * @param maior65
	 */
	public static void adicionaColaborador(List<String> listaNomes, Colaborador colaborador, List<Colaborador> lista,
			int menor18, int maior65) {
		if ((Util.calculaIdade(colaborador.getDtNascimento()) >= 18 && Util.calculaIdade(colaborador.getDtNascimento()) < 65
						&& Controller.isNotBlacklist(listaNomes, colaborador))
						|| (Util.calculaIdade(colaborador.getDtNascimento()) < 18 && Controller.isVagaParaMenores18(lista, menor18))
						|| (Util.calculaIdade(colaborador.getDtNascimento()) >= 65 && Controller.isVagaParaMaiores65(lista, maior65)))

			colaborador.setId(cDAO.adiciona(colaborador));
	}

	/**
	 * Verifica se o colaborador maior de 65 anos, pode ser cadastrado. Caso não tenha vaga, lança uma exceção.
	 * 
	 * @param colaborador
	 * @param lista
	 * @param maior65
	 */
	public static void excecaoDisponibilidadeDeVagaParaMaiores65(Colaborador colaborador, List<Colaborador> lista,
			int maior65) {
		if (Util.calculaIdade(colaborador.getDtNascimento()) >= 65 && !Controller.isVagaParaMaiores65(lista, maior65))
			throw new LimiteDeIdadeException("Limite de colaboradores maiores que 65 anos já atingido!");
	}

	/**
	 * Verifica se o colaborador menor de 18 anos, pode ser cadastrado. Caso não tenha vaga, lança uma exceção.
	 * 
	 * @param colaborador
	 * @param lista
	 * @param menor18
	 */
	public static void excecaoDisponibilidadeVagaParaMenores(Colaborador colaborador, List<Colaborador> lista, int menor18) {
		if (Util.calculaIdade(colaborador.getDtNascimento()) < 18 && !Controller.isVagaParaMenores18(lista, menor18))
			throw new LimiteDeIdadeException("Limite de colaboradores menores de idade já atingido!");
	}

	/**
	 * Verifica se o colaborador está na blacklist. Caso esteja, lança uma exceção.
	 * 
	 * @param listaNomes
	 * @param colaborador
	 */
	public static void excecaoBlacklist(List<String> listaNomes, Colaborador colaborador) {
		if (!Controller.isNotBlacklist(listaNomes, colaborador))
			throw new BlacklistColaboradorException("Este colaborador está na lista negra!");
	}

}
