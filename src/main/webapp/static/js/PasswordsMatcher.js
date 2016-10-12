'use strict;'
function check(input) {
	if (input.value != document.getElementById('userPsw').value) {
		input.setCustomValidity('Двете пароли не съвпадат!');
	} else {
		// input is valid -- reset the error message
		input.setCustomValidity('');
	}
}

//function checkEmailAvailability() {
//	var email = $(".mailRegistration");
//	var emailRegex = new RegExp(/^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/);
//
//	if (emailRegex.test(email)) {
//		$.post("ValidationServlet", {email: email.val()}, function(result) {
//			if (result === true) {
//				emailExist = true;
//				email.attr('data-original-title', 'Емайла вече е зает. Моля, въведете нов.').tooltip().mouseover();
//			} else if(result === false) {
//				emailExist = false;
//				email.tooltip('destroy');
//				email.attr('title', 'Въведете валиден Email адрес!');
//			}
//		});
//	}
//	
//	console.log('testssad')
//}
//
//var emailExist = false;
//checkEmailAvailability()