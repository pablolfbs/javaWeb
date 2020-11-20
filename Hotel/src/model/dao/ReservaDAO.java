package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import controller.Ctrl;
import model.Hospede;
import model.Reserva;

public class ReservaDAO {

	private Connection connection = ConnectionFactory.getConnection();
	
	private static final String ID_HOSPEDE = "id_hospede";
	private static final String QUARTO = "quarto";
	private static final String DT_ENTRADA = "dtEntrada";
	private static final String DT_SAIDA = "dtSaida";

	private static final String QUERY_RESEVAHOSPEDE = " SELECT * FROM reserva r JOIN hospede h WHERE r.id_hospede = h.id AND h.nome LIKE '%";

	public void inserir(Reserva reserva) {
		String sql = " INSERT INTO reserva (id_hospede, quarto, dtEntrada, dtSaida) VALUES (?, ?, ?, ?) ";
		Integer quarto = reserva.getQuarto();
		
		try (PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setInt(1, reserva.getHospede().getId());
			ps.setInt(2, quarto);
			ps.setDate(3, new java.sql.Date(reserva.getDtEntrada().getTime()));
			ps.setDate(4, new java.sql.Date(reserva.getDtSaida().getTime()));
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Reserva reserva) {
		String sql = " UPDATE reserva SET id_hospede = ?, quarto = ?, dtEntrada = ?, dtSaida = ? WHERE id = ? ";

		Hospede hospede = reserva.getHospede();
		Integer quarto = reserva.getQuarto();
		
		try (PreparedStatement ps = connection.prepareStatement(sql);) {
			
			ps.setInt(1, hospede.getId());
			ps.setInt(2, quarto);
			ps.setDate(3, new java.sql.Date(reserva.getDtEntrada().getTime()));
			ps.setDate(4, new java.sql.Date(reserva.getDtSaida().getTime()));
			ps.setInt(5, reserva.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void excluir(int id) {
		String sql = " DELETE FROM reserva WHERE id = ? ";
		
		try (PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluirTodos() {
		String sql = " DELETE FROM reserva ";

		try (PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Collection<Reserva> listar() {
		String sql = " SELECT * FROM reserva ";
		Set<Reserva> reservas = new LinkedHashSet<>();
		
		try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				Reserva reserva = new Reserva();
				reserva.setId(rs.getInt("id"));
				reserva.setHospede(Ctrl.buscarHospedePorId(rs.getInt(ID_HOSPEDE)));
				reserva.setQuarto(rs.getInt(QUARTO));
				reserva.setDtEntrada(rs.getDate(DT_ENTRADA));
				reserva.setDtSaida(rs.getDate(DT_SAIDA));
				reservas.add(reserva);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}
	
	public Collection<Reserva> buscarPorNomeHospede(String nome) {
		String sql = QUERY_RESEVAHOSPEDE + nome
				+ "%' ";

		Set<Reserva> reservas = new LinkedHashSet<>();
		
		try (Statement sttm = connection.createStatement(); ResultSet rs = sttm.executeQuery(sql);) {
			
			while (rs.next()) {
				Reserva r = new Reserva();
				r.setId(rs.getInt("id"));
				r.setHospede(Ctrl.buscarHospedePorId(rs.getInt(ID_HOSPEDE)));
				r.setQuarto(rs.getInt(QUARTO));
				r.setDtEntrada(rs.getDate(DT_ENTRADA));
				r.setDtSaida(rs.getDate(DT_SAIDA));
				reservas.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}

	public Collection<Reserva> buscarPorEmailHospede(String nome) {
		String sql = " SELECT * FROM reserva r JOIN hospede h WHERE r.id_hospede = h.id AND h.email LIKE '%" + nome
				+ "%' ";

		Set<Reserva> reservas = new LinkedHashSet<>();
		
		try (Statement sttm = connection.createStatement(); ResultSet rs = sttm.executeQuery(sql);) {
			while (rs.next()) {
				Reserva r = new Reserva();
				r.setId(rs.getInt("id"));
				r.setHospede(Ctrl.buscarHospedePorId(rs.getInt(ID_HOSPEDE)));
				r.setQuarto(rs.getInt(QUARTO));
				r.setDtEntrada(rs.getDate(DT_ENTRADA));
				r.setDtSaida(rs.getDate(DT_SAIDA));
				reservas.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}

	public Collection<Reserva> ordenarReserva(String param) {
		String sql = " SELECT * FROM reserva r ORDER BY r." + param + " ";

		Set<Reserva> reservas = new LinkedHashSet<>();
		
		try (Statement sttm = connection.createStatement(); ResultSet rs = sttm.executeQuery(sql);) {
			while (rs.next()) {
				Reserva r = new Reserva();
				r.setId(rs.getInt("id"));
				r.setHospede(Ctrl.buscarHospedePorId(rs.getInt(ID_HOSPEDE)));
				r.setQuarto(rs.getInt(QUARTO));
				r.setDtEntrada(rs.getDate(DT_ENTRADA));
				r.setDtSaida(rs.getDate(DT_SAIDA));
				reservas.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}

	public Collection<Reserva> ordenarReservaPorHospede(String param) {
		String sql = " SELECT * FROM reserva r JOIN hospede h WHERE r.id_hospede = h.id ORDER BY h." + param + " ";

		Set<Reserva> reservas = new LinkedHashSet<>();
		
		try (Statement sttm = connection.createStatement(); ResultSet rs = sttm.executeQuery(sql);) {
			while (rs.next()) {
				Reserva r = new Reserva();
				r.setId(rs.getInt("id"));
				r.setHospede(Ctrl.buscarHospedePorId(rs.getInt(ID_HOSPEDE)));
				r.setQuarto(rs.getInt(QUARTO));
				r.setDtEntrada(rs.getDate(DT_ENTRADA));
				r.setDtSaida(rs.getDate(DT_SAIDA));
				reservas.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}

	public Collection<Reserva> buscarReservaPorNomeOrdenada(String param, String nome) {
		String sql = QUERY_RESEVAHOSPEDE + nome
				+ "%' ORDER BY r." + param + " ";

		Set<Reserva> reservas = new LinkedHashSet<>();
		try (Statement sttm = connection.createStatement(); ResultSet rs = sttm.executeQuery(sql);) {
			while (rs.next()) {
				Reserva r = new Reserva();
				r.setId(rs.getInt("id"));
				r.setHospede(Ctrl.buscarHospedePorId(rs.getInt(ID_HOSPEDE)));
				r.setQuarto(rs.getInt(QUARTO));
				r.setDtEntrada(rs.getDate(DT_ENTRADA));
				r.setDtSaida(rs.getDate(DT_SAIDA));
				reservas.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}

	public Collection<Reserva> buscarReservaPorNomeOrdenadaPorHospede(String param, String nome) {
		String sql = QUERY_RESEVAHOSPEDE + nome
				+ "%' ORDER BY h." + param + " ";

		Set<Reserva> reservas = new LinkedHashSet<>();
		try (Statement sttm = connection.createStatement(); ResultSet rs = sttm.executeQuery(sql);) {
			
			while (rs.next()) {
				Reserva r = new Reserva();
				r.setId(rs.getInt("id"));
				r.setHospede(Ctrl.buscarHospedePorId(rs.getInt(ID_HOSPEDE)));
				r.setQuarto(rs.getInt(QUARTO));
				r.setDtEntrada(rs.getDate(DT_ENTRADA));
				r.setDtSaida(rs.getDate(DT_SAIDA));
				reservas.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}

}
