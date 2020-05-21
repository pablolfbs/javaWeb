package util;

import java.util.Collection;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import model.Reserva;

public class ControllerTable {
	
	public static PdfPTable criarCabecalho()
			throws DocumentException {
		PdfPTable table = new PdfPTable(new float[] { 2f, 5f, 7f, 4f, 10f, 4f, 4f });
		
		PdfPCell celulaId = new PdfPCell(new Phrase("#"));
		celulaId.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell celulaNome = new PdfPCell(new Phrase("Nome"));
		celulaNome.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell celulaCpf = new PdfPCell(new Phrase("CPF"));
		celulaCpf.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell celulaQuarto = new PdfPCell(new Phrase("Quarto"));
		celulaQuarto.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell celulaEmail = new PdfPCell(new Phrase("E-mail"));
		celulaEmail.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell celulaDtEntrada = new PdfPCell(new Phrase("Entrada"));
		celulaDtEntrada.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell celulaDtSaida = new PdfPCell(new Phrase("Saída"));
		celulaDtSaida.setHorizontalAlignment(Element.ALIGN_CENTER);
		

		table.addCell(celulaId);
		table.addCell(celulaNome);
		table.addCell(celulaCpf);
		table.addCell(celulaQuarto);
		table.addCell(celulaEmail);
		table.addCell(celulaDtEntrada);
		table.addCell(celulaDtSaida);
		
		return table;
	}

	public static void preencherDados(Document document, PdfPTable table,
			Collection<? extends Reserva> reservas) throws DocumentException {
		if (document.isOpen()) {
			for (Reserva reserva : reservas) {
				PdfPCell celula1 = new PdfPCell(new Phrase(Integer.valueOf(reserva.getId()).toString()));
				PdfPCell celula2 = new PdfPCell(new Phrase(reserva.getHospede().getNome()));
				PdfPCell celula3 = new PdfPCell(new Phrase(reserva.getHospede().getCpf()));
				PdfPCell celula4 = new PdfPCell(new Phrase(reserva.getQuarto().toString()));
				PdfPCell celula5 = new PdfPCell(new Phrase(reserva.getHospede().getEmail()));
				PdfPCell celula6 = new PdfPCell(new Phrase(reserva.getDtEntradaFormatada()));
				PdfPCell celula7 = new PdfPCell(new Phrase(reserva.getDtSaidaFormatada()));

				table.addCell(celula1);
				table.addCell(celula2);
				table.addCell(celula3);
				table.addCell(celula4);
				table.addCell(celula5);
				table.addCell(celula6);
				table.addCell(celula7);
			}
			document.add(table);
		}
	}
}