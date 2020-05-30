package controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Reserva;
import model.dao.ReservaDAO;

public class ListarReservas implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		
		ReservaDAO rDAO = new ReservaDAO();
		Collection<? extends Reserva> reservas = rDAO .listar();
		
		sessao.setAttribute("listaHospedes", reservas);
		
		return "forward:listareservas.jsp";
	}

}
