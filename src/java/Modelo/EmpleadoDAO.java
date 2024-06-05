package Modelo;

import config.Conexion;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    Conexion conexion = new Conexion();

    Connection con;

    PreparedStatement pst;

    ResultSet rs;

    int respuesta;

    public EmpleadoDTO validar(String user, String dni) {

        EmpleadoDTO em = new EmpleadoDTO();

        String sql = "SELECT * FROM empleado WHERE User=? AND Dni=?";

        try {

            con = conexion.Conexion();

            pst = con.prepareStatement(sql);

            pst.setString(1, user);

            pst.setString(2, dni);

            rs = pst.executeQuery();

            while (rs.next()) {

                em.setIdEmpleado(rs.getInt("IdEmpleado"));
                em.setDni(rs.getString("Dni"));
                em.setNombre(rs.getString("Nombres"));
                em.setTelefono(rs.getString("Telefono"));
                em.setEstado(rs.getString("Estado"));
                em.setUser(rs.getString("User"));
            }
        } catch (SQLException e) {
            System.out.println("Error en: public EmpleadoDTO validar(String user, String dni)" + e.getMessage());
        }

        return em;
    }

    //op CRUD
    public List listar() {

        String sql = "select * from empleado";
        List<EmpleadoDTO> lista = new ArrayList<>();
        try {
            con = conexion.Conexion();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                EmpleadoDTO em = new EmpleadoDTO();
                em.setIdEmpleado(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNombre(rs.getString(3));
                em.setTelefono(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
                lista.add(em);

            }
        } catch (SQLException e) {
            System.out.println("Error en: public List listar()" + e.getMessage());
        }
        return lista;
    }

    public int agregar(EmpleadoDTO em) {

        String sql = "insert into empleado(Dni, Nombres, Telefono, Estado, User)values(?,?,?,?,?)";
        try {
            con = conexion.Conexion();
            pst = con.prepareStatement(sql);
            pst.setString(1, em.getDni());
            pst.setString(2, em.getNombre());
            pst.setString(3, em.getTelefono());
            pst.setString(4, em.getEstado());
            pst.setString(5, em.getUser());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en: public int agregar(EmpleadoDTO em)" + e.getMessage());
        }
        return respuesta;
    }

    public EmpleadoDTO listarId(int id) {
        EmpleadoDTO emp = new EmpleadoDTO();
        String sql = "select * from empleado where IdEmpleado=" + id;

        try {
            con = conexion.Conexion();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                emp.setDni(rs.getString(2));
                emp.setNombre(rs.getString(3));
                emp.setTelefono(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUser(rs.getString(6));
            }
        } catch (SQLException e) {
            System.out.println("Error en: public EmpleadoDTO listarId(int id)" + e.getMessage());
        }
        return emp;
    }

    public int actualizar(EmpleadoDTO em) {

        String sql = "update empleado set Dni=?, Nombres=?, Telefono=?, Estado=?, User=? where IdEmpleado=?";
        try {
            con = conexion.Conexion();
            pst = con.prepareStatement(sql);
            pst.setString(1, em.getDni());
            pst.setString(2, em.getNombre());
            pst.setString(3, em.getTelefono());
            pst.setString(4, em.getEstado());
            pst.setString(5, em.getUser());
            pst.setInt(6, em.getIdEmpleado());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en: public int actualizar(EmpleadoDTO em)" + e.getMessage());
        }
        return respuesta;
    }

    public void delete(int id) {
        String sql = "delete from empleado where IdEmpleado=" + id;
        try {
            con = conexion.Conexion();
            pst = con.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en: public void delete(int id)" + e.getMessage());
        }
    }
}
