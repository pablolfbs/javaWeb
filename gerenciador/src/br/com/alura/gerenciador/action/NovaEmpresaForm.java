package br.com.alura.gerenciador.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovaEmpresaForm implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		return "forward:formNovaEmpresa.jsp";
		
	}

}
