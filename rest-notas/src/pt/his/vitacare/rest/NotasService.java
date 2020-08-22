package pt.his.vitacare.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pt.his.vitacare.dao.NotaDAO;
import pt.his.vitacare.entidade.Nota;

@Path("/notas")
public class NotasService {

	private static final String CHARSET_UTF8 = ";charset=utf-8";

	private NotaDAO notaDAO;

//	@PostConstruct
//	private void init() {
//		notaDAO = new NotaDAO();
//	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public List<Nota> listarNotas() {
		List<Nota> lista = null;
		try {
			lista = notaDAO.listarNotas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public Nota testeJSON(Nota nota) {
		return nota;
	}

	@POST
	@Path("/buscaXML")
	@Produces(MediaType.APPLICATION_XML + CHARSET_UTF8)
	public String buscar(String xml) {
		return xml.toString();
	}

	@GET
	@Path("/buscar")
	@Produces(MediaType.APPLICATION_XML)
	public String busca() {
		Nota nota = null;
		try {
			nota = new NotaDAO().buscarNotaPorId(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(nota.toXML());
		return nota.toXML();
	}

	public String testeXML(String s) {
		return s;
	}

	@GET
	@Path("/get/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	public Nota buscarPorId(@PathParam("id") int idNota) {
		Nota nota = null;
		try {
			nota = notaDAO.buscarNotaPorId(idNota);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nota;
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String addNota(Nota nota) {
		String msg = "";

		System.out.println(nota.getTitulo());

		try {
			int idGerado = notaDAO.addNota(nota);

			msg = String.valueOf(idGerado);
		} catch (Exception e) {
			msg = "Erro ao add a nota!";
			e.printStackTrace();
		}
		return msg;
	}

	@PUT
	@Path("/edit/{id}")
	@Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	@Produces(MediaType.TEXT_PLAIN)
	public String editarNota(Nota nota, @PathParam("id") int idNota) {
		String msg = "";

		System.out.println(nota.getTitulo());

		try {
			notaDAO.editarNota(nota, idNota);

			msg = "Nota editada com sucesso!";
		} catch (Exception e) {
			msg = "Erro ao editar a nota!";
			e.printStackTrace();
		}

		return msg;
	}

	@DELETE
	@Path("/delete/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String removerNota(@PathParam("id") int idNota) {
		String msg = "";

		try {
			notaDAO.removerNota(idNota);

			msg = "Nota removida com sucesso!";
		} catch (Exception e) {
			msg = "Erro ao remover a nota!";
			e.printStackTrace();
		}

		return msg;
	}

}
