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
			<table id="tabela" class="highlight" id="tabela" hidden>
				<thead>
					<tr>
						<th class="col s1">#</th>
						<th class="col s2">Nome</th>
						<th class="col s2 center">Quarto</th>
						<th class="col s2 center">E-mail</th>
						<th class="col s1">Entrada</th>
						<th class="col s1">Saída</th>
						<th class="col s1">Excluir</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="reserva" items="${listaHospedes}">
						<tr>
							<td class="col s1"><input type="text" id="id" name="hospedeId" hidden value="${reserva.hospede.id}" /><c:out value="${reserva.hospede.id}" /></td>
							<td class="col s2"><c:out value="${reserva.hospede.nome}" /></td>
							<td class="col s2 center"><input type="text" id="quarto" name="quartoNum" hidden value="${reserva.quarto}" /><c:out value="${reserva.quarto}" /></td>
							<td class="col s2 center"><c:out value="${reserva.hospede.email}" /></td>
							<td class="col s1"><c:out value="${reserva.dtEntradaFormatada}" /></td>
							<td class="col s1"><c:out value="${reserva.dtSaidaFormatada}" /></td>
							<td class="col s1">
								<!-- <a href="javascript:hospedes.id.submit()" id="excluir" value="excluirLinha" name="opcao">
								<img border="0" src="img/x.jpg" width="22" height="22"></a> -->
								<button class="btn waves-effect waves-light #e53935 red darken-1" type="submit" id="btExcluir" value="excluirLinha" name="opcao" >
								Excluir <i class="material-icons right ">send</i></button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<h5 class="center" style="color:red" id="listavazia" hidden>A lista de reservas está vazia.</h5>
			<br>
			<div class="input-field col s6" id="busca" hidden>
				<input id="buscarPorNome" type="text" name="opcao" class="validate" >
				<label for="buscarPorNome">Pesquisar por nome</label>
			</div>
		</form>
		<br><a href="index.jsp">voltar</a>
		
	</div>

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    
    <script>
    
    $(document).ready(function() {
    	
    	var valor = $('#tabela td').text();
    	
    	if (valor == '') {
    		$('#listavazia').show();
    		$('#tabela').hide();
    	} else {
    		$('#tabela').show();
    		$('#busca').show();
    	}
    	
    	$('#tabela').find('tr').on('click', function() {
    		$('#id').val($(this).find('td:first').text());
    		$('#quarto').val($(this).find('td:eq(2)').text());
    	});
    	
    	$('#buscarPorNome').on('keyup', function() {
    		if ($(this).val().length > 1 || $(this).val() == '') {
    			var nome = $(this).val().trim();
	    		$.ajax({
	                type: 'GET',
	                url: 'listareservas',
	                data: {opcao : 'buscarPorNome', valor : nome},
	                dataType: "JSON",
	                success: function(response) {
	                	montarTabela(response);
	                },
		            error: function (err) {
		            	console.log(err);
		            }
	            });
			}
    	});
    });
    
    function montarTabela(data) {
    	$('tbody tr').remove();
        var table;
        for (let i = 0; i < data.length; i++) {
            table += '<tr>';
            table += '<td class="col s1"><input type="text" id="id" name="hospedeId" hidden value="' + data[i].id + '" />' + data[i].id + '</td>';
            table += '<td class="col s2">' + data[i].hospede.nome + '</td>';
            table += '<td class="col s2 center"><input type="text" id="quarto" name="quartoNum" hidden value="' + data[i].quarto + '" />' + data[i].quarto + '</td>';
            table += '<td class="col s2 center">' + data[i].hospede.email + '</td>';
            table += '<td class="col s1">' + data[i].dtEntrada + '</td>';
            table += '<td class="col s1">' + data[i].dtSaida + '</td>';
            table += '<td class="col s1"><button class="btn waves-effect waves-light #e53935 red darken-1" type="submit" id="btExcluir" value="excluirLinha" name="opcao" >Excluir <i class="material-icons right ">send</i></button></td>';
            table += '</tr>';
        }
        $('table tbody').html(table);
        
		$('#tabela').find('tr').on('click', function() {
    		$('#id').val($(this).find('td:first').text());
    		$('#quarto').val($(this).find('td:eq(2)').text());
    	});
    }
    
    </script>
</body>

</html>