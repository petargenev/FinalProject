
function ValidateFileUploadComputer() {
	var fuData = document.getElementById("computerImage");
	var FileUploadPath = fuData.value;
	// To check if user upload any file
	if (FileUploadPath == '') {
		alert("Please upload an image");

	} else {
		var Extension = FileUploadPath.substring(
				FileUploadPath.lastIndexOf('.') + 1).toLowerCase();

		// The file uploaded is an image

		if (Extension == "gif" || Extension == "png" || Extension == "bmp"
				|| Extension == "jpeg" || Extension == "jpg") {

			document.getElementById('computerBtn').style.display = 'block';
			document.getElementById('computerWarning').style.display = 'none';
			document.getElementById('imageC').style.display = 'block';

			if (fuData.files && fuData.files[0]) {
				var reader = new FileReader();

				reader.onload = function(e) {
					$('#imageC').attr('src', e.target.result).width(250).height(200);
				}

				reader.readAsDataURL(fuData.files[0]);
			}

		}

		// The file upload is NOT an image
		else {
			document.getElementById('computerBtn').style.display = 'none';
			document.getElementById('computerWarning').style.display = 'block';
			document.getElementById('imageC').style.display = 'none';
			alert("Снимката трябва да е от тип GIF, PNG, JPG, JPEG and BMP. ");

		}
	}
}

function ValidateFileUploadTablet() {
	var fuData = document.getElementById("tabletImage");
	var FileUploadPath = fuData.value;
	// To check if user upload any file
	if (FileUploadPath == '') {
		alert("Please upload an image");

	} else {
		var Extension = FileUploadPath.substring(
				FileUploadPath.lastIndexOf('.') + 1).toLowerCase();

		// The file uploaded is an image

		if (Extension == "gif" || Extension == "png" || Extension == "bmp"
				|| Extension == "jpeg" || Extension == "jpg") {

			document.getElementById('tabletBtn').style.display = 'block';
			document.getElementById('tabletWarning').style.display = 'none';
			document.getElementById('imageT').style.display = 'block';

			if (fuData.files && fuData.files[0]) {
				var reader = new FileReader();

				reader.onload = function(e) {
					$('#imageT').attr('src', e.target.result).width(250).height(200);
				}

				reader.readAsDataURL(fuData.files[0]);
			}

		}

		// The file upload is NOT an image
		else {

			document.getElementById('tabletBtn').style.display = 'none';
			document.getElementById('tabletWarning').style.display = 'block';
			document.getElementById('imageT').style.display = 'none';
			alert("Снимката трябва да е от тип GIF, PNG, JPG, JPEG and BMP. ");

		}
	}
}


function ValidateFileUploadLaptop() {
	var fuData = document.getElementById("laptopImage");
	var FileUploadPath = fuData.value;
	// To check if user upload any file
	if (FileUploadPath == '') {
		alert("Please upload an image");

	} else {
		var Extension = FileUploadPath.substring(
				FileUploadPath.lastIndexOf('.') + 1).toLowerCase();

		// The file uploaded is an image

		if (Extension == "gif" || Extension == "png" || Extension == "bmp"
				|| Extension == "jpeg" || Extension == "jpg") {

			document.getElementById('computerBtn').style.display = 'block';
			document.getElementById('laptopWarning').style.display = 'none';
			document.getElementById('imageL').style.display = 'block';

			if (fuData.files && fuData.files[0]) {
				var reader = new FileReader();

				reader.onload = function(e) {
					$('#imageL').attr('src', e.target.result).width(250).height(200);
				}

				reader.readAsDataURL(fuData.files[0]);
			}

		}

		// The file upload is NOT an image
		else {
			document.getElementById('laptopBtn').style.display = 'none';
			document.getElementById('laptopWarning').style.display = 'block';
			document.getElementById('imageL').style.display = 'none';
			
			alert("Снимката трябва да е от тип GIF, PNG, JPG, JPEG and BMP. ");

		}
	}
}
