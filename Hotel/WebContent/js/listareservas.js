$(function() {
	
	$('.tooltipped').tooltip();
	
	$('select').formSelect();

	var valor = $('#tabela td').text();

	$('.modal').modal();

	if (valor == '') {
		$('#listavazia').show();
		$('#tabela').hide();
		$('#exportar').hide();
		$('#divPesquisa').hide();
	} else {
		$('#tabela').show();
		$('#busca').show();
		$('#exportar').show();
		$('#divPesquisa').show();
	}
	
	$('#tabela').find('tr').on('click', function() {
		$('#id').val($(this).find('td:first').text());
		$('#quarto').val($(this).find('td:eq(3)').text());
	});

	$('#confirmaExport').on('click', function() {
		var nome = $('#pesquisar').val().trim();
		$.ajax({
			type : 'GET',
			url : 'entrada',
			data : {
				acao : 'exportarPdf',
				param : nome
			},
			dataType : "JSON",
			success : function() {
				var instance = M.Modal.getInstance($('#modal2').modal());
				instance.open();
			},
			error : function(err) {
				console.log(err);
				var instance = M.Modal.getInstance($('#modal3').modal());
				instance.open();
			}
		});
	});

	$('#pesquisar').on('keyup', function() {
		if ($(this).val().length > 1 || $(this).val() == '') {
			var nome = $(this).val().trim();
			var param = $('#selectPesquisar option:selected').text();
			if ($('#selectPesquisar').val() == null) {
				var instance = M.Modal.getInstance($('#modal4').modal());
				instance.open();
			} else {
				$.ajax({
					type : 'GET',
					url : 'entrada',
					data : {
						acao : 'pesquisarPor' + param,
						param : nome
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
			
		}
	});
	
	$('#selectPesquisar').on('change', function() {
		var acao = $('#selectPesquisar option:selected').text().toLowerCase();
		$('#labelPesquisar').text('Pesquisar por ' + acao);
	});

	$('#tabela thead tr th').on('click', function() {
		var nome = $('#pesquisar').val().trim();
		var valor = '';
		switch($(this).text()) {
		case '#':
			valor = 'ordenarPorId';
			break;
		case 'Nome':
			valor = 'ordenarPorNome';
			break;
		case 'CPF':
			valor = 'ordenarPorCpf';
			break;
		case 'Quarto':
			valor = 'ordenarPorQuarto';
			break;
		case 'E-mail':
			valor = 'ordenarPorEmail';
			break;
		case 'Entrada':
			valor = 'ordenarPorDtEntrada';
			break;
		case 'Saída':
			valor = 'ordenarPorDtSaida';
			break;
		}
		$.ajax({
			type : 'GET',
			url : 'listareservas',
			data : {
				acao : valor,
				param : nome
			},
			dataType : "JSON",
			success : function(response) {
				montarTabela(response);
			},
			error : function(err) {
				console.log(err);
			}
		});
	});
});

function montarTabela(data) {
	$('tbody tr').remove();
	var table;
	for (let i = 0; i < data.length; i++) {
		table += '<tr>';
		table += '<td class="col s1"><input type="hidden" id="id" name="hospedeId" value="' + data[i].id + '" />' + data[i].id + '</td>';
		table += '<td class="col s2">' + data[i].hospede.nome + '</td>';
		table += '<td class="col s2 center">' + data[i].hospede.cpf + '</td>';
		table += '<td class="col s2 center"><input type="hidden" id="quarto" name="quartoNum" value="' + data[i].quarto + '" />' + data[i].quarto + '</td>';
		table += '<td class="col s2 center">' + data[i].hospede.email + '</td>';
		table += '<td class="col s1 center">' + data[i].dtEntrada + '</td>';
		table += '<td class="col s1 center">' + data[i].dtSaida + '</td>';
		table += '<td class="col s1 center">';
		table += '<button class="btn waves-effect waves-teal btn-flat" id="btExcluir" value="excluirLinha" name="acao">';
		table += '<i class="fa fa-trash"></button></td>';
		table += '</tr>';
	}
	$('table tbody').html(table);

	$('#tabela').find('tr').on('click', function() {
		$('#id').val($(this).find('td:first').text());
		$('#quarto').val($(this).find('td:eq(3)').text());
	});
}