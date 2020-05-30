package servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
		String param = request.getParameter("param");
		
		RequestDispatcher rd;
		
		switch (opcao) {
		case "exportarPdf":
//			if (param != null) {
//				try {
//					Document document = new Document();
//					document.setPageSize(PageSize.A3);
//					PdfWriter.getInstance(document, new FileOutputStream("C:\\pdf\\listadereservas " + 
//								new SimpleDateFormat("dd-MM-yyyy HHmmss").format(new Date()) + ".pdf"));
//					
//					// Abre documento
//					document.open();
//					
//					PdfPTable table = ControllerTable.criarCabecalho();
//					
//					reservas = Ctrl.buscarReservaPorNomeHospede(param);
//					
//					ControllerTable.preencherDados(document, table, reservas);
//					
//					// Encerra documento
//					document.close();
//					
//					montarJsonComDtFormatada(response);
//					
//				} catch (DocumentException de) {
//					System.err.println(de.getMessage());
//				} catch (IOException ioe) {
//					System.err.println(ioe.getMessage());
//				}
//			} else {
//				throw new NullPointerException("O parâmetro de pesquisa para exportação do pdf não pode ser nulo.");
//			}
			break;
			
		case "excluirLinha":
//			String hospedeId = request.getParameter("hospedeId");
//			String quartoNum = request.getParameter("quartoNum");
//
//			Hospede hospede = Ctrl.buscarHospedePorId(Integer.parseInt(hospedeId));
//			
//			Quarto quarto = new Quarto();
//			quarto.setNum(Integer.parseInt(quartoNum));
//			
//			Ctrl.excluiLinha(hospedeId, quarto);
//
//			quartos.addAll(Ctrl.carregaListaQuartos());
//			secao.setAttribute("listaQuartos", quartos);
//			
//			reservas = Ctrl.carregaListaReservas();
//			secao.setAttribute("listaHospedes", reservas);
//			
//			Ctrl.enviaEmailExclusaoReserva(hospede, quarto);
//
//			rd = getServletContext().getRequestDispatcher("/WEB-INF/listareservas.jsp");
//			rd.forward(request, response);
			break;
			
		case "listar":
//			reservas = Ctrl.carregaListaReservas();
//
//			secao.setAttribute("listaHospedes", reservas);
//			
//			rd = getServletContext().getRequestDispatcher("/WEB-INF/listareservas.jsp");
//			rd.forward(request, response);
			break;
			
		case "pesquisarPorNome":
//			if (param.length() > 1 || param.isEmpty()) {
//				reservas = Ctrl.buscarReservaPorNomeHospede(param);
//				
//				montarJsonComDtFormatada(response);
//			}
			break;
			
		case "ordenarPorId":
			if (!param.isEmpty()) {
				reservas = Ctrl.buscarReservaPorNomeOrdenadaHospede(opcao, param);
			} else {
				reservas = Ctrl.ordenarReservaHospede(opcao);
			}
			montarJsonComDtFormatada(response);
			break;
			
		case "ordenarPorNome":
			if (!param.isEmpty()) {
				reservas = Ctrl.buscarReservaPorNomeOrdenadaHospede(opcao, param);
			} else {
				reservas = Ctrl.ordenarReservaHospede(opcao);
			}
			montarJsonComDtFormatada(response);
			break;
			
		case "ordenarPorCpf":
			if (!param.isEmpty()) {
				reservas = Ctrl.buscarReservaPorNomeOrdenadaHospede(opcao, param);
			} else {
				reservas = Ctrl.ordenarReservaHospede(opcao);
			}
			montarJsonComDtFormatada(response);
			break;
			
		case "ordenarPorQuarto":
			if (!param.isEmpty()) {
				reservas = Ctrl.buscarReservaPorNomeOrdenada(opcao, param);
			} else {
				reservas = Ctrl.ordenarReserva(opcao);
			}
			montarJsonComDtFormatada(response);
			break;
			
		case "ordenarPorEmail":
			if (!param.isEmpty()) {
				reservas = Ctrl.buscarReservaPorNomeOrdenadaHospede(opcao, param);
			} else {
				reservas = Ctrl.ordenarReservaHospede(opcao);
			}
			montarJsonComDtFormatada(response);
			break;
			
		case "ordenarPorDtEntrada":
			if (!param.isEmpty()) {
				reservas = Ctrl.buscarReservaPorNomeOrdenada(opcao, param);
			} else {
				reservas = Ctrl.ordenarReserva(opcao);
			}
			montarJsonComDtFormatada(response);
			break;
		
		case "ordenarPorDtSaida":
			if (!param.isEmpty()) {
				reservas = Ctrl.buscarReservaPorNomeOrdenada(opcao, param);
			} else {
				reservas = Ctrl.ordenarReserva(opcao);
			}
			montarJsonComDtFormatada(response);
			break;
		}
	}

	private void montarJsonComDtFormatada(HttpServletResponse response) throws IOException {
		Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();
		String json = gson.toJson(reservas);
		
		response.setContentType("application/json");
		response.getOutputStream().write(json.getBytes(StandardCharsets.UTF_8));
		response.flushBuffer();
	}
}
