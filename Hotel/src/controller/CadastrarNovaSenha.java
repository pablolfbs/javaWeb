package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;

public class CadastrarNovaSenha implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		
		String senha1 = request.getParameter("pass1");
		String senha2 = request.getParameter("pass2");
		
		if (senha1.equals(senha2)) {
			Usuario usuario = new Usuario(email, senha1);
			Ctrl.usuarioExiste(usuario);
			
			Ctrl.cadastrarNovaSenha(usuario);
		}
        
		return "redirect:entrada?acao=loginForm";
	}

}
