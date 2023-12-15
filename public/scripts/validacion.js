function asegurarRegistro() {
    const mail = localStorage.getItem('mail');
    if (mail === null){
        location.href="/index.html"
    } else {

    }
    console.log('La página ha terminado de cargarse!');
}