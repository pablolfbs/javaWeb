package br.senac.rj.controle;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.senac.rj.modelo.Cliente;
import br.senac.rj.modelo.dao.ClienteDAO;

@Named(value = "controleCliente")
@SessionScoped
public class ControleCliente implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ClienteDAO dao;
	private Cliente cliente;
	
	public void gravar() {
		dao.gravar(cliente);
	}
	
	public void editar(Cliente c) {
		dao.editar(c);
	}
	
	public void remover(Cliente c) {
		dao.remove(c);
	}
	
	public Cliente buscaPorId() {
		return dao.buscaPorId(cliente.getId());
	}
	
	public List<Cliente> listar() {
		return dao.todosObjetos();
	}
	
	public void getNewCliente() {
		cliente = new Cliente();
		cliente.setId(null);
	}

	public ClienteDAO getDao() {
		return dao;
	}

	public void setDao(ClienteDAO dao) {
		this.dao = dao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
