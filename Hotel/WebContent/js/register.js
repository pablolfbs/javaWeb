$(() => {
	
	$('.tooltipped').tooltip();
	
	registra.onclick = validaRegistro;
	
});

var password = document.getElementById("password")
	, password2 = document.getElementById("password2");

var validatePassword = () => {
	if (password.value != password2.value) {
		password2.setCustomValidity("Passwords Don't Match");
	} else {
		password2.setCustomValidity('');
	}
}

password.onchange = validatePassword;
password2.onkeydown = validatePassword;

var registra = document.getElementById('btRegistrar');

var validaRegistro = () => {
	var email = document.getElementById('email').value;
	var password = document.getElementById('email').value;
	
	if (email == "" && password == "") {
		var instance = M.Modal.getInstance($('#modal1').modal());
		instance.open();
	} else {
		var new_elem = document.createElement('div');
		new_elem.innerHTML = '<input type="hidden" name="acao" value="registro" />';
		document.getElementById('formRegistro').append(new_elem);
		document.getElementById('formRegistro').submit();
	}
}