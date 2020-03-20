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

<!--Import materialize.css-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>

<body>
	<div class="container">
		<div class="section center">
			<h1 class="teal-text text-lighten-2">RESERVA</h1>
		</div>
		<form action="hospedes" method="POST">
			<div class="row">
				<div class="input-field col s6">
					<i class="material-icons prefix">account_circle</i>
					<input id="first_name" type="text" name="nome" class="validate" required >
					<label for="first_name">Nome</label>
				</div>
				<div id="divSelect" class="input-field col s6">
					<select id="comboBox" name="quarto" class="validate" required >
						<!-- <option value="" disabled selected >Escolha seu quarto</option> -->
						<%-- <c:forEach var="quarto" items="${listaQuartos}">
							<option value="${quarto.num}" >${quarto.num}</option>
						</c:forEach> --%>
				    </select>
			    	<label for="quarto">Quarto</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12">
					<i class="material-icons prefix">email</i> <input id="email" type="email" name="email" class="validate" required >
					<label for="email">E-mail</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<i class="material-icons prefix">date_range</i>
					<input id="dtEntrada" type="date" name="dtEntrada" class="validate" maxlength="10" >
					<label for="dtEntrada">Data de Entrada (somente números)</label>
				</div>
				<div class="input-field col s6">
					<i class="material-icons prefix">date_range</i>
					<input id="dtSaida" type="date" name="dtSaida" class="validate" maxlength="10" >
					<label for="dtSaida">Data de Saída (somente números)</label>
				</div>
			</div>
			<div class="row">
				<div class="col s12">
					<button class="btn waves-effect waves-light right" type="submit" id="btCadastrar" value="cadastrar" name="opcao" >
						Cadastrar <i class="material-icons right">send</i>
					</button>
					<button class="btn waves-effect waves-light #e53935 red darken-1" type="submit" id="btExcluir" value="excluir" name="opcao" >
						Excluir <i class="material-icons right">send</i>
					</button>
					<div id="mensagem"></div>
				</div>
			</div>
		</form>
		<form action="listareservas" method="GET">
			<div class="row">
				<div class="col s12">
					<button class="btn waves-effect waves-light" type="submit" id="btListar" value="listar" name="opcao" >
						Listar <i class="material-icons right">send</i>
					</button>
				</div>
			</div>
		</form>
	</div>

	<!--JavaScript at end of body for optimized loading-->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
				
	<script type="text/javascript">
	
		$(document).ready(function () {
			
			$.ajax({
	            type: 'GET',
	            url: 'quartos',
	            dataType: 'JSON',
	            success: function(response) {
	            	 montarCombobox(response);
	            },
	            error: function (err) {
	            	console.log(err);
	            }
	        });
			
			$('#divSelect').on('click', function() {
				if($('li').length == 1) {
					alert('Não há quartos disponíveis');
				}
			});
		    
			$('#btListar, #btExcluir, #comboBox').on('click', function() {
				$('.validate').removeAttr('required');
			});
			
			$('#btExcluir').on('click', function() {
				var confirmacao = confirm('Tem certeza que deseja excluir todas as reservas?');
				
				if (confirmacao) {
					return true;
				} else {
					return false;
				}
			});
			
			$('#btCadastrar').on('click', function() {
				if ($('select option:selected').val() == '') {
					if ($('#first_name').val() != '' && $('#email').val() != '') {
						alert('Por favor, escolha um quarto!');
						return false;
					}
				}
			});
		});
		
		function montarCombobox(data) {
			$('#comboBox').append('<option value="" disabled selected >Escolha seu quarto</option>');
        	for (let i = 0; i < data.length; i++) {
            	$('#comboBox').append('<option value="' + data[i].num + '">' + data[i].num + '</option>');
			}
        	$('select').formSelect();
		}
		
	</script>
</body>

</html>