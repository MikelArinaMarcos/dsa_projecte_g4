/******************************************/
/* JAVASCRIPT PARA EL PROCESO DE LOGIN */
/******************************************/
$(document).ready(function(){
    $('#loginBtn').click(function(event){
        event.preventDefault();
        // Obtener los datos del formulario
        var mail = $('#maill').val();
        var password = $('#passwordd').val();

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
                location.href = "/shop.html";
                // Redirigir o realizar otras acciones después del inicio de sesión exitoso
                // location.href = "/ruta-a-la-página-post-login";
            })
            .fail(function(xhr, err){
                console.log("ERROR", err);
                alert("Inicio de sesión fallido. Por favor, revisa los datos introducidos.");
            });

        return true;
    });
});

