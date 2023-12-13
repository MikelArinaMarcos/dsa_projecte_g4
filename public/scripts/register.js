/******************************************/
/* JAVASCRIPT PARA EL PROCESO DE REGISTRO */
/******************************************/

$(document).ready(function(){
    $('#signupButton').click(function(event){
        event.preventDefault();

        // Nos creamos variables para recoger los datos del formulario.

        var name = $('#name').val();
        var password = $('#password').val();
        var password2 = $('#password2').val();
        var mail = $('#mail').val();
        var username = $('#username').val();
        var lastName = $('#lastName').val();
        var bolivares = parseInt('0',10);
        var objetos = [
            {
                id:parseInt('0',10),
                rareza:parseInt('0',10),
                Nombre:"a",
                Precio:parseInt('0',10),
                Damage:parseInt('0',10),
            },
        ];
        var body = {
            "name": name,
            "password": password,
            "mail": mail,
            "username": username,
            "lastName": lastName,
            "bolivares": bolivares,
            "objetos": objetos
        };

        // Comprobamos si los dos campos de contraseña tienen el mismo contenido o no.
        if (password != password2) {
            // Si las dos constraseñas no coinciden, mandamos un aviso al usuario para que lo revise.
            alert("Las contraseñas no coinciden. Por favor, inténtalo de nuevo.");
        }
        else {
            // Si los dos campos son iguales, intentamos realizar el registro.
            $.post({
                url: '/dsaApp/usuario/register',
                data: JSON.stringify(body),
                contentType: 'application/json; charset=utf8'
            })
            // Si es correcto, mandamos mensaje a usuario y redirigimos a la página principal.
            .done(function (data, status){
                alert("Usuario registrado correctamente.");
                localStorage.setItem("mail", mail);
                location.href = "/principal.html";
            })
            // Si ha habido algún error, le informamos al usuario que debe revisar los datos introducidos.
            .fail(function(xhr, err){
                console.log("ERRO", err);
                alert("Por favor, revisa los datos introducidos");
                //location.reload();
            });
            return true;
        }
    });
});