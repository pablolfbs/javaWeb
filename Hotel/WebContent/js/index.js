$(function() {

	$('.tooltipped').tooltip();

	carregaQuartos();

	/*
	 * $('#divSelect').on('click', function() { if($('li').length == 1) {
	 * alert('Não há quartos disponíveis'); } });
	 */

	$('#btListar, #btExcluir, #comboBox').on('click', function() {
		$('.validate').removeAttr('required');
	});

	$('#btCadastrar').on('click', function() {
		let opcao = 'validaCadastro';
		let nome = $('#first_name').val();
		let cpf = $('#cpf').val();
		let email = $('#email').val();
		let quarto = $('#comboBox').val();
		
		if (nome == '' || email == '' || cpf == '' || quarto == null) {
			var instance = M.Modal.getInstance($('#modal6').modal());
			instance.open();
		} else {
			$.ajax({
				type : 'GET',
				url : 'hospedes',
				data : {
					opcao : opcao,
					email : email
				},
				dataType : 'JSON',
				success : function(response) {
					if (response) {
						var instance = M.Modal.getInstance($('#modal5').modal());
						instance.open();
					} else {
						$('#formHospedes').submit();
					}
				},
				error : function(err) {
					console.log(err);
				}
			});
		}
	});

	$('#btExcluir').on('click', function() {
		$.ajax({
			type : 'GET',
			url : 'hospedes',
			data : {
				opcao : 'verificaReservas'
			},
			dataType : 'JSON',
			success : function(response) {
				if (response == '') {
					var instance = M.Modal.getInstance($('#modal3').modal());
					instance.open();
				} else {
					var instance = M.Modal.getInstance($('#modal1').modal());
					instance.open();
				}
			},
			error : function(err) {
				console.log(err);
			}
		});
	});
	
	$('#btLimpar').on('click', function() {
		$('#first_name').val('');
		$('#cpf').val('');
		$('#email').val('');
		carregaQuartos();
	});

	$('.waves-green').on('click', function() {
		$.ajax({
			type : 'GET',
			url : 'hospedes',
			data : {
				opcao : 'excluir'
			},
			dataType : 'JSON',
			success : function(response) {
				carregaQuartos();
				var instance = M.Modal.getInstance($('#modal2').modal());
				instance.open();
			},
			error : function(err) {
				console.log(err);
			}
		});
	});

	$('#btCadastrar').on('click', function() {
		if ($('select option:selected').val() == '') {
			if ($('#first_name').val() != '' && $('#email').val() != '') {
				/* alert('Por favor, escolha um quarto!'); */
				$('#modal4').modal('open');
				return false;
			}
		}
	});
});

function montarCombobox(data) {
	$('#comboBox').html(
			'<option value="" disabled selected >Escolha seu quarto</option>');
	for (let i = 0; i < data.length; i++) {
		$('#comboBox').append(
				'<option value="' + data[i].num + '">' + data[i].num
						+ '</option>');
	}

	// exemplo de enhanced for feito com arrow functions.
	// data.map(data => $('#comboBox').append('<option value="' + data.num +
	// '">' + data.num + '</option>'));

	$('select').formSelect();
}

function carregaQuartos() {
	$.ajax({
		type : 'GET',
		url : 'quartos',
		dataType : 'JSON',
		success : function(response) {
			$('#comboBox').text('');
			montarCombobox(response);
		},
		error : function(err) {
			console.log(err);
		}
	});
}