$(function() {

	$('.modal').modal();

	carregaQuartos();
	
	/*
	 * $('#divSelect').on('click', function() { if($('li').length == 1) {
	 * alert('Não há quartos disponíveis'); } });
	 */

	$('#btListar, #btExcluir, #comboBox').on('click', function() {
		$('.validate').removeAttr('required');
	});
	
	/*
	 * $('#btCadastrar').on('click', function() { var email = $('#email').val();
	 * $.ajax({ type: 'GET', url: 'hospedes', data: { opcao : 'validaCadastro',
	 * email : email }, dataType: 'JSON', success: function(response) { if
	 * (response) { $('#modal4').modal('open'); } else {
	 * $('#formHospedes').submit(); } }, error: function (err) {
	 * console.log(err); } }); });
	 */

	/*
	 * $('#btExcluir').on('click', function() { var confirmacao = confirm('Tem
	 * certeza que deseja excluir todas as reservas?');
	 * 
	 * if (confirmacao) { return true; } else { return false; } });
	 */

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
				$('#modal2').modal('open');
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
				$('#modal3').modal('open');
				return false;
			}
		}
	});
});

function montarCombobox(data) {
	$('#comboBox').append(
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