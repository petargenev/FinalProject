function validateForm() {
	var name = document.forms["registerForm"]["name"].value;
	var email = document.forms["registerForm"]["email"].value;
	var alphaExp = /^[a-zA-Z]+$/;

	var password = document.forms["registerForm"]["password"].value;
	if ((name == null || name == "") || (email == null || email == "")
			|| (password == null || password == "")) {

		alert("Моля попълнете всички полета!");
		return false;
	}

}

function validateLoginForm() {
	var email = document.forms["loginForm"]["email"].value;
	var password = document.forms["loginForm"]["password"].value;
	
	if ((email == null || email == "") || (password == null || password == "")
		) {

		alert("Моля попълнете всички полета!");
		return false;
	}

}

//function validateComputerForm() {
//	var label = document.forms["computerForm"]["label"].value;
//	// var model = document.forms["computerForm"]["model"].value;
//	// var price = document.forms["computerForm"]["price"].value;
//	// var ram = document.forms["computerForm"]["ram"].value;
//	// var processorSpeed =
//	// document.forms["computerForm"]["processorSpeed"].value;
//	// var operationSystem =
//	// document.forms["computerForm"]["operationSystem"].value;
//	// var hdd = document.forms["computerForm"]["hdd"].value;
//	// var processorType =
//	// document.forms["computerForm"]["processorType"].value;
//	// var videoCardType =
//	// document.forms["computerForm"]["videoCardType"].value;
//	// var file = document.forms["computerForm"]["file"].value;
//
//	var alphaExp = /^[a-zA-Z]+$/;
//
//	if ((label == null || label == "")
//	// (price == null || price == "") ||
//	// (ram == null || ram == "") ||
//	// (processorSpeed == null || processorSpeed == "") ||
//	// (operationSystem == null || operationSystem == "") ||
//	// (hdd == null || hdd == "") ||
//	// (processorType == null || processorType == "") ||
//	// (model == null || model == "") ||
//	// (videoCardType == null || videoCardType == "") ||
//	// (file == null || file == "")
//	) {
//
//		alert("Моля попълнете всички полета!");
//		return false;
//	}
//}



function myFunction() {
    var x = document.getElementById("label").required;
    
}