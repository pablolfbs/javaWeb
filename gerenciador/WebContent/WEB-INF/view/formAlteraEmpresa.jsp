<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada?acao=alteraEmpresa" var="linkServletAlteraEmpresa" />

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
    <form action="${ linkServletAlteraEmpresa }" method="POST">
    	Nome: <input type="text" name="nome" value="${ empresa.nome }" />
    	<input type="hidden" name="id" value="${ empresa.id }"/>
    	
    	<input type="submit" value="Enviar" />
    </form>
</body>
</html>