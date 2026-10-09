<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Editar Producto</title>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
        
        <link rel="stylesheet" href="css/estilos.css">

        <script src="js/validaciones.js"></script>
    </head>
    <body>
        <div class="container mt-5">
            <div class="card">
                <div class="card-header bg-warning">
                    <h3>Editar Producto</h3>
                </div>
                <div class="card-body">
                    <form action="producto" method="post">
                        <input type="hidden" name="accion"
                               value="actualizar">
                        <input type="hidden" name="id"
                               value="${producto.id}">
                        <div class="mb-3">
                            <label class="form-label">
                                Nombre
                            </label>
                            <input type="text"
                                   id="nombre"
                                   name="nombre"
                                   class="form-control"
                                   value="${producto.nombre}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">
                                Precio
                            </label>
                            <input type="number"
                                   step="0.01"
                                   id="precio"
                                   name="precio"
                                   class="form-control"
                                   value="${producto.precio}">
                        </div>
                        <button type="submit"
                                class="btn btn-success">
                            Actualizar
                        </button>
                        <a href="producto?accion=listar"
                           class="btn btn-secondary">
                            Cancelar
                        </a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>