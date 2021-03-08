package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import model.Usuario;

public class UsuarioDAO {
	
	Connection connection = ConnectionFactory.getConnection();
	
	public Usuario inserir(Usuario usuario) {
		String sql = " INSERT INTO usuario (email, senha) VALUES (?, ?) ";
		
		try (PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getSenha());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	public Collection<Usuario> listar() {
		String sql = " SELECT * FROM usuario ";
		
		Set<Usuario> usuarios = new HashSet<>();
		
		try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public Usuario validate(String email, String senha) {
		String sql = " SELECT * FROM usuario WHERE email = '" + email + "' AND senha = " + senha + ";";
		
		Usuario usuario = null;
		
		try (Statement sttm = connection.createStatement(); ResultSet rs = sttm.executeQuery(sql);) {
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public void buscarPorEmail(String email) {
		String sql = " SELECT * FROM usuario WHERE email = '" + email + ";";
		
		Usuario usuario = null;
		
		try (Statement sttm = connection.createStatement(); ResultSet rs = sttm.executeQuery(sql);) {
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
}
