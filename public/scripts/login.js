$(document).ready(function() {
    $('#loginBtn').click(function(event){
        event.preventDefault();

        var mail = $("#email").val();
        var password = $("#password").val();
        console.log(mail,password);
        if (mail == '' || password == '') {
            alert('Por favor, complete todos los campos.');
            return;
        }

        if (!isValidEmail(mail)) {
            alert('Por favor, introduzca un correo electrónico válido.');
            return;
        }

        $.ajax({
            url: "/dsaApp/users/login",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                mail: mail,
                password: password
            }),
            success: function(response) {
                alert("Inicio de sesión exitoso");
                // Redirige a la tienda utilizando la función desde index.js
                location.href = "/shop.html";
            },
            error: function(error) {
                alert("Usuario o contraseña incorrectos");
            }
        });
    });

    function isValidEmail(email) {
        var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return emailRegex.test(email);
    }
});


