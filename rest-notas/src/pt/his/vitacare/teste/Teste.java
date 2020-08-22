package pt.his.vitacare.teste;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Teste {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		StringBuffer xml = new StringBuffer(6000);
		xml.append("<AGENDAMENTO>");
		xml.append("<SOLICITACAO_ID>");
		xml.append("1000");
		xml.append("</SOLICITACAO_ID>");
		xml.append("<DATA>");
		xml.append(sdf.format(new Date()));
		xml.append("</DATA>");
		xml.append("<SOLICITANTE>");
		xml.append("<CRM>");
		xml.append("12345679");
		xml.append("</CRM>");
		xml.append("<NOME>");
		xml.append("Maycon");
		xml.append("</NOME>");
		xml.append("<COD_ESPECIALIDADE>");
		xml.append("01");
		xml.append("</COD_ESPECIALIDADE>");
		xml.append("</SOLICITANTE>");
		xml.append("<PACIENTE>");
		xml.append("<PCT_ID>");
		xml.append("123");
		xml.append("</PCT_ID>");
		xml.append("<MATRICULA>");
		xml.append("m40");
		xml.append("</MATRICULA>");
		xml.append("<CPF>");
		xml.append("1235467890");
		xml.append("</CPF>");
		xml.append("<CARTEIRINHA>");
		xml.append("000111222333");
		xml.append("</CARTEIRINHA>");
		xml.append("</PACIENTE>");
		xml.append("<STATUS_AGENDAMENTO>");
		xml.append("</STATUS_AGENDAMENTO>");
		xml.append("<DATA_EVENTO>");
		xml.append("</DATA_EVENTO>");
		xml.append("</AGENDAMENTO>");

		// NotasService ns = new NotasService();
		// String xml =
		// "<br.edu.devmedia.entidade.Nota><id>1</id><titulo>abc</titulo><descricao>Teste
		// 1</descricao><id>2</id><titulo>ABCD</titulo><descricao>teste2</descricao></br.edu.devmedia.entidade.Nota>";
		// String xml = ns.teste(ns.busca());

		// String xml = null;
		// ns.buscar(xml);

		// Nota json = ns.testeJSON(ns.buscarPorId(1));
		// System.out.println(json.toString());

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);

		InputStream is = new ByteArrayInputStream(xml.toString().getBytes());
		Reader reader = new InputStreamReader(is, "UTF-8");

		InputSource io = new InputSource(reader);
		io.setEncoding("UTF-8");

		Document strXML = dbf.newDocumentBuilder().parse(io);

		String[] array = new String[] { "SOLICITACAO_ID", "DATA", "CRM", "NOME", "COD_ESPECIALIDADE", "PCT_ID",
				"MATRICULA", "CPF", "CARTEIRINHA" };

		for (int i = 0; i < array.length; i++) {
			NodeList node = strXML.getElementsByTagName(array[i]);
			
			Node prop = node.item(0);
			System.out.println(prop.getNodeName());
			
			String property = prop.getTextContent();
			System.out.println(property);
			
			System.out.println("");
		}

//		NodeList solicId = strXML.getElementsByTagName("SOLICITACAO_ID");
//		NodeList data = strXML.getElementsByTagName("DATA");
//		NodeList crm = strXML.getElementsByTagName("CRM");
//		NodeList nome = strXML.getElementsByTagName("NOME");
//		NodeList codEspec = strXML.getElementsByTagName("COD_ESPECIALIDADE");
//		NodeList pacienteId = strXML.getElementsByTagName("PCT_ID");
//		NodeList matricula = strXML.getElementsByTagName("MATRICULA");
//		NodeList cpf = strXML.getElementsByTagName("CPF");
//		NodeList carteirinha = strXML.getElementsByTagName("CARTEIRINHA");
//		
//		Node propSolicId = solicId.item(0);
//		System.out.println(propSolicId.getNodeName());
//		String propertySolicId = propSolicId.getTextContent();
//		System.out.println(propertySolicId);
//		System.out.println("");
//		
//		Node propData = data.item(0);
//		System.out.println(propData.getNodeName());
//		String propertyData = propData.getTextContent();
//		System.out.println(propertyData);
//		System.out.println("");
//		
//		Node propCrm = crm.item(0);
//		System.out.println(propCrm.getNodeName());
//		String propertyCrm = propCrm.getTextContent();
//		System.out.println(propertyCrm);
//		System.out.println("");
//		
//		Node propNome = nome.item(0);
//		System.out.println(propNome.getNodeName());
//		String propertyNome = propNome.getTextContent();
//		System.out.println(propertyNome);
//		System.out.println("");
//		
//		Node propCodEspec = codEspec.item(0);
//		System.out.println(propCodEspec.getNodeName());
//		String propertyCodEspec = propCodEspec.getTextContent();
//		System.out.println(propertyCodEspec);
//		System.out.println("");
//		
//		Node propPacienteId = pacienteId.item(0);
//		System.out.println(propPacienteId.getNodeName());
//		String propertyPacienteId = propPacienteId.getTextContent();
//		System.out.println(propertyPacienteId);
//		System.out.println("");
//		
//		Node propMatricula = matricula.item(0);
//		System.out.println(propMatricula.getNodeName());
//		String propertyMatricula = propMatricula.getTextContent();
//		System.out.println(propertyMatricula);
//		System.out.println("");
//		
//		Node propCpf = cpf.item(0);
//		System.out.println(propCpf.getNodeName());
//		String propertyCpf = propCpf.getTextContent();
//		System.out.println(propertyCpf);
//		System.out.println("");
//
//		Node propCarteirinha = carteirinha.item(0);
//		System.out.println(propCarteirinha.getNodeName());
//		String propertyCarteirinha = propCarteirinha.getTextContent();
//		System.out.println(propertyCarteirinha);
//		System.out.println("");

		System.out.println(xml);

	}

}
