$(document).ready(function(){
    $('#registerBtn').click(function(event){
        event.preventDefault();

        // Nos creamos variables para recoger los datos del formulario.

        var name = $('#name').val();
        var password = $('#password').val();
        var mail = $('#mail').val();
        var username = $('#username').val();
        var lastName = $('#lastName').val();
        var body = {"name": name, "password": password, "mail": mail, "username": username, "lastName": lastName
        };
        $.post({
            url: '/dsaApp/juego/users/register',
            data: JSON.stringify(body),
            contentType: 'application/json; charset=utf8'
        })
            .done(function (data, status){
                alert("***************** Usuario registrado correctamente.");
                location.href = "/./informacion.html";
            })
            .fail(function(xhr, err){
                console.log("ERRO", err);
                alert("Por favor, revisa los datos introducidos");
                //location.reload();
            });
        return true;
    });
});