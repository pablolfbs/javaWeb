package br.com.hightechcursos.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hightechcursos.entidades.Usuario;

public class UsuarioDAO {

	private Connection con = Conexao.getConnection();

	public void cadastrar(Usuario usuario) {
		String sql = "INSERT INTO usuario (nome, login, senha) VALUES (?, ?, ?);";

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			ps.execute();
			ps.close();
			System.out.println("Cadastrado com sucesso!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Usuario usuario) {
		String sql = "UPDATE usuario SET nome = ?, login = ?, senha = md5(?) WHERE id = ?;";

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getLogin());
			ps.setString(3, usuario.getSenha());
			ps.setInt(4, usuario.getId());
			ps.execute();
			ps.close();
			System.out.println("Atualizado com sucesso!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void salvar(Usuario usuario) {
		if (usuario.getId() != null && usuario.getId() != 0) {
			atualizar(usuario);
		} else {
			cadastrar(usuario);
		}
	}

	public void excluir(Usuario usuario) {
		String sql = "DELETE FROM usuario WHERE id = ?;";

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, usuario.getId());
			ps.execute();
			ps.close();
			System.out.println("Apagado com sucesso!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Usuario> buscarTodos() {
		String sql = "SELECT * FROM usuario;";

		PreparedStatement ps;
		ResultSet rs;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuarios.add(usuario);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public Usuario buscarPorId(Integer id) {
		String sql = "SELECT * FROM usuario WHERE id = ?;";

		PreparedStatement ps;
		ResultSet rs;
		Usuario usuario = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	public List<Usuario> buscarPorNome(String nome) {
		String sql = "SELECT * FROM usuario WHERE nome like ?;";

		PreparedStatement ps;
		ResultSet rs;
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + nome + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuarios.add(usuario);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public Usuario autenticar(Usuario usuario) {
		String sql = "SELECT * FROM usuario WHERE login = ? AND senha = md5(?);";

		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getSenha());
			rs = ps.executeQuery();
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
			}
			ps.close();
			return usuario;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
