function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();

		reader.onload = function(e) {
			$('#blah').attr('src', e.target.result).width(150).height(100);
		};

		reader.readAsDataURL(input.files[0]);
	}
}

function readURLTablet(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();

		reader.onload = function(e) {
			$('#tabletImage').attr('src', e.target.result).width(150).height(100);
		};

		reader.readAsDataURL(input.files[0]);
	}
}

function readURLLaptop(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();

		reader.onload = function(e) {
			$('#laptopImage').attr('src', e.target.result).width(150).height(100);
		};

		reader.readAsDataURL(input.files[0]);
	}
}