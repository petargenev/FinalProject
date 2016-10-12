function validateForm() {
    var name = document.forms["registerForm"]["name"].value;
    var email = document.forms["registerForm"]["email"].value;
    var alphaExp = /^[a-zA-Z]+$/;
    
    var password = document.forms["registerForm"]["password"].value;
    if ((name == null || name == "") || 
    	(email == null || email == "") || 
    	(password == null || password == "")) {
    	
        alert("Моля попълнете всички полета!");
        return false;
    }
    
   
}