<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Reservas</title>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>

<!--Import Google Icon Font-->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>

<body>
	<div class="container">
		<div class="section center">
			<h1 class="teal-text text-lighten-2">RESERVAS</h1>
		</div>
		<form action="listareservas" method="POST">
			<table class="highlight" id="tabela">
				<thead>
					<tr>
						<th class="col s1 center">#</th>
						<th class="col s2 center">Nome</th>
						<th class="col s2 center">Quarto</th>
						<th class="col s2 center">E-mail</th>
						<th class="col s1 center">Entrada</th>
						<th class="col s1 center">Saída</th>
						<th class="col s1 center">Excluir</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="reserva" items="${listaHospedes}">
						<tr>
							<td class="col s1 center"><input type="text" id="id" name="hospedeId" hidden value="${reserva.hospede.id}" /><c:out value="${reserva.hospede.id}" /></td>
							<td class="col s2"><c:out value="${reserva.hospede.nome}" /></td>
							<td class="col s2 center"><input type="text" id="quarto" name="quartoNum" hidden value="${reserva.quarto}" /><c:out value="${reserva.quarto}" /></td>
							<td class="col s2"><c:out value="${reserva.hospede.email}" /></td>
							<td class="col s1 center"><c:out value="${reserva.dtEntradaFormatada}" /></td>
							<td class="col s1 center"><c:out value="${reserva.dtSaidaFormatada}" /></td>
							<td class="col s1 center">
								<!-- <a href="javascript:hospedes.id.submit()" id="excluir" value="excluirLinha" name="opcao">
								<img border="0" src="img/x.jpg" width="22" height="22"></a> -->
								<button class="btn waves-effect waves-light #e53935 red darken-1" type="submit" id="btExcluir" value="excluirLinha" name="opcao" >
								Excluir <i class="material-icons right ">send</i></button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
		<br><a href="index.jsp">voltar</a>
		
	</div>

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    
    <script>
    	
    $(document).ready(function() {
    	
    	$('#tabela').find('tr').on('click', function() {
    		
    		$('#id').val($(this).find('td:first').text());
    		$('#quarto').val($(this).find('td:eq(2)').text());
    		
    	});
    });
    
    </script>
</body>

</html>