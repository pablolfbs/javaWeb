package Control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import model.Quarto;
import model.dao.QuartoDAO;

@Named(value = "controlQuarto")
@SessionScoped
public class ControlQuarto implements Serializable {

	@EJB
	private QuartoDAO dao;
	private List<Quarto> list;
	public Quarto quarto;

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public void getQuarto() {
		quarto = new Quarto();
		quarto.setNumero(null);
	}

	public void insert() {
		list.add(quarto);
		do {
			dao.inserir(quarto);
		} while (list.size() <= 30);
	}

	public void delete() {
		dao.delete(quarto.getNumero());
	}

	public void update() {
		dao.update(quarto);
	}

	public Quarto buscaPorId() {
		return dao.buscaPorId(quarto.getNumero());
	}

	public List<Quarto> listar() {
		return dao.listAll();
	}

}
