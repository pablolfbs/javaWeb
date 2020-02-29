package br.com.hightechcursos.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.hightechcursos.entidades.Usuario;
import br.com.hightechcursos.jdbc.UsuarioDAO;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/usucontroller.do")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("Chamando método get");
//		String nome = request.getParameter("nome");
//		System.out.println("Nome: " + nome);
//		String empresa = request.getParameter("empresa");
//		System.out.println("Empresa: " + empresa);
//		
//		PrintWriter saida = response.getWriter();
//		saida.println("Nome: " + nome + " Empresa: " + empresa);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> usuarios = usuarioDAO.buscarTodos();
		
		request.setAttribute("lista", usuarios);
		
		RequestDispatcher saida = request.getRequestDispatcher("listausuarios.jsp");
		saida.forward(request, response);
		
//		String htmlSaida = "<html> <body> <table border='1'>"
//				+ "<tr> <td>Id</td> <td>Nome</td> <td>Login</td> <td>Senha</td> </tr>";
//		
//		for (Usuario usuario : usuarios) {
//			htmlSaida += "<tr> <td>" + usuario.getId() + "</td> <td>" + usuario.getNome() + "</td>"
//					+ "<td>" + usuario.getLogin() + "</td> <td>" + usuario.getSenha() + "</td> </tr>";
//		}
//		
//		htmlSaida += "</table> </body> </html>";
//		
//		PrintWriter saida = response.getWriter();
//		saida.println(htmlSaida);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando método post");
		
		String id = request.getParameter("txtid");
		String nome = request.getParameter("txtnome");
		String login = request.getParameter("txtlogin");
		String senha = request.getParameter("txtsenha");
		
		Usuario usuario = new Usuario();
		if (id != "") {
			usuario.setId(Integer.parseInt(id));
		}
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
		
		PrintWriter saida = response.getWriter();
		saida.println("Salvo com sucesso");
	}

}
