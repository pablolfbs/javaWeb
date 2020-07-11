/*var app = angular.module('mainModule', []);

app.controller('mainController', function($scope, $http) { // o scope liga o js
															// e o template
	$scope.nome = 'Valor Inicial';
	// $http.get().success();
	$scope.reset = function() {
		$scope.nome = '';
	}
	
});*/


document.getElementById('botao').onclick = () => {
	window.localStorage.setItem('login', document.getElementById('email').value);
	window.localStorage.setItem('senha', document.getElementById('password').value);
}

document.getElementById('email').value = localStorage.login;
document.getElementById('password').value = localStorage.senha;

