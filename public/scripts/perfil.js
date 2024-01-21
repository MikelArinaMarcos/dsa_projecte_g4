$(document).ready(function(){
    $('#eliminarperfilBtn').click(function(event){
        event.preventDefault();
        const mail = localStorage.getItem('mail')
        // Obtener los datos del formulario
        var password = $('#passwordeliminar').val();
        // Crear el objeto de datos para enviar al servidor
        // Enviar la solicitud POST al servidor para el inicio de sesión
        $.post({
            url: `/dsaApp/usuario//deleteUser/${encodeURIComponent(mail)}&${encodeURIComponent(password)}`, // Ajusta la URL según tu estructura de carpetas y rutas
            contentType: 'application/json; charset=utf8'
        })
            .done(function (data, status){
                alert("¡Eliminación de cuenta exitosa!");
                location.href = "/index.html";
            })
            .fail(function(xhr, err){
                console.log("ERROR", err);
                alert("Inicio de sesión fallido. Por favor, revisa los datos introducidos.");
            });
        return true;
    });
});
function editarperfil(){
    location.href="/cambio_de_perfil.html";

}
