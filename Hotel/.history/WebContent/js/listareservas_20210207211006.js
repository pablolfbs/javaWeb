$(() => {

	$('.tooltipped').tooltip();

	$('select').formSelect();

	selecionaLinha();

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

});

document.getElementById('exportar').addEventListener('click', () => {
	let instance = M.Modal.getInstance($('#modal1').modal());
	instance.open();
});

document.getElementById('selectPesquisar').addEventListener('change', () => {
	let param = document.querySelector('#selectPesquisar option:checked').innerText;

	document.querySelector('#labelPesquisar').innerText = 'Pesquisar por ' + param;
});

document.getElementById('pesquisar').addEventListener('keyup', e => {
	if (e.currentTarget.value.length > 1 || e.currentTarget.value == '') {
		let nome = e.currentTarget.value.trim();
		let param = document.querySelector('#selectPesquisar option:checked').value;
		param = param.substring(0, 1).toUpperCase() + param.substring(1);

		if (document.getElementById('selectPesquisar').value == '') {
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
});

document.getElementById('confirmaExport').addEventListener('click', () => {
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
});

document.getElementById('btExcluirTodos').addEventListener('click', () => {
	let instance = M.Modal.getInstance($('#modal5').modal());
	instance.open();
});

document.getElementById('confirmaExcluir').addEventListener('click', () => {
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
});

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

const itens = document.querySelectorAll("#tabela thead tr th");

for (const item of itens) {

	item.addEventListener('click', e => {

		let nome = document.getElementById('pesquisar').value.trim();
		let valor = e.currentTarget.innerText.substring(0, 1).toUpperCase() + e.currentTarget.innerText.substring(1).toLowerCase();
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
					var objetoJSON = response;
					montarTabela(objetoJSON);
				},
				error: err => {
					console.log(err);
				}
			});
		}
	});
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

	selecionaLinha();
}

let selecionaLinha = () => {
	$('#tabela').find('tr').on('click', e => {
		document.getElementById('id').value = $(e.currentTarget).find('td:first').text();
		document.getElementById('quarto').value = $(e.currentTarget).find('td:eq(3)').text();
	});
}

