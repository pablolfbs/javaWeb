<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
	
    <form action="/gerenciador/entrada?acao=novaEmpresa" method="POST">
    	Nome: <input type="text" name="nome" />
    	
    	<input type="submit" value="Enviar" />
    </form>
</body>
</html>