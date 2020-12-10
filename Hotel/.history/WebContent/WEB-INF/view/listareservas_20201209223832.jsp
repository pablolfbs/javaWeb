<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Reservas</title>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>

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
	
	.radioDistance { padding-left: 20px; }
	
	th .btn:hover, td .btn:hover, #btLogout:hover, #exportar:hover, li:hover { background-color: #ee6e73; color: white; }
</style>
</head>

<body style="margin-bottom: 50px">
	<div class="container">
		<div class="row">
			<nav>
				<div class="nav-wrapper">
					<div class="col s8">
						<h3 class="brand-logo col s8">RESERVAS</h3>
					</div>
				</div>
			</nav>
		</div>
		<form id="myForm" action="entrada" method="POST">
			<table id="tabela" class="highlight" id="tabela" summary="reservas" hidden>
				<thead>
					<tr>
						<th class="col s1" scope="col"><a class="btn waves-effect waves-orange btn-flat" href="#">#</a></th>
						<th class="col s2" scope="col"><a class="btn waves-effect waves-orange btn-flat" href="#">Nome</a></th>
						<th class="col s2 center" scope="col"><a class="btn waves-effect waves-orange btn-flat" href="#">CPF</a></th>
						<th class="col s2 center" scope="col"><a class="btn waves-effect waves-orange btn-flat" href="#">Quarto</a></th>
						<th class="col s2 center" scope="col"><a class="btn waves-effect waves-orange btn-flat" href="#">E-mail</a></th>
						<th class="col s1 center" scope="col"><a class="btn waves-effect waves-orange btn-flat" href="#">Entrada</a></th>
						<th class="col s1 center" scope="col"><a class="btn waves-effect waves-orange btn-flat" href="#">Saída</a></th>
						<th class="col s1 center" id="btExcluirTodos"><a class="btn waves-effect waves-orange btn-flat" href="#">Excluir</a></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="reserva" items="${listaHospedes}">
						<tr class="hoverable">
							<td class="col s1"><input type="hidden" id="id" name="hospedeId" value="${ reserva.hospede.id }" /><c:out value="${ reserva.hospede.id }" /></td>
							<td class="col s2"><c:out value="${ reserva.hospede.nome }" /></td>
							<td class="col s2 center"><c:out value="${ reserva.hospede.cpf }" /></td>
							<td class="col s2 center"><input type="hidden" id="quarto" name="quartoNum" value="${ reserva.quarto }" /><c:out value="${ reserva.quarto }" /></td>
							<td class="col s2 center"><c:out value="${ reserva.hospede.email }" /></td>
							<td class="col s1 center"><c:out value="${ reserva.dtEntradaFormatada }" /></td>
							<td class="col s1 center"><c:out value="${ reserva.dtSaidaFormatada }" /></td>
							<td class="col s1 center">
								<button class="btn tooltipped waves-effect waves-orange btn-flat" id="btExcluir" data-position="top" data-tooltip="excluir linha" value="excluirLinha" name="acao">
									<i class="fa fa-trash"></i>
								</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<div class="col-md-12 center text-center">
                <span class="left" id="total_reg"></span>
                <ul class="pagination pager" id="myPager"></ul>
            </div>
			<br>
			<h4 class="center" style="color:red" id="listavazia" hidden>A lista de reservas está vazia.</h4>
			<div id="divPesquisa" class="row">
				<div class="input-field hoverable col s2">
					<select id="selectPesquisar">
						<option value="" disabled selected>Pesquisar por</option>
						<option value="nome">Nome</option>
						<option value="email">E-mail</option>
					</select>
				</div>
				<div class="input-field hoverable col s10" id="busca" hidden>
					<input id="pesquisar" type="text" class="validate" >
					<label id="labelPesquisar" for="buscar">Pesquisar</label>
				</div>
			</div>
			<button style="width: 185px" class="btn waves-effect waves-orange btn-flat btn-large" type="submit" id="btLogout" name="acao" value="logout">
				Logout<i class="material-icons left red-text">power_settings_new</i>
			</button>
			
			<!-- Modal Trigger -->
  			<button type="button" data-target="modal1" id="exportar" class="btn modal-trigger waves-effect waves-orange btn-flat btn-large right">
  				<i class="material-icons left">file_download</i>Exportar PDF
  			</button>
  			
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
			
			<!-- Modal Structure -->
			<div id="modal4" class="modal">
				<div class="modal-content">
					<h4>AVISO</h4>
					<p>Favor escolher um parâmetro para a pesquisa!</p>
				</div>
				<div class="modal-footer">
					<a href="#!" class="modal-close waves-effect btn-flat">Ok</a>
				</div>
			</div>
			
			<!-- Modal Structure -->
			<div id="modal5" class="modal">
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
			<div id="modal6" class="modal">
				<div class="modal-content">
					<h4>SUCESSO</h4>
					<p>Todas as reservas foram apagadas!</p>
				</div>
				<div class="modal-footer">
					<a href="#!" class="modal-close waves-effect btn-flat">Ok</a>
				</div>
			</div>
			
			<!-- Modal Structure -->
			<div id="modal7" class="modal">
				<div class="modal-content">
					<h4>AVISO</h4>
					<p>Não há reservas a serem apagadas!</p>
				</div>
				<div class="modal-footer">
					<a href="#!" class="modal-close waves-effect btn-flat">Ok</a>
				</div>
			</div>
		</form>
		<div>
			<!-- <button class="btn tooltipped waves-effect waves-orange btn-flat" id="btExcluir" data-position="top" data-tooltip="excluir linha" value="excluirLinha" name="acao"> -->
			<br>
			<a href="entrada?acao=index" class="tooltipped" data-position="top" data-tooltip="voltar" value="voltar">
			<img border="0" alt="voltar" src="img/btVoltar.png" width="35" height="35">
		</div>
	</div>

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    
    <script type="text/javascript" src="js/listareservas.js"></script>
    
    <script type="text/javascript" src="js/pagination.js"></script>
</body>

</html>