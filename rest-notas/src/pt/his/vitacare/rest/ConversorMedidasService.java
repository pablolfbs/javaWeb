package pt.his.vitacare.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import pt.his.vitacare.seguranca.Seguro;

@Path("/medidas")
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