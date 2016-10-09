'use strict;'
function check(input) {
	if (input.value != document.getElementById('userPsw').value) {
		input.setCustomValidity('Двете пароли не съвпадат!');
	} else {
		// input is valid -- reset the error message
		input.setCustomValidity('');
	}
}
