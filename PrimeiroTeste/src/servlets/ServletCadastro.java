package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCadastro extends HttpServlet{
	
	private static final long serialVersionUID = -3410152004813244654L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String nomeUsuario = req.getParameter("nome");
		String cpfUsuario = req.getParameter("cpf");
		
		System.out.println(nomeUsuario + "\n" + cpfUsuario);
		
		res.sendRedirect("confirmacao.html");
		
	}

}
