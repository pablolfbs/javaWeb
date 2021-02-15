package controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Reserva;

public class ListarReservas implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		
		Collection<? extends Reserva> reservas = Ctrl.carregaListaReservas();
		
		sessao.setAttribute("listaHospedes", reservas);
		
		return "forward:listareservas.jsp/entrada?acao=listarReservas";
	}

}
