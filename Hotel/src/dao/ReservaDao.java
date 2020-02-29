package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Hospede;
import model.Quarto;
import model.Reserva;
import dao.ConnectionFactory;

public class ReservaDao {

private Connection connection = ConnectionFactory.getConnection();
	
	public void inserir(Reserva reserva) {
		String sql = "INSERT INTO reserva (id_hospede, id_quarto, dtEntrada, dtSaida) VALUES (?, ?, ?, ?);";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setLong(1, reserva.getHospede().getId());
			ps.setInt(2, reserva.getQuarto().getNumero());
			ps.setString(3, reserva.getDataEntrada());
			ps.setString(4, reserva.getDataSaida());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean temVaga() {
		int cont = 0;
		String sql = "SELECT * FROM reserva;";
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getObject("dtSaida") == null) {
					cont += 1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (cont < 30) {
			return true;
		}
		return false;
	}
	
	public List<Reserva> listar() {
		String sql = "SELECT * FROM reserva;";
		PreparedStatement ps;
		ResultSet rs;
		List<Reserva> reservas = new ArrayList<Reserva>();
		HospedeDao h = new HospedeDao();
		QuartoDao q = new QuartoDao();
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Reserva reserva = new Reserva();
				reserva.setHospede(h.getHospedeById((int) rs.getObject("hospede")));
				reserva.setQuarto(q.getQuartoById((int) rs.getObject("quarto")));
				reserva.setDataEntrada(rs.getString("dtEntrada"));
				reserva.setDataSaida(rs.getString("dtSaida"));
				reservas.add(reserva);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}
}
