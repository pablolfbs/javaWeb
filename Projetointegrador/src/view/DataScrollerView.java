package view;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import domain.Anuncio;
import service.AnuncioService;

@ManagedBean
@ViewScoped
public class DataScrollerView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Anuncio> anuncios;

	@ManagedProperty("#{AnuncioService}")
	private AnuncioService service;

	public DataScrollerView() {
		service = new AnuncioService();
		anuncios = service.getListAnuncio();
	}

	public List<Anuncio> getAnuncios() {
		return anuncios;
	}

	public void setService(AnuncioService service) {
		this.service = service;
	}

}
