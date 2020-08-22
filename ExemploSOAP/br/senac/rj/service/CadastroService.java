package br.senac.rj.service;

import javax.jws.WebService;
import javax.jws.WebMethod;

import br.senac.rj.model.Pessoa;

/**
 * SEI - Service Endpoint Interface
 */

@WebService
public interface CadastroService {

	@WebMethod
	public boolean addPessoa(Pessoa p);

	@WebMethod
	public boolean deletePessoa(int id);

	@WebMethod
	public Pessoa getPessoa(int id);

	@WebMethod
	public Pessoa[] getTodasPessoas();

}