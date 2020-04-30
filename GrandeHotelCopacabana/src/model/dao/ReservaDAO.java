package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

import controller.Ctrl;
import model.Hospede;
import model.Reserva;

public class ReservaDAO {

	private Connection connection = ConnectionFactory.getConnection();
	
	public void inserir(Reserva reserva) {
		String sql = " INSERT INTO reserva (id_hospede, quarto, dtEntrada, dtSaida) VALUES (?, ?, ?, ?) ";
		Integer quarto = reserva.getQuarto();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, reserva.getHospede().getId());
			ps.setInt(2, quarto);
			ps.setDate(3, new java.sql.Date(reserva.getDtEntrada().getTime()));
			ps.setDate(4, new java.sql.Date(reserva.getDtSaida().getTime()));
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Reserva reserva) {
		String sql = " UPDATE reserva SET id_hospede = ?, quarto = ?, dtEntrada = ?, dtSaida = ? WHERE id = ? ";
		
		Hospede hospede = reserva.getHospede();
		Integer quarto = reserva.getQuarto();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, hospede.getId());
			ps.setInt(2, quarto);
			ps.setDate(3, new java.sql.Date(reserva.getDtEntrada().getTime()));
			ps.setDate(4, new java.sql.Date(reserva.getDtSaida().getTime()));
			ps.setInt(5, reserva.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void excluir(int id) {
		String sql = " DELETE FROM reserva WHERE id = ? ";
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
		String sql = " DELETE FROM reserva ";
		
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Set<Reserva> listar() {
		String sql = " SELECT * FROM reserva ";
		PreparedStatement ps;
		ResultSet rs;
		Set<Reserva> reservas = new LinkedHashSet<Reserva>();
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Reserva reserva = new Reserva();
				reserva.setHospede(Ctrl.getHospedeById(rs.getInt("id_hospede")));
//				reserva.setQuarto(Ctrl.getQuartoByNum(rs.getInt("quarto")));
				reserva.setQuarto(rs.getInt("quarto"));
				reserva.setDtEntrada(rs.getDate("dtEntrada"));
				reserva.setDtSaida(rs.getDate("dtSaida"));
				reservas.add(reserva);
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}
	
}
