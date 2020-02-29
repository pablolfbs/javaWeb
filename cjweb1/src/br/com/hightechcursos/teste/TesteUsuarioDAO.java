package br.com.hightechcursos.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.hightechcursos.entidades.Usuario;
import br.com.hightechcursos.jdbc.UsuarioDAO;

public class TesteUsuarioDAO {
	
	public static void main(String[] args) {
	
	// testCadastrar();
	// testAtualizar();
	// testExcluir();
	// testBuscarTodos();
	testBuscarPorId();
	
	}

	private static void testAtualizar() {
		Usuario u = new Usuario();
		UsuarioDAO udao = new UsuarioDAO();
		
		u.setNome("Ingrid");
		u.setLogin("didilbs");
		u.setSenha("1234");
		u.setId(2);
		udao.atualizar(u);
	}

	private static void testCadastrar() {
		Usuario u = new Usuario();
		UsuarioDAO udao = new UsuarioDAO();
		
		u.setNome("Nadja");
		u.setLogin("nadjasb");
		u.setSenha("1234");
		udao.cadastrar(u);
	}
	
	private static void testExcluir() {
		Usuario u = new Usuario();
		UsuarioDAO udao = new UsuarioDAO();
		u.setId(3);
		udao.excluir(u);
	}
	
	private static void testBuscarTodos() {
		UsuarioDAO udao = new UsuarioDAO();
		List<Usuario> usuarios = udao.buscarTodos();
		for (Usuario usuario : usuarios) {
			System.out.println(usuario.getId());
			System.out.println(usuario.getNome());
			System.out.println(usuario.getLogin());
			System.out.println(usuario.getSenha());
		}
	}
	
	private static void testBuscarPorId() {
		Usuario u = new Usuario();
		UsuarioDAO udao = new UsuarioDAO();
		u = udao.buscarPorId(0);
		System.out.println(u.getId());
		System.out.println(u.getNome());
		System.out.println(u.getLogin());
		System.out.println(u.getSenha());
	}
}
