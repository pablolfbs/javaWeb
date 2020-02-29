package model.dao;

import javax.ejb.Stateless;

import model.Hospede;

@Stateless
public class HospedeDAO extends DAOGeneric<Hospede>{
	
	public HospedeDAO() {
		persistence = Hospede.class;
		
	}

}
