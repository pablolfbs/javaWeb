package model.dao;

import javax.ejb.Stateless;

import model.Reservas;

@Stateless
public class ReservaDAO extends DAOGeneric<Reservas> {

	public ReservaDAO() {
		persistence = Reservas.class;
	}
}
