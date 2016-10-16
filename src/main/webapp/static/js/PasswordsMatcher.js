'use strict;'
function check(input) {
	if (input.value != document.getElementById('userPsw').value) {
		input.setCustomValidity('Двете пароли не съвпадат!');
	} else {
		// input is valid -- reset the error message
		input.setCustomValidity('');
	}
}

function checkEmailAvailability() {
	var email = $(".mailRegistration");
	var emailRegex = new RegExp(/^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/);
	console.log('here')
	if (emailRegex.test(email.val())) {
		$.post("emailAvailability", {email: email.val()}, function(result) {
			console.log(result)
			if (result === "true") {
				console.log(result)
				emailExist = true;
				email.tooltip('destroy');
				email.attr('title', 'Емейла вече е зает или не отговаря на изискванията. Моля, въведете нов.').tooltip().mouseover();
				document.getElementById("registerBtn").disabled = true; 
			} else if(result === "false") {
				emailExist = false;
				console.log(result)
				email.tooltip('destroy');
				email.attr('title', 'Емейла е свободен.').tooltip().mouseover();
				document.getElementById("registerBtn").disabled = false; 
			}
		});
	}
}
//
//var emailExist = false;
//checkEmailAvailability()