package util;

import java.util.Collection;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import model.Reserva;

public class ControllerTable {
	
	public static PdfPTable criarCabecalho() throws DocumentException {
		
		PdfPTable table = new PdfPTable(new float[] { 3f, 5f, 6f, 3.5f, 10f, 4f, 4f });
		
		Font bold = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
		
		Phrase pId = new Phrase("#", bold);
		PdfPCell celulaId = new PdfPCell(pId);
		celulaId.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		Phrase pNome = new Phrase("NOME", bold);
		PdfPCell celulaNome = new PdfPCell(pNome);
		celulaNome.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		Phrase pCpf = new Phrase("CPF", bold);
		PdfPCell celulaCpf = new PdfPCell(pCpf);
		celulaCpf.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		Phrase pQuarto = new Phrase("QUARTO", bold);
		PdfPCell celulaQuarto = new PdfPCell(pQuarto);
		celulaQuarto.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		Phrase pEmail = new Phrase("E-MAIL", bold);
		PdfPCell celulaEmail = new PdfPCell(pEmail);
		celulaEmail.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		Phrase pDtEntrada = new Phrase("ENTRADA", bold);
		PdfPCell celulaDtEntrada = new PdfPCell(pDtEntrada);
		celulaDtEntrada.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		Phrase pDtSaida = new Phrase("SAÍDA", bold);
		PdfPCell celulaDtSaida = new PdfPCell(pDtSaida);
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
				celula1.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell celula2 = new PdfPCell(new Phrase(reserva.getHospede().getNome()));
				PdfPCell celula3 = new PdfPCell(new Phrase(reserva.getHospede().getCpf()));
				celula3.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell celula4 = new PdfPCell(new Phrase(reserva.getQuarto().toString()));
				celula4.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell celula5 = new PdfPCell(new Phrase(reserva.getHospede().getEmail()));
				PdfPCell celula6 = new PdfPCell(new Phrase(reserva.getDtEntradaFormatada()));
				celula6.setHorizontalAlignment(Element.ALIGN_CENTER);
				PdfPCell celula7 = new PdfPCell(new Phrase(reserva.getDtSaidaFormatada()));
				celula7.setHorizontalAlignment(Element.ALIGN_CENTER);

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