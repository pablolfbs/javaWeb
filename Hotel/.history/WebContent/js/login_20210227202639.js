/*var app = angular.module('mainModule', []);

app.controller('mainController', function($scope, $http) { // o scope liga o js
															// e o template
	$scope.nome = 'Valor Inicial';
	// $http.get().success();
	$scope.reset = function() {
		$scope.nome = '';
	}
	
});*/

document.getElementById('remember-me').checked = localStorage.opcao ? JSON.parse(localStorage.opcao) : window.localStorage.setItem('opcao', document.getElementById('remember-me').checked);
document.getElementById('email').value = !sessionStorage.login ? '' : sessionStorage.login;
document.getElementById('password').value = !sessionStorage.senha ? '' : sessionStorage.senha;

document.getElementById('botao').onclick = () => {
	
	if (document.getElementById('remember-me').checked) {
		window.sessionStorage.setItem('login', document.getElementById('email').value);
		window.sessionStorage.setItem('senha', document.getElementById('password').value);
		
	} else {
		window.sessionStorage.removeItem('login');
		window.sessionStorage.removeItem('senha');
	}
	
	window.localStorage.setItem('opcao', document.getElementById('remember-me').checked);
}

document.getElementById('teste').addEventListener('click', () => {
	/*axios.get('entrada?acao=esqueciSenha')
		.then(() => {
			alert('ok');
		})
		.catch(err => {
			console.log(err);
		});*/

	$.ajax({
		type: 'GET',
		url: 'entrada',
		data: {
			acao: 'esqueciSenha'
		},
		dataType: 'JSON',
		success: () => {
			console.log('ok');
		},
		error: err => {
			console.log(err);
		}
	});
});


