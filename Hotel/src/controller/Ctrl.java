package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
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
import model.enumerador.QuartoEnum;

public class Ctrl {

	static QuartoDAO qDAO = new QuartoDAO();
	static ReservaDAO rDAO = new ReservaDAO();
	static HospedeDAO hDAO = new HospedeDAO();

	public static Hospede buscarHospedePorId(Integer id) {
		return hDAO.buscarPorId(id);
	}

	public static Collection<? extends Quarto> iniciarListaQuartos() {
		Set<Quarto> quartos = new LinkedHashSet<Quarto>();
		
		for (QuartoEnum qEnum : QuartoEnum.values()) {
			quartos.add(new Quarto(qEnum.getNum()));
		}
		return quartos;
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
		Collection<? extends Reserva> reservas = carregaListaReservas();
		Set<String> strList = new HashSet<String>();

		reservas.forEach(r -> strList.add(r.getHospede().getEmail()));

		return strList.contains(email);
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
	
	public static Quarto inserirQuarto(String quartoHospede) {
		return qDAO.inserir(new Quarto(Integer.valueOf(quartoHospede)));
	}

	public static void excluiLinha(String hospedeId, Quarto quarto) {
		qDAO.excluir(quarto.getNum());
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
	
	public static String getParam(String param) {
		int a = param.indexOf("Por");
		return param.substring(a + 3, a + 4).toLowerCase() + param.substring(a + 4);
	}

	public static Collection<? extends Reserva> ordenarReserva(String param) {
		return rDAO.ordenarReserva(Ctrl.getParam(param));
	}

	public static Collection<? extends Reserva> ordenarReservaHospede(String param) {
		return rDAO.ordenarReservaPorHospede(Ctrl.getParam(param));
	}

	public static Collection<? extends Reserva> buscarReservaPorNomeOrdenada(String param, String nome) {
		return rDAO.buscarReservaPorNomeOrdenada(Ctrl.getParam(param), nome);
	}

	public static Collection<? extends Reserva> buscarReservaPorNomeOrdenadaHospede(String param, String nome) {
		return rDAO.buscarReservaPorNomeOrdenadaPorHospede(Ctrl.getParam(param), nome);
	}

}
