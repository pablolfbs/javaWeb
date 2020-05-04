package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import model.Hospede;
import model.Quarto;
import model.Reserva;
import model.dao.HospedeDAO;
import model.dao.QuartoDAO;
import model.dao.ReservaDAO;

public class Ctrl {

	static QuartoDAO qDAO = new QuartoDAO();
	static ReservaDAO rDAO = new ReservaDAO();
	static HospedeDAO hDAO = new HospedeDAO();

	public static Hospede buscarHospedePorId(Integer id) {
		return hDAO.buscarPorId(id);
	}

	private static void iniciarQuartos(LinkedHashSet<Quarto> quartos) {
		qDAO.iniciarQuartos(quartos);
	}

	public static void iniciarListaQuartos() {
		LinkedHashSet<Quarto> quartos = new LinkedHashSet<Quarto>();
		for (int i = 1; i <= 10; i++) {
			Quarto q = new Quarto();
			q.setNum(i);
			quartos.add(q);
		}
		iniciarQuartos(quartos);
	}

	public static Set<Reserva> buscarReservaPorNomeHospede(String nome) {
		return rDAO.buscarPorNomeHospede(nome);
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
		Set<String> strList = new HashSet<String>();

		r.forEach(res -> strList.add(res.getHospede().getEmail()));

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

	public static Hospede inserirHospede(String nome, String cpf, String email) {
		Hospede hospede = new Hospede();
		hospede.setNome(nome);
		hospede.setCpf(cpf);
		hospede.setEmail(email);
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

	public static void inserir(Reserva reserva) {
		rDAO.inserir(reserva);
	}

}
