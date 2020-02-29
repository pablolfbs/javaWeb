package teste;

import model.Hospede;
import model.Quarto;
import model.dao.HospedeDAO;
import model.dao.QuartoDAO;

public class Main {

	public static void main(String[] args) {
		
		Hospede h = new Hospede();
		HospedeDAO hd = new HospedeDAO();
		
		QuartoDAO qd = new QuartoDAO();
		Quarto q = new Quarto();
		
		q.setNumero(14);
		qd.inserir(q);
		
//		h.setCpf("16114840739");
//		h.setNome("Danilo");
//		h.setId(95);
//		
//		hd.inserir(h);
		
		
	}
}
