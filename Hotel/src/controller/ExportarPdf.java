package controller;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.Reserva;
import util.ControllerTable;
import util.Propriedades;

public class ExportarPdf implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("param");
		
		Properties props = Propriedades.getProp();
		
		String json = null;
		if (param != null) {
			try {
				File diretorio = new File(props.getProperty("prop.pathname"));
				if (!diretorio.exists())
					diretorio.mkdir();
	            
				Document document = new Document();
				
				File file = new File(props.getProperty("prop.pathname") + "\\listadereservas" + 
						new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date()) + ".pdf");
				
				document.setPageSize(PageSize.A3);
				PdfWriter.getInstance(document, new FileOutputStream(file));
				
				// Abre documento
				document.open();
				
				PdfPTable table = ControllerTable.criarCabecalho();
				
				Collection<? extends Reserva> reservas = Ctrl.buscarReservaPorNomeHospede(param);
				
				ControllerTable.preencherDados(document, table, reservas);
				
				// Encerra documento
				document.close();
				
				// Abre pasta do arquivo
				Desktop desktop = Desktop.getDesktop();
				desktop.open(diretorio);
				
				Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
				json = gson.toJson(reservas);
				
				response.setContentType("application/json");
				response.getOutputStream().write(json.getBytes(StandardCharsets.UTF_8));
				response.flushBuffer();
				
			} catch (DocumentException de) {
				System.err.println(de.getMessage());
			} catch (IOException ioe) {
				System.err.println(ioe.getMessage());
			}
		} else {
			throw new NullPointerException("O par�metro de pesquisa para exporta��o do pdf n�o pode ser nulo.");
		}
		return json;
	}

}
