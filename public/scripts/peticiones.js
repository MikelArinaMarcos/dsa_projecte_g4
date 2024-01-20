document.addEventListener('DOMContentLoaded', function () {
    // Esperamos a que el contenido del DOM esté cargado antes de ejecutar el código
    // Realizamos una solicitud al backend para obtener la lista de objetos
    fetch(`/dsaApp/Peticiones/peticiones`)
        .then(response => response.json())
        .then(data => {
            // Manejamos los datos y llamamos a la función para mostrar la lista de objetos
            mostrarPeticiones(data);
        })
        .catch(error => console.error('Error al obtener la lista de peticiones:', error));
});

function mostrarPeticiones(listaPeticiones) {
    const listaPeticionesContainer = document.getElementById('listaPeticiones');

    // Iteramos sobre la lista de objetos y creamos dinámicamente las secciones en el DOM
    listaPeticiones.forEach(peticiones => {
        const itemDiv = document.createElement('div');
        itemDiv.classList.add('item');

        const petdate = document.createElement('h2');
        petdate.classList.add('date');
        petdate.textContent = peticiones.date;

        const pettitle = document.createElement('p');
        pettitle.classList.add('title');
        pettitle.textContent = peticiones.title;

        const petmessage = document.createElement('p');
        petmessage.classList.add('message');
        petmessage.textContent = `Mensage: ${peticiones.message}`;

        const petsender = document.createElement('p');
        petsender.classList.add('autor');
        petsender.textContent = `Autor: ${peticiones.sender}`;

        // Agregamos los elementos al contenedor
        itemDiv.appendChild(petdate);
        itemDiv.appendChild(pettitle);
        itemDiv.appendChild(petmessage);
        itemDiv.appendChild(petsender);

        listaPeticionesContainer.appendChild(itemDiv); // Ajuste del nombre de la variable
    });
}