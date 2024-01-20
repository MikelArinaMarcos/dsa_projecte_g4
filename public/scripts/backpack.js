document.addEventListener('DOMContentLoaded', function () {
    // Esperamos a que el contenido del DOM esté cargado antes de ejecutar el código
    const mail = localStorage.getItem('mail');
    // Realizamos una solicitud al backend para obtener la lista de objetos
    fetch(`/dsaApp/usuario/backpack/${encodeURIComponent(mail)}`)
        .then(response => response.json())
        .then(data => {
            // Manejamos los datos y llamamos a la función para mostrar la lista de objetos
            mostrarBackpack(data);
        })
        .catch(error => console.error('Error al obtener la lista de objetos:', error));
})
    function mostrarBackpack(listaObjetosBackpack) {
    const listaBackpackContainer = document.getElementById('listaObjetosBackpack');

    // Iteramos sobre la lista de objetos y creamos dinámicamente las secciones en el DOM
    listaObjetosBackpack.forEach(objeto => {
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

        // Agregamos los elementos al contenedor
        itemDiv.appendChild(nombreObjetoHeading);
        itemDiv.appendChild(descripcionP);
        itemDiv.appendChild(atributoPrecioP);
        itemDiv.appendChild(atributoDanioP);

        listaObjetosContainer.appendChild(itemDiv);
    });
}