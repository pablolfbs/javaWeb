package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import br.com.alura.jpa.modelo.Movimentacao;

public class TestaSomaDasMovimentacoes {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
//		BigDecimal somaDasMovimentacoes = new MovimentacaoDAO(em).getSomaDasMovimentacoes();
//		
//		System.out.println("A soma das movimentações é : " + somaDasMovimentacoes);
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);
		
		Root<Movimentacao> root = query.from(Movimentacao.class);
		
		Expression<BigDecimal> sum = builder.sum(root.<BigDecimal>get("valor"));
		query.select(sum);
		
		TypedQuery<BigDecimal> typedQuery = em.createQuery(query);
		
		System.out.println("A soma das movimentações é : " + typedQuery.getSingleResult());
		
		
//		String jpql = "select avg(m.valor) from Movimentacao m";
//		
//		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
//		
//		Double mediaDasMovimentacoes = query.getSingleResult();
//		System.out.println("A média das movimentações é : " + mediaDasMovimentacoes);
		
	}

}
