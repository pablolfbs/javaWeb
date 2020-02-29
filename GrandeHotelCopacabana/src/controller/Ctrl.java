package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Hospede;
import model.Quarto;
import model.Reserva;
import model.dao.ConnectionFactory;
import model.dao.HospedeDAO;
import model.dao.QuartoDAO;
import model.dao.ReservaDAO;

public class Ctrl {

	private static Connection connection = ConnectionFactory.getConnection();

	public static Hospede getHospedeById(int id) {
		String sql = " SELECT * FROM hospede WHERE id = ? ";

		Hospede hospede = new Hospede();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				hospede.setId(rs.getInt("id"));
				hospede.setNome(rs.getString("nome"));
				hospede.setSobrenome(rs.getString("sobrenome"));
				hospede.setEmail(rs.getString("email"));
			}
			rs.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hospede;

	}

	public static Quarto getQuartoByNum(int num) {
		String sql = " SELECT * FROM quarto WHERE num = ? ";

		Quarto quarto = new Quarto();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, num);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				quarto.setNum(rs.getInt("num"));
			}
			rs.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quarto;
	}

	private static int iniciarQuartosDAO(Quarto quarto) {
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

	public static void iniciarQuartos() {
		Quarto quarto = new Quarto();

		for (int i = 1; i <= 10; i++) {
			quarto.setNum(i);
			iniciarQuartosDAO(quarto);
		}
	}
	
	public static List<Hospede> carregaListaHospedes() {
		HospedeDAO hDAO = new HospedeDAO();
		List<Hospede> hospedes = hDAO.listar();
		return hospedes;
	}
	
	public static List<Reserva> carregaListaReservas() {
		ReservaDAO rDAO = new ReservaDAO();
		List<Reserva> reservas = rDAO.listar();
		return reservas;
	}
	
	public static List<Quarto> carregaListaQuartos() {
		QuartoDAO qDAO = new QuartoDAO();
		List<Quarto> quartos = qDAO.listar();
		return quartos;
	}
	
}
