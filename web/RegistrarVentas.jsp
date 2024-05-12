<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <title>Ventas</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-5.5">
                <div class="card">
                    <div class="card-body">
                        <form action="Controlador?menu=NuevaVenta" method="POST">
                            <div class="form-group">
                                <label>Datos del cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex" style="margin-right: 10px;">
                                    <input type="text" name="txtDniCliente" value="${clienteBuscar.getDniCliente()}" class="form-control" placeholder="Código Cliente" >
                                    <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info" style="margin-left: 10px;">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="txtNombreCliente" value="${clienteBuscar.getNombresCliente()}" class="form-control" placeholder="Datos cliente" >
                                </div>  
                            </div>
                            <div class="form-group">
                                <label>Datos producto</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex" style="margin-right: 10px;">
                                    <input type="text" name="txtCodigoProducto" value="${productoBuscar.getIdProducto()}" class=" form-control" placeholder="Código Producto" >
                                    <input type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info" style="margin-left: 10px;">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="txtNombreProducto" value="${productoBuscar.getNombreProducto()}" class="form-control" placeholder="Producto" >
                                </div> 
                            </div>
                            <br>
                            <div class="form-group d-flex">
                                <div class="col-sm-4 d-flex" style="margin-right: 10px;">
                                    <input type="text" name="txtPrecioProducto" value="${productoBuscar.getPrecioProducto()}" class="form-control" placeholder="$00.00">
                                </div>
                                <div class="col-sm-2" style="margin-right: 10px;">
                                    <input type="number" name="txtCantidadProducto" value="1" class="form-control">
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" name="txtStockProducto" value="${productoBuscar.getStockProducto()}" class="form-control" placeholder="Stock">
                                </div>
                            </div>
                            <div>
                                <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info" style="margin-top:10px;">Agregar Producto</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-sm-6" style="margin-left: 10px;">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-5 ml-auto">
                            <label>Nro. Serie</label>
                            <input readonly="" type="text" name="txtNumeroSerie" value="${nserie}" class="form-control">
                        </div>
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>Codigo</th>
                                    <th>Descripción</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Subtotal</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                    <tr>
                                        <td>${list.getItem()}</td>
                                        <td>${list.getIdProducto()}</td>
                                        <td>${list.getDescricionProducto()}</td>
                                        <td>${list.getPrecioProducto()}</td>
                                        <td>${list.getCantidad()}</td>
                                        <td>${list.getSubtotal()}</td>
                                        <td class="d-flex">
                                            <a class="btn btn-warning">Editar</a>
                                            <a class="btn btn-danger">Eliminar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <a href="Controlador?menu=NuevaVenta%accion=GenerarVenta" class="btn btn-success">Generar Venta</a> 
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                        </div>
                        <div class="col-sm-4 ml-auto">
                            <input type="text" name="txtTotal" value="$/. ${totalPagar}0" class="form-control">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div></div>
    </body>
</html>
