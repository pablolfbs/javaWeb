package controller;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Hospede;
import model.Quarto;
import model.Reserva;

public class ExcluirLinha implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		
		String hospedeId = request.getParameter("hospedeId");
		String quartoNum = request.getParameter("quartoNum");

		Hospede hospede = Ctrl.buscarHospedePorId(Integer.parseInt(hospedeId));
		
		Quarto quarto = new Quarto(Integer.valueOf(quartoNum));
		
		Ctrl.excluiLinha(hospedeId, quarto);

		Set<Quarto> quartos = new LinkedHashSet<>();
		quartos.addAll(Ctrl.carregaListaQuartos());
		sessao.setAttribute("listaQuartos", quartos);
		
		Collection<? extends Reserva> reservas = Ctrl.carregaListaReservas();
		sessao.setAttribute("listaHospedes", reservas);
		
		Ctrl.enviaEmailExclusaoReserva(hospede, quarto);

		return "redirect:entrada?acao=listarReservas";
	}

}
