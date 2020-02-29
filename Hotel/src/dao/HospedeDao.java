package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Hospede;
import dao.ConnectionFactory;

public class HospedeDao {

	Connection connection = ConnectionFactory.getConnection();

	public void inserir(Hospede hospede) {
		String sql = "INSERT INTO hospede (cpf, nome) VALUES (?, ?);";

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, hospede.getCpf());
			ps.setString(2, hospede.getNome());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Hospede> listar() {
		String sql = "SELECT * FROM hospede;";

		PreparedStatement ps;
		ResultSet rs;
		List<Hospede> hospedes = new ArrayList<Hospede>();
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Hospede hospede = new Hospede();
				hospede.setId(rs.getInt("id"));
				hospede.setNome(rs.getString("nome"));
				hospede.setCpf(rs.getString("cpf"));
				hospedes.add(hospede);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hospedes;
	}

	public Hospede getHospedeById(int id) {
		String sql = "SELECT * FROM hospede WHERE id = ?;";
		
		PreparedStatement ps;
		ResultSet rs;

		try {
			ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Hospede hospede = new Hospede();
				hospede.setId(rs.getInt("id"));
				hospede.setNome(rs.getString("nome"));
				hospede.setCpf(rs.getString("cpf"));
				return hospede;
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
