package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiroServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		super.service(req, res);
		
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("<Primeiro Servlet>");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("Hello Servlet!!");
		out.println("</body>");
		out.println("</html>");
	}

}
