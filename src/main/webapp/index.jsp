<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;
              charset=UTF-8">
        <title>Registro Productos</title>
       <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
       <link href="css/estilos.css" rel="stylesheet">       
       
       <script src="js/validaciones.js"></script>
    </head>
    <body>        
        <div class="container mt-5">
            <div class="card">
                <div class="card-header bg-primary text-white">
                    <h2>Registrar Producto</h2>
                </div>
                <div class="card-body">
                    <form action="producto" method="post" onsubmit="return validarProducto();">
                        <input type="hidden" name="accion" value="guardar">
                        <div class="mb-3">
                            <label  class="form-label">Nombre</label>
                            <input type="text" name="nombre" id="nombre" class="form-control">
                        </div>
                        
                        <div class="mb-3">
                            <label class="form-label">Precio</label>
                            <input type="number" step="0.01" name="precio" id="precio"
                               class="form-control">
                        </div>

                        <button class="btn btn-success">
                            Guardar
                        </button>

                        <a href="producto?accion=listar" class="btn btn-primary">
                            Ver Productos
                        </a>

                    </form>
                </div>
            </div>
        </div>
    </body>
</html>