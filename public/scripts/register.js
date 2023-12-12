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
        var body = {"name": name, "password": password, "mail": mail, "username": username, "lastName": lastName ,"bolivares": bolivares, "objetos": objetos};

        if (password != password2) {
            alert("Las contraseñas no coinciden. Por favor, inténtalo de nuevo.");
        } else {
            // Aquí puedes enviar el formulario o realizar otras acciones necesarias
            alert("Usuario registrado correctamente.");


        $.post({
            url: '/dsaApp/usuario/register',
            data: JSON.stringify(body),
            contentType: 'application/json; charset=utf8'
        })
            .done(function (data, status){
                alert("***************** Usuario registrado correctamente.");
                location.href = "/shop.html";
            })
            .fail(function(xhr, err){
                console.log("ERRO", err);
                alert("Por favor, revisa los datos introducidos");
                //location.reload();
            });
        return true;
    }
    });
});