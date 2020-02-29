<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%--
<%@ page import="model.Cliente" %>
<%@ page import="java.util.ArrayList" %>
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%--
<% ArrayList<Cliente> lista = (ArrayList<Cliente>)session.getAttribute("listaCli"); %>
--%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clientes Cadastrados</title>

<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

</head>
<body>

	<%--
		<% for(Cliente c : lista) { %>
			<%= c.getNome() %>
		<% } %>
	--%>

	<%-- for(Cliente c : lista) --%>

	<c:forEach var="cliente" items="${sessionScope.listaCli}">

		<div class="container" style="margin-top: 50px;">
			<div class="row">
				<c:out value="${cliente.nome} - ${cliente.cpf}" />
			</div>
		</div>

	</c:forEach>

	<%--
	String[] vetor = {"", "", ""}
	<c:set var="lista" value="${[]}" />
	<c:set var="vetor" value="${{}}" />
	--%>
</body>
</html>
