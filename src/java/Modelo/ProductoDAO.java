package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    Conexion conexion = new Conexion();

    Connection connection;

    PreparedStatement preparedStatement;

    ResultSet resultSet;

    int respuesta;

    public ProductoDTO validar(String idProducto) {

        ProductoDTO producto = new ProductoDTO();

        String sql = "SELECT * FROM producto WHERE idProducto=?";

        try {

            connection = conexion.Conexion();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, idProducto);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                producto.setIdProducto(resultSet.getInt("idProducto"));

                producto.setNombreProducto(resultSet.getString("Nombres"));

                producto.setPrecioProducto(resultSet.getString("Precio"));

                producto.setStockProducto(resultSet.getString("Stock"));

                producto.setEstadoProducto(resultSet.getString("Estado"));
            }
        } catch (Exception e) {
        }

        return producto;
    }

    public List listar() {

        String sql = "SELECT * FROM producto";

        List<ProductoDTO> lista = new ArrayList<>();

        try {

            connection = conexion.Conexion();

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                ProductoDTO producto = new ProductoDTO();

                producto.setIdProducto(resultSet.getInt(1));

                producto.setNombreProducto(resultSet.getString(2));

                producto.setPrecioProducto(resultSet.getString(3));

                producto.setStockProducto(resultSet.getString(4));

                producto.setEstadoProducto(resultSet.getString(5));

                lista.add(producto);
                
            }

        } catch (Exception e) {
        }
        
        return lista;
    }
    
    public int agregar (ProductoDTO producto) {
        
        String sql = "INSERT INTO producto (Nombres, Precio, Stock, Estado) VALUES (?,?,?,?)";
        
        try {
            
            connection = conexion.Conexion();
            
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, producto.getNombreProducto());
            
            preparedStatement.setString(2, producto.getPrecioProducto());
            
            preparedStatement.setString(3, producto.getStockProducto());
            
            preparedStatement.setString(4, producto.getEstadoProducto());
            
            preparedStatement.executeUpdate();
            
        } catch (Exception e) {
        }
        return respuesta;
    }
    
    public ProductoDTO listarId (int id) {
        
        ProductoDTO producto = new ProductoDTO();
        
        String sql = "SELECT * FROM producto WHERE idProducto=" + id;
        
        try {
            
            connection = conexion.Conexion();
            
            preparedStatement = connection.prepareStatement(sql);
            
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                
                producto.setNombreProducto(resultSet.getString(2));
                
                producto.setPrecioProducto(resultSet.getString(3));
                
                producto.setStockProducto(resultSet.getString(4));
                
                producto.setEstadoProducto(resultSet.getString(5));
                
            }
        } catch (Exception e) {
        }
        
        return producto;
    }
    
    public int actualizar (ProductoDTO producto) {
        
        String sentenciaSQL = "UPDATE producto SET Nombres=?, Precio=?, Stock=?, Estado=? WHERE idProducto=?";
        
        try {
            
            connection = conexion.Conexion();
            
            preparedStatement = connection.prepareStatement(sentenciaSQL);
            
            preparedStatement.setString(1, producto.getNombreProducto());
            
            preparedStatement.setString(2, producto.getPrecioProducto());
            
            preparedStatement.setString(3, producto.getStockProducto());
            
            preparedStatement.setString(4, producto.getEstadoProducto());
            
            preparedStatement.setInt(5, producto.getIdProducto());
            
            preparedStatement.executeUpdate();
            
        } catch (Exception e) {
        }
        
        return respuesta;
    }
    
    public void eliminar (int id) {
        
        String sentenciaSQL = "DELETE FROM empleado WHERE idEmpleado=" + id;
        
        try {
            
            connection = conexion.Conexion();
            
            preparedStatement = connection.prepareStatement(sentenciaSQL);
            
            preparedStatement.executeUpdate();
            
        } catch (Exception e) {
        }
        
    }
}
