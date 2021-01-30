package controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import model.Quarto;
import model.dao.QuartoDAO;

@Named(value = "controleQuarto")
@SessionScoped
public class ControleQuarto implements Serializable {
	
	private static final long serialVersionUID = -8852880419253131543L;
	
	@EJB
	private QuartoDAO dao;
	private Quarto quarto;

	public void gravar() {
		dao.gravar(quarto);
	}

	public void editar() {
		dao.editar(quarto);
	}

	public void remover() {
		dao.remove(quarto.getNum());
	}

	public Quarto buscarPorId() {
		return dao.buscarPorId(quarto.getNum());
	}

	public List<Quarto> listar() {
		return dao.todosObjetos();
	}

	public QuartoDAO getDao() {
		return dao;
	}

	public void setDao(QuartoDAO dao) {
		this.dao = dao;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

}
