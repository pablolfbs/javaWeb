<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style type="text/css">
	.modal { width: 25% !important; }
</style>
</head>

<body>
	<div class="container">
		<div class="section center">
			<h1 class="teal-text text-lighten-2">RESERVAS</h1>
		</div>
		<form id="myForm" action="listareservas" method="POST">
			<table id="tabela" class="highlight" id="tabela" hidden>
				<thead>
					<tr>
						<th class="col s1"><a class="btn waves-effect waves-teal btn-flat" href="#">#</a></th>
						<th class="col s2"><a class="btn waves-effect waves-teal btn-flat" href="#">Nome</a></th>
						<th class="col s2 center"><a class="btn waves-effect waves-teal btn-flat" href="#">CPF</a></th>
						<th class="col s2 center"><a class="btn waves-effect waves-teal btn-flat" href="#">Quarto</a></th>
						<th class="col s2 center"><a class="btn waves-effect waves-teal btn-flat" href="#">E-mail</a></th>
						<th class="col s1 center"><a class="btn waves-effect waves-teal btn-flat" href="#">Entrada</a></th>
						<th class="col s1 center"><a class="btn waves-effect waves-teal btn-flat" href="#">Saída</a></th>
						<th class="col s1 center"><a class="waves-effect waves-light #e53935 red darken-1 btn" href="#">Excluir</a></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="reserva" items="${listaHospedes}">
						<tr>
							<td class="col s1"><input type="hidden" id="id" name="hospedeId" value="${ reserva.hospede.id }" /><c:out value="${ reserva.hospede.id }" /></td>
							<td class="col s2"><c:out value="${ reserva.hospede.nome }" /></td>
							<td class="col s2 center"><c:out value="${ reserva.hospede.cpf }" /></td>
							<td class="col s2 center"><input type="hidden" id="quarto" name="quartoNum" value="${ reserva.quarto }" /><c:out value="${ reserva.quarto }" /></td>
							<td class="col s2 center"><c:out value="${ reserva.hospede.email }" /></td>
							<td class="col s1 center"><c:out value="${ reserva.dtEntradaFormatada }" /></td>
							<td class="col s1 center"><c:out value="${ reserva.dtSaidaFormatada }" /></td>
							<td class="col s1 center">
								<button class="btn waves-effect waves-teal btn-flat" id="btExcluir" value="excluirLinha" name="opcao"><i class="fa fa-trash"></i></button>
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
			<!-- <button type="button" class="btn right" id="btPdf" value="exportarPdf" name="opcao">Exportar PDF</button> -->
			
			<!-- Modal Trigger -->
  			<button type="button" data-target="modal1" id="exportar" class="btn modal-trigger waves-effect waves-teal btn-flat btn-large right">Exportar PDF</button>
  			
			<!-- Modal Structure -->
			<div id="modal1" class="modal">
				<div class="modal-content">
					<h4>AVISO</h4>
					<p>Deseja exportar para PDF?</p>
				</div>
				<div class="modal-footer">
					<a href="#!" class="modal-close waves-effect btn-flat ">Não</a>
					<a href="#!" class="modal-close waves-effect waves-green btn-flat" id="confirmaExport">Sim</a>
				</div>
			</div>
			
			<!-- Modal Structure -->
			<div id="modal2" class="modal">
				<div class="modal-content">
					<h4>SUCESSO</h4>
					<p>PDF criado com sucesso!</p>
				</div>
				<div class="modal-footer">
					<a href="#!" class="modal-close waves-effect btn-flat">Ok</a>
				</div>
			</div>
			
			<!-- Modal Structure -->
			<div id="modal3" class="modal">
				<div class="modal-content">
					<h4>ERRO</h4>
					<p>Falha ao criar PDF!</p>
				</div>
				<div class="modal-footer">
					<a href="#!" class="modal-close waves-effect btn-flat">Ok</a>
				</div>
			</div>
          
		</form>
		<br><a href="index.jsp">voltar</a>
	</div>

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    
    <script type="text/javascript" src="js/listareservas.js"></script>
</body>

</html>