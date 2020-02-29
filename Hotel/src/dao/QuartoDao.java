package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Hospede;
import model.Quarto;
import dao.ConnectionFactory;

public class QuartoDao {

Connection connection = ConnectionFactory.getConnection();
	
	public void inserir(Quarto quarto) {
		String sql = "INSERT INTO quarto (num) VALUES (?);";
		
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, quarto.getNumero());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Quarto> listar() {
		String sql = "SELECT * FROM quarto;";
		
		PreparedStatement ps;
		ResultSet rs;
		List<Quarto> quartos = new ArrayList<Quarto>();
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Quarto q = new Quarto();
				q.setNumero(rs.getInt("numero"));
				quartos.add(q);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quartos;
	}
	
	public Quarto getQuartoById(int id) {
		String sql = "SELECT * FROM quarto WHERE numero = ?;";
		
		PreparedStatement ps;
		ResultSet rs;

		try {
			ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Quarto quarto = new Quarto();
				quarto.setNumero(rs.getInt("numero"));
				return quarto;
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
