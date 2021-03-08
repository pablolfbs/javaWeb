package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;

public class ResetarSenha implements Acao {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	HttpSession session = request.getSession();

        String email = request.getParameter("email");
        session.setAttribute("email", email);
        
        Usuario usuario = new Usuario(email);
        Ctrl.usuarioExiste(usuario);

        if (Ctrl.usuarioExiste(usuario))
        	return "forward:novasenha.jsp";
        else
        	return "forward:esquecisenha.jsp";

    }
    
}
