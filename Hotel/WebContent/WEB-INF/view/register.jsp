<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Registro</title>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>

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
<body>
	<div class="container col s8">
		<div class="row">
			<nav>
				<div class="nav-wrapper">
					<div class="col s8">
						<h3 class="brand-logo col s8">Please Register</h3>
					</div>
				</div>
			</nav>
		</div>
		<form class="col s14" id="formRegistro" action="entrada" method="POST">
			<div class="row">
				<div class="input-field hoverable col s6">
					<i class="material-icons prefix">contacts</i> <input id="first_name" type="text" class="validate" name="first_name">
					<label for="first_name">First Name</label>
				</div>
				<div class="input-field hoverable col s6">
					<i class="material-icons prefix">contacts</i> <input id="last_name" type="text" class="validate" name="last_name">
					<label for="last_name">Last Name</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field hoverable col s6">
					<i class="material-icons prefix">account_circle</i> <input id="username" type="text" class="validate" name="username">
					<label for="username">Username</label>
				</div>
				<div class="input-field hoverable col s6">
					<i class="material-icons prefix">mail_outline</i> <input id="email" type="email" class="validate" name="email">
					<label for="email">Email</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field hoverable col s6">
					<i class="material-icons prefix">lock_outline</i> <input id="password" type="password" class="validate" name="password">
					<label for="password">Password</label>
				</div>
				<div class="input-field hoverable col s6">
					<i class="material-icons prefix">replay</i> <input id="password2" type="password" class="validate" name="password2">
					<label for="password2">Retype Password</label>
				</div>
			</div>
			<!-- <a href="entrada?acao=registro" class="waves-effect waves-light btn right hoverable" type="submit""><i class="large material-icons right">done</i>register</a> -->
			<button style="width: 185px" class="btn tooltipped waves-effect waves-orange btn-flat btn-large right" data-position="top" data-tooltip="registrar usuï¿½rio" type="button" id="btRegistrar" value="registro" name="acao" >
				<i class="material-icons left">add</i>Registrar
			</button>
			
			<!-- Modal Structure -->
			<div id="modal1" class="modal">
				<div class="modal-content">
					<h4>AVISO</h4>
					<p>O email e a senha não podem estar vazios!</p>
				</div>
				<div class="modal-footer">
					<a href="#!" class="modal-close waves-effect btn-flat" id="ok">Ok</a>
				</div>
			</div>
		</form>
		<div>
			<br><a href="entrada?acao=loginForm">voltar</a>
		</div>
	</div>
	
	<!--JavaScript at end of body for optimized loading-->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
	
	<script type="text/javascript" src="js/register.js"></script>
</body>
</html>

