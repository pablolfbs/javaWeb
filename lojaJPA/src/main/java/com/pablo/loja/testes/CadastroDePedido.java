package com.pablo.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import com.pablo.loja.dao.CategoriaDao;
import com.pablo.loja.dao.ClienteDao;
import com.pablo.loja.dao.PedidoDao;
import com.pablo.loja.dao.ProdutoDao;
import com.pablo.loja.modelo.Categoria;
import com.pablo.loja.modelo.Cliente;
import com.pablo.loja.modelo.ItemPedido;
import com.pablo.loja.modelo.Pedido;
import com.pablo.loja.modelo.Produto;
import com.pablo.loja.util.JPAUtil;

public class CadastroDePedido {
	
	public static void main(String[] args) {
		
		popularBancoDeDados();
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		
		Produto produto = produtoDao.buscarPorId(1l);
		Produto produto2 = produtoDao.buscarPorId(2l);
		Produto produto3 = produtoDao.buscarPorId(3l);
		
		Cliente cliente = clienteDao.buscarPorId(1l);
		
		em.getTransaction().begin();
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(produto, pedido, 10, produto.getPreco()));
		pedido.adicionarItem(new ItemPedido(produto2, pedido, 40, produto2.getPreco()));
		
		Pedido pedido2 = new Pedido(cliente);
		pedido2.adicionarItem(new ItemPedido(produto3, pedido2, 2, produto3.getPreco()));
		
		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.cadastrar(pedido);
		pedidoDao.cadastrar(pedido2);
		
		em.getTransaction().commit();
		
		BigDecimal valorVendido = pedidoDao.valorTotalVendido();
		System.out.println("VALOR TOTAL: " + valorVendido);
		
		pedidoDao.relatorioDeVendas().forEach(System.out::println);
		
		em.close();
	}
	
	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");
		Categoria videogames = new Categoria("VIDEOGAMES");
		Categoria informatica = new Categoria("INFORMATICA");
		
		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal(800), celulares);
		Produto videogame = new Produto("PS5", "Playstation5", new BigDecimal(4400), videogames);
		Produto macbook = new Produto("Macbook", "Macbock pro", new BigDecimal(11800), informatica);
		
		Cliente cliente = new Cliente("Pablo", "123456");
		
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celulares);
		categoriaDao.cadastrar(videogames);
		categoriaDao.cadastrar(informatica);
		
		produtoDao.cadastrar(celular);
		produtoDao.cadastrar(videogame);
		produtoDao.cadastrar(macbook);
		
		clienteDao.cadastrar(cliente);
		
		em.getTransaction().commit();
		em.close();
	}

}
