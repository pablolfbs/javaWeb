package teste;

import model.Hospede;
import model.dao.HospedeDAO;

public class TesteConexao {

	public static void main(String[] args) {
		
		HospedeDAO hDAO = new HospedeDAO();
		Hospede h = new Hospede();
		h.setNome("Ingrid");
		h.setCpf("1234");
		h.setEmail("didilbs@hotmail.com");
		hDAO.inserir(h);
	}

}
