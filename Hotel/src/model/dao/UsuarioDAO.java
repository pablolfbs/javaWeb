package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import model.Usuario;

public class UsuarioDAO {
	
	Connection connection = ConnectionFactory.createConnection();
	
	public Usuario inserir(Usuario usuario) {
		String sql = " INSERT INTO usuario (email, senha) VALUES (?, ?) ";
		
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getSenha());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	public Collection<? extends Usuario> listar() {
		String sql = " SELECT * FROM usuario ";
		
		PreparedStatement ps;
		ResultSet rs;
		Set<Usuario> usuarios = new HashSet<Usuario>();
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuarios.add(usuario);
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public Usuario validate(String email, String senha) {
		String sql = " SELECT * FROM usuario WHERE email = ? AND senha = ? ";
		
		PreparedStatement ps;
		ResultSet rs;
		Usuario usuario = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, senha);
			rs = ps.executeQuery();
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
}
