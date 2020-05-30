package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import controller.Ctrl;
import model.Hospede;
import model.Quarto;
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
	
	public Collection<? extends Reserva> listar() {
		String sql = " SELECT * FROM reserva ";
		PreparedStatement ps;
		ResultSet rs;
		Set<Reserva> reservas = new LinkedHashSet<Reserva>();
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Reserva reserva = new Reserva();
				reserva.setId(rs.getInt("id"));
				reserva.setHospede(Ctrl.buscarHospedePorId(rs.getInt("id_hospede")));
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
	
	public List<Quarto> listarQuartosReservados() {
		String sql = " SELECT quarto FROM reserva ";
		PreparedStatement ps;
		ResultSet rs;
		List<Quarto> quartos = new ArrayList<Quarto>();
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Reserva reserva = new Reserva();
				reserva.setQuarto(rs.getInt("quarto"));
				Quarto q = new Quarto();
				q.setNum(reserva.getQuarto());
				quartos.add(q);
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quartos;
	}
	
	public Collection<? extends Reserva> buscarPorNomeHospede(String nome) {
		String sql = " SELECT * FROM reserva r JOIN hospede h WHERE r.id_hospede = h.id AND h.nome LIKE '%" 
				+ nome + "%' ";

		Set<Reserva> reservas = new LinkedHashSet<Reserva>();
		try {
			Statement sttm = connection.createStatement();
			ResultSet rs = sttm.executeQuery(sql);
			while (rs.next()) {
				Reserva r = new Reserva();
				r.setId(rs.getInt("id"));
				r.setHospede(Ctrl.buscarHospedePorId(rs.getInt("id_hospede")));
				r.setQuarto(rs.getInt("quarto"));
				r.setDtEntrada(rs.getDate("dtEntrada"));
				r.setDtSaida(rs.getDate("dtSaida"));
				reservas.add(r);
			}
			sttm.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}
	
	public Collection<? extends Reserva> ordenarReserva(String param) {
		String sql = " SELECT * FROM reserva r ORDER BY r." + param + " ";
		
		Set<Reserva> reservas = new LinkedHashSet<Reserva>();
		try {
			Statement sttm = connection.createStatement();
			ResultSet rs = sttm.executeQuery(sql);
			while (rs.next()) {
				Reserva r = new Reserva();
				r.setId(rs.getInt("id"));
				r.setHospede(Ctrl.buscarHospedePorId(rs.getInt("id_hospede")));
				r.setQuarto(rs.getInt("quarto"));
				r.setDtEntrada(rs.getDate("dtEntrada"));
				r.setDtSaida(rs.getDate("dtSaida"));
				reservas.add(r);
			}
			sttm.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}
	
	public Collection<? extends Reserva> ordenarReservaPorHospede(String param) {
		String sql = " SELECT * FROM reserva r JOIN hospede h WHERE r.id_hospede = h.id ORDER BY h." + param + " ";
		
		Set<Reserva> reservas = new LinkedHashSet<Reserva>();
		try {
			Statement sttm = connection.createStatement();
			ResultSet rs = sttm.executeQuery(sql);
			while (rs.next()) {
				Reserva r = new Reserva();
				r.setId(rs.getInt("id"));
				r.setHospede(Ctrl.buscarHospedePorId(rs.getInt("id_hospede")));
				r.setQuarto(rs.getInt("quarto"));
				r.setDtEntrada(rs.getDate("dtEntrada"));
				r.setDtSaida(rs.getDate("dtSaida"));
				reservas.add(r);
			}
			sttm.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}

	public Collection<? extends Reserva> buscarReservaPorNomeOrdenada(String param, String nome) {
		String sql = " SELECT * FROM reserva r JOIN hospede h WHERE r.id_hospede = h.id AND h.nome LIKE '%" 
				+ nome + "%' ORDER BY r." + param + " ";

		Set<Reserva> reservas = new LinkedHashSet<Reserva>();
		try {
			Statement sttm = connection.createStatement();
			ResultSet rs = sttm.executeQuery(sql);
			while (rs.next()) {
				Reserva r = new Reserva();
				r.setId(rs.getInt("id"));
				r.setHospede(Ctrl.buscarHospedePorId(rs.getInt("id_hospede")));
				r.setQuarto(rs.getInt("quarto"));
				r.setDtEntrada(rs.getDate("dtEntrada"));
				r.setDtSaida(rs.getDate("dtSaida"));
				reservas.add(r);
			}
			sttm.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}

	public Collection<? extends Reserva> buscarReservaPorNomeOrdenadaPorHospede(String param, String nome) {
		String sql = " SELECT * FROM reserva r JOIN hospede h WHERE r.id_hospede = h.id AND h.nome LIKE '%" 
				+ nome + "%' ORDER BY h." + param + " ";

		Set<Reserva> reservas = new LinkedHashSet<Reserva>();
		try {
			Statement sttm = connection.createStatement();
			ResultSet rs = sttm.executeQuery(sql);
			while (rs.next()) {
				Reserva r = new Reserva();
				r.setId(rs.getInt("id"));
				r.setHospede(Ctrl.buscarHospedePorId(rs.getInt("id_hospede")));
				r.setQuarto(rs.getInt("quarto"));
				r.setDtEntrada(rs.getDate("dtEntrada"));
				r.setDtSaida(rs.getDate("dtSaida"));
				reservas.add(r);
			}
			sttm.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}
}
