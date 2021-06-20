package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQLMovimentacaoDeUmaCategoria {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		@SuppressWarnings("deprecation")
		Categoria categoria = new Categoria();
		categoria.setId(2L);
		
		String sql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";
		
		TypedQuery<Movimentacao> query = em.createQuery(sql, Movimentacao.class);
		query.setParameter("pCategoria", categoria);
		
		List<Movimentacao> resultList = query.getResultList();
		
		resultList.forEach(m -> System.out.println(
													"Categorias: " + m.getCategorias() 
				  									+ "\nDescrição: " + m.getDescricao() 
				  									+ "\nTipo: " + m.getTipoMovimentacao() 
				  									+ "\nValor: " + m.getValor()
				  								  )
						  );
		
	}

}
