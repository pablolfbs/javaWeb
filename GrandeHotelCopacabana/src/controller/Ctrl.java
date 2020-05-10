package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
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

	public static void iniciarListaQuartos() {
		qDAO.iniciarQuartos();
	}

	public static Collection<? extends Reserva> buscarReservaPorNomeHospede(String nome) {
		return rDAO.buscarPorNomeHospede(nome);
	}

	public static Set<Hospede> carregaListaHospedes() {
		return hDAO.listar();
	}

	public static Collection<? extends Reserva> carregaListaReservas() {
		return rDAO.listar();
	}

	public static Set<Quarto> carregaListaQuartos() {
		return qDAO.listar();
	}
	
	public static boolean isCadastrado(String email) {
		Collection<? extends Reserva> r = rDAO.listar();
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

	public static Collection<? extends Reserva> ordenarReservaPorNomeHospede() {
		return rDAO.ordenarReservaPorNome();
	}

	public static Collection<? extends Reserva> ordenarReservaPorIdHospede() {
		return rDAO.ordenarReservaPorId();
	}

	public static Collection<? extends Reserva> ordenarReservaPorCpfHospede() {
		return rDAO.ordenarReservaPorCpf();
	}

	public static Collection<? extends Reserva> ordenarReservaPorQuarto() {
		return rDAO.ordenarReservaPorQuarto();
	}

	public static Collection<? extends Reserva> ordenarReservaPorEmailHospede() {
		return rDAO.ordenarReservaPorEmail();
	}
	
	public static Collection<? extends Reserva> ordenarReservaPorDtEntrada() {
		return rDAO.ordenarReservaPorDtEntrada();
	}
	
	public static Collection<? extends Reserva> ordenarReservaPorDtSaida() {
		return rDAO.ordenarReservaPorDtSaida();
	}

	public static Collection<? extends Reserva> buscarReservaPorNomeOrdenadaPorId(String nome) {
		return rDAO.buscarReservaPorNomeOrdenadaPorId(nome);
	}

	public static Collection<? extends Reserva> buscarReservaPorNomeOrdenadaPorNome(String nome) {
		return rDAO.buscarReservaPorNomeOrdenadaPorNome(nome);
	}

	public static Collection<? extends Reserva> buscarReservaPorNomeOrdenadaPorCpf(String nome) {
		return rDAO.buscarReservaPorNomeOrdenadaPorCpf(nome);
	}

	public static Collection<? extends Reserva> buscarReservaPorNomeOrdenadaPorQuarto(String nome) {
		return rDAO.buscarReservaPorNomeOrdenadaPorQuarto(nome);
	}

	public static Collection<? extends Reserva> buscarReservaPorNomeOrdenadaPorEmail(String nome) {
		return rDAO.buscarReservaPorNomeOrdenadaPorEmail(nome);
	}

	public static Collection<? extends Reserva> buscarReservaPorNomeOrdenadaPorDtEntrada(String nome) {
		return rDAO.buscarReservaPorNomeOrdenadaPorDtEntrada(nome);
	}

	public static Collection<? extends Reserva> buscarReservaPorNomeOrdenadaPorDtSaida(String nome) {
		return rDAO.buscarReservaPorNomeOrdenadaPorDtSaida(nome);
	}

}
