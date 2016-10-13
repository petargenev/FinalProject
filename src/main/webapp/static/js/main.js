/*price range*/

$('#sl2').slider();

var RGBChange = function() {
	$('#RGB').css(
			'background',
			'rgb(' + r.getValue() + ',' + g.getValue() + ',' + b.getValue()
					+ ')')
};

/* scroll to top */

$(document).ready(function() {
	$(function() {
		$.scrollUp({
			scrollName : 'scrollUp', // Element ID
			scrollDistance : 300, // Distance from top/bottom before showing
			// element (px)
			scrollFrom : 'top', // 'top' or 'bottom'
			scrollSpeed : 300, // Speed back to top (ms)
			easingType : 'linear', // Scroll to top easing (see
			// http://easings.net/)
			animation : 'fade', // Fade, slide, none
			animationSpeed : 200, // Animation in speed (ms)
			scrollTrigger : false, // Set a custom triggering element. Can be
			// an HTML string or jQuery object
			// scrollTarget: false, // Set a custom target element for scrolling
			// to the top
			scrollText : '<i class="fa fa-angle-up"></i>', // Text for element,
			// can contain HTML
			scrollTitle : false, // Set a custom <a> title if required.
			scrollImg : false, // Set true to use image
			activeOverlay : false, // Set CSS color to display scrollUp active
			// point, e.g '#00FFFF'
			zIndex : 2147483647
		// Z-Index for the overlay
		});
	});
});

function Validatebodypanelbumper(theForm) {
	var regexp;
	var extension = new FormData(theForm).get("file").value.lastIndexOf('.');
	if ((extension.toLowerCase() != ".gif")
			&& (extension.toLowerCase() != ".jpg") && (extension != "")) {
		alert("The \"FileUpload\" field contains an unapproved filename.");
		theForm.file.focus();
		return false;
	}
	return true;
}

function getId(item) {
	var itemId = item.id
	var itemName = item.name;
	// var url = '@Url.Action("UpdateReport/", "Report")';
	var data = {
		Article : itemName,
		Id : itemId

	};
	if (confirm("Сигурни ли сте, че искате да добавите дадения артикул в количката си ?") == true) {
		document.getElementById(itemId).disabled = true; 
		$.post("getArticleId", data, function(result) {
			if (result === "Article exists!") {
				alert("Артикулът, който опитвате да добавите е вече в количката ви!");
			}

		});
    } else {
       
    }
	
}

s

function getIdAndRemove(item) {
	var itemId = item.id
	var itemName = item.name;
	// var url = '@Url.Action("UpdateReport/", "Report")';
	var data = {
		Article : itemName,
		Id : itemId

	};
	if (confirm("Сигурни ли сте, че искате да добавите дадения артикул в количката си ?") == true){
	$.post("removeArticle", data, function(result) {
		// var id = '#postedFor' + postId;
		// $(id).html(result);

	});
	}
	location.reload();
}

function addArticle() {
    
    
   
}
