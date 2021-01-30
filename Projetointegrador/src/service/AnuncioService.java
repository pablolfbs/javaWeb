package service;

import java.util.List;

import dao.AnuncioDAO;
import domain.Anuncio;

public class AnuncioService {

	private AnuncioDAO db = new AnuncioDAO();

	public List<Anuncio> getListAnuncio() {
		try {

			List<Anuncio> anuncios = db.getListAnuncios();

			if (anuncios != null) {
				return anuncios;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
