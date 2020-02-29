package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Reserva;

@WebServlet("/opcao")
public class IndexServlets extends HttpServlet{
	
	ArrayList<Reserva> reserva = (ArrayList<Reserva>) RegistraReservasServlets.reservas;
	
	@Override
	protected void service(HttpServletRequest tico, 
			HttpServletResponse teco) throws ServletException, IOException {
		
		String opcao = tico.getParameter("opcao");
		
		HttpSession secao = tico.getSession();
		
		if(opcao.equals("Reserva")){
			
			//if (reserva.getReserva().size() >= 3) {
				teco.sendRedirect("cadastroReservas.html");
			//} else {
				//teco.sendRedirect("");
			//}
	
		} else if(opcao.equals("Listar")){
			
			//System.out.println(reserva.get(0).getHospede().getNome());
			
			secao.setAttribute("listaReserva", reserva);
			teco.sendRedirect("ListarReservas.jsp");
			
		}
		
	}
}
