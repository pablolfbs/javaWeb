package controller;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Quarto;

public class CarregaQuartos implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Set<Quarto> quartos = new LinkedHashSet<Quarto>();
		
		if (Ctrl.carregaListaReservas().isEmpty())
			quartos.addAll(Ctrl.iniciarListaQuartos());
			
		else
			quartos.addAll(Ctrl.carregaListaQuartos());
			
		String json = new Gson().toJson(quartos);

		response.setContentType("application/json");
		response.getOutputStream().write(json.getBytes());
		response.flushBuffer();
		return json;
	}

}
