package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import config.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    Conexion conexion = new Conexion();

    Connection connection;

    PreparedStatement preparedStatement;

    ResultSet resultSet;

    int respuesta;

    public ClienteDTO validar(String idCliente) {

        ClienteDTO cliente = new ClienteDTO();

        String sentenciaSQL = "SELECT * FROM cliente WHERE idCliente=?";

        try {

            connection = conexion.Conexion();

            preparedStatement = connection.prepareStatement(sentenciaSQL);

            preparedStatement.setString(1, idCliente);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                cliente.setIdCliente(resultSet.getInt("idCliente"));

                cliente.setDniCliente(resultSet.getString("Dni"));

                cliente.setNombresCliente(resultSet.getString("Nombres"));

                cliente.setDireccionCliente(resultSet.getString("Direccion"));

                cliente.setEstadoCliente(resultSet.getString("Estado"));

            }

        } catch (SQLException e) {
            System.out.println("Error en: public ClienteDTO validar(String idCliente)" + e.getMessage());
        }

        return cliente;

    }
    
    public ClienteDTO buscar(String dni) {
        
        ClienteDTO cliente = new ClienteDTO();
        
        String sentenciaSQL = "SELECT * FROM cliente WHERE Dni=" + dni;
        
        try {
            
            connection = conexion.Conexion();
            
            preparedStatement = connection.prepareStatement(sentenciaSQL);
            
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                
                cliente.setIdCliente(resultSet.getInt(1));
                
                cliente.setDniCliente(resultSet.getString(2));
                
                cliente.setNombresCliente(resultSet.getString(3));
                
                cliente.setDireccionCliente(resultSet.getString(4));
                
                cliente.setEstadoCliente(resultSet.getString(5));
                
            }
            
        } catch (SQLException e) {
            System.out.println("Error en: public ClienteDTO buscar(String dni)" + e.getMessage());
        }
        
        return cliente;
    }

    public List listar() {

        String sentenciaSQL = "SELECT * FROM cliente";

        List<ClienteDTO> lista = new ArrayList<>();

        try {

            connection = conexion.Conexion();

            preparedStatement = connection.prepareStatement(sentenciaSQL);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                ClienteDTO cliente = new ClienteDTO();

                cliente.setIdCliente(resultSet.getInt(1));

                cliente.setDniCliente(resultSet.getString(2));

                cliente.setNombresCliente(resultSet.getString(3));

                cliente.setDireccionCliente(resultSet.getString(4));

                cliente.setEstadoCliente(resultSet.getString(5));

                lista.add(cliente);

            }

        } catch (SQLException e) {
            System.out.println("Error en: public List listar()" + e.getMessage());
        }

        return lista;
    }

    public int agregar(ClienteDTO cliente) {

        String sentenciaSQL = "INSERT INTO cliente (Dni, Nombres, Direccion, Estado) VALUES (?,?,?,?)";

        try {

            connection = conexion.Conexion();

            preparedStatement = connection.prepareStatement(sentenciaSQL);

            preparedStatement.setString(1, cliente.getDniCliente());

            preparedStatement.setString(2, cliente.getNombresCliente());

            preparedStatement.setString(3, cliente.getDireccionCliente());

            preparedStatement.setString(4, cliente.getEstadoCliente());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en: public int agregar(ClienteDTO cliente)" + e.getMessage());
        }
        return respuesta;
    }

    public ClienteDTO listarId(int id) {

        ClienteDTO cliente = new ClienteDTO();

        String sentenciaSQL = "SELECT * FROM cliente WHERE idCliente=" + id;

        try {

            connection = conexion.Conexion();

            preparedStatement = connection.prepareStatement(sentenciaSQL);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                cliente.setDniCliente(resultSet.getString(2));

                cliente.setNombresCliente(resultSet.getString(3));

                cliente.setDireccionCliente(resultSet.getString(4));

                cliente.setEstadoCliente(resultSet.getString(5));

            }
        } catch (SQLException e) {
            System.out.println("Error en: public ClienteDTO listarId(int id)" + e.getMessage());
        }

        return cliente;
    }

    public int actualizar(ClienteDTO cliente) {

        String sentenciaSQL = "UPDATE cliente SET Dni=?, Nombres=?, Direccion=?, Estado=? WHERE idCliente=?";

        try {

            connection = conexion.Conexion();

            preparedStatement = connection.prepareStatement(sentenciaSQL);

            preparedStatement.setString(1, cliente.getDniCliente());

            preparedStatement.setString(2, cliente.getNombresCliente());

            preparedStatement.setString(3, cliente.getDireccionCliente());

            preparedStatement.setString(4, cliente.getEstadoCliente());

            preparedStatement.setInt(5, cliente.getIdCliente());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en: public int actualizar(ClienteDTO cliente)" + e.getMessage());
        }

        return respuesta;
    }

    public void eliminar(int id) {

        String sentenciaSQL = "DELETE FROM cliente WHERE idCliente=" + id;

        try {

            connection = conexion.Conexion();

            preparedStatement = connection.prepareStatement(sentenciaSQL);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en: public void eliminar(int id)" + e.getMessage());
        }

    }
}
