package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HospedeDao;
import dao.QuartoDao;
import dao.ReservaDao;
import model.Hospede;
import model.Quarto;
import model.Reserva;

@WebServlet("/cadastro")
public class RegistraReservasServlets extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest tico, 
			HttpServletResponse teco) throws ServletException, IOException {
		
		String numeroQuarto = tico.getParameter("numero"); 
		String cpfHospede = tico.getParameter("cpf"); 
		String dataEntrada = tico.getParameter("data");
		String nomeHospede = tico.getParameter("nome");
		
		Hospede hospede = new Hospede();
		
		hospede.setNome(nomeHospede);
		hospede.setCpf(cpfHospede);
		
		HospedeDao h = new HospedeDao();
		h.inserir(hospede);
		
		
		Quarto quarto = new Quarto();

		quarto.setNumero(Integer.parseInt(numeroQuarto));
		
		QuartoDao q = new QuartoDao();
		q.inserir(quarto);
		
		Reserva reserva = new Reserva();
		
		reserva.setHospede(hospede);
		reserva.setQuarto(quarto);
		reserva.setDataEntrada(dataEntrada);
		
		ReservaDao r = new ReservaDao();
		r.inserir(reserva);
		
		teco.sendRedirect("confirmacao.html");
		
	}
}
