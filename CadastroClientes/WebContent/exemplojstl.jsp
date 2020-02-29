<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- JSP Standard Tag Library --%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="a" value="0"/>
	
	<%-- Expression Language --%>
	<c:if test="${a == 1}">
		Escrevo alguma coisa.
	</c:if>
	
	
	<c:set var="i" value="173"/>
	
	<c:choose>
		<c:when test="${i == 50}">
			O i é cinquenta.
		</c:when>
		<c:when test="${i == 15}">
			O i é quinze.
		</c:when>
		<c:otherwise>
			O i é outra coisa.
		</c:otherwise>
	</c:choose>
	
	<br>
	
	<%-- for(int k = 0; k <= 10; k++) --%>
	<c:forEach var="k" begin="0" end="10" step="1">
		<div style="font-size: 40px;">${k} </div><br>		
	</c:forEach>
	
</body>
</html>