package servlets;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controller.Ctrl;
import model.Hospede;
import model.Quarto;
import model.Reserva;

@WebServlet(name = "hospedes", urlPatterns = "/hospedes")
public class ServletHospedes extends HttpServlet {

	private static final long serialVersionUID = 7653668041008639990L;

	Set<Reserva> reservas = null;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String opcao = req.getParameter("opcao");

		String nomeHospede = req.getParameter("nome");
		String cpfHospede = req.getParameter("cpf");
		String emailHospede = req.getParameter("email");
		String quartoHospede = req.getParameter("quarto");
		String dtEntrada = req.getParameter("dtEntrada");
		String dtSaida = req.getParameter("dtSaida");

		switch (opcao) {
		case "validaCadastro":
			String json;
			if (Ctrl.isCadastrado(emailHospede)) {
				json = new Gson().toJson(true);
			} else {
				json = new Gson().toJson(false);
			}

			res.setContentType("application/json");
			res.getOutputStream().write(json.getBytes());
			res.flushBuffer();
			break;

		case "cadastrar":
			if (quartoHospede == null) {
				return;

			} else if (!Ctrl.isCadastrado(emailHospede)) {
				
				Quarto quarto = Ctrl.inserirQuarto(quartoHospede);

				Hospede hospede = Ctrl.inserirHospede(nomeHospede, cpfHospede, emailHospede);

				Reserva reserva = Ctrl.inserirReserva(quarto, hospede, dtEntrada, dtSaida);

				Ctrl.inserir(reserva);

				Ctrl.enviaEmailConfirmacao(quarto, hospede, reserva);

				res.sendRedirect("confirmacao.jsp");

			} else {
				res.sendRedirect("emailduplicado.jsp");
			}
			break;

		case "excluir":
			Ctrl.excluirTodos();

			montarJsonComDtFormatada(res);
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
