package util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import controller.Ctrl;
import model.Reserva;

public class GeneratorPDF {
	public static void main(String[] args) {
		try {
			Document document = new Document();
			document.setPageSize(PageSize.A3);
			PdfWriter.getInstance(document, new FileOutputStream("C:\\pdf\\PDF_DevMedia.pdf"));
			
			// Abre documento
			document.open();
			
			PdfPTable table = ControllerTable.criarCabecalho();
			
			Collection<? extends Reserva> reservas = Ctrl.carregaListaReservas();
			
			reservas.forEach(r -> {
				r.getId();
				r.getHospede().getNome();
				r.getHospede().getCpf();
				r.getQuarto().toString();
				r.getHospede().getEmail();
				r.getDtEntrada();
				r.getDtSaida();
			});
			
			ControllerTable.preencherDados(document, table, reservas);
			
			// Encerra documento
			document.close();
			
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
	}
}