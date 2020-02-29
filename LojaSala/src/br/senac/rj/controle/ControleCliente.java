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
public class ControleCliente implements Serializable {

	@EJB
	private ClienteDAO dao;
	private Cliente cliente;

	public void zerarCliente() {
		cliente = new Cliente();
		cliente.setId(null);
	}
	
	public void gravarCliente() {
		dao.gravar(cliente);
	}
	
	public void editar(Cliente c) {
		dao.editar(c);
	}
	
	public void remover(Integer id) {
		dao.remove(id);
	}
	
	public List<Cliente> listarClientes() {
		return dao.todosObjetos();
	}
	
	public Cliente buscaPorId(Integer id) {
		return dao.buscaPorId(id);
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
