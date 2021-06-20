package br.com.alura.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import br.com.alura.entidade.AgendamentoEmail;

@Stateless
public class AgendamentoEmailDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public AgendamentoEmailDAO() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AgendamentoEmailDS");
		this.entityManager = entityManagerFactory.createEntityManager();
	}
	
	public List<AgendamentoEmail> listar() {
		return entityManager.createQuery(" SELECT ae FROM agendamentoEmail ae ", AgendamentoEmail.class).getResultList();
	}

}
