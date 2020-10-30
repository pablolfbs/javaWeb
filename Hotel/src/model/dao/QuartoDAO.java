package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import model.Quarto;

public class QuartoDAO {
	
	Connection connection = ConnectionFactory.getConnection();
	
	public Quarto inserir(Quarto quarto) {
		String sql = " INSERT INTO quarto (num) VALUES (?) ";
		
		try (PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setInt(1, quarto.getNum());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quarto;
	}
	
	public void atualizar(Quarto quarto) {
		String sql = " UPDATE quarto SET num = ? ";
		
		try (PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setInt(1, quarto.getNum());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int num) {
		String sql = " DELETE FROM quarto WHERE num = ? ";
		
		try (PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setInt(1, num);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void excluirTodos() {
		String sql = " DELETE FROM quarto ";
		
		try (PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Collection<Quarto> listar() {
		String sql = " SELECT * FROM quarto ORDER BY num ";
		
		Set<Quarto> quartos = new LinkedHashSet<>();
		try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				Quarto q = new Quarto();
				q.setNum(rs.getInt("num"));
				quartos.add(q);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quartos;
	}

}
