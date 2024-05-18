package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    Conexion conexion = new Conexion();

    Connection connection;

    PreparedStatement preparedStatement;

    ResultSet resultSet;

    int respuesta;

    public ProductoDTO buscar(int idProducto) {

        ProductoDTO producto = new ProductoDTO();

        String sentenciaSQL = "SELECT * FROM producto WHERE idProducto=" + idProducto;

        try {

            connection = conexion.Conexion();

            preparedStatement = connection.prepareStatement(sentenciaSQL);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                producto.setIdProducto(resultSet.getInt(1));

                producto.setNombreProducto(resultSet.getString(2));

                producto.setPrecioProducto(resultSet.getDouble(3));

                producto.setStockProducto(resultSet.getInt(4));

                producto.setEstadoProducto(resultSet.getString(5));

            }

        } catch (SQLException e) {
            System.out.println("Error en: public ProductoDTO buscar(int idProducto)" + e.getMessage());
        }

        return producto;
    }

    public int actualizarStock(int idProducto, int stockActualProducto) {

        String sentenciaSQL = "UPDATE producto SET Stock=? WHERE IdProducto=?";

        try {

            connection = conexion.Conexion();

            preparedStatement = connection.prepareStatement(sentenciaSQL);

            preparedStatement.setInt(1, stockActualProducto);

            preparedStatement.setInt(2, idProducto);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en: public int actualizarStock(int idProducto, int stockActualProducto)" + e.getMessage());
        }

        return respuesta;
    }

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

                producto.setPrecioProducto(resultSet.getDouble("Precio"));

                producto.setStockProducto(resultSet.getInt("Stock"));

                producto.setEstadoProducto(resultSet.getString("Estado"));

            }
        } catch (SQLException e) {
            System.out.println("Error en: public ProductoDTO validar(String idProducto)" + e.getMessage());
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

                producto.setPrecioProducto(resultSet.getDouble(3));

                producto.setStockProducto(resultSet.getInt(4));

                producto.setEstadoProducto(resultSet.getString(5));

                lista.add(producto);

            }

        } catch (SQLException e) {
            System.out.println("Error en: public List listar()" + e.getMessage());
        }

        return lista;
    }

    public int agregar(ProductoDTO producto) {

        String sql = "INSERT INTO producto (Nombres, Precio, Stock, Estado) VALUES (?,?,?,?)";

        try {

            connection = conexion.Conexion();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, producto.getNombreProducto());

            preparedStatement.setDouble(2, producto.getPrecioProducto());

            preparedStatement.setInt(3, producto.getStockProducto());

            preparedStatement.setString(4, producto.getEstadoProducto());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en: public int agregar(ProductoDTO producto)" + e.getMessage());
        }
        return respuesta;
    }

    public ProductoDTO listarId(int id) {

        ProductoDTO producto = new ProductoDTO();

        String sql = "SELECT * FROM producto WHERE idProducto=" + id;

        try {

            connection = conexion.Conexion();

            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                producto.setIdProducto(resultSet.getInt(1));

                producto.setNombreProducto(resultSet.getString(2));

                producto.setPrecioProducto(resultSet.getDouble(3));

                producto.setStockProducto(resultSet.getInt(4));

                producto.setEstadoProducto(resultSet.getString(5));

            }
        } catch (SQLException e) {
            System.out.println("Error en: public ProductoDTO listarId(int id)" + e.getMessage());
        }

        return producto;
    }

    public int actualizar(ProductoDTO producto) {

        String sentenciaSQL = "UPDATE producto SET Nombres=?, Precio=?, Stock=?, Estado=? WHERE idProducto=?";

        try {

            connection = conexion.Conexion();

            preparedStatement = connection.prepareStatement(sentenciaSQL);

            preparedStatement.setString(1, producto.getNombreProducto());

            preparedStatement.setDouble(2, producto.getPrecioProducto());

            preparedStatement.setInt(3, producto.getStockProducto());

            preparedStatement.setString(4, producto.getEstadoProducto());

            preparedStatement.setInt(5, producto.getIdProducto());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en: public int actualizar(ProductoDTO producto)" + e.getMessage());
        }

        return respuesta;
    }

    public void eliminar(int id) {

        String sentenciaSQL = "DELETE FROM producto WHERE idProducto=" + id;

        try {

            connection = conexion.Conexion();

            preparedStatement = connection.prepareStatement(sentenciaSQL);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en: public void eliminar(int id)" + e.getMessage());
        }

    }
}
