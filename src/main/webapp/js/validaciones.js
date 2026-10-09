function validarProducto() {
    let nombre = document.getElementById("nombre").value;
    let precio = document.getElementById("precio").value;

    if (nombre.trim() === "") {
        alert("Ingrese nombre");
        return false;
    }
    if (precio === "" || precio <= 0) {
        alert("Precio inválido");
        return false;
    }
    return true;
}