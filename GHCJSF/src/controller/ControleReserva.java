package controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import model.Hospede;
import model.Reserva;
import model.dao.HospedeDAO;
import model.dao.ReservaDAO;

@Named(value = "controleReserva")
@SessionScoped
public class ControleReserva implements Serializable {
	
	private static final long serialVersionUID = -6875136894917040009L;
	
	@EJB
	private ReservaDAO dao;
	@EJB
	private HospedeDAO hDao;
	private Reserva reserva;
	private Hospede hospede;
	
	public void novaReserva() {
		reserva = new Reserva();
		hospede = new Hospede();
		// reserva.setHospede(hospede);
		reserva.setId(null);
	}

	public HospedeDAO gethDao() {
		return hDao;
	}

	public void sethDao(HospedeDAO hDao) {
		this.hDao = hDao;
	}

	public void gravar() {
		dao.gravar(reserva);
		hDao.gravar(hospede);
		
	}

	public void editar() {
		dao.editar(reserva);
	}

	public void remover() {
		dao.remove(reserva.getId());
	}

	public Reserva buscarPorId() {
		return dao.buscarPorId(reserva.getId());
	}

	public List<?> listar() {
		return dao.todosObjetos();
	}

	public ReservaDAO getDao() {
		return dao;
	}

	public void setDao(ReservaDAO dao) {
		this.dao = dao;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

}
