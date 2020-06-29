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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<!--Import materialize.css-->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">

<!--Let browser know website is optimized for mobile-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style type="text/css">
	.modal { width: 25% !important; }
	
	.btn:hover { background-color: #ee6e73; color: white; }
</style>
</head>

<body style="margin-bottom: 50px">
	<div class="container">
		<div class="row">
			<nav>
				<div class="nav-wrapper">
					<div class="col s8">
						<h3 class="brand-logo col s8">RESERVA</h3>
					</div>
				</div>
			</nav>
		</div>
		<!-- <div class="section center">
			<h1 class="teal-text text-lighten-2">RESERVA</h1>
		</div> -->
		<form id="formHospedes" action="entrada" method="POST">
			<div class="row">
				<div class="input-field hoverable col s6">
					<i class="material-icons prefix">account_circle</i>
					<input id="first_name" type="text" name="nome" class="validate" required >
					<label for="first_name">Nome</label>
				</div>
				<div class="input-field hoverable col s6">
					<i class="material-icons prefix">email</i>
					<input id="email" type="email" name="email" class="validate" required >
					<label for="email">E-mail</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field hoverable col s6">
					<i class="material-icons prefix">dvr</i>
					<input id="cpf" type="text" name="cpf" class="validate" required >
					<label for="cpf">CPF</label>
				</div>
				<div id="divSelect" class="input-field hoverable col s6">
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
				<div class="input-field hoverable col s6">
					<i class="material-icons prefix">date_range</i>
					<input id="dtEntrada" type="date" name="dtEntrada" class="validate" maxlength="10" >
					<label for="dtEntrada">Data de Entrada (somente números)</label>
				</div>
				<div class="input-field hoverable col s6">
					<i class="material-icons prefix">date_range</i>
					<input id="dtSaida" type="date" name="dtSaida" class="validate" maxlength="10" >
					<label for="dtSaida">Data de Saída (somente números)</label>
				</div>
			</div>
			<div class="row">
				<!-- Modal Trigger -->
				<button class="btn tooltipped waves-effect waves-orange btn-flat btn-large right" data-position="top" data-tooltip="nova reserva" type="button" id="btCadastrar" value="cadastrarHospede" name="acao" >
					<i class="material-icons left">add</i>Cadastrar
				</button>
				<!-- <input type="hidden" name="acao" value="cadastrarHospede" /> -->
				<!-- Modal Trigger -->
				<button class="btn tooltipped modal-trigger waves-effect waves-orange btn-flat btn-large" data-position="top" data-tooltip="apagar todas as reservas" type="button" id="btExcluir" value="excluirTodos" name="acao">
					<i style="padding-right: 20px" class="fa fa-trash"></i>Excluir Todos
				</button>
				
				<!-- Modal Structure -->
				<div id="modal1" class="modal">
					<div class="modal-content">
						<h4>AVISO</h4>
						<p>Tem certeza que deseja excluir todas as reservas?</p>
					</div>
					<div class="modal-footer">
						<a href="#!" class="modal-close waves-effect btn-flat">Não</a>
						<a href="#!" id="confirmaExcluir" class="modal-close waves-effect waves-green btn-flat">Sim</a>
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
				<!-- Modal Structure -->
				<div id="modal3" class="modal">
					<div class="modal-content">
						<h4>AVISO</h4>
						<p>Não há reservas a serem apagadas!</p>
					</div>
					<div class="modal-footer">
						<a href="#!" class="modal-close waves-effect btn-flat">Ok</a>
					</div>
				</div>
			</div>
			<!-- Modal Structure -->
			<div id="modal4" class="modal">
				<div class="modal-content">
					<h4>AVISO</h4>
					<p>Por favor, escolha um quarto!</p>
				</div>
				<div class="modal-footer">
					<a href="#!" class="modal-close waves-effect btn-flat">Ok</a>
				</div>
			</div>
			<!-- Modal Structure -->
			<div id="modal5" class="modal">
				<div class="modal-content">
					<h4>AVISO</h4>
					<p>Este e-mail já está cadastrado!</p>
				</div>
				<div class="modal-footer">
					<a href="#!" class="modal-close waves-effect btn-flat">Ok</a>
				</div>
			</div>
			<!-- Modal Structure -->
			<div id="modal6" class="modal">
				<div class="modal-content">
					<h4>AVISO</h4>
					<p>Favor preencher todos os campos!</p>
				</div>
				<div class="modal-footer">
					<a href="#!" class="modal-close waves-effect btn-flat">Ok</a>
				</div>
			</div>
			<!-- Modal Structure -->
			<div id="modal7" class="modal">
				<div class="modal-content">
					<h4>SUCESSO</h4>
					<p>Reserva cadastrada com sucesso!</p>
				</div>
				<div class="modal-footer">
					<a href="#!" class="modal-close waves-effect btn-flat">Ok</a>
				</div>
			</div>
			<!-- Modal Structure -->
			<div id="modal8" class="modal">
				<div class="modal-content">
					<h4>ERRO</h4>
					<p>Erro ao cadastrar reserva!</p>
				</div>
				<div class="modal-footer">
					<a href="#!" class="modal-close waves-effect btn-flat">Ok</a>
				</div>
			</div>
			<!-- Modal Structure -->
			<div id="modal9" class="modal">
				<div class="modal-content">
					<h4>AVISO</h4>
					<p>Não há quartos disponíveis!</p>
				</div>
				<div class="modal-footer">
					<a href="#!" class="modal-close waves-effect btn-flat">Ok</a>
				</div>
			</div>
			<div class="row">
				<button style="width: 185px" class="btn tooltipped waves-effect waves-orange btn-flat btn-large" data-position="top" data-tooltip="mockar nova reserva" type="button" id="btCadMock" value="cadMock" name="acao" >
					<i class="material-icons left">child_care</i>Mock
				</button>
				<button style="width: 185px" class="btn tooltipped waves-effect waves-orange btn-flat btn-large right" data-position="top" data-tooltip="listar reservas" type="submit" id="btListar" value="listarReservas" name="acao" >
					<i class="material-icons left">format_list_bulleted</i>Listar
				</button>
			</div>
			<div class="row">
				<button style="width: 185px" class="btn waves-effect waves-orange btn-flat btn-large" type="submit" id="btLogout" name="acao" value="logout">
					Logout<i class="material-icons left red-text">power_settings_new</i>
				</button>
				<button style="width: 185px" class="btn tooltipped waves-effect waves-orange btn-flat btn-large right" data-position="top" data-tooltip="limpar campos digitados" type="button" id="btLimpar" value="limpar">
					<i class="material-icons left">clear_all</i>Limpar
				</button>
			</div>
		</form>
	</div>

	<!--JavaScript at end of body for optimized loading-->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
				
	<script type="text/javascript" src="js/index.js"></script>
</body>

</html>