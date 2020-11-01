package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {

	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		Date hrExecucao = new Date();

		long antes = System.currentTimeMillis();
		String acao = request.getParameter("acao");

		chain.doFilter(request, response);

		long depois = System.currentTimeMillis();
		System.out.println("Hora da execução -> " + sdf.format(hrExecucao) + " | Tempo de execução da ação " + acao
				+ " -> " + (depois - antes));
	}

	@Override
	public void destroy() {

	}

}
