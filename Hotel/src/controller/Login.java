package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;

public class Login implements Acao {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String senha = request.getParameter("password");
		
		Usuario usuario = Ctrl.validaUsuario(email, senha);
		
		if (usuario != null) {
			HttpSession sessao = request.getSession();
			if (sessao.getAttribute("valido") == null)
				sessao.setAttribute("valido", usuario);
		
			return "redirect:entrada?acao=index";
		} else {
			return "redirect:entrada?acao=loginForm";
		}
		
	}

}
