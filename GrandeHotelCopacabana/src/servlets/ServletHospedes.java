package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.EnvioEmail;
import model.Hospede;
import model.Quarto;
import model.Reserva;
import model.dao.HospedeDAO;
import model.dao.QuartoDAO;
import model.dao.ReservaDAO;

@WebServlet("/hospedes")
public class ServletHospedes extends HttpServlet {

	private static final long serialVersionUID = 7653668041008639990L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String opcao = req.getParameter("opcao");

		QuartoDAO qDAO = new QuartoDAO();
		ReservaDAO rDAO = new ReservaDAO();
		HospedeDAO hDAO = new HospedeDAO();
		
		if (opcao.equals("cadastrar")) {
			String nomeHospede = req.getParameter("nome");
			String emailHospede = req.getParameter("email");
			String quartoHospede = req.getParameter("quarto");
			
			if (quartoHospede == null) {
				return;
			}

			Quarto quarto = new Quarto();
			quarto.setNum(Integer.parseInt(quartoHospede));

			qDAO.excluir(quarto.getNum());

			Hospede hospede = new Hospede();
			hospede.setNome(nomeHospede);
			hospede.setEmail(emailHospede);

			hospede.setId(hDAO.inserir(hospede));

			String dtEntrada = req.getParameter("dtEntrada");
			String dtSaida = req.getParameter("dtSaida");

			Reserva reserva = new Reserva();
			reserva.setHospede(hospede);
			reserva.setQuarto(quarto.getNum());

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				reserva.setDtEntrada(dtEntrada == null || dtEntrada.equals("") ? new Date() : sdf.parse(dtEntrada));
				reserva.setDtSaida(dtSaida == null || dtSaida.equals("") ? new Date() : sdf.parse(dtSaida));

			} catch (ParseException e) {
				e.printStackTrace();
			}

			rDAO.inserir(reserva);

//			EnvioEmail.send(hospede.getEmail(),
//					"Sr(a). " + hospede.getNome() + ", sua reserva para o dia " + reserva.getDtEntradaFormatada()
//							+ ", no quarto " + quarto.getNum() + " foi efetuada com sucesso.");

			res.sendRedirect("confirmacao.jsp");

		} else if (opcao.equals("excluir")) {
			qDAO.excluirTodos();
			rDAO.excluirTodos();
			hDAO.excluirTodos();

			res.sendRedirect("exclusao.jsp");
		}
	}
}
