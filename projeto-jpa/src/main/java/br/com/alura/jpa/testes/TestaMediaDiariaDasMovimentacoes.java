package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.MediaComData;
import br.com.alura.jpa.modelo.dao.MovimentacaoDAO;

public class TestaMediaDiariaDasMovimentacoes {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		List<MediaComData> mediaDasMovimentacoes = new MovimentacaoDAO(em).getMediaDiariaDasMovimentacoes();
		
		mediaDasMovimentacoes.forEach(m -> {
			System.out.println("A média das movimentações do dia " + m.getDia() + "/" + m.getMes() + " é: " + m.getValor());
		});
		
	}

}
