$(document).ready(function(){
    $("#myForm").submit(function(event){
        inicioSesion(event);
    });
});

function inicioSesion(event){
    event.preventDefault();
    var mail = $('#mail').val();
    var password = $('#password').val();
    $.post({
        url: '/dsaApp/users/{mail}&{password}',
        data: JSON.stringify({"identifier": mail, "password": password}),
        contentType: 'application/json; charset=utf8'
    })
        .done(function (data, status){
            alert("Welcome");
            document.location= "/shop.html";
        })
        .fail(function(xhr, err){
            alert("Usuario o contraseña incorrectos");
            //document.location = "/html/login.html";
        })
};
