package br.com.alura.gerenciador.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<Empresa>();
	private static List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private static Integer chave = 1;

	static {
		Empresa empresa1 = new Empresa();
		empresa1.setId(chave++);
		empresa1.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chave++);
		empresa2.setNome("Caelum");
		lista.add(empresa1);
		lista.add(empresa2);

		Usuario u1 = new Usuario();
		u1.setLogin("pablo@pablo.com");
		u1.setSenha("123");
		listaUsuarios.add(u1);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chave++);
		Banco.lista.add(empresa);
	}

	public void altera(Empresa empresa) {

	}

	public Empresa buscarEmpresaPorId(Integer id) {
		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {
		Iterator<Empresa> it = lista.iterator();

		while (it.hasNext()) {
			Empresa empresa = it.next();
			if (empresa.getId() == id) {
				it.remove();
			}
		}
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario u : listaUsuarios) {
			if (u.validate(login, senha)) {
				return u;
			}
		}
		return null;
	}
}
