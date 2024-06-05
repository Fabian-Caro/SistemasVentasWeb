<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  
    HttpSession obj = request.getSession();
    if (obj != null && obj.getAttribute("usuario") != null) {
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Productos</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            
            body, .table, .card, .card-body, .form-control, .form-control:focus {
                background-color: #1e1e1e;
                color: #fff;
            }

            .table-hover tbody tr:hover {
                color: #fff;
            }

            footer {
                background-color: #1e1e1e;
                color: #fff;
            }
        </style>
    </head>
    <body>
        <h1>Producto</h1>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Producto" method="POST">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" value="${producto.getNombreProducto()}" name="txtNombreProducto" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Precio</label>
                            <input type="text" value="${producto.getPrecioProducto()}" name="txtPrecioProducto" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Stock</label>
                            <input type="text" value="${producto.getStockProducto()}" name="txtStockProducto" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${producto.getEstadoProducto()}" name="txtEstadoProducto" class="form-control" required>
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>    
                            <th>NOMBRES</th>
                            <th>PRECIO</th>
                            <th>STOCK</th>
                            <th>ESTADO</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="producto" items="${productos}">
                            <tr>
                                <td>${producto.getIdProducto()}</td>              
                                <td>${producto.getNombreProducto()}</td>
                                <td>${producto.getPrecioProducto()}</td>
                                <td>${producto.getStockProducto()}</td>
                                <td>${producto.getEstadoProducto()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Producto&accion=Editar&idProducto=${producto.getIdProducto()}">Editar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=Producto&accion=Eliminar&idProducto=${producto.getIdProducto()}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
<%  
    } else {
        request.getRequestDispatcher("error.html").forward(request, response);
    }
%>
