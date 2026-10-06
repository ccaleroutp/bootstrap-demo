<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;
              charset=UTF-8">
        <title>Registro Productos</title>
       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
       <link href="css/estilos.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-5">
            <h2>Registrar Producto</h2>
            <form action="producto" method="post">
                <label>Nombre</label>
                <input type="text" name="nombre" class="form-control">
                <br>

                <label>Precio</label>
                <input type="number" step="0.01" name="precio"
                       class="form-control">
                <br>

                <button class="btn btn-success">
                    Guardar
                </button>
            </form>
        </div>
    </body>
</html>