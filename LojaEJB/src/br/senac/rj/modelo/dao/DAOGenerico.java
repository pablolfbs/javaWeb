package br.senac.rj.modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// Usando Generics
public abstract class DAOGenerico<T> {
	
	@PersistenceContext(unitName = "LojaSala")
	protected EntityManager em;
	
	protected Class classePersistente;
	
	public void gravar(T obj) {
		// JPA + Hibernate "classico"
		//em.getTransaction().begin();
		em.persist(obj);
		//em.getTransaction().commit();
	}
	
	public void editar(T obj) {
		em.merge(obj);
	}
	
	public T buscaPorId(Integer id) {
		return (T) em.find(classePersistente, id);
	}
	
	public void remove(T obj) {
		/*
		 * Como obj vem da view, ele não está no escopo persistente. O uso
		 * deste merge é um artifício para colocá-lo no escopo antes de
		 * poder realizar a remoção (Relacionado com aquelas questões de
		 * escopo que conversamos em sala). 
		 */
		obj = em.merge(obj);
		em.remove(obj);
	}
	
	public List<T> todosObjetos() {
		// select * from classePersistente
		return em.createQuery("from " + classePersistente.getName()).
			getResultList();
	}

}








