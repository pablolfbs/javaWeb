package br.senac.rj.modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// Usando Generics
public abstract class DAOGenerico<T> {
	
	@PersistenceContext(unitName = "LojaDS")
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
	
	public void remove(Integer id) {
		T obj = buscaPorId(id);
		
		em.remove(obj);
	}
	
	public List<T> todosObjetos() {
		// select * from classePersistente
		return em.createQuery("from " + classePersistente.getName()).
			getResultList();
	}

}








