function validateInput(){
    var textInput = document.getElementById("name").value;
    textInput = textInput.replace(/[^A-Za-z]/g, "");
    document.getElementById("name").value = textInput;
}