/******************************************/
/* JAVASCRIPT PARA EL PROCESO DE LOGIN */
/******************************************/
$(document).ready(function(){
    $('#loginBtn').click(function(event){
        event.preventDefault();
        // Obtener los datos del formulario
        var mail = $('#mail').val();
        var password = $('#password').val();

        // Crear el objeto de datos para enviar al servidor
        var body = {
            "mail": mail,
            "password": password
        };

        // Enviar la solicitud POST al servidor para el inicio de sesión
        $.post({
            url: '/dsaApp/usuario/login', // Ajusta la URL según tu estructura de carpetas y rutas
            data: JSON.stringify(body),
            contentType: 'application/json; charset=utf8'
        })
            .done(function (data, status){
                alert("¡Inicio de sesión exitoso!");
                localStorage.setItem("mail", mail);
                location.href = "/principal.html";
            })
            .fail(function(xhr, err){
                console.log("ERROR", err);
                alert("Inicio de sesión fallido. Por favor, revisa los datos introducidos.");
            });

        return true;
    });


});

