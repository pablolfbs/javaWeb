$(() => {

	$('.tooltipped').tooltip();

	$('select').formSelect();

	$('#tabela').find('tr').on('click', e => {
		document.getElementById('id').value = $(e.currentTarget).find('td:first').text();
		document.getElementById('quarto').value = $(e.currentTarget).find('td:eq(3)').text();
	});

	$('#tabela').pageMe({
		pagerSelector: '#myPager',
		activeColor: '#ee6e73',
		prevText: 'previous',
		nextText: 'next',
		showPrevNext: true,
		hidePageNumbers: false,
		perPage: 100
	});
	
	alteraVisibilidade();

	document.querySelector('#tabela thead tr th').onclick = e => {
		let nome = document.getElementById('pesquisar').value.trim();
		let valor = $(e.currentTarget).text().substring(0, 1).toUpperCase() + $(e.currentTarget).text().substring(1).toLowerCase();
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
	}
});

document.getElementById('exportar').onclick = () => {
	let instance = M.Modal.getInstance($('#modal1').modal());
	instance.open();
}

document.getElementById('selectPesquisar').onchange = () => {
	let param = $('#selectPesquisar option:selected').text();

	$('#labelPesquisar').text('Pesquisar por ' + param);
}

document.getElementById('pesquisar').onkeyup = e => {
	if ($(e.currentTarget).val().length > 1 || $(e.currentTarget).val() == '') {
		let nome = $(e.currentTarget).val().trim();
		let param = $('#selectPesquisar option:selected').val();
		param = param.substring(0, 1).toUpperCase() + param.substring(1);

		if ($('#selectPesquisar').val() == null) {
			let instance = M.Modal.getInstance($('#modal4').modal());
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
}

document.getElementById('confirmaExport').onclick = () => {
	let nome = document.getElementById('pesquisar').value.trim();
	$.ajax({
		type: 'GET',
		url: 'entrada',
		data: {
			acao: 'exportarPdf',
			param: nome
		},
		dataType: "JSON",
		success: () => {
			let instance = M.Modal.getInstance($('#modal2').modal());
			instance.open();
		},
		error: err => {
			console.log(err);
			let instance = M.Modal.getInstance($('#modal3').modal());
			instance.open();
		}
	});
}

document.getElementById('btExcluirTodos').onclick = () => {
	let instance = M.Modal.getInstance($('#modal5').modal());
	instance.open();
}

document.getElementById('confirmaExcluir').onclick = () => {
	axios.get('entrada?acao=excluirTodos')
		.then(() => {
			$('tbody tr').remove();
			alteraVisibilidade();

			let instance = M.Modal.getInstance($('#modal6').modal());
			instance.open();
		})
		.catch(err => {
			console.log(err);
		});
	
	/*$.ajax({
		type: 'GET',
		url: 'entrada',
		data: {
			acao: 'excluirTodos'
		},
		dataType: 'JSON',
		success: () => {
			$('tbody tr').remove();
			alteraVisibilidade();

			let instance = M.Modal.getInstance($('#modal6').modal());
			instance.open();
		},
		error: err => {
			console.log(err);
		}
	});*/
}

let alteraVisibilidade = () => {
	// Nesse caso, comparar valor com vazio.
	// let valor = $('#tabela td').text();
	let valor = document.querySelector('#tabela td');

	if (!valor) {
		$('#listavazia').show();
		$('#tabela').hide();
		$('#exportar').hide();
		$('#divPesquisa').hide();
		$('#myPager').hide();
		$('#total_reg').text('0 registro no total');
	} else {
		$('#tabela').show();
		$('#busca').show();
		$('#exportar').show();
		$('#divPesquisa').show();
	}
}

let montarTabela = data => {
	$('tbody tr').remove();
	let table = '';

	data.map(d => {
		table += '<tr class="hoverable">';
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

	document.querySelector('table tbody').innerHTML = table;
	
	$('#myPager').text('');
	$('#tabela').pageMe({
		pagerSelector: '#myPager',
		activeColor: '#ee6e73',
		prevText: 'previous',
		nextText: 'next',
		showPrevNext: true,
		hidePageNumbers: false,
		perPage: 100
	});

	$('#tabela').find('tr').on('click', e => {
		document.getElementById('id').value = $(e.currentTarget).find('td:first').text();
		document.getElementById('quarto').value = $(e.currentTarget).find('td:eq(3)').text();
	});
}

