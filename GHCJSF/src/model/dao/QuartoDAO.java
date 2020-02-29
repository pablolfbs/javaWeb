package model.dao;

import javax.ejb.Stateless;

import model.Quarto;

@Stateless
public class QuartoDAO extends DAOGenerico<Quarto> {
	
	public QuartoDAO() {
		classePersistente = Quarto.class;
	}

}
