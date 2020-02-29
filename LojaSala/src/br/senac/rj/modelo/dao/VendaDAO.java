package br.senac.rj.modelo.dao;

import javax.ejb.Stateless;

import br.senac.rj.modelo.Venda;

@Stateless
public class VendaDAO extends DAOGenerico<Venda> {

	public VendaDAO() {
		classePersistente = Venda.class;
	}

}
