<%@page import="br.com.hightechcursos.entidades.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr bgcolor="#CCCCCC">
			<th>ID</th> <th>Nome</th> <th>Login</th> <th>Senha</th>
		</tr>
		
		<%
		List<Usuario> usuarios = (List<Usuario>) request.getAttribute("lista");
		for (Usuario usuario : usuarios) {
		%>
		<tr>
			<td><%= usuario.getId() %></td>
			<td><%= usuario.getNome() %></td>
			<td><%= usuario.getLogin() %></td>
			<td><%= usuario.getSenha() %></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>