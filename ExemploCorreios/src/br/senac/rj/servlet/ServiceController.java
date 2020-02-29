package br.senac.rj.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senac.rj.correios.AtendeCliente;
import br.senac.rj.correios.AtendeClienteService;
import br.senac.rj.correios.EnderecoERP;
import br.senac.rj.correios.SQLException_Exception;
import br.senac.rj.correios.SigepClienteException;

@WebServlet("/servlet")
public class ServiceController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7455103186335782925L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		System.getProperties().put("proxySet", "true");
//		System.getProperties().put("https.proxyHost", "true");
//		System.getProperties().put("https.proxyPort", "3128");
//		System.getProperties().put("https.proxyUser", "36115142016.2n");
//		System.getProperties().put("https.proxyPassword", "senac@11514");
		
		AtendeClienteService service = new AtendeClienteService();
		
		AtendeCliente port = service.getAtendeClientePort();
		
		EnderecoERP resultado = null;
		
		// String cep = request.getParameter("cep");
		
		String cep = "21051000";
		
		try {
			resultado = port.consultaCEP(cep);
		} catch (SQLException_Exception | SigepClienteException e) {
			System.out.println("Problemas ao consultar o cep");
		}
		System.out.println(resultado.getEnd() + " - " + resultado.getBairro());
	}
}
