$(() => {

	$('.tooltipped').tooltip();

});

const listaIds = document.querySelectorAll('#btListar, #btExcluir, #comboBox, #btLogout');

for (const id of listaIds) {
	id.addEventListener('click', () => {
		$('.validate').removeAttr('required');
	});
}

document.getElementById('divSelect').addEventListener('click', () => {
	if (document.querySelectorAll('li').length == 1) {

		let instance = M.Modal.getInstance($('#modal9').modal());
		instance.open();
	}
});

document.getElementById('btExcluir').addEventListener('click', () => {
	axios.get('entrada?acao=verificaReservas')
		.then(response => {
			if (response.data == '') {
				let instance = M.Modal.getInstance($('#modal3').modal());
				instance.open();
			} else {
				let instance = M.Modal.getInstance($('#modal1').modal());
				instance.open();
			}
			limparCampos();
		})
		.catch(err => {
			console.log(err);
		});

	/*$.ajax({
		type: 'GET',
		url: 'entrada',
		data: {
			acao: 'verificaReservas'
		},
		dataType: 'JSON',
		success: response => {
			if (response == '') {
				const instance = M.Modal.getInstance($('#modal3').modal());
				instance.open();
			} else {
				const instance = M.Modal.getInstance($('#modal1').modal());
				instance.open();
			}
		},
		error: err => {
			console.log(err);
		}
	});*/
});

document.getElementById('confirmaExcluir').addEventListener('click', () => {
	axios.get('entrada?acao=excluirTodos')
		.then(() => {
			carregaQuartos();
			let instance = M.Modal.getInstance($('#modal2').modal());
			instance.open();
		})
		.catch(err => {
			console.log(err);
		})

	/*$.ajax({
		type: 'GET',
		url: 'entrada',
		data: {
			acao: 'excluirTodos'
		},
		dataType: 'JSON',
		success: () => {
			carregaQuartos();
			let instance = M.Modal.getInstance($('#modal2').modal());
			instance.open();
		},
		error: err => {
			console.log(err);
		}
	});*/
});

document.getElementById('btCadMock').addEventListener('click', () => {
	axios.post('entrada?acao=mock')
		.then(response => {
			if (response.data) {
				let instance = M.Modal.getInstance($('#modal7').modal());
				instance.open();
			} else {
				let instance = M.Modal.getInstance($('#modal9').modal());
				instance.open();
			}
			limparCampos();
		})
		.catch(err => {
			console.log(err);
		});

	/*$.ajax({
		type: 'POST',
		url: 'entrada',
		data: {
			acao: 'mock'
		},
		dataType: 'JSON',
		success: response => {
			if (response) {
				let instance = M.Modal.getInstance($('#modal7').modal());
				instance.open();
			} else {
				let instance = M.Modal.getInstance($('#modal9').modal());
				instance.open();
			}
			limparCampos();
		},
		error: err => {
			console.log(err);
		}
	});*/
});

document.getElementById('btCadMockAll').addEventListener('click', () => {
	axios.post('entrada?acao=mockAll')
		.then(response => {
			if (response.data) {
				let instance = M.Modal.getInstance($('#modal10').modal());
				instance.open();
			} else {
				let instance = M.Modal.getInstance($('#modal9').modal());
				instance.open();
			}
			limparCampos();
		})
		.catch(err => {
			console.log(err);
		});

	/*$.ajax({
		type: 'POST',
		url: 'entrada',
		data: {
			acao: 'mockAll'
		},
		dataType: 'JSON',
		success: response => {
			if (response) {
				let instance = M.Modal.getInstance($('#modal10').modal());
				instance.open();
			} else {
				let instance = M.Modal.getInstance($('#modal9').modal());
				instance.open();
			}
			limparCampos();
		},
		error: err => {
			console.log(err);
		}
	});*/
});

document.getElementById('cpf').addEventListener('keypress', evt => {
	var theEvent = evt || window.event;
	var key = theEvent.keyCode || theEvent.which;
	key = String.fromCharCode(key);
	//var regex = /^[0-9.,]+$/;
	var regex = /^[0-9.]+$/;
	if (!regex.test(key)) {
		theEvent.returnValue = false;
		if (theEvent.preventDefault) theEvent.preventDefault();
	}
});

document.getElementById('btCadastrar').addEventListener('click', () => {
	const acao = 'validaCadastro';
	const nome = document.getElementById('first_name').value;
	const cpf = document.getElementById('cpf').value;
	const email = document.getElementById('email').value;
	const quarto = document.getElementById('comboBox').value;
	const dtEntrada = document.getElementById('dtEntrada').value;
	const dtSaida = document.getElementById('dtSaida').value;

	if (!quarto) {
		let instance = M.Modal.getInstance($('#modal4').modal());
		instance.open();
	} else if (cpf.length != 11) {
		let instance = M.Modal.getInstance($('#modal11').modal());
		instance.open();
	} else if (nome == '' || email == '') {
		let instance = M.Modal.getInstance($('#modal6').modal());
		instance.open();
	} else {
		validaCadastro(acao, nome, cpf, email, quarto, dtEntrada, dtSaida);
	}
});

var limparCampos = () => {
	$('#first_name').removeClass('valid').val('').removeClass('invalid').val('').next().removeClass('active');
	$('#cpf').removeClass('valid').val('').removeClass('invalid').val('').next().removeClass('active');
	$('#email').removeClass('valid').val('').removeClass('invalid').val('').next().removeClass('active');
	carregaQuartos();
	$('#dtEntrada').removeClass('valid').val('').next().removeClass('active');
	$('#dtSaida').removeClass('valid').val('').next().removeClass('active');
}

document.getElementById('btLimpar').onclick = limparCampos;

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
				let instance = M.Modal.getInstance($('#modal5').modal());
				instance.open();
			} else {
				// $('#formHospedes').submit();
				cadastrarReserva(nome, cpf, email, quarto, dtEntrada, dtSaida);
			}
		},
		error: err => {
			console.log(err);
			let instance = M.Modal.getInstance($('#modal8').modal());
			instance.open();
		}
	});
}

var cadastrarReserva = (nome, cpf, email, quarto, dtEntrada, dtSaida) => {
	axios.post('entrada?acao=cadastrarHospede', {
			nome: nome,
			cpf: cpf,
			email: email,
			quarto: quarto,
			dtEntrada: dtEntrada,
			dtSaida: dtSaida
		})
		.then(() => {
			let instance = M.Modal.getInstance($('#modal7').modal());
			instance.open();

			limparCampos();
		})
		.catch(err => {
			console.log(err);
			let instance = M.Modal.getInstance($('#modal8').modal());
			instance.open();
		});

	/*$.ajax({
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
			let instance = M.Modal.getInstance($('#modal7').modal());
			instance.open();

			limparCampos();
		},
		error: err => {
			console.log(err);
			let instance = M.Modal.getInstance($('#modal8').modal());
			instance.open();
		}
	});
}

var montarCombobox = data => {
	document.getElementById('comboBox').innerHTML =
		'<option value="" disabled selected >Escolha seu quarto</option>';
	//	for (let i = 0; i < data.length; i++) {
	//		$('#comboBox').append('<option value="' + data[i].num + '">' + data[i].num + '</option>');
	//	}

	// exemplo de enhanced for feito com arrow functions.
	data.data.map(d => $('#comboBox').append('<option value="' + d.num + '">' + d.num + '</option>'));

	$('select').formSelect();
}

var carregaQuartos = () => {
	axios.get('entrada?acao=carregaQuartos')
		.then(response => {
			montarCombobox(response);
		})
		.catch(err => {
			console.log(err);
		});

	/*$.ajax({
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
	});*/
}

carregaQuartos();

