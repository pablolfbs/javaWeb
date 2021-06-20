package br.com.alura.servico;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.alura.dao.AgendamentoEmailDAO;
import br.com.alura.entidade.AgendamentoEmail;

@Stateless
public class AgendamentoEmailServico {
	
	@Inject
	AgendamentoEmailDAO aDAO;
	
	public List<AgendamentoEmail> listar() {
		return aDAO.listar();
	}

}
