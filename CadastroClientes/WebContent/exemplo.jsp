<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exemplos de TAG</title>
</head>
<body>
	<jsp:useBean id="cliente" class="model.Cliente" scope="page"/>
	
	<% cliente.setNome("Joana"); %>
	<div style="background: red; font-size: 40px; text-align: center;"><%= cliente.getNome() %></div><br/>
	
	
	<jsp:setProperty property="cpf" name="cliente" value="000.111.222-33"/>
	
	<div style="background: lightblue; font-size: 40px; text-align: center;"><%= cliente.getCpf() %></div><br/>
	
	
	<div style="background: red; font-size: 40px; text-align: center;"> ${cliente.nome} </div><br/>
	<div style="background: lightblue; font-size: 40px; text-align: center;"> ${cliente.cpf} </div>
</body>
</html>