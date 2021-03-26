function formValidate() {

    document.getElementById("email").innerHTML = "";

    var pass = document.getElementById("password-5").value;
    var email = document.getElementById("email").value;
    var emailreg = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
    var isEmailValid = emailreg.test(email);

    $("#inputErr").remove();

    if(email == "" | pass == ""){

        document.getElementById("invalidInput").innerHTML = "<span style=\"color: #ff0000;\">Please enter the missing fields</span>";
    }
    else if (!isEmailValid){
        // document.getElementById("email").value = "";
        document.getElementById("invalidInput").innerHTML = "<span style=\"color: #ff0000;\">Invalid email or password.</span>";

        return false;
    }
}


document.getElementById("lgnBtn").addEventListener("click", formValidate);

       