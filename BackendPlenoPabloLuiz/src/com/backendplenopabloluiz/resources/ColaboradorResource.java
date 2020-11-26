package com.backendplenopabloluiz.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.backendplenopabloluiz.model.Colaborador;
import com.backendplenopabloluiz.service.ColaboradorService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Classe do webservice de colaborador.
 * 
 * @author pablo
 *
 */
@Path("/colaborador")
public class ColaboradorResource {

	private static final String UTF_8 = "UTF-8";

	private ColaboradorService repositorio = new ColaboradorService();

	/**
	 * Envia requisição post para inserir um novo colaborador.
	 * 
	 * @param json
	 * @return
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/adicionar")
	public Response adiciona(String json) {
		try {
			Gson gson = new Gson();
			Colaborador c = gson.fromJson(json, Colaborador.class);
			repositorio.adiciona(c);
			
			return Response.status(Response.Status.CREATED).entity(json).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	/**
	 * Envia requisição para apagar colaborador.
	 * @param id
	 * @return
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/remover/{id}")
	public Response remove(@PathParam("id") Integer id) {
		Colaborador c = repositorio.buscar(id);
		if (c == null)
			return Response.status(Response.Status.NOT_FOUND).build();

		try {
			repositorio.remove(id);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
		}
	}

	/**
	 * Retorna um json com o coladorador, buscando pelo id.
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscar/{id}")
	public String buscar(@PathParam("id") Integer id) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

		return gson.toJson(repositorio.buscar(id));
	}

	/**
	 * Devolve uma lista de todos os colaboradores cadastrados.
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON + UTF_8)
	@Path("/listar")
	public String listar() {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

		return gson.toJson(repositorio.listar());
	}

}
