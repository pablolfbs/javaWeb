package com.pablo.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.pablo.loja.modelo.Produto;

public class ProdutoDao {
	
	private EntityManager em;
	
	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}
	
	public Produto buscarPorId(Long id) {
		return this.em.find(Produto.class, id);
	}
	
	public List<Produto> buscarTodos() {
		return em.createQuery("select p from Produto p", Produto.class).getResultList();
	}
	
	public List<Produto> buscarPorNome(String nome) {
		return em.createQuery("select p from Produto p where p.nome = :nome", Produto.class).setParameter("nome", nome).getResultList();
	}
	
	public List<Produto> buscarPorNomeDaCategoria(String nome) {
		return em.createQuery("select p from Produto p where p.categoria.nome = :nome", Produto.class).setParameter("nome", nome).getResultList();
	}
	
	public BigDecimal buscarPrecoDoProdutoPorNome(String nome) {
		return em.createQuery("select p.preco from Produto p where p.nome = :nome", BigDecimal.class).setParameter("nome", nome).getSingleResult();
	}

}
