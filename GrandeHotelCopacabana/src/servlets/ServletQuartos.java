package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import controller.Ctrl;
import model.Quarto;

@WebServlet(name = "quartos", urlPatterns = { "/quartos" })
public class ServletQuartos extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Quarto> quartos = new ArrayList<Quarto>();
		quartos.addAll(Ctrl.carregaListaQuartos());

		if (quartos.isEmpty() && Ctrl.carregaListaReservas().isEmpty()) {
			Ctrl.iniciarQuartos();
			quartos.addAll(Ctrl.carregaListaQuartos());
		}
		String json = null;
		json = new Gson().toJson(quartos);
		
		response.setContentType("application/json");
		response.getOutputStream().write(json.getBytes());
		response.flushBuffer();
	}
	
}
