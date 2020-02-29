package service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.AnuncioDAO;
import dao.UserDAO;
import domain.Anuncio;
import domain.User;

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
