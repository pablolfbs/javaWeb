package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

import model.Quarto;

public class QuartoDAO {
	
	Connection connection = ConnectionFactory.getConnection();
	
	public int inserir(Quarto quarto) {
		String sql = " INSERT INTO quarto (num) VALUES (?) ";
		
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, quarto.getNum());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quarto.getNum();
	}
	
	public void atualizar(Quarto quarto) {
		String sql = " UPDATE quarto SET num = ? ";
		
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, quarto.getNum());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int num) {
		String sql = " DELETE FROM quarto WHERE num = ? ";
		
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, num);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluirTodos() {
		String sql = " DELETE FROM quarto ";
		
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Set<Quarto> listar() {
		String sql = " SELECT * FROM quarto ORDER BY num ";
		
		PreparedStatement ps;
		ResultSet rs;
		Set<Quarto> quartos = new LinkedHashSet<Quarto>();
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Quarto q = new Quarto();
				q.setNum(rs.getInt("num"));
				quartos.add(q);
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quartos;
	}

	public void iniciarQuartos() {
		String sql = " INSERT INTO quarto (num) VALUES (?), (?), (?), (?), (?), (?), (?), (?), (?), (?) ";

		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
			
			for (int i = 1; i <= 10; i++) {
				ps.setInt(i, i);
			}
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
