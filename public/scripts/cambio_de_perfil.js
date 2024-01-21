$(document).ready(function(){
    $('#editarperfilButton').click(function(event){
        event.preventDefault();
        const mail = localStorage.getItem('mail');
        // Nos creamos variables para recoger los datos del formulario.

        var newName = $('#nname').val();
        var newPassword = $('#opassword').val();
        var password2 = $('#npassword').val();
        var newMail = $('#nmail').val();
        var newUsername = $('#nusername').val();
        var newLastName = $('#nlastName').val();
        var bolivares = parseInt('500',10);

        // Comprobamos si los dos campos de contraseña tienen el mismo contenido o no.
        if (newPassword != password2) {
            // Si las dos constraseñas no coinciden, mandamos un aviso al usuario para que lo revise.
            alert("Las contraseñas no coinciden. Por favor, inténtalo de nuevo.");
        }
        else {
            // Si los dos campos son iguales, intentamos realizar el registro.
            $.put({
                url: `/dsaApp/usuario/actualizarUsuario/${encodeURIComponent(mail)}/${encodeURIComponent(newPassword)}/${encodeURIComponent(newUsername)}/${encodeURIComponent(newName)}/${encodeURIComponent(newLastName)}/${encodeURIComponent(newMail)}/${encodeURIComponent(newBolivares)}`,
                contentType: 'application/json; charset=utf8'
            })
                // Si es correcto, mandamos mensaje a usuario y redirigimos a la página principal.
                .done(function (data, status){
                    alert("Usuario registrado correctamente.");
                    localStorage.setItem("mail", newMail);
                    location.href = "/perfil.html";
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
function cancelar(){
    location.href="/perfil.html";

}