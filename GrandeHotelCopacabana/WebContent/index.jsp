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

<style type="text/css">
	.modal { width: 25% !important; }
</style>
</head>

<body>
	<div class="container">
		<div class="section center">
			<h1 class="teal-text text-lighten-2">RESERVA</h1>
		</div>
		<form accept-charset="ISO-8859-1" id="formHospedes" action="hospedes" method="POST">
			<div class="row">
				<div class="input-field col s6">
					<i class="material-icons prefix">account_circle</i>
					<input id="first_name" type="text" name="nome" class="validate" required >
					<label for="first_name">Nome</label>
				</div>
				<div class="input-field col s6">
					<i class="material-icons prefix">email</i>
					<input id="email" type="email" name="email" class="validate" required >
					<label for="email">E-mail</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<i class="material-icons prefix">dvr</i>
					<input id="cpf" type="text" name="cpf" class="validate" >
					<label for="cpf">CPF</label>
				</div>
				<div id="divSelect" class="input-field col s6">
					<i class="material-icons prefix">airline_seat_individual_suite</i>
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
					<button class="btn tooltipped waves-effect waves-teal btn-flat btn-large right" data-position="top" data-tooltip="Nova reserva" type="submit" id="btCadastrar" value="cadastrar" name="opcao" >
						<i class="material-icons left">add</i>Cadastrar
					</button>
					<!-- <button class="btn waves-effect waves-light #e53935 red darken-1" type="submit" id="btExcluir" value="excluir" name="opcao" >
						Excluir <i class="material-icons right">send</i>
					</button>
					<div id="mensagem"></div> -->
					<!-- Modal Trigger -->
					<button data-target="modal1" class="btn tooltipped modal-trigger waves-light red btn-large" data-position="top" data-tooltip="Apagar todas as reservas" type="button" id="btExcluir" value="excluir" name="opcao">Excluir Todos<i class="material-icons right">send</i></button>
								
					<!-- Modal Structure -->
					<div id="modal1" class="modal">
						<div class="modal-content">
							<h4>AVISO</h4>
							<p>Tem certeza que deseja excluir todas as reservas?</p>
						</div>
						<div class="modal-footer">
							<a href="#!" class="modal-close waves-effect btn-flat">Não</a>
							<a href="#!" class="modal-close waves-effect waves-green btn-flat">Sim</a>
						</div>
					</div>
					
					<!-- Modal Structure -->
					<div id="modal2" class="modal">
						<div class="modal-content">
							<h4>SUCESSO</h4>
							<p>Todas as reservas foram apagadas!</p>
						</div>
						<div class="modal-footer">
							<a href="#!" class="modal-close waves-effect btn-flat">Ok</a>
						</div>
					</div>
				</div>
			</div>
			<!-- Modal Structure -->
			<div id="modal3" class="modal">
				<div class="modal-content">
					<h4>AVISO</h4>
					<p>Por favor, escolha um quarto!</p>
				</div>
				<div class="modal-footer">
					<a href="#!" class="modal-close waves-effect btn-flat">Ok</a>
				</div>
			</div>
			<!-- Modal Structure -->
			<div id="modal4" class="modal">
				<div class="modal-content">
					<h4>AVISO</h4>
					<p>Este e-mail já está cadastrado!</p>
				</div>
				<div class="modal-footer">
					<a href="#!" class="modal-close waves-effect btn-flat">Ok</a>
				</div>
			</div>
		</form>
		<form action="listareservas" method="GET">
			<div class="row">
				<div class="col s12">
					<button style="width: 185px" class="btn tooltipped waves-effect waves-teal btn-flat btn-large right" data-position="top" data-tooltip="Listar todas as reservas" type="submit" id="btListar" value="listar" name="opcao" >
						<i class="material-icons left">format_list_bulleted</i>Listar
					</button>
				</div>
			</div>
		</form>
	</div>

	<!--JavaScript at end of body for optimized loading-->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
				
	<script type="text/javascript" src="js/index.js"></script>
</body>

</html>