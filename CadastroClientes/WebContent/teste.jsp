<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teste do JSP</title>
</head>
<body>

	<%-- 
	
		<% %>   --> scriptlet, onde escrevemos java puro.
		<%@ %>  --> diretiva, onde "configuramos" o JSP.
		<%= %>  --> espressão, onde produzimos saídas pro user.
		<%! %>  --> declaração, para declarações no escopo da classe.		
	
	 --%>
	
	<% String str = "Hello JSP!"; %>
	<% out.print(str); %> <br>
	<%= str %> <br>
	
	<% for(int i = 0; i < 10; i++) {
		out.print(i + "<br>"); %>
		<%= i %> <br>
	<% } %>
	
</body>
</html>