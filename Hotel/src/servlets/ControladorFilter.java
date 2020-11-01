package servlets;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Acao;

@WebFilter("/entrada")
public class ControladorFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String paramAcao = request.getParameter("acao");

		String className = "controller." + paramAcao.substring(0, 1).toUpperCase() + paramAcao.substring(1);

		String nome = null;

		try {
			nome = buscaClasse(request, response, className, nome);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException | IOException e) {
			throw new ServletException(e);
		}

		String[] param = nome != null ? nome.split(":") : new String[] {};
		if (param[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + param[1]);
			rd.forward(request, response);
		} else if (param[0].equals("redirect")) {
			response.sendRedirect(param[1]);
		}
	}

	private String buscaClasse(HttpServletRequest request, HttpServletResponse response, String className, String nome)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, ServletException,
			IOException {
		Class<?> classe = Class.forName(className);
		try {
			Acao acao = (Acao) classe.getDeclaredConstructor().newInstance();
			nome = acao.executa(request, response);
		} catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return nome;
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}
}
