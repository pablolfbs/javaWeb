<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page import="java.util.List, br.com.alura.gerenciador.model.Empresa" %> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
	Usuario Logado: ${ usuarioLogado.login }
	<br><br>

	Lista de empresas: <br>
	
	<ul>
		<c:forEach items="${ empresas }" var="empresa">
			<li>
				${ empresa.nome } 
				<a href="/gerenciador/entrada?acao=mostraEmpresa&id=${ empresa.id }">edita</a>
				<a href="/gerenciador/entrada?acao=removeEmpresa&id=${ empresa.id }">remove</a>
			</li>
		</c:forEach>
	</ul>
	<%-- <ul>
	<%
		List<Empresa> empresas = (List<Empresa>) request.getAttribute("empresas");
		for (Empresa empresa : empresas) {
	%>
	<li><%= empresa.getNome() %></li>
	<%
		}
	%>
	</ul> --%>
</body>
</html>
