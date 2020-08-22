package pt.his.vitacare.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pt.his.vitacare.seguranca.Seguro;

@Path("/agendamento")
public class AgendamentoService {

	@Seguro
	@POST
	@Path("/buscaXML")
	@Produces(MediaType.APPLICATION_XML)
	public String buscar(String xml) {
		return xml.toString();
	}
}
