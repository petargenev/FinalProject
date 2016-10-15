//function readURL(input) {
//	if (input.files && input.files[0]) {
//		var reader = new FileReader();
//
//		reader.onload = function(e) {
//			$('#computerImage').attr('src', e.target.result).width(150).height(100);
//		};
//
//		reader.readAsDataURL(input.files[0]);
//	}
//}
//
//function readURLTablet(input) {
//	if (input.files && input.files[0]) {
//		var reader = new FileReader();
//
//		reader.onload = function(e) {
//			$('#tabletImage').attr('src', e.target.result).width(150).height(
//					100);
//		};
//
//		reader.readAsDataURL(input.files[0]);
//	}
//}
//
//function readURLLaptop(input) {
//	if (input.files && input.files[0]) {
//		var reader = new FileReader();
//
//		reader.onload = function(e) {
//			$('#laptopImage').attr('src', e.target.result).width(150).height(
//					100);
//		};
//
//		reader.readAsDataURL(input.files[0]);
//	}
//}



//document.getElementById("fileChooser").onchange = function () {
//    var reader = new FileReader();
//    if(this.files[0].size>1500000){
//    	document.getElementById("submitBtn").disabled = true;
//        document.getElementById('warning').style.display = 'block';
//        
//        alert("Image Size should not be greater than 500Kb");
//        
//        $("#menu_image").attr("src","blank");
//        $("#menu_image").hide();  
//        $('#menu_images').wrap('<form>').closest('form').get(0).reset();
//        $('#menu_images').unwrap();
//        
//        return false;
//    }
//    if(this.files[0].type.indexOf("image")==-1){
//        alert("Invalid Type");
//        $("#menu_image").attr("src","blank");
//        $("#menu_image").hide();  
//        $('#menu_images').wrap('<form>').closest('form').get(0).reset();
//        $('#menu_images').unwrap();         
//        return false;
//    }   
//    reader.onload = function (e) {
//        // get loaded data and render thumbnail.
//    	document.getElementById("submitBtn").disabled = false;
//        document.getElementById('warning').style.display = 'none';
//        
//        document.getElementById("menu_image").src = e.target.result;
//        $("#menu_image").show(); 
//    };
//
//    
//    reader.readAsDataURL(this.files[0]);
//};
