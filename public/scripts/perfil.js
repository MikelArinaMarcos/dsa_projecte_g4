document.addEventListener('DOMContentLoaded', function () {
    const mail = localStorage.getItem('mail');
    fetch(`/dsaApp/usuario/usuario/${encodeURIComponent(mail)}`)
        .then(response => response.json())
        .then(data => {
            // Manejamos los datos y llamamos a la función para mostrar la información de los objetos
            mostrarInfoUsuario(data);
        })
        .catch(error => console.error('Error al obtener la lista de objetos:', error));
});
function mostrarInfoUsuario(usuario) {
    // Crear una etiqueta <label> para el usuario
    const usuarioLabel = document.createElement('label');
    const itemDiv = document.createElement('div');
    itemDiv.classList.add('item');

    const nombreObjetoHeading = document.createElement('h2');
    nombreObjetoHeading.classList.add('nombreObjeto');
    nombreObjetoHeading.textContent = usuario.username;

    const descripcionP = document.createElement('p');
    descripcionP.classList.add('descripcion');
    descripcionP.textContent = usuario.name;

    const descripcionP2 = document.createElement('p');
    descripcionP2.classList.add('descripcion');
    descripcionP2.textContent = usuario.lastName;

    const descripcionP3 = document.createElement('p');
    descripcionP3.classList.add('descripcion');
    descripcionP3.textContent = usuario.mail;

    const atributoPrecioP = document.createElement('p');
    atributoPrecioP.classList.add('atributo');
    atributoPrecioP.textContent = `Bolivares= ${usuario.bolivares}`;

    // Agregamos los elementos al contenedor
    itemDiv.appendChild(nombreObjetoHeading);
    itemDiv.appendChild(descripcionP);
    itemDiv.appendChild(descripcionP2);
    itemDiv.appendChild(descripcionP3);
    itemDiv.appendChild(atributoPrecioP);

    const infoUsuariosContainer = document.getElementById('infoUsuariosContainer');

    // Agregamos el itemDiv al contenedor existente
    infoUsuariosContainer.appendChild(itemDiv);

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
            url: `/dsaApp/usuario/deleteUser/${encodeURIComponent(mail)}&${encodeURIComponent(password)}`, // Ajusta la URL según tu estructura de carpetas y rutas
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
