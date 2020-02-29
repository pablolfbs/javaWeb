package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cliente;

@WebServlet("/clientes")
public class ServletClientes extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8976026478628987344L;
	
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String opcao = req.getParameter("opcao");
		
		HttpSession secao = req.getSession();
		
		if (opcao.equals("Cadastrar")) {
			
			String nomeCli = req.getParameter("nome");
			String cpfCli = req.getParameter("cpf");
			
			Cliente cliente = new Cliente();
			cliente.setNome(nomeCli);
			cliente.setCpf(cpfCli);
			
			clientes.add(cliente);
			
			res.sendRedirect("confirmacao.html");
			
		} else if(opcao.equals("Listar")) {
			
			secao.setAttribute("listaCli", clientes);
			res.sendRedirect("listacontatos.jsp");
			
			/*
			PrintWriter out = res.getWriter();
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>");
			out.println("Lista de Clientes");
			out.println("</title>");
			out.println("</head>");
			out.println("<body>");
			
			for (Cliente cliente : clientes) {
				out.println(cliente.getNome() + "<br>");
				out.println(cliente.getCpf() + "<br><br>");
			}
			
			out.println("</body>");
			out.println("</html>");
			*/
			
		}
		
	}

}
