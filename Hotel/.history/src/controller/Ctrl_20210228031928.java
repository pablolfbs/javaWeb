package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import exception.MockException;
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
import util.NomeIO;

public class Ctrl {

	private static QuartoDAO qDAO = new QuartoDAO();
	private static ReservaDAO rDAO = new ReservaDAO();
	private static HospedeDAO hDAO = new HospedeDAO();
	private static UsuarioDAO uDAO = new UsuarioDAO();

	private Ctrl() {
		
	}
	
	public static Hospede buscarHospedePorId(Integer id) {
		return hDAO.buscarPorId(id);
	}

	public static Collection<Reserva> buscarReservaPorNomeHospede(String nome) {
		return rDAO.buscarPorNomeHospede(nome);
	}

	public static Collection<Reserva> buscarReservaPorEmailHospede(String nome) {
		return rDAO.buscarPorEmailHospede(nome);
	}

	public static Set<Hospede> carregaListaHospedes() {
		return hDAO.listar();
	}

	public static Collection<Reserva> carregaListaReservas() {
		return rDAO.listar();
	}
	
	public static Usuario registraUsuario(String email, String password) {
		return uDAO.inserir(new Usuario(email, password));
	}

	public static List<Quarto> carregaListaQuartos() {
		Collection<Quarto> lista = qDAO.listar();
		List<Quarto> quartos = new ArrayList<>();

		for (QuartoEnum quartoEnum : QuartoEnum.values()) {
			Quarto q = new Quarto(quartoEnum.getNum());
			if (!lista.contains(q))
				quartos.add(q);
		}
		return quartos;
	}

	public static boolean isCadastrado(String email) {
		Collection<Reserva> reservas = carregaListaReservas();
		Set<String> strList = new HashSet<>();

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

	public static Collection<Reserva> ordenarReserva(String param) {
		return rDAO.ordenarReserva(Ctrl.getParam(param));
	}

	public static Collection<Reserva> ordenarReservaHospede(String param) {
		return rDAO.ordenarReservaPorHospede(Ctrl.getParam(param));
	}

	public static Collection<Reserva> buscarReservaPorNomeOrdenada(String param, String nome) {
		return rDAO.buscarReservaPorNomeOrdenada(Ctrl.getParam(param), nome);
	}

	public static Collection<Reserva> buscarReservaPorNomeOrdenadaHospede(String param, String nome) {
		return rDAO.buscarReservaPorNomeOrdenadaPorHospede(Ctrl.getParam(param), nome);
	}
	
	public static Usuario validaUsuario(String email, String senha) {
		return uDAO.validate(email, senha);
	}

	// Mockar reservas
	public static boolean mockar() {
		if (Ctrl.carregaListaReservas().size() < QuartoEnum.values().length) {
			mock();

			return true;
		} else {
			return false;
		}
	}
	
	public static boolean mockAll() {
		if (Ctrl.carregaListaReservas().size() < QuartoEnum.values().length) {
			Collection<Quarto> quartos = Ctrl.carregaListaQuartos();
			quartos.forEach(q -> mock());
			
			return true;
		} else {
			return false;
		}
	}

	private static void mock() {
		int idHospede = mockHospede();
		Quarto quarto = mockQuarto();
		mockReserva(idHospede, quarto);
	}

	private static void mockReserva(int idHospede, Quarto quarto) {
		Ctrl.inserirReserva(new Reserva(quarto.getNum(), new Hospede(idHospede), new Date(), new Date()));
	}

	private static Quarto mockQuarto() {
		List<Quarto> quartos = Ctrl.carregaListaQuartos();
		Quarto q = new Quarto(quartos.get(0).getNum());
		
		if (quartos.contains(q)) {
			return qDAO.inserir(q);
		}
		throw new MockException("Erro ao mockar quarto!");
	}

	private static int mockHospede() {
		Collection<String> nomes = NomeIO.lerArquivo();
		List<String> listaNomes = new ArrayList<>(nomes);
		
		Set<Hospede> hospedes = hDAO.listar();
		Set<String> setNomes = hospedes.stream().map(Hospede::getNome).collect(Collectors.toSet());

		String nome = null;
		String email = null;
		String cpf = GeraCpfCnpj.cpf(false);
		
		for (int i = 0; i < listaNomes.size(); i++) {
			if (!setNomes.contains(listaNomes.get(i))) {
				nome = listaNomes.get(i);
				email = listaNomes.get(i).toLowerCase() + "@" + listaNomes.get(i).toLowerCase() + ".com";

				return hDAO.inserir(new Hospede(nome, cpf, email));
			}
		}
		throw new MockException("Erro ao mockar hospede!");
	}
	// Fim do mock.

	public static void usuarioExiste(String email) {
		uDAO.findByEmail(email);
	}

}
