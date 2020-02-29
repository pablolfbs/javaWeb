package br.com.projetoRest.services;

import javax.ws.rs.GET;

import javax.ws.rs.Path;

import javax.ws.rs.PathParam;

import javax.ws.rs.core.Response;

import br.com.projetoRest.seguranca.Seguro;

@Path("servicos")

public class ConversorMedidasService {

	@Seguro
	@GET
	@Path("quilometrosParaMilhas/{quilometros}")
	public Response quilometroParaMilha(@PathParam("quilometros") Double quilometros) {

		quilometros = quilometros / 1.6;

		return Response.ok(quilometros).build();

	}

	@GET
	@Path("milhasParaQuilometros/{milhas}")
	public Response milhasParaQuilometros(@PathParam("milhas") Double milhas) {

		milhas = milhas * 1.6;

		return Response.ok(milhas).build();

	}

}