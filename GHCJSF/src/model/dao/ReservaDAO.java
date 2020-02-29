package model.dao;

import javax.ejb.Stateless;

import model.Reserva;

@Stateless
public class ReservaDAO extends DAOGenerico<Reserva> {
	
	public ReservaDAO() {
		classePersistente = Reserva.class;
	}

}
