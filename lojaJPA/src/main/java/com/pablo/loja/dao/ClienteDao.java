package com.pablo.loja.dao;

import javax.persistence.EntityManager;

import com.pablo.loja.modelo.Cliente;

public class ClienteDao {
	
	private EntityManager em;
	
	public ClienteDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Cliente cliente) {
		this.em.persist(cliente);
	}
	
	public Cliente buscarPorId(Long id) {
		return this.em.find(Cliente.class, id);
	}
	
}
