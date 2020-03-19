package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import controller.Ctrl;
import controller.EnvioEmail;
import model.Hospede;
import model.Quarto;
import model.Reserva;
import model.dao.HospedeDAO;
import model.dao.QuartoDAO;
import model.dao.ReservaDAO;

@WebServlet(name = "listareservas", urlPatterns = { "/listareservas" })
public class ServletListaReservas extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession secao = request.getSession();
		
		String opcao = request.getParameter("opcao");
		String nome = request.getParameter("valor");
		
		QuartoDAO qDAO = new QuartoDAO();
		ReservaDAO rDAO = new ReservaDAO();
		HospedeDAO hDAO = new HospedeDAO();
		
		List<Reserva> reservas = new ArrayList<Reserva>();
		List<Quarto> quartos = new ArrayList<Quarto>();
		List<Hospede> hospedes = new ArrayList<Hospede>();
		
		if (opcao.equals("excluirLinha")) {
			String hospedeId = request.getParameter("hospedeId");
			String quartoNum = request.getParameter("quartoNum");

			Hospede hospede = hDAO.buscarPorId(Integer.parseInt(hospedeId));
			
			Quarto quarto = new Quarto();
			quarto.setNum(Integer.parseInt(quartoNum));
			
			qDAO.inserir(quarto);
			rDAO.excluir(Integer.parseInt(hospedeId));
			hDAO.excluir(Integer.parseInt(hospedeId));

			quartos.addAll(Ctrl.carregaListaQuartos());
			secao.setAttribute("listaQuartos", quartos);
			
			reservas.addAll(Ctrl.carregaListaReservas());
			secao.setAttribute("listaHospedes", reservas);

//			EnvioEmail.send(hospede.getEmail(), "Sr(a). " + hospede.getNome() + ", sua reserva para o quarto "
//					+ quarto.getNum() + " foi cancelada.");

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/listareservas.jsp");
			rd.forward(request, response);
			
		} else if (opcao.equals("listar")) {
			
			reservas.addAll(Ctrl.carregaListaReservas());

			secao.setAttribute("listaHospedes", reservas);
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/listareservas.jsp");
			rd.forward(request, response);
			
		} else if (opcao.equals("buscarPorNome")) {
			reservas = Ctrl.buscarReservaPorNomeHospede(nome);
			// hospedes = hDAO.buscarPorNome(nome);
			
			String json = null;
			json = new Gson().toJson(reservas);
			
			response.setContentType("application/json");
			response.getOutputStream().write(json.getBytes());
			response.flushBuffer();
		}
		
	}

}
