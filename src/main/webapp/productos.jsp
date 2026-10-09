<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;
              charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" >
    </head>
    <body>
        <div class="container mt-5">
            <h2>Productos</h2>

            <form action="producto" method="post">
                <input type="hidden" name="accion"
                       value="buscarNombre">
                <div class="mb-3">
                    <input type="text" name="nombre" class="formcontrol">
                </div>
                <button class="btn btn-primary">
                    Buscar
                </button>
            </form>

            <table
                class="table table-striped table-hover">
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>ELIMINAR</th>
                    <th>ACTUALIZAR</th>
                </tr>
                <c:forEach var="producto" items="${listProducto}">
                    <tr>
                        <td>${producto.id}</td>
                        <td>${producto.nombre}</td>
                        <td>${producto.precio}</td>
                        <td>
                            <a href="producto?accion=eliminar&id=${producto.id}" class="btn btn-danger"
                               onclick="return confirm('¿Eliminar producto?');"> Eliminar</a>
                        </td>
                        <td>
                            <a class="btn btn-warning"

                               href="producto?accion=buscar&id=${producto.id}">
                                Editar
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <a href="index.jsp"
               class="btn btn-primary">
                Nuevo
            </a>
        </div>
    </body>
</html>