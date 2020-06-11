package teste;

import java.util.Collection;

import model.Reserva;
import model.dao.ReservaDAO;

public class Teste {

	public static void main(String[] args) {
		
//		Hospede h = new Hospede();
//		h.setNome("FAR");
//		
//		HospedeDAO hDAO = new HospedeDAO();
//		List<Hospede> hospedes = hDAO.buscarPorNome(h);
//		
//		for (Hospede hospede : hospedes) {
//			System.out.println(hospede.getNome());
//		}
		
//		Random rand = new Random();
//		for (int i = 0; i < 100; i++) {
//			int a = rand.nextInt(30);
//			System.out.println(a + 1);
//		}

//		int[] numQuarto = new int[5];
//		int num;
//		List<Quarto> quartos = new ArrayList<Quarto>();
//		Quarto quarto = new Quarto();
//
//		Random rand = new Random();
//		
//		for (int i = 0; i < 5; i++) {
//			quarto = new Quarto();
//			num = rand.nextInt(5);
//			numQuarto[i] = num;
//			quarto.setNum(num);
//			quartos.add(quarto);
//			if (quarto != null) {
//				if (num != quartos.get(i).getNum()) {
//					quarto = new Quarto();
//					num = rand.nextInt(5);
//					numQuarto[i] = num;
//					quarto.setNum(num);
//					quartos.add(quarto);
//				} else {
//					continue;
//				}
//				
//			}
//			System.out.println(quarto.getNum());
//		}
		
//		Date data = new Date();
//		System.out.println(data);
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		System.out.println(sdf.format(data));
//		
//		try {
//			Date data1 = sdf.parse(sdf.format(data));
//			System.out.println(data1);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		/*
		 * Quarto q = new Quarto(); List<Quarto> qs = new ArrayList<Quarto>();
		 * qs.add(q);
		 * 
		 * if (qs.contains(q)) { System.out.println("Contém"); } else {
		 * System.out.println("Não contém"); }
		 */
		
		/*
		 * List<Integer> nums = new ArrayList<>();
		 * 
		 * Random rand = new Random(); int n = 0; int count = 0;
		 * 
		 * for (int i = 0; i < 10; i++) { n = rand.nextInt(50); if (!nums.contains(n)) {
		 * nums.add(n); } else { nums.add(n); nums.add(n); } } System.out.println(nums);
		 * System.out.println("Números repetidos: " + count);
		 */
		
		/*
		 * String a = null; String teste = a != null ? "a1" : "a2";
		 * 
		 * System.out.println(a); System.out.println(teste);
		 */
		
//		ReservaDAO rDAO = new ReservaDAO();
//		Collection<? extends Reserva> reservas = rDAO.listar();
//		
//		for (Reserva r : reservas) {
//			System.out.println(r.getHospede().getNome());
//			System.out.println(r.getDtEntrada());
//			System.out.println(r.getDtEntradaFormatada() + "\n");
//		}
		
//			ReservaDAO rDAO = new ReservaDAO();
//			Collection<? extends Reserva> reservas = rDAO.buscarPorNomeHospede("");
//			reservas.forEach(r -> System.out.println(r.getHospede().getNome()));
		
//		ListaQuartos[] values = ListaQuartos.values();
//		for (int i = 0; i < values.length; i++) {
//			System.out.println(values[i]);
//		}
		
		String texto = "pablo luiz faria britto de souza";
		int index = 0;
		int indexAnterior = 0;
		System.out.println("O texto tem " + texto.length() + " caracteres.");
//		while (index >= 0) {
//			if (index > 0) {
//				System.out.println(texto.substring(indexAnterior, index));
//				indexAnterior = index + 1;
//			}
//			index = texto.indexOf(" ", index + 1);
//			if (index == -1) {
//				System.out.println(texto.substring(indexAnterior));
//			}
//		}
		while (index >= 0) {
			if (index > 0) {
				System.out.println(texto.substring(indexAnterior, indexAnterior + 1).toUpperCase().concat(texto.substring(indexAnterior + 1, index)));
				indexAnterior = index + 1;
			}
			index = texto.indexOf(" ", index + 1);
			if (index == -1) {
				System.out.println(texto.substring(indexAnterior, indexAnterior + 1).toUpperCase().concat(texto.substring(indexAnterior + 1)));
			}
		}
	}
	
	private enum ListaQuartos {
		
		UM(1), DOIS(2), TRES(3), QUATRO(4), CINCO(5), SEIS(6), SETE(7), OITO(8), NOVE(9), DEZ(10),
		ONZE(11), DOZE(12), TREZE(13), QUATORZE(14), QUINZE(15), DEZESSEIS(16), DEZESETE(17), DEZOITO(18), DEZENOVE(19), VINTE(20),
		VINTEEUM(21), VINTEEDOIS(22), VINTEETRES(23), VINTEEQUATRO(24), VINTEECINCO(25);

		
		private Integer num;
		
		ListaQuartos(Integer num) {
			this.num = num;
		}
		
		public Integer getNum() {
			return num;
		}
		
		public void setNum(Integer num) {
			this.num = num;
		}
	}

}
