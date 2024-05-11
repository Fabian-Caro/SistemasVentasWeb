package Modelo;

import java.util.Objects;

public class ProductoDTO {

    private int idProducto;

    private String nombreProducto;

    private String precioProducto;

    private String stockProducto;

    private String estadoProducto;

    public ProductoDTO() {
    }

    public ProductoDTO(int idProducto, String nombreProducto, String precioProducto, String stockProducto, String estadoProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.stockProducto = stockProducto;
        this.estadoProducto = estadoProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(String precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(String stockProducto) {
        this.stockProducto = stockProducto;
    }

    public String getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(String estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idProducto;
        hash = 59 * hash + Objects.hashCode(this.nombreProducto);
        hash = 59 * hash + Objects.hashCode(this.precioProducto);
        hash = 59 * hash + Objects.hashCode(this.stockProducto);
        hash = 59 * hash + Objects.hashCode(this.estadoProducto);
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
        final ProductoDTO other = (ProductoDTO) obj;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (!Objects.equals(this.nombreProducto, other.nombreProducto)) {
            return false;
        }
        if (!Objects.equals(this.precioProducto, other.precioProducto)) {
            return false;
        }
        if (!Objects.equals(this.stockProducto, other.stockProducto)) {
            return false;
        }
        return Objects.equals(this.estadoProducto, other.estadoProducto);
    }

    @Override
    public String toString() {
        return "ProductoDTO{" + "idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", precioProducto=" + precioProducto + ", stockProducto=" + stockProducto + ", estadoProducto=" + estadoProducto + '}';
    }
}
