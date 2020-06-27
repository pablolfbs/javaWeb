package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;

public class Registro implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		
		Usuario usuario = null;
		if (!email.equals("") && email != null && !password.equals("") && password != null && password.equals(password2)) {
			usuario = Ctrl.registraUsuario(email, password);
			
			HttpSession sessao = request.getSession();
			if (sessao.getAttribute("valido") == null)
				sessao.setAttribute("valido", usuario);
			return "redirect:entrada?acao=index";
		} else {
			return "redirect:entrada?acao=registroForm";
		}
		
	}

}
