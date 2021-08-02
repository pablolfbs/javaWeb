package br.com.projetoRest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(value = "teste")
public class TesteResource {
	
	@GET
	@Path("recebeTeste/{data}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response teste(@PathParam("data") String data) {
		System.out.println(data);
		return Response.ok(data).build();
	}

}
