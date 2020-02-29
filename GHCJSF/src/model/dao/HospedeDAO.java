package model.dao;

import javax.ejb.Stateless;

import model.Hospede;

@Stateless
public class HospedeDAO extends DAOGenerico<Hospede> {
	
	public HospedeDAO() {
		classePersistente = Hospede.class;
	}

}
