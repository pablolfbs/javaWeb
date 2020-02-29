package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hospede;
import model.Quarto;
import model.Reserva;

@WebServlet("/cadastro")
public class RegistraReservasServlets extends HttpServlet{
	
	static ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	
	@Override
	protected void service(HttpServletRequest tico, 
			HttpServletResponse teco) throws ServletException, IOException {

		String numeroQuarto = tico.getParameter("numero"); 
		String dataSaidaQuarto = tico.getParameter("data");
		String nomeHospede = tico.getParameter("nome");
		
		Hospede hospede = new Hospede();
		
		hospede.setNome(nomeHospede);
		
		Quarto quarto = new Quarto();
		
		quarto.setDataSaida(dataSaidaQuarto);
		quarto.setNumero(Integer.parseInt(numeroQuarto));
		
		Reserva reserva = new Reserva();
		
		reserva.setHospede(hospede);
		reserva.setQuarto(quarto);
		
		reservas.add(reserva);
		
		teco.sendRedirect("confirmacao.html");
		
	}
}
