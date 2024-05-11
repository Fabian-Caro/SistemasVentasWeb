package Modelo;

import java.util.Objects;

public class ClienteDTO {
    
    private int idCliente;
    
    private String dniCliente;
    
    private String NombresCliente;
    
    private String direccionCliente;
    
    private String estadoCliente;   

    public ClienteDTO() {
    }

    public ClienteDTO(int idCliente, String dniCliente, String NombresCliente, String direccionCliente, String estadoCliente) {
        this.idCliente = idCliente;
        this.dniCliente = dniCliente;
        this.NombresCliente = NombresCliente;
        this.direccionCliente = direccionCliente;
        this.estadoCliente = estadoCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getNombresCliente() {
        return NombresCliente;
    }

    public void setNombresCliente(String NombresCliente) {
        this.NombresCliente = NombresCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(String estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idCliente;
        hash = 89 * hash + Objects.hashCode(this.dniCliente);
        hash = 89 * hash + Objects.hashCode(this.NombresCliente);
        hash = 89 * hash + Objects.hashCode(this.direccionCliente);
        hash = 89 * hash + Objects.hashCode(this.estadoCliente);
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
        final ClienteDTO other = (ClienteDTO) obj;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (!Objects.equals(this.dniCliente, other.dniCliente)) {
            return false;
        }
        if (!Objects.equals(this.NombresCliente, other.NombresCliente)) {
            return false;
        }
        if (!Objects.equals(this.direccionCliente, other.direccionCliente)) {
            return false;
        }
        return Objects.equals(this.estadoCliente, other.estadoCliente);
    }

    @Override
    public String toString() {
        return "ClienteDTO{" + "idCliente=" + idCliente + ", dniCliente=" + dniCliente + ", NombresCliente=" + NombresCliente + ", direccionCliente=" + direccionCliente + ", estadoCliente=" + estadoCliente + '}';
    }
}
