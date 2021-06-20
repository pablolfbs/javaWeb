package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// Usando Generics
public abstract class DAOGenerico<T> {
	
	@PersistenceContext(unitName="Hotel")
	protected EntityManager em;
	
	protected Class<T> classePersistente;
	
	public void gravar(T obj) {
		em.persist(obj);
	}
	
	public void editar(T obj) {
		em.merge(obj);
	}
	
	public T buscarPorId(Integer id) {
		return (T) em.find(classePersistente, id);
	}
	
	public void remove(Integer id) {
		T obj = buscarPorId(id);
		em.remove(obj);
	}
	
	public List<?> todosObjetos() {
		return em.createQuery("from" + classePersistente.getName()).getResultList();
		
	}

}
