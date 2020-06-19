$(() => {

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

	$('#tabela').find('tr').on('click', e => {
		$('#id').val($(e.currentTarget).find('td:first').text());
		$('#quarto').val($(e.currentTarget).find('td:eq(3)').text());
	});

	$('#confirmaExport').on('click', () => {
		var nome = $('#pesquisar').val().trim();
		$.ajax({
			type: 'GET',
			url: 'entrada',
			data: {
				acao: 'exportarPdf',
				param: nome
			},
			dataType: "JSON",
			success: () => {
				var instance = M.Modal.getInstance($('#modal2').modal());
				instance.open();
			},
			error: err => {
				console.log(err);
				var instance = M.Modal.getInstance($('#modal3').modal());
				instance.open();
			}
		});
	});

	$('#pesquisar').on('keyup', e => {
		if ($(e.currentTarget).val().length > 1 || $(e.currentTarget).val() == '') {
			var nome = $(e.currentTarget).val().trim();
			var param = $('#selectPesquisar option:selected').val();
			param = param.substring(0, 1).toUpperCase() + param.substring(1);
			
			if ($('#selectPesquisar').val() == null) {
				var instance = M.Modal.getInstance($('#modal4').modal());
				instance.open();
			} else {
				$.ajax({
					type: 'GET',
					url: 'entrada',
					data: {
						acao: 'pesquisarPor' + param,
						param: nome
					},
					dataType: "JSON",
					success: response => {
						montarTabela(response);
					},
					error: err => {
						console.log(err);
					}
				});
			}
		}
	});

	$('#selectPesquisar').on('change', () => {
		var param = $('#selectPesquisar option:selected').text();

		$('#labelPesquisar').text('Pesquisar por ' + param);
	});

	$('#tabela thead tr th').on('click', e => {
		var nome = $('#pesquisar').val().trim();
		var valor = $(e.currentTarget).text().substring(0, 1).toUpperCase() + $(e.currentTarget).text().substring(1).toLowerCase();
		if (valor != 'Excluir') {
			$.ajax({
				type: 'GET',
				url: 'entrada',
				data: {
					acao: 'ordenarPor',
					paramOrdenacao: valor,
					param: nome
				},
				dataType: "JSON",
				success: response => {
					montarTabela(response);
				},
				error: err => {
					console.log(err);
				}
			});
		}
	});
});

var montarTabela = data => {
	$('tbody tr').remove();
	var table;

	data.map(d => {
		table += '<tr>';
		table += '<td class="col s1"><input type="hidden" id="id" name="hospedeId" value="' + d.id + '" />' + d.id + '</td>';
		table += '<td class="col s2">' + d.hospede.nome + '</td>';
		table += '<td class="col s2 center">' + d.hospede.cpf + '</td>';
		table += '<td class="col s2 center"><input type="hidden" id="quarto" name="quartoNum" value="' + d.quarto + '" />' + d.quarto + '</td>';
		table += '<td class="col s2 center">' + d.hospede.email + '</td>';
		table += '<td class="col s1 center">' + d.dtEntrada + '</td>';
		table += '<td class="col s1 center">' + d.dtSaida + '</td>';
		table += '<td class="col s1 center">';
		table += '<button class="btn waves-effect waves-teal btn-flat" id="btExcluir" value="excluirLinha" name="acao">';
		table += '<i class="fa fa-trash"></button></td>';
		table += '</tr>';
	});

	/*for (let i = 0; i < data.length; i++) {
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
	}*/

	$('table tbody').html(table);

	$('#tabela').find('tr').on('click', e => {
		$('#id').val($(e.currentTarget).find('td:first').text());
		$('#quarto').val($(e.currentTarget).find('td:eq(3)').text());
	});
}