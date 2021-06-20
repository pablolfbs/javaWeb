package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.dao.MovimentacaoDAO;

public class TesteMovimentacoesFiltradasPorDataCriteria {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO(em);
		List<Movimentacao> movimentacoesFiltradasPorData = movimentacaoDAO.getMovimentacoesFiltradasPorData(null, null, null);
		movimentacoesFiltradasPorData.forEach(m -> {
			System.out.println("Descrição -> " + m.getDescricao());
			System.out.println("Valor -> " + m.getValor());
			System.out.println("-------------");
		});

	}

}
