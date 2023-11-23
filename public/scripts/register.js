$(document).ready(function() {
    $('#signupButton').click(function(event){
        event.preventDefault();

        var mail = $("#mail").val();
        var username = $("#username").val();
        var password = $("#password").val();
        var password2 = $("#password2").val();

        if (mail == '' || username == '' || password == '' || password2 == '') {
            alert('Por favor, complete todos los campos.');
            return;
        }

        if (!isValidEmail(mail)) {
            alert('Por favor, introduzca un correo electrónico válido.');
            return;
        }

        $.ajax({
            url: "/dsaApp/users/register",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                mail: mail,
                username: username,
                password: password
            }),
            success: function(response) {
                alert("User registrado correctamente");
                document.location= "/login.html";
            },
            error: function(error) {
                alert("Usuario o contraseña incorrectos");
            }
        });
    });

    function isValidEmail(email) {
        var emailRegex = /^[^\s@]+@[^\s@]+.[^\s@]+$/;
        return emailRegex.test(email);
    }
});