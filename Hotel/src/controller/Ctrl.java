package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import model.Hospede;
import model.Quarto;
import model.Reserva;
import model.Usuario;
import model.dao.HospedeDAO;
import model.dao.QuartoDAO;
import model.dao.ReservaDAO;
import model.dao.UsuarioDAO;
import model.enumerador.QuartoEnum;
import util.GeraCpfCnpj;

public class Ctrl {

	private static QuartoDAO qDAO = new QuartoDAO();
	private static ReservaDAO rDAO = new ReservaDAO();
	private static HospedeDAO hDAO = new HospedeDAO();
	private static UsuarioDAO uDAO = new UsuarioDAO();

	public static Hospede buscarHospedePorId(Integer id) {
		return hDAO.buscarPorId(id);
	}

	public static Collection<? extends Reserva> buscarReservaPorNomeHospede(String nome) {
		return rDAO.buscarPorNomeHospede(nome);
	}

	public static Collection<? extends Reserva> buscarReservaPorEmailHospede(String nome) {
		return rDAO.buscarPorEmailHospede(nome);
	}

	public static Set<Hospede> carregaListaHospedes() {
		return hDAO.listar();
	}

	public static Collection<? extends Reserva> carregaListaReservas() {
		return rDAO.listar();
	}
	
	public static Usuario registraUsuario(String email, String password) {
		return uDAO.inserir(new Usuario(email, password));
	}

//	public static Collection<? extends Quarto> iniciarListaQuartos() {
//		Set<Quarto> quartos = new LinkedHashSet<Quarto>();
//
//		for (QuartoEnum qEnum : QuartoEnum.values())
//			quartos.add(new Quarto(qEnum.getNum()));
//
//		return quartos;
//	}

	public static Collection<? extends Quarto> carregaListaQuartos() {
		Collection<? extends Quarto> lista = qDAO.listar();
		Set<Quarto> quartos = new LinkedHashSet<Quarto>();

		for (QuartoEnum quartoEnum : QuartoEnum.values()) {
			Quarto q = new Quarto(quartoEnum.getNum());
			if (!lista.contains(q))
				quartos.add(q);
		}
		return quartos;
	}

	public static boolean isCadastrado(String email) {
		Collection<? extends Reserva> reservas = carregaListaReservas();
		Set<String> strList = new HashSet<String>();

		reservas.forEach(r -> strList.add(r.getHospede().getEmail()));

		return strList.contains(email);
	}
	
	public static void inserirReserva(Reserva reserva) {
		rDAO.inserir(reserva);
	}

	public static Reserva montarReserva(Quarto quarto, Hospede hospede, String dtEntrada, String dtSaida) {
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
	
	public static Usuario validaUsuario(String email, String senha) {
		return uDAO.validate(email, senha);
	}

	// Mockar reservas
	public static boolean mockar() {
		if (Ctrl.carregaListaReservas().size() < QuartoEnum.values().length) {
			int idHospede = mockHospede();
			Quarto quarto = mockQuarto();
			mockReserva(idHospede, quarto);

			return true;
		} else {
			return false;
		}
	}

	private static void mockReserva(int idHospede, Quarto quarto) {
		Ctrl.inserirReserva(new Reserva(quarto.getNum(), new Hospede(idHospede), new Date(), new Date()));
	}

	private static Quarto mockQuarto() {
		Collection<? extends Quarto> quartos = Ctrl.carregaListaQuartos();

		Quarto q = new Quarto();
		for (int i = 1; i <= QuartoEnum.values().length; i++) {
			q.setNum(i);
			if (quartos.contains(q)) {
				return qDAO.inserir(q);
			}
		}
		throw new RuntimeException("Erro ao mockar quarto!");
	}

	private static int mockHospede() {
		String[] arrayNome = carregaArrayNomes();
		String[] arrayEmail = carregaArrayEmails();
		
		Set<Hospede> hospedes = hDAO.listar();
		
		Set<String> setEmail = hospedes.stream().map(h -> h.getEmail()).collect(Collectors.toSet());

		String nome = null;
		String email = null;
		String cpf = GeraCpfCnpj.cpf(false);
		
		for (int i = 0; i < arrayEmail.length; i++) {
			if (!setEmail.contains(arrayEmail[i])) {
				nome = arrayNome[i];
				email = arrayEmail[i];

				return hDAO.inserir(new Hospede(nome, cpf, email));
			}
		}
		throw new RuntimeException("Erro ao mockar reserva!");
	}
	// Fim de mock.

	private static String[] carregaArrayEmails() {
		return new String[] { "pablo@pablo.com", "ingrid@ingrid.com", "alice@alice.com", "marcello@marcello.com",
				"nadja@nadja.com", "antonio@antonio.com", "rosa@rosa.com", "vania@vania.com", "romario@romario.com",
				"rodrigo@rodrigo.com" };
	}

	private static String[] carregaArrayNomes() {
		return new String[] { "Pablo", "Ingrid", "Alice", "Marcello", "Nadja", "Antonio Luiz", "Rosa", "Vânia",
				"Romário", "Rodrigo" };
	}

}
