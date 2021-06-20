package br.com.alura.gerenciador.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class AlteraEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Alterando empresa");
		
		String paramNome = request.getParameter("nome");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscarEmpresaPorId(id);
		empresa.setNome(paramNome);
		banco.altera(empresa);
		
		return "redirect:entrada?acao=listaEmpresas";
	}

}
