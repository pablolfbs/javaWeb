package com.pablo.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.pablo.loja.modelo.Pedido;
import com.pablo.loja.vo.RelatorioDeVendasVO;

public class PedidoDao {
	
	private EntityManager em;
	
	public PedidoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}
	
	public BigDecimal valorTotalVendido() {
		return em.createQuery("select sum(p.valorTotal) from Pedido p", BigDecimal.class).getSingleResult();
	}
	
	public List<RelatorioDeVendasVO> relatorioDeVendas() {
		String jpql = "select new com.pablo.loja.vo.RelatorioDeVendasVO(produto.nome, sum(item.quantidade), max(pedido.data)) from Pedido pedido join pedido.itens item " + 
						"join item.produto produto group by produto.nome order by item.quantidade desc";
		return em.createQuery(jpql, RelatorioDeVendasVO.class).getResultList();
	}

	public Pedido buscarPedidoComCliente(Long id) {
		return em.createQuery("SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :id", Pedido.class)
				.setParameter("id", id)
				.getSingleResult();
	}
	
}
