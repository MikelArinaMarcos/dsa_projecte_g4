document.addEventListener('DOMContentLoaded', function () {
    // Esperamos a que el contenido del DOM esté cargado antes de ejecutar el código

    // Realizamos una solicitud al backend para obtener la lista de objetos
    fetch('/dsaApp/tienda/objetos')
        .then(response => response.json())
        .then(data => {
            // Manejamos los datos y llamamos a la función para mostrar la lista de objetos
            mostrarListaObjetos(data);
        })
        .catch(error => console.error('Error al obtener la lista de objetos:', error));
});

function crearElementoObjeto(objeto) {
    const itemDiv = document.createElement('div');
    itemDiv.classList.add('item');

    const nombreObjetoHeading = document.createElement('h2');
    nombreObjetoHeading.classList.add('nombreObjeto');
    nombreObjetoHeading.textContent = objeto.nombre;

    const descripcionP = document.createElement('p');
    descripcionP.classList.add('descripcion');
    descripcionP.textContent = objeto.id;

    const atributoPrecioP = document.createElement('p');
    atributoPrecioP.classList.add('atributo');
    atributoPrecioP.textContent = `Precio: $${objeto.precio}`;

    const atributoDanioP = document.createElement('p');
    atributoDanioP.classList.add('atributo');
    atributoDanioP.textContent = `Damage: ${objeto.damage}`;

    const comprarBtn = document.createElement('button');
    comprarBtn.classList.add('comprarBtn');
    comprarBtn.textContent = 'Comprar';

    // Agregamos los elementos al contenedor
    itemDiv.appendChild(nombreObjetoHeading);
    itemDiv.appendChild(descripcionP);
    itemDiv.appendChild(atributoPrecioP);
    itemDiv.appendChild(atributoDanioP);
    itemDiv.appendChild(comprarBtn);

    return itemDiv;
}

function mostrarListaObjetos(listaObjetos) {
    const listaObjetosContainer = document.getElementById('listaObjetos');

    // Iteramos sobre la lista de objetos y creamos dinámicamente las secciones en el DOM
    listaObjetos.forEach(objeto => {
        const itemDiv = crearElementoObjeto(objeto);
        listaObjetosContainer.appendChild(itemDiv);
    });
}

$(document).ready(function(){
    $('#listaObjetos').on('click', '.comprarBtn', function (event) {
        event.preventDefault();
        var objeto = $(this).closest('.item').data('objeto');
        // Obtener los datos de los objetos
        var id = objeto.id;
        var rareza = objeto.rareza;
        var nombre = objeto.nombre;
        var precio = objeto.precio;
        var damage = objeto.damage;
        var url = objeto.url;
        const mail = localStorage.getItem('mail'); // Reemplaza esto con el correo electrónico que deseas enviar al servidor
        var body = {
            "id": id,
            "rareza": rareza,
            "nombre": nombre,
            "precio": precio,
            "damage": damage,
            "url": url
        };

        // Enviar la solicitud POST al servidor para el inicio de sesión
        $.post({
            url:  `/dsaApp/tienda/comprarObjeto/${encodeURIComponent(mail)}`, // Ajusta la URL según tu estructura de carpetas y rutas
            data: JSON.stringify(body),
            contentType: 'application/json; charset=utf8'
        })
            .done(function (data, status){
                alert("¡Añadido a tu inventario!");
                location.href = "/principal.html";
            })
            .fail(function(xhr, err){
                console.log("ERROR", err);
                alert("No se ha podido comprar");
            });
        return true;
    });
});
