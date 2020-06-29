<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Login</title>

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

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style type="text/css">
	html, body {
	height: 100%;
	}
	
	html {
		display: table;
		margin: auto;
	}
	
	body {
		display: table-cell;
		vertical-align: middle;
		background: #4ECDC4;
	}
	
	#login-page {
		width: 500px;
	}
	
	.card {
		position: absolute;
		left: 50%;
		top: 50%;
		-moz-transform: translate(-50%, -50%) -webkit-transform: translate(-50%, -50%)
			-ms-transform: translate(-50%, -50%) -o-transform: translate(-50%, -50%)
			transform: translate(-50%, -50%);
	}
	
	.btn { background-color: #ee6e73; }
	
	.btn:hover { background-color: #ee6e73; color: white; }
</style>

</head>
<body ng-app="mainModule" ng-controller="mainController">
	<div id="login-page" class="row">
		<div class="col s12 z-depth-6 card-panel">
			<nav>
				<div class="nav-wrapper">
					<div class="col s8">
						<h3 class="brand-logo col s8">Login</h3>
					</div>
				</div>
			</nav>
			<form class="login-form" action="entrada" method="POST">
				<div class="row"></div>
				<div class="row">
					<div class="input-field hoverable col s12">
						<i class="material-icons prefix">mail_outline</i>
						<input class="validate" id="email" type="email" name="email"> <label for="email" data-error="wrong" data-success="right">Email</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field hoverable col s12">
						<i class="material-icons prefix">lock_outline</i>
						<input id="password" type="password" name="password"> <label for="password">Password</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12 m12 l12 login-text">
					<label for="remember-me">
						<input type="checkbox" id="remember-me" /><span>Remember me</span>
					</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<button class="btn waves-effect waves-light col s12 waves-orange hoverable" type="submit" value="login" name="acao">Login</button>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s6 m6 l6">
						<p class="margin medium-small">
							<a href="entrada?acao=registroForm">Register Now!</a>
						</p>
					</div>
					<div class="input-field col s6 m6 l6">
						<p class="margin right-align medium-small">
							<a href="#">Forgot password?</a>
						</p>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!--JavaScript at end of body for optimized loading-->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
	
	<script type="text/javascript" src="js/login.js"></script>
</body>

</html>