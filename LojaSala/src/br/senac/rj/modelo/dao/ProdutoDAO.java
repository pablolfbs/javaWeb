package br.senac.rj.modelo.dao;

import javax.ejb.Stateless;

import br.senac.rj.modelo.Produto;

@Stateless
public class ProdutoDAO extends DAOGenerico<Produto>{

	public ProdutoDAO() {
		classePersistente = Produto.class;
	}
	
}
