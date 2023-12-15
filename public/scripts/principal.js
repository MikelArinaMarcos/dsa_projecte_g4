function asegurarRegistro() {
    const mail = localStorage.getItem('mail');
    if (mail === null){
        location.href="/index.html"
    } else {
    }
}