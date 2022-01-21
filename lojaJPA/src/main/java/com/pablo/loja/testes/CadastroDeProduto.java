package com.pablo.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.pablo.loja.dao.CategoriaDao;
import com.pablo.loja.dao.ProdutoDao;
import com.pablo.loja.modelo.Categoria;
import com.pablo.loja.modelo.CategoriaId;
import com.pablo.loja.modelo.Produto;
import com.pablo.loja.util.JPAUtil;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		
		cadastrarProduto();
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		Produto p = produtoDao.buscarPorId(1l);
		System.out.println(p.getPreco());
		
		produtoDao.buscarTodos().forEach(p1 -> System.out.println(p1.getNome()));
		
		produtoDao.buscarPorNome("Xiaomi Redmi").forEach(p2 -> System.out.println(p2.getNome()));
		
		produtoDao.buscarPorNomeDaCategoria("CELULARES").forEach(c -> System.out.println(c.getNome()));
		
		System.out.println("Preço do produto: " + produtoDao.buscarPrecoDoProdutoPorNome("Xiaomi Redmi"));
	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal(800), celulares);
		
		EntityManager em = JPAUtil.getEntityManager();
		
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		
		em.getTransaction().commit();
		
		em.find(Categoria.class, new CategoriaId("CELULARES", "xpto"));
		
		em.close();
	}

}
