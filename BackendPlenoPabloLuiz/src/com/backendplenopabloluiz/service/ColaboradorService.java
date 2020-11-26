package com.backendplenopabloluiz.service;

import java.util.List;

import com.backendplenopabloluiz.controller.Controller;
import com.backendplenopabloluiz.model.Colaborador;
import com.backendplenopabloluiz.model.dao.ColaboradorDAO;
import com.backendplenopabloluiz.util.Util;

/**
 * Classe de serviço que pegas as requisições e envia para o banco de dados.
 * 
 * @author pablo
 *
 */
public class ColaboradorService {

	ColaboradorDAO cDAO = new ColaboradorDAO();

	public Colaborador adiciona(Colaborador colaborador) {

		List<String> listaNomes = Controller.listaNomes();

		List<Colaborador> lista = cDAO.listar();

		int menor18 = Controller.menor18(lista);
		int maior65 = Controller.maior65(lista);

		Controller.excecaoBlacklist(listaNomes, colaborador);
		Controller.excecaoDisponibilidadeVagaParaMenores(colaborador, lista, menor18);
		Controller.excecaoDisponibilidadeDeVagaParaMaiores65(colaborador, lista, maior65);

		Controller.adicionaColaborador(listaNomes, colaborador, lista, menor18, maior65);

		return colaborador;
	}

	/**
	 * Pesquisa no banco e devolver um colaborador, localizado pelo id.
	 * 
	 * @param id
	 * @return
	 */
	public Colaborador buscar(Integer id) {
		return cDAO.buscar(id);
	}

	/**
	 * Devolve a lista de todos os colaboradores.
	 * @return
	 */
	public List<Colaborador> listar() {
		List<Colaborador> lista = cDAO.listar();
		for (Colaborador colaborador : lista) {
			colaborador.setIdade(Util.calculaIdade(colaborador.getDtNascimento()));
		}
		return lista;
	}

	/**
	 * Envia a requisição delete para o colaborador ser apagado do banco de dados.
	 * @param id
	 */
	public void remove(Integer id) {
		cDAO.remove(id);
	}

}
