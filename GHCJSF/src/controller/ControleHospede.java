package controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import model.Hospede;
import model.dao.HospedeDAO;

@Named(value = "controleHospede")
@SessionScoped
public class ControleHospede implements Serializable {

	private static final long serialVersionUID = -3705378899655885128L;
	
	@EJB
	private HospedeDAO dao;
	private Hospede hospede;
	
	public void novoHospede() {
		hospede = new Hospede();
		hospede.setId(null);
	}

	public void gravar() {
		dao.gravar(hospede);
	}

	public void editar() {
		dao.editar(hospede);
	}

	public void remover() {
		dao.remove(hospede.getId());
	}

	public Hospede buscarPorId() {
		return dao.buscarPorId(hospede.getId());
	}

	public List<Hospede> listar() {
		return dao.todosObjetos();
	}

	public HospedeDAO getDao() {
		return dao;
	}

	public void setDao(HospedeDAO dao) {
		this.dao = dao;
	}

	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

}
