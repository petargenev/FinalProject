function showComputer() {
	document.getElementById('computerDiv').style.display = "block";
	document.getElementById('tabletDiv').style.display = "none";
	document.getElementById('laptopDiv').style.display = "none";
	

}

function showTablet() {
	document.getElementById('tabletDiv').style.display = "block";
	document.getElementById('computerDiv').style.display = "none";
	document.getElementById('laptopDiv').style.display = "none";
}

function showLaptop() {
	document.getElementById('laptopDiv').style.display = "block";
	document.getElementById('computerDiv').style.display = "none";
	document.getElementById('tabletDiv').style.display = "none";
}



function clearComputerFields(){
	$('#computerForm')[0].reset();
}