<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="model.Reserva" %>
<%@ page import="model.Hospede" %>
<%@ page import="model.Quarto" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% ArrayList<Reserva> lista = (ArrayList<Reserva>) session.getAttribute("listaReserva"); %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Listar Reserva</title>
	</head>
		
	<body>

		<% for(Reserva r : lista){ %>
			<%= "Numero do Quarto:" + r.getQuarto().getNumero() %> <br/>
			<%= "Nome do Hospede:" + r.getHospede().getNome() %> <br/>
		<% } %>
	
	</body>
</html>