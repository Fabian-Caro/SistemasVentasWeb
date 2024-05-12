package Modelo;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import config.Conexion;

public class VentaDAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public String GenerarSerie() {
        String numeroserie = "";
        String sql = "select max(NumeroSerie) from ventas";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                numeroserie = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return numeroserie;
    }

    public String IDVentas() {
        String idventas = "";
        String sql = "select max(IdVentas) from ventas";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                idventas=rs.getString(1);
                
            }
        } catch (Exception e) {
        }
        return idventas;
    }
    
    public int guardarVenta(Venta ve){
        String sql="insert into ventas(IdCliente, IdEmpleado, NumeroSerie, FechaVentas, Monto, Estado)values(?,?,?,?,?,?)";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ve.getIdCliente());
            ps.setInt(2, ve.getIdEmpleado());
            ps.setString(3, ve.getNumeroSerie());
            ps.setString(4, ve.getFechaVenta());
            ps.setDouble(5, ve.getPrecioProducto());
            ps.setString(6, ve.getEstadoVenta());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public int guardarDetalleventas(Venta venta){
        String sql="insert into detalle_ventas(IdVentas, IdProducto, Cantidad, PrecioVenta)values(?,?,?,?)";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, venta.getId());
            ps.setInt(2, venta.getIdProducto());
            ps.setInt(3, venta.getCantidad());
            ps.setDouble(4, venta.getPrecioProducto());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
}
