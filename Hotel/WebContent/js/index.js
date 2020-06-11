$(function() {
	
	$('.tooltipped').tooltip();
	
	carregaQuartos();

	$('#divSelect').on('click', function() {
		if($('li').length == 1) {
			var instance = M.Modal.getInstance($('#modal9').modal());
			instance.open();
		}
	});

	$('#btListar, #btExcluir, #comboBox, #btLogout').on('click', function() {
		$('.validate').removeAttr('required');
	});
	
	$('#btLimpar').on('click', function() {
		limparCampos();
	});

	$('#btCadastrar').on('click', function() {
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

	$('#btExcluir').on('click', function() {
		$.ajax({
			type : 'GET',
			url : 'entrada',
			data : {
				acao : 'verificaReservas'
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
	
	$('#confirmaExcluir').on('click', function() {
		$.ajax({
			type : 'GET',
			url : 'entrada',
			data : {
				acao : 'excluirTodos'
			},
			dataType : 'JSON',
			success : function() {
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

function validaCadastro(acao, nome, cpf, email, quarto, dtEntrada, dtSaida) {
	$.ajax({
		type : 'GET',
		url : 'entrada',
		data : {
			acao : acao,
			email : email
		},
		dataType : 'JSON',
		success : function(response) {
			if (response) {
				var instance = M.Modal.getInstance($('#modal5').modal());
				instance.open();
			} else {
				/*$('#formHospedes').submit();*/
				cadastrarReserva(nome, cpf, email, quarto, dtEntrada, dtSaida);
			}
		},
		error : function(err) {
			console.log(err);
			var instance = M.Modal.getInstance($('#modal8').modal());
			instance.open();
		}
	});
}

function cadastrarReserva(nome, cpf, email, quarto, dtEntrada, dtSaida) {
	$.ajax({
	    type: "POST",
	    url: "entrada",
	    data: {
	    	acao : "cadastrarHospede",
	    	nome : nome,
	    	cpf : cpf,
	    	email : email,
	    	quarto : quarto,
	    	dtEntrada : dtEntrada,
	    	dtSaida : dtSaida
	    },
	    dataType: "JSON",
	    success: function () {
	    	var instance = M.Modal.getInstance($('#modal7').modal());
			instance.open();
			
			limparCampos();
	    },
		error : function(err) {
			console.log(err);
			var instance = M.Modal.getInstance($('#modal8').modal());
			instance.open();
		}
	});
}

function limparCampos() {
	$('#first_name').removeClass('valid').val('').next().removeClass('active');
	$('#cpf').removeClass('valid').val('').next().removeClass('active');
	$('#email').removeClass('valid').val('').next().removeClass('active');
	carregaQuartos();
	
}

function montarCombobox(data) {
	$('#comboBox').html(
			'<option value="" disabled selected >Escolha seu quarto</option>');
	for (let i = 0; i < data.length; i++) {
		$('#comboBox').append(
				'<option value="' + data[i].num + '">' + data[i].num + '</option>');
	}

	// exemplo de enhanced for feito com arrow functions.
	// data.map(data => $('#comboBox').append('<option value="' + data.num +
	// '">' + data.num + '</option>'));

	$('select').formSelect();
}

function carregaQuartos() {
	$.ajax({
		type : 'GET',
		url : 'entrada',
		data : {
			acao : 'carregaQuartos'
		},
		dataType : 'JSON',
		success : function(response) {
			montarCombobox(response);
		},
		error : function(err) {
			console.log(err);
		}
	});
}