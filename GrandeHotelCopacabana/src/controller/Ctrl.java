package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import model.Hospede;
import model.Quarto;
import model.Reserva;
import model.dao.ConnectionFactory;
import model.dao.HospedeDAO;
import model.dao.QuartoDAO;
import model.dao.ReservaDAO;

public class Ctrl {

	private static Connection connection = ConnectionFactory.getConnection();

	static QuartoDAO qDAO = new QuartoDAO();
	static ReservaDAO rDAO = new ReservaDAO();
	static HospedeDAO hDAO = new HospedeDAO();

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

	public static Set<Reserva> buscarReservaPorNomeHospede(String nome) {
		String sql = " SELECT * FROM reserva r JOIN hospede h WHERE r.id_hospede = h.id AND h.nome LIKE '%" + nome
				+ "%' ";

		Set<Reserva> reservas = new LinkedHashSet<Reserva>();
		try {
			Statement sttm = connection.createStatement();
			ResultSet rs = sttm.executeQuery(sql);
			while (rs.next()) {
				Reserva r = new Reserva();
				r.setId(rs.getInt("id"));
				r.setHospede(Ctrl.getHospedeById(rs.getInt("id_hospede")));
				r.setQuarto(rs.getInt("quarto"));
				r.setDtEntrada(rs.getDate("dtEntrada"));
				r.setDtSaida(rs.getDate("dtSaida"));
				reservas.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reservas;
	}

	public static Set<Hospede> carregaListaHospedes() {
		Set<Hospede> hospedes = hDAO.listar();
		return hospedes;
	}

	public static Set<Reserva> carregaListaReservas() {
		Set<Reserva> reservas = rDAO.listar();
		return reservas;
	}

	public static Set<Quarto> carregaListaQuartos() {
		Set<Quarto> quartos = qDAO.listar();
		return quartos;
	}

	public static boolean verificaEmail(String email) {
		Set<Reserva> r = rDAO.listar();
		List<String> strList = new ArrayList<String>();

		r.forEach(res -> {
			strList.add(res.getHospede().getEmail());
		});

		return strList.contains(email);
	}

	public static Quarto inserirQuarto(String quartoHospede) {
		Quarto quarto = new Quarto();
		quarto.setNum(Integer.parseInt(quartoHospede));
		qDAO.excluir(quarto.getNum());
		return quarto;
	}

	public static Reserva inserirReserva(Quarto quarto, Hospede hospede, String dtEntrada, String dtSaida) {
		Reserva reserva = new Reserva();
		reserva.setHospede(hospede);
		reserva.setQuarto(quarto.getNum());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			reserva.setDtEntrada(dtEntrada == null || dtEntrada.equals("") ? new Date() : sdf.parse(dtEntrada));
			reserva.setDtSaida(dtSaida == null || dtSaida.equals("") ? new Date() : sdf.parse(dtSaida));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return reserva;
	}

	public static Hospede inserirHospede(String nomeHospede, String emailHospede) {
		Hospede hospede = new Hospede();
		hospede.setNome(nomeHospede);
		hospede.setEmail(emailHospede);
		hospede.setId(hDAO.inserir(hospede));
		return hospede;
	}

	public static void excluiLinha(String hospedeId, Quarto quarto) {
		qDAO.inserir(quarto);
		rDAO.excluir(Integer.parseInt(hospedeId));
		hDAO.excluir(Integer.parseInt(hospedeId));
	}

	public static void enviaEmailConfirmacao(Quarto quarto, Hospede hospede, Reserva reserva) {
//		EnvioEmail.send(hospede.getEmail(),
//				"Sr(a). " + hospede.getNome() + ", sua reserva para o dia " + reserva.getDtEntradaFormatada()
//						+ ", no quarto " + quarto.getNum() + " foi efetuada com sucesso.");
	}

	public static void enviaEmailExclusaoReserva(Hospede hospede, Quarto quarto) {
//		EnvioEmail.send(hospede.getEmail(), "Sr(a). " + hospede.getNome() + ", sua reserva para o quarto "
//				+ quarto.getNum() + " foi cancelada.");
	}

	public static void excluirTodos() {
		qDAO.excluirTodos();
		rDAO.excluirTodos();
		hDAO.excluirTodos();
	}

	public static Hospede buscarPorHospedePorId(Integer id) {
		return hDAO.buscarPorId(id);
	}

	public static void inserir(Reserva reserva) {
		rDAO.inserir(reserva);
	}

}
