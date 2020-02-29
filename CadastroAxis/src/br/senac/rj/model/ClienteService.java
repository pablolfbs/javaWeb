package br.senac.rj.model;

public interface ClienteService {
	
	public boolean addCliente(Cliente c);
	
	public boolean removeCliente(int id);
	
	public Cliente getCliente(int id);
	
	public Cliente[] getTodosClientes();

}
