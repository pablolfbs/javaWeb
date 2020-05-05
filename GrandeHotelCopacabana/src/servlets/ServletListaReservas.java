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
		
		RequestDispatcher rd;
		
		switch (opcao) {
		case "excluirLinha":
			String hospedeId = request.getParameter("hospedeId");
			String quartoNum = request.getParameter("quartoNum");

			Hospede hospede = Ctrl.buscarHospedePorId(Integer.parseInt(hospedeId));
			
			Quarto quarto = new Quarto();
			quarto.setNum(Integer.parseInt(quartoNum));
			
			Ctrl.excluiLinha(hospedeId, quarto);

			quartos.addAll(Ctrl.carregaListaQuartos());
			secao.setAttribute("listaQuartos", quartos);
			
			reservas = new LinkedHashSet<Reserva>(Ctrl.carregaListaReservas());
			secao.setAttribute("listaHospedes", reservas);
			
			Ctrl.enviaEmailExclusaoReserva(hospede, quarto);

			rd = getServletContext().getRequestDispatcher("/WEB-INF/listareservas.jsp");
			rd.forward(request, response);
			break;
			
		case "listar":
			reservas = new LinkedHashSet<Reserva>(Ctrl.carregaListaReservas());

			secao.setAttribute("listaHospedes", reservas);
			
			rd = getServletContext().getRequestDispatcher("/WEB-INF/listareservas.jsp");
			rd.forward(request, response);
			break;
			
		case "buscarPorNome":
			if (nome.length() > 1 || nome.isEmpty()) {
				reservas = new LinkedHashSet<Reserva>(Ctrl.buscarReservaPorNomeHospede(nome));
				
				montarJsonComDtFormatada(response);
			}
			break;
			
		case "ordenarPorId":
			if (!nome.isEmpty()) {
				reservas = new LinkedHashSet<Reserva>(Ctrl.buscarReservaPorNomeOrdenadaPorId(nome));
			} else {
				reservas = new LinkedHashSet<Reserva>(Ctrl.ordenarReservaPorIdHospede());
			}
			montarJsonComDtFormatada(response);
			break;
			
		case "ordenarPorNome":
			if (!nome.isEmpty()) {
				reservas = new LinkedHashSet<Reserva>(Ctrl.buscarReservaPorNomeOrdenadaPorNome(nome));
			} else {
				reservas = new LinkedHashSet<Reserva>(Ctrl.ordenarReservaPorNomeHospede());
			}
			montarJsonComDtFormatada(response);
			break;
			
		case "ordenarPorCpf":
			if (!nome.isEmpty()) {
				reservas = new LinkedHashSet<Reserva>(Ctrl.buscarReservaPorNomeOrdenadaPorCpf(nome));
			} else {
				reservas = new LinkedHashSet<Reserva>(Ctrl.ordenarReservaPorCpfHospede());
			}
			montarJsonComDtFormatada(response);
			break;
			
		case "ordenarPorQuarto":
			if (!nome.isEmpty()) {
				reservas = new LinkedHashSet<Reserva>(Ctrl.buscarReservaPorNomeOrdenadaPorQuarto(nome));
			} else {
				reservas = new LinkedHashSet<Reserva>(Ctrl.ordenarReservaPorQuarto());
			}
			montarJsonComDtFormatada(response);
			break;
			
		case "ordenarPorEmail":
			if (!nome.isEmpty()) {
				reservas = new LinkedHashSet<Reserva>(Ctrl.buscarReservaPorNomeOrdenadaPorEmail(nome));
			} else {
				reservas = new LinkedHashSet<Reserva>(Ctrl.ordenarReservaPorEmailHospede());
			}
			montarJsonComDtFormatada(response);
			break;

		default:
			break;
		}
	}

	private void montarJsonComDtFormatada(HttpServletResponse response) throws IOException {
		Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
		String json = gson.toJson(reservas);
		
		response.setContentType("application/json");
		response.getOutputStream().write(json.getBytes());
		response.flushBuffer();
	}
}
