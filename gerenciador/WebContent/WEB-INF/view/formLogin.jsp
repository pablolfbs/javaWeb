<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="/gerenciador/entrada?acao=login" method="POST">
    	Login: <input type="text" name="login" />
    	Senha: <input type="password" name="senha" />
    	
    	<input type="submit" value="Enviar" />
    </form>
</body>
</html>