import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

import br.senac.rj.model.Pessoa;
import br.senac.rj.service.CadastroService;

public class ServiceClient {

	public static void main(String[] args) throws Exception {

		URL url = new URL("http://localhost:9905/CadastroService?wsdl");

		QName qname = new QName("http://service.rj.senac.br/", "CadastroServiceImplService");

		Service service = Service.create(url, qname);

		QName portName = new QName("http://service.rj.senac.br/", "CadastroServiceImplPort");

		CadastroService cs = service.getPort(portName, CadastroService.class);

		// Pessoa p = new Pessoa();
		// p.setId(7);
		// p.setNome("Mariazin");

		// System.out.println(cs.addPessoa(p));

		Pessoa p = cs.getPessoa(7);
		System.out.println(p.getNome());

	}

}