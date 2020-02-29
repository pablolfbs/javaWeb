package model.dao;

import javax.ejb.Stateless;

import model.Quarto;

@Stateless
public class QuartoDAO extends DAOGeneric<Quarto> {
	
	public QuartoDAO() {
		persistence = Quarto.class;
	}

}
