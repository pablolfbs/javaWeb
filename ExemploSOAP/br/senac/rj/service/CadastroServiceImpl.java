package br.senac.rj.service;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

import javax.jws.WebService;

import br.senac.rj.model.Pessoa;

/**
 * SIB - Service Implementation Bean
 */

@WebService(endpointInterface = "br.senac.rj.service.CadastroService")
public class CadastroServiceImpl implements CadastroService {

	private Map<Integer, Pessoa> pessoas = new HashMap<Integer, Pessoa>();

	public boolean addPessoa(Pessoa p) {
		if (pessoas.get(p.getId()) != null)
			return false;

		pessoas.put(p.getId(), p);
		return true;
	}

	public boolean deletePessoa(int id) {
		if (pessoas.get(id) == null)
			return false;
		
		pessoas.remove(id);
		return true;
	}

	public Pessoa getPessoa(int id) {
		return pessoas.get(id);
	}

	public Pessoa[] getTodasPessoas() {
		Set<Integer> ids = pessoas.keySet();
		Pessoa[] listaPessoas = new Pessoa[ids.size()];

		int i = 0;
		for (Integer id : ids) {
			listaPessoas[i] = pessoas.get(id);
			i++;
		}
		return listaPessoas;
	}

}