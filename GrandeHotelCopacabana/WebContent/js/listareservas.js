$(function() {

	var valor = $('#tabela td').text();

	$('.modal').modal();

	if (valor == '') {
		$('#listavazia').show();
		$('#tabela').hide();
	} else {
		$('#tabela').show();
		$('#busca').show();
	}

	$('#tabela').find('tr').on('click', function() {
		$('#id').val($(this).find('td:first').text());
		$('#quarto').val($(this).find('td:eq(3)').text());
	});

	/*
	 * $('#confirmaExcluirLinha').on('click', function() { var hospedeId =
	 * $('table tbody tr').find('#id').val(); var quartoNum = $('table tbody
	 * tr').find('#quarto').val(); $.ajax({ type: 'POST', url: 'listareservas',
	 * data: { opcao : 'excluirLinha', hospedeId : hospedeId, quartoNum :
	 * quartoNum }, dataType: "JSON", success: function(response) {
	 * montarTabela(response); $('#modal4').modal('open'); return; }, error:
	 * function (err) { console.log(err); } }); });
	 */

	$('#btExcluir')
			.on(
					'click',
					function() {
						var confirmacao = confirm('Tem certeza que deseja excluir essa reserva?');
						if (confirmacao) {
							return true;
						} else {
							return false;
						}
					});

	$('#confirmaExport').on('click', function() {
		var nome = $('#buscarPorNome').val().trim();
		$.ajax({
			type : 'GET',
			url : 'listareservas',
			data : {
				opcao : 'exportarPdf',
				valor : nome
			},
			dataType : "JSON",
			success : function(response) {
				$('#modal2').modal('open');
			},
			error : function(err) {
				console.log(err);
			}
		});
	});

	$('#buscarPorNome').on('keyup', function() {
		if ($(this).val().length > 1 || $(this).val() == '') {
			var nome = $(this).val().trim();
			$.ajax({
				type : 'GET',
				url : 'listareservas',
				data : {
					opcao : 'buscarPorNome',
					valor : nome
				},
				dataType : "JSON",
				success : function(response) {
					montarTabela(response);
				},
				error : function(err) {
					console.log(err);
				}
			});
		}
	});

	$('#tabela thead tr th').on('click', function() {
		var nome = $('#buscarPorNome').val().trim();
		if ($(this).text() == '#') {
			$.ajax({
				type : 'GET',
				url : 'listareservas',
				data : {
					opcao : 'ordenarPorId',
					valor : nome
				},
				dataType : "JSON",
				success : function(response) {
					montarTabela(response);
				},
				error : function(err) {
					console.log(err);
				}
			});
		} else if ($(this).text() == 'Nome') {
			$.ajax({
				type : 'GET',
				url : 'listareservas',
				data : {
					opcao : 'ordenarPorNome',
					valor : nome
				},
				dataType : "JSON",
				success : function(response) {
					montarTabela(response);
				},
				error : function(err) {
					console.log(err);
				}
			});
		} else if ($(this).text() == 'CPF') {
			$.ajax({
				type : 'GET',
				url : 'listareservas',
				data : {
					opcao : 'ordenarPorCpf',
					valor : nome
				},
				dataType : "JSON",
				success : function(response) {
					montarTabela(response);
				},
				error : function(err) {
					console.log(err);
				}
			});
		} else if ($(this).text() == 'Quarto') {
			$.ajax({
				type : 'GET',
				url : 'listareservas',
				data : {
					opcao : 'ordenarPorQuarto',
					valor : nome
				},
				dataType : "JSON",
				success : function(response) {
					montarTabela(response);
				},
				error : function(err) {
					console.log(err);
				}
			});
		} else if ($(this).text() == 'E-mail') {
			$.ajax({
				type : 'GET',
				url : 'listareservas',
				data : {
					opcao : 'ordenarPorEmail',
					valor : nome
				},
				dataType : "JSON",
				success : function(response) {
					montarTabela(response);
				},
				error : function(err) {
					console.log(err);
				}
			});
		} else if ($(this).text() == 'Entrada') {
			$.ajax({
				type : 'GET',
				url : 'listareservas',
				data : {
					opcao : 'ordenarPorDtEntrada',
					valor : nome
				},
				dataType : "JSON",
				success : function(response) {
					montarTabela(response);
				},
				error : function(err) {
					console.log(err);
				}
			});
		} else if ($(this).text() == 'Saída') {
			$.ajax({
				type : 'GET',
				url : 'listareservas',
				data : {
					opcao : 'ordenarPorDtSaida',
					valor : nome
				},
				dataType : "JSON",
				success : function(response) {
					montarTabela(response);
				},
				error : function(err) {
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
		table += '<td class="col s1"><input type="text" id="id" name="hospedeId" hidden value="'
				+ data[i].id + '" />' + data[i].id + '</td>';
		table += '<td class="col s2">' + data[i].hospede.nome + '</td>';
		table += '<td class="col s2 center">' + data[i].hospede.cpf + '</td>';
		table += '<td class="col s2 center"><input type="text" id="quarto" name="quartoNum" hidden value="'
				+ data[i].quarto + '" />' + data[i].quarto + '</td>';
		table += '<td class="col s2 center">' + data[i].hospede.email + '</td>';
		table += '<td class="col s1 center">' + data[i].dtEntrada + '</td>';
		table += '<td class="col s1 center">' + data[i].dtSaida + '</td>';
		table += '<td class="col s1 center"><button class="btn" id="btExcluir" value="excluirLinha" name="opcao"><i class="fa fa-trash"></i></button></td>';
		table += '</tr>';
	}
	$('table tbody').html(table);

	$('#tabela').find('tr').on('click', function() {
		$('#id').val($(this).find('td:first').text());
		$('#quarto').val($(this).find('td:eq(3)').text());
	});
}