/*var app = angular.module('mainModule', []);

app.controller('mainController', function($scope, $http) { // o scope liga o js
															// e o template
	$scope.nome = 'Valor Inicial';
	// $http.get().success();
	$scope.reset = function() {
		$scope.nome = '';
	}
	
});*/

document.getElementById('remember-me').checked = JSON.parse(localStorage.opcao);
document.getElementById('email').value = !localStorage.login ? '' : localStorage.login;
document.getElementById('password').value = !localStorage.senha ? '' : localStorage.senha;

document.getElementById('botao').onclick = () => {
	if (document.getElementById('remember-me').checked) {
		window.localStorage.setItem('login', document.getElementById('email').value);
		window.localStorage.setItem('senha', document.getElementById('password').value);
	} else {
		window.localStorage.removeItem('login');
		window.localStorage.removeItem('senha');
	}
	window.localStorage.setItem('opcao', document.getElementById('remember-me').checked);
}


