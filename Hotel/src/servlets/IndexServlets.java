package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReservaDao;
import model.Reserva;

@WebServlet("/opcao")
public class IndexServlets extends HttpServlet{
	
	ReservaDao r = new ReservaDao();
	
	@Override
	protected void service(HttpServletRequest tico, 
			HttpServletResponse teco) throws ServletException, IOException {
		
		String opcao = tico.getParameter("opcao");
		
		HttpSession secao = tico.getSession();
		
		if(opcao.equals("Check-in")){
			
			if (r.temVaga()) {
				teco.sendRedirect("checkIn.html");
			} else {
				System.out.println("Deu certo porra");
				teco.sendRedirect("");
			}
	
		} else if (opcao.equals("Check-out")) {
			
			teco.sendRedirect("checkOut.html");
			
		} else if(opcao.equals("Listar")){
			
			//System.out.println(reserva.get(0).getHospede().getNome());
			
			//secao.setAttribute("listaReserva", );
			teco.sendRedirect("ListarReservas.jsp");
			
		}
		
	}
}
