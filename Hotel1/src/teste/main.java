package teste;

import dao.HospedeDao;
import model.Hospede;

public class main {

	public static void main(String[] args) {
		
		Hospede h = new Hospede();
		
		h.setCpf("123456789");
		h.setNome("Romario");
		
		HospedeDao hd = new HospedeDao();
		
		hd.inserir(h);
		
	}
}
