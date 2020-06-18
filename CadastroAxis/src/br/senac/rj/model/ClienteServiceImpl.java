package br.senac.rj.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ClienteServiceImpl implements ClienteService {

	private Map<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();

	@Override
	public boolean addCliente(Cliente c) {
		if (clientes.get(c.getId()) != null) {
			return false;
		}
		clientes.put(c.getId(), c);
		return true;
	}

	@Override
	public boolean removeCliente(int id) {
		if (clientes.get(id) == null) {
			return false;
		}
		return true;
	}

	@Override
	public Cliente getCliente(int id) {
		return clientes.get(id);
	}

	@Override
	public Cliente[] getTodosClientes() {
		Set<Integer> ids = clientes.keySet();
		Cliente[] arrayClientes = new Cliente[ids.size()];

		int i = 0;
		for (Integer id : ids) {
			arrayClientes[i] = clientes.get(id);
		}
		return null;
	}

}
