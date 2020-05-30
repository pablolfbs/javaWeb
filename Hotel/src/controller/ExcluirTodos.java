package controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Reserva;

public class ExcluirTodos implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<? extends Reserva> reservas = Ctrl.carregaListaReservas();

		if (!reservas.isEmpty()) {
			Ctrl.excluirTodos();
		}

		Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
		String json = gson.toJson(reservas);

		response.setContentType("application/json");
		response.getOutputStream().write(json.getBytes(StandardCharsets.UTF_8));
		response.flushBuffer();
		return json;
	}

}
