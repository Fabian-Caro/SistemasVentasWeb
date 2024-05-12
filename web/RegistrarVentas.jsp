<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <title>Ventas</title>
        <style>
            @media print {
                .parte01, .btn, .accion{
                    display: none;
                }
            }
        </style>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-lg-5.5 parte01">
                <div class="card">
                    <div class="card-body">
                        <form action="Controlador?menu=NuevaVenta" method="POST">
                            <div class="form-group">
                                <label>Datos del cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex" style="margin-right: 10px;">
                                    <input type="text" name="txtDniCliente" value="${clienteBuscar.getDniCliente()}" class="form-control" placeholder="Código Cliente">
                                    <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info" style="margin-left: 10px;">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="txtNombreCliente" value="${clienteBuscar.getNombresCliente()}" class="form-control" placeholder="Datos cliente" readonly="">
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
                                    <input type="text" name="txtNombreProducto" value="${productoBuscar.getNombreProducto()}" class="form-control" placeholder="Producto" readonly="">
                                </div> 
                            </div>
                            <br>
                            <div class="form-group d-flex">
                                <div class="col-sm-4 d-flex" style="margin-right: 10px;">
                                    <input type="text" name="txtPrecioProducto" value="${productoBuscar.getPrecioProducto()}" class="form-control" placeholder="$00.00" readonly="">
                                </div>
                                <div class="col-sm-2" style="margin-right: 10px;">
                                    <input type="number" name="txtCantidadProducto" value="1" class="form-control" min="1" step="1">
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" name="txtStockProducto" value="${productoBuscar.getStockProducto()}" class="form-control" placeholder="Stock" readonly="">
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
                            <input type="text" name="txtNumeroSerie" value="${nserie}" class="form-control" readonly="">
                        </div>
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <!-- Asegúrate de agregar una columna de encabezado para las acciones -->
                                <tr>
                                    <th>Item</th>
                                    <th>ID Producto</th>
                                    <th>Descripción Producto</th>
                                    <th>Precio Producto</th>
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
                                        <td>
                                            <input type="number" id="cantidad${list.getIdProducto()}" value="${list.getCantidad()}" class="form-control" min="0" step="1">
                                        </td>
                                        <td>${list.getSubtotal()}</td>
                                        <td> 
                                            <form action="Controlador?menu=NuevaVenta" method="POST" style="display: flex;">
                                                <input type="hidden" name="idProducto" value="${list.getIdProducto()}">
                                                <input type="hidden" name="txtCantidadAgregada" id="hiddenCantidad${list.getIdProducto()}" value="${list.getCantidad()}">
                                                <input type="submit" name="accion" value="Editar" class="btn btn-warning" style="margin-right: 10px;" onclick="document.getElementById('hiddenCantidad${list.getIdProducto()}').value = document.getElementById('cantidad${list.getIdProducto()}').value;">
                                                <input type="submit" name="accion" value="Eliminar" class="btn btn-danger">
                                            </form>
                                        </td>  
                                    </tr>
                                </c:forEach>
                            </tbody>

                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" onclick="print()" class="btn btn-success">Generar Venta</a> 
                            <form action="Controlador?menu=NuevaVenta" method="POST" style="display: inline;">
                                <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                            </form>
                        </div>
                        <div class="col-sm-4 ml-auto" style="display: flex; align-items: center;">
                            <label for="txtTotal" style="margin-right: 10px;">Total a pagar:</label>
                            <input type="text" id="txtTotal" name="txtTotal" value="${totalPagar}" class="form-control" readonly="">
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <div></div>
    </body>
</html>
