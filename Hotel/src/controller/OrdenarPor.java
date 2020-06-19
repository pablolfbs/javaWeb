package controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.LinkedHashSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Reserva;

public class OrdenarPor implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("paramOrdenacao");
		paramAcao = paramAcao.equals("#") ? "Id" :
					paramAcao.equals("E-mail") ? "Email" :
					paramAcao.equals("Entrada") ? "DtEntrada" :
					paramAcao.equals("Saída") ? "DtSaida" : paramAcao;
		String acao = request.getParameter("acao") + paramAcao;
		String param = request.getParameter("param");

		Collection<? extends Reserva> reservas = new LinkedHashSet<Reserva>();
		
		if (paramAcao.equals("Id") || paramAcao.equals("Nome") || paramAcao.equals("Cpf") || paramAcao.equals("Email"))
			reservas = !param.isEmpty() ? Ctrl.buscarReservaPorNomeOrdenadaHospede(acao, param) : Ctrl.ordenarReservaHospede(acao);
			
		else if (paramAcao.equals("Quarto") || paramAcao.equals("DtEntrada") || paramAcao.equals("DtSaida"))
			reservas = !param.isEmpty() ? Ctrl.buscarReservaPorNomeOrdenada(acao, param) : Ctrl.ordenarReserva(acao);
			
		Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
		String json = gson.toJson(reservas);

		response.setContentType("application/json");
		response.getOutputStream().write(json.getBytes(StandardCharsets.UTF_8));
		response.flushBuffer();
		return json;
	}
}
