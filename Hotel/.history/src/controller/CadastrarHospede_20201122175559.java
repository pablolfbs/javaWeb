package controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Hospede;
import model.Quarto;
import model.Reserva;

public class CadastrarHospede implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeHospede = request.getParameter("nome");
		String cpfHospede = request.getParameter("cpf");
		String emailHospede = request.getParameter("email");
		String quartoHospede = request.getParameter("quarto");
		String dtEntrada = request.getParameter("dtEntrada");
		String dtSaida = request.getParameter("dtSaida");
		
		Quarto quarto = Ctrl.inserirQuarto(quartoHospede);

		Hospede hospede = Ctrl.inserirHospede(nomeHospede, cpfHospede, emailHospede);

		Reserva reserva = Ctrl.montarReserva(quarto, hospede, dtEntrada, dtSaida);

		Ctrl.inserirReserva(reserva);

		Ctrl.enviaEmailConfirmacao(quarto, hospede, reserva);
		
		Collection<? extends Reserva> reservas = Ctrl.carregaListaReservas();
		
		Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
		String json = gson.toJson(reservas);

		response.setContentType("application/json");
		response.getOutputStream().write(json.getBytes(StandardCharsets.UTF_8));
		response.flushBuffer();
		return json;
		
//		return "redirect:entrada?acao=index";
	}

}
