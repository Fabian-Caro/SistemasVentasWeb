package Modelo;

import config.Conexion;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

public class EmpleadoDAO {

    Conexion conexion = new Conexion();
    
    Connection con;
    
    PreparedStatement pst;
    
    ResultSet rs;
    
    public EmpleadoDTO validar (String user, String dni) {
        
        EmpleadoDTO em = new EmpleadoDTO();
        
        String sql = "SELECT * FROM empleado WHERE User=? AND Dni=?";
        
        try {
            
            con = conexion.Conexion();
            
            pst = con.prepareStatement(sql);
            
            pst.setString(1, user);
            
            pst.setString(2, dni);
            
            rs = pst.executeQuery();
            
            while (rs.next()) {
                
                em.setIdEmpleado(rs.getString("IdEmpleado"));
                
                em.setUser(rs.getString("User"));
                
                em.setDni(rs.getString("Dni"));
                
                em.setNombre(rs.getString("Nombres"));
                
            }
            
        } catch (Exception e) {
        }
        
        return em;
    }
}
