package com.pablo.loja.testes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import com.pablo.loja.dao.CategoriaDao;
import com.pablo.loja.dao.ProdutoDao;
import com.pablo.loja.modelo.Categoria;
import com.pablo.loja.modelo.Produto;
import com.pablo.loja.util.JPAUtil;

public class TesteCriteria {

	public static void main(String[] args) {
		popularBancoDeDados();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		List<Produto> produtos = produtoDao.buscarPorParametrosComCriteria(null, null, LocalDate.now());
		produtos.forEach(p -> System.out.println(p.getNome()));
	}

	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");
		Categoria videogames = new Categoria("VIDEOGAMES");
		Categoria informatica = new Categoria("INFORMATICA");

		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
		Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal("8000"), videogames);
		Produto macbook = new Produto("Macbook", "Macboo pro retina", new BigDecimal("14000"), informatica);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		em.getTransaction().begin();

		categoriaDao.cadastrar(celulares);
		categoriaDao.cadastrar(videogames);
		categoriaDao.cadastrar(informatica);

		produtoDao.cadastrar(celular);
		produtoDao.cadastrar(videogame);
		produtoDao.cadastrar(macbook);

		em.getTransaction().commit();
		em.close();
	}
	
}
