package servlets;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Acao;

//@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
		String className = "controller." + paramAcao.substring(0, 1).toUpperCase() + paramAcao.substring(1);
		
		String nome = null;
		
		try {
			Class<?> classe = Class.forName(className);
			Acao acao = (Acao) classe.getDeclaredConstructor().newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException | IOException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new ServletException(e);
		}
		
		String[] param = nome.split(":");
		if (param[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + param[1]);
			rd.forward(request, response);
		} else if (param[0].equals("redirect")) {
			response.sendRedirect(param[1]);
		}
	}
}
