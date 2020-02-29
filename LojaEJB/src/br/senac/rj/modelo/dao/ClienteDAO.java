package br.senac.rj.modelo.dao;

import javax.ejb.Stateless;

import br.senac.rj.modelo.Cliente;

@Stateless
public class ClienteDAO extends DAOGenerico<Cliente>{
	
	public ClienteDAO() {
		classePersistente = Cliente.class;
	}

}
