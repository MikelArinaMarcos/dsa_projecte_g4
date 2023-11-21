document.addEventListener('DOMContentLoaded', function () {
    // Esperamos a que el contenido del DOM esté cargado antes de ejecutar el código

    // Realizamos una solicitud al backend para obtener la lista de objetos
    fetch('/ruta/a/tu/endpoint')
        .then(response => response.json())
        .then(data => {
            // Manejamos los datos y llamamos a la función para mostrar la lista de objetos
            mostrarListaObjetos(data);
        })
        .catch(error => console.error('Error al obtener la lista de objetos:', error));
});

function mostrarListaObjetos(listaObjetos) {
    const listaObjetosContainer = document.getElementById('listaObjetos');

    // Iteramos sobre la lista de objetos y creamos dinámicamente las secciones en el DOM
    listaObjetos.forEach(objeto => {
        const itemDiv = document.createElement('div');
        itemDiv.classList.add('item');

        const nombreObjetoHeading = document.createElement('h2');
        nombreObjetoHeading.classList.add('nombreObjeto');
        nombreObjetoHeading.textContent = objeto.Nombre;

        const descripcionP = document.createElement('p');
        descripcionP.classList.add('descripcion');
        descripcionP.textContent = objeto.Descripcion;

        const atributoPrecioP = document.createElement('p');
        atributoPrecioP.classList.add('atributo');
        atributoPrecioP.textContent = `Precio: $${objeto.Precio}`;

        const atributoDanioP = document.createElement('p');
        atributoDanioP.classList.add('atributo');
        atributoDanioP.textContent = `Daño: ${objeto.Daño}`;

        const comprarBtn = document.createElement('button');
        comprarBtn.classList.add('comprarBtn');
        comprarBtn.textContent = 'Comprar';

        // Agregamos los elementos al contenedor
        itemDiv.appendChild(nombreObjetoHeading);
        itemDiv.appendChild(descripcionP);
        itemDiv.appendChild(atributoPrecioP);
        itemDiv.appendChild(atributoDanioP);
        itemDiv.appendChild(comprarBtn);

        listaObjetosContainer.appendChild(itemDiv);
    });
}
