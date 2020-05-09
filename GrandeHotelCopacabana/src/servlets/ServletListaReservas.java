package servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import controller.Ctrl;
import model.Hospede;
import model.Quarto;
import model.Reserva;
import util.ControllerTable;

@WebServlet(name = "listareservas", urlPatterns = { "/listareservas" })
public class ServletListaReservas extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	Collection<? extends Reserva> reservas = null;
	Set<Quarto> quartos = new HashSet<Quarto>();
	Set<Hospede> hospedes = new HashSet<Hospede>();
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession secao = request.getSession();
		
		String opcao = request.getParameter("opcao");
		String nome = request.getParameter("valor");
		
		RequestDispatcher rd;
		
		switch (opcao) {
		case "exportarPdf":
			try {
				Document document = new Document();
				document.setPageSize(PageSize.A3);
				PdfWriter.getInstance(document, new FileOutputStream("C:\\pdf\\listadereservas- " + 
							new SimpleDateFormat("dd-MM-yyyy HHmmss").format(new Date()) + ".pdf"));
				
				// Abre documento
				document.open();
				
				PdfPTable table = ControllerTable.criarCabecalho();
				
				reservas = Ctrl.buscarReservaPorNomeHospede(nome);
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
				
				montarJsonComDtFormatada(response);
				
			} catch (DocumentException de) {
				System.err.println(de.getMessage());
			} catch (IOException ioe) {
				System.err.println(ioe.getMessage());
			}
			break;
			
		case "excluirLinha":
			String hospedeId = request.getParameter("hospedeId");
			String quartoNum = request.getParameter("quartoNum");

			Hospede hospede = Ctrl.buscarHospedePorId(Integer.parseInt(hospedeId));
			
			Quarto quarto = new Quarto();
			quarto.setNum(Integer.parseInt(quartoNum));
			
			Ctrl.excluiLinha(hospedeId, quarto);

			quartos.addAll(Ctrl.carregaListaQuartos());
			secao.setAttribute("listaQuartos", quartos);
			
			reservas = Ctrl.carregaListaReservas();
			secao.setAttribute("listaHospedes", reservas);
			
			Ctrl.enviaEmailExclusaoReserva(hospede, quarto);

			rd = getServletContext().getRequestDispatcher("/WEB-INF/listareservas.jsp");
			rd.forward(request, response);
			break;
			
		case "listar":
			reservas = Ctrl.carregaListaReservas();

			secao.setAttribute("listaHospedes", reservas);
			
			rd = getServletContext().getRequestDispatcher("/WEB-INF/listareservas.jsp");
			rd.forward(request, response);
			break;
			
		case "buscarPorNome":
			if (nome.length() > 1 || nome.isEmpty()) {
				reservas = Ctrl.buscarReservaPorNomeHospede(nome);
				
				montarJsonComDtFormatada(response);
			}
			break;
			
		case "ordenarPorId":
			if (!nome.isEmpty()) {
				reservas = Ctrl.buscarReservaPorNomeOrdenadaPorId(nome);
			} else {
				reservas = Ctrl.ordenarReservaPorIdHospede();
			}
			montarJsonComDtFormatada(response);
			break;
			
		case "ordenarPorNome":
			if (!nome.isEmpty()) {
				reservas = Ctrl.buscarReservaPorNomeOrdenadaPorNome(nome);
			} else {
				reservas = Ctrl.ordenarReservaPorNomeHospede();
			}
			montarJsonComDtFormatada(response);
			break;
			
		case "ordenarPorCpf":
			if (!nome.isEmpty()) {
				reservas = Ctrl.buscarReservaPorNomeOrdenadaPorCpf(nome);
			} else {
				reservas = Ctrl.ordenarReservaPorCpfHospede();
			}
			montarJsonComDtFormatada(response);
			break;
			
		case "ordenarPorQuarto":
			if (!nome.isEmpty()) {
				reservas = Ctrl.buscarReservaPorNomeOrdenadaPorQuarto(nome);
			} else {
				reservas = Ctrl.ordenarReservaPorQuarto();
			}
			montarJsonComDtFormatada(response);
			break;
			
		case "ordenarPorEmail":
			if (!nome.isEmpty()) {
				reservas = Ctrl.buscarReservaPorNomeOrdenadaPorEmail(nome);
			} else {
				reservas = Ctrl.ordenarReservaPorEmailHospede();
			}
			montarJsonComDtFormatada(response);
			break;
			
		case "ordenarPorDtEntrada":
			if (!nome.isEmpty()) {
				reservas = Ctrl.buscarReservaPorNomeOrdenadaPorDtEntrada(nome);
			} else {
				reservas = Ctrl.ordenarReservaPorDtEntrada();
			}
			montarJsonComDtFormatada(response);
			break;
		
		case "ordenarPorDtSaida":
			if (!nome.isEmpty()) {
				reservas = Ctrl.buscarReservaPorNomeOrdenadaPorDtSaida(nome);
			} else {
				reservas = Ctrl.ordenarReservaPorDtSaida();
			}
			montarJsonComDtFormatada(response);
			break;
		}
	}

	private void montarJsonComDtFormatada(HttpServletResponse response) throws IOException {
		Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
		String json = gson.toJson(reservas);
		
		response.setContentType("application/json");
		response.getOutputStream().write(json.getBytes());
		response.flushBuffer();
	}
}
