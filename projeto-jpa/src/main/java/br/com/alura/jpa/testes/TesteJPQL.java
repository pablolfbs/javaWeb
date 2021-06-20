package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQL {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setId(2L);
		
		String sql = "select m from Movimentacao m where m.conta = :pConta order by m.valor desc";
		
		TypedQuery<Movimentacao> query = em.createQuery(sql, Movimentacao.class);
		query.setParameter("pConta", conta);
		
		List<Movimentacao> resultList = query.getResultList();
		
		resultList.forEach(m -> System.out.println(
				  									"Descrição: " + m.getDescricao() 
				  									+ "\nTipo: " + m.getTipoMovimentacao() 
				  									+ "\nValor: " + m.getValor()
				  								  )
						  );
		
	}

}
