package Modelo;

import java.util.Objects;

public class Venta {
    
    int id;
    int item;
    int idCliente;
    int idEmpleado;
    int idProducto;
    String NumeroSerie;
    String DescricionProducto;
    String FechaVenta;
    Double precioProducto;
    int cantidad;
    Double subtotal;
    Double montoVenta;
    String estadoVenta;

    public Venta() {
    }

    public Venta(int id, int item, int idCliente, int idEmpleado, int idProducto, String NumeroSerie, String DescricionProducto, String FechaVenta, Double precioProducto, int cantidad, Double subtotal, Double montoVenta, String estadoVenta) {
        this.id = id;
        this.item = item;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.idProducto = idProducto;
        this.NumeroSerie = NumeroSerie;
        this.DescricionProducto = DescricionProducto;
        this.FechaVenta = FechaVenta;
        this.precioProducto = precioProducto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.montoVenta = montoVenta;
        this.estadoVenta = estadoVenta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNumeroSerie() {
        return NumeroSerie;
    }

    public void setNumeroSerie(String NumeroSerie) {
        this.NumeroSerie = NumeroSerie;
    }

    public String getDescricionProducto() {
        return DescricionProducto;
    }

    public void setDescricionProducto(String DescricionProducto) {
        this.DescricionProducto = DescricionProducto;
    }

    public String getFechaVenta() {
        return FechaVenta;
    }

    public void setFechaVenta(String FechaVenta) {
        this.FechaVenta = FechaVenta;
    }

    public Double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getMontoVenta() {
        return montoVenta;
    }

    public void setMontoVenta(Double montoVenta) {
        this.montoVenta = montoVenta;
    }

    public String getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(String estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + this.item;
        hash = 29 * hash + this.idCliente;
        hash = 29 * hash + this.idEmpleado;
        hash = 29 * hash + this.idProducto;
        hash = 29 * hash + Objects.hashCode(this.NumeroSerie);
        hash = 29 * hash + Objects.hashCode(this.DescricionProducto);
        hash = 29 * hash + Objects.hashCode(this.FechaVenta);
        hash = 29 * hash + Objects.hashCode(this.precioProducto);
        hash = 29 * hash + this.cantidad;
        hash = 29 * hash + Objects.hashCode(this.subtotal);
        hash = 29 * hash + Objects.hashCode(this.montoVenta);
        hash = 29 * hash + Objects.hashCode(this.estadoVenta);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venta other = (Venta) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.item != other.item) {
            return false;
        }
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (this.idEmpleado != other.idEmpleado) {
            return false;
        }
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (!Objects.equals(this.NumeroSerie, other.NumeroSerie)) {
            return false;
        }
        if (!Objects.equals(this.DescricionProducto, other.DescricionProducto)) {
            return false;
        }
        if (!Objects.equals(this.FechaVenta, other.FechaVenta)) {
            return false;
        }
        if (!Objects.equals(this.estadoVenta, other.estadoVenta)) {
            return false;
        }
        if (!Objects.equals(this.precioProducto, other.precioProducto)) {
            return false;
        }
        if (!Objects.equals(this.subtotal, other.subtotal)) {
            return false;
        }
        return Objects.equals(this.montoVenta, other.montoVenta);
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", item=" + item + ", idCliente=" + idCliente + ", idEmpleado=" + idEmpleado + ", idProducto=" + idProducto + ", NumeroSerie=" + NumeroSerie + ", DescricionProducto=" + DescricionProducto + ", FechaVenta=" + FechaVenta + ", precioProducto=" + precioProducto + ", cantidad=" + cantidad + ", subtotal=" + subtotal + ", montoVenta=" + montoVenta + ", estadoVenta=" + estadoVenta + '}';
    }
}
