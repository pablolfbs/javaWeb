package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;

import model.Hospede;

public class HospedeDAO {
	
Connection connection = ConnectionFactory.getConnection();
	
	public int inserir(Hospede hospede) {
		String sql = " INSERT INTO hospede (nome, sobrenome, email) VALUES (?, ?, ?) ";
		
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, hospede.getNome());
			ps.setString(2, hospede.getSobrenome());
			ps.setString(3, hospede.getEmail());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet rs;
		int id = 0;
		try {
			rs = ps.getGeneratedKeys();
			if(rs.next()){
				id = rs.getInt(1);
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public void atualizar(Hospede hospede) {
		String sql = " UPDATE hospede SET nome = ?, sobrenome = ?, email = ? WHERE id = ? ";
		
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, hospede.getNome());
			ps.setString(2, hospede.getSobrenome());
			ps.setString(3, hospede.getEmail());
			ps.setInt(4, hospede.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int id) {
		String sql = " DELETE FROM hospede WHERE id = ? ";
		
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluirTodos() {
		String sql = " DELETE FROM hospede ";
		
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Hospede buscarPorId(Integer id) {
		String sql = " SELECT * FROM hospede WHERE id = ? ";
		
		Hospede hospede = new Hospede();
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				hospede.setId(id);
				hospede.setNome(rs.getString("nome"));
				hospede.setEmail(rs.getString("email"));
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hospede;
	}
	
	public Set<Hospede> buscarPorNome(String nome) {
		String sql = " SELECT * FROM hospede WHERE nome LIKE '%" + nome + "%' ";
		
		Set<Hospede> hospedes = new LinkedHashSet<Hospede>();
		try {
			Statement sttm = connection.createStatement();
			ResultSet rs = sttm.executeQuery(sql);
			while (rs.next()) {
				Hospede hospede = new Hospede();
				hospede.setId(rs.getInt("id"));
				hospede.setNome(rs.getString("nome"));
				hospede.setEmail(rs.getString("email"));
				hospedes.add(hospede);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hospedes;
	}
	
	public Set<Hospede> listar() {
		String sql = " SELECT * FROM hospede ";
		
		PreparedStatement ps;
		ResultSet rs;
		Set<Hospede> hospedes = new LinkedHashSet<Hospede>();
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Hospede hospede = new Hospede();
				hospede.setId(rs.getInt("id"));
				hospede.setNome(rs.getString("nome"));
				hospede.setSobrenome(rs.getString("sobrenome"));
				hospede.setEmail(rs.getString("email"));
				hospedes.add(hospede);
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hospedes;
	}
	
}
