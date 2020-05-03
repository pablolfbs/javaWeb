package servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controller.Ctrl;
import model.Hospede;
import model.Quarto;
import model.Reserva;

@WebServlet(name = "listareservas", urlPatterns = { "/listareservas" })
public class ServletListaReservas extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	Set<Reserva> reservas = null;
	Set<Quarto> quartos = new HashSet<Quarto>();
	Set<Hospede> hospedes = new HashSet<Hospede>();
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession secao = request.getSession();
		
		String opcao = request.getParameter("opcao");
		String nome = request.getParameter("valor");
		
		if (opcao.equals("excluirLinha")) {
			String hospedeId = request.getParameter("hospedeId");
			String quartoNum = request.getParameter("quartoNum");

			Hospede hospede = Ctrl.buscarPorHospedePorId(Integer.parseInt(hospedeId));
			
			Quarto quarto = new Quarto();
			quarto.setNum(Integer.parseInt(quartoNum));
			
			Ctrl.excluiLinha(hospedeId, quarto);

			quartos.addAll(Ctrl.carregaListaQuartos());
			secao.setAttribute("listaQuartos", quartos);
			
			reservas = new LinkedHashSet<Reserva>(Ctrl.carregaListaReservas());
			secao.setAttribute("listaHospedes", reservas);
			
			Ctrl.enviaEmailExclusaoReserva(hospede, quarto);

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/listareservas.jsp");
			rd.forward(request, response);
			
		} else if (opcao.equals("listar")) {
			reservas = new LinkedHashSet<Reserva>(Ctrl.carregaListaReservas());

			secao.setAttribute("listaHospedes", reservas);
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/listareservas.jsp");
			rd.forward(request, response);
			
		} else if (opcao.equals("buscarPorNome")) {
			
			if (nome.length() > 1 || nome.equals("")) {
				reservas = new LinkedHashSet<Reserva>(Ctrl.buscarReservaPorNomeHospede(nome));
				
				Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
				String json = gson.toJson(reservas);
				
				response.setContentType("application/json");
				response.getOutputStream().write(json.getBytes());
				response.flushBuffer();
			}
		}
	}
}
