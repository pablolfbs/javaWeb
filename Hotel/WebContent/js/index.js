$(() => {

	$('.tooltipped').tooltip();

	carregaQuartos();

	$('#divSelect').on('click', () => {
		if ($('li').length == 1) {
			var instance = M.Modal.getInstance($('#modal9').modal());
			instance.open();
		}
	});

	$('#btListar, #btExcluir, #comboBox, #btLogout').on('click', () => {
		$('.validate').removeAttr('required');
	});

	$('#btLimpar').on('click', () => {
		limparCampos();
	});

	$('#btCadastrar').on('click', () => {
		var acao = 'validaCadastro';
		var nome = $('#first_name').val();
		var cpf = $('#cpf').val();
		var email = $('#email').val();
		var quarto = $('#comboBox').val();
		var dtEntrada = $('#dtEntrada').val();
		var dtSaida = $('#dtSaida').val();

		if (nome == '' || email == '' || cpf == '' || quarto == null) {
			var instance = M.Modal.getInstance($('#modal6').modal());
			instance.open();
		} else {
			validaCadastro(acao, nome, cpf, email, quarto, dtEntrada, dtSaida);
		}
	});

	$('#btExcluir').on('click', () => {
		$.ajax({
			type: 'GET',
			url: 'entrada',
			data: {
				acao: 'verificaReservas'
			},
			dataType: 'JSON',
			success: response => {
				if (response == '') {
					var instance = M.Modal.getInstance($('#modal3').modal());
					instance.open();
				} else {
					var instance = M.Modal.getInstance($('#modal1').modal());
					instance.open();
				}
			},
			error: err => {
				console.log(err);
			}
		});
	});

	$('#confirmaExcluir').on('click', () => {
		$.ajax({
			type: 'GET',
			url: 'entrada',
			data: {
				acao: 'excluirTodos'
			},
			dataType: 'JSON',
			success: () => {
				carregaQuartos();
				var instance = M.Modal.getInstance($('#modal2').modal());
				instance.open();
			},
			error: err => {
				console.log(err);
			}
		});
	});

	$('#btCadastrar').on('click', () => {
		if ($('select option:selected').val() == '') {
			if ($('#first_name').val() != '' && $('#email').val() != '') {
				/* alert('Por favor, escolha um quarto!'); */
				$('#modal4').modal('open');
				return false;
			}
		}
	});
});

var validaCadastro = (acao, nome, cpf, email, quarto, dtEntrada, dtSaida) => {
	$.ajax({
		type: 'GET',
		url: 'entrada',
		data: {
			acao: acao,
			email: email
		},
		dataType: 'JSON',
		success: response => {
			if (response) {
				var instance = M.Modal.getInstance($('#modal5').modal());
				instance.open();
			} else {
				/*$('#formHospedes').submit();*/
				cadastrarReserva(nome, cpf, email, quarto, dtEntrada, dtSaida);
			}
		},
		error: err => {
			console.log(err);
			var instance = M.Modal.getInstance($('#modal8').modal());
			instance.open();
		}
	});
}

var cadastrarReserva = (nome, cpf, email, quarto, dtEntrada, dtSaida) => {
	$.ajax({
		type: "POST",
		url: "entrada",
		data: {
			acao: "cadastrarHospede",
			nome: nome,
			cpf: cpf,
			email: email,
			quarto: quarto,
			dtEntrada: dtEntrada,
			dtSaida: dtSaida
		},
		dataType: "JSON",
		success: () => {
			var instance = M.Modal.getInstance($('#modal7').modal());
			instance.open();

			limparCampos();
		},
		error: err => {
			console.log(err);
			var instance = M.Modal.getInstance($('#modal8').modal());
			instance.open();
		}
	});
}

var limparCampos = () => {
	$('#first_name').removeClass('valid').val('').removeClass('invalid').val('').next().removeClass('active');
	$('#cpf').removeClass('valid').val('').removeClass('invalid').val('').next().removeClass('active');
	$('#email').removeClass('valid').val('').removeClass('invalid').val('').next().removeClass('active');
	carregaQuartos();
	$('#dtEntrada').removeClass('valid').val('').next().removeClass('active');
	$('#dtSaida').removeClass('valid').val('').next().removeClass('active');

}

var montarCombobox = data => {
	$('#comboBox').html(
		'<option value="" disabled selected >Escolha seu quarto</option>');
	//	for (let i = 0; i < data.length; i++) {
	//		$('#comboBox').append(
	//				'<option value="' + data[i].num + '">' + data[i].num + '</option>');
	//	}

	// exemplo de enhanced for feito com arrow functions.
	data.map(d => $('#comboBox').append('<option value="' + d.num + '">' + d.num + '</option>'));

	$('select').formSelect();
}

var carregaQuartos = () => {
	$.ajax({
		type: 'GET',
		url: 'entrada',
		data: {
			acao: 'carregaQuartos'
		},
		dataType: 'JSON',
		success: response => {
			montarCombobox(response);
		},
		error: err => {
			console.log(err);
		}
	});
}