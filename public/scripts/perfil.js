document.addEventListener('DOMContentLoaded', function () {
    const mail = localStorage.getItem('mail');
    fetch(`/dsaApp/usuario/usuario/${encodeURIComponent(mail)}`)
        .then(response => response.json())
        .then(data => {
            // Manejamos los datos y llamamos a la función para mostrar la información de los objetos
            mostrarInfoUsuarios(data);
        })
        .catch(error => console.error('Error al obtener la lista de objetos:', error));
});
function mostrarInfoUsuarios(listaUsuarios) {
    // Seleccionamos el contenedor donde queremos mostrar la información
    const infoUsuariosContainer = document.getElementById('infoUsuariosContainer');

    // Iteramos sobre la lista de objetos y creamos dinámicamente las etiquetas en el DOM
    listaUsuarios.forEach(usuario => {
        // Crear una etiqueta <label> para cada objeto
        const usuarioLabel = document.createElement('label');
        usuarioLabel.classList.add('objeto-label');

        // Configurar el contenido de la etiqueta con la información del objeto
        usuarioLabel.innerHTML = `
            <label class="info-label">Nombre de Usuario: ${usuario.username}</label><br>
            <label class="info-label">Nombre: ${usuario.name}</label><br>
            <label class="info-label">Apellido: ${usuario.lastName}</label><br>
            <label class="info-label">Correo Electrónico: ${usuario.mail}</label><br>
        `;

        // Agregamos la etiqueta al contenedor
        infoUsuariosContainer.appendChild(usuarioLabel);
    });
}

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
