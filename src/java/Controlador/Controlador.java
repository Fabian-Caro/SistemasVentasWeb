package Controlador;

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;
import Modelo.EmpleadoDAO;
import Modelo.EmpleadoDTO;
import Modelo.ProductoDAO;
import Modelo.ProductoDTO;
import Modelo.Venta;
import Modelo.VentaDAO;
import config.GenerarSerie;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    EmpleadoDTO em = new EmpleadoDTO();
    EmpleadoDAO edao = new EmpleadoDAO();
    ProductoDTO producto = new ProductoDTO();
    ProductoDAO productoDAO = new ProductoDAO();
    ClienteDTO cliente = new ClienteDTO();
    ClienteDAO clienteDAO = new ClienteDAO();
    Venta venta = new Venta();
    List<Venta> lista = new ArrayList<>();
    int item;
    int codigoProducto;
    String descripcionProducto;
    double precio;
    int cantidad;
    double subtotal;
    int ide;
    int idProducto;
    int idCliente;
    double totalPagar;

    String numeroserie;
    VentaDAO vdao = new VentaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");

        String accion = request.getParameter("accion");

        if (menu.equals("Principal")) {

            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }

        if (menu.equals("Empleado")) {

            switch (accion) {
                case "Listar":
                    List lista = edao.listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String tel = request.getParameter("txtTel");
                    String est = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUser");
                    em.setDni(dni);
                    em.setNombre(nom);
                    em.setTelefono(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("idEmpleado"));
                    EmpleadoDTO e = edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nom1 = request.getParameter("txtNombres");
                    String tel1 = request.getParameter("txtTel");
                    String est1 = request.getParameter("txtEstado");
                    String user1 = request.getParameter("txtUser");
                    em.setDni(dni1);
                    em.setNombre(nom1);
                    em.setTelefono(tel1);
                    em.setEstado(est1);
                    em.setUser(user1);
                    em.setIdEmpleado(ide);
                    edao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    ide = Integer.parseInt(request.getParameter("idEmpleado"));
                    edao.delete(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);

        }
        /*Controlador producto*/
        if (menu.equals("Producto")) {

            switch (accion) {

                case "Listar":

                    List lista = productoDAO.listar();

                    request.setAttribute("productos", lista);

                    break;

                case "Agregar":

                    String nombreProducto = request.getParameter("txtNombreProducto");

                    String precioProducto = request.getParameter("txtPrecioProducto");

                    String stockProducto = request.getParameter("txtStockProducto");

                    String estadoProducto = request.getParameter("txtEstadoProducto");

                    producto.setNombreProducto(nombreProducto);

                    producto.setPrecioProducto(precioProducto);

                    producto.setStockProducto(stockProducto);

                    producto.setEstadoProducto(estadoProducto);

                    productoDAO.agregar(producto);

                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

                    break;

                case "Editar":

                    idProducto = Integer.parseInt(request.getParameter("idProducto"));

                    ProductoDTO productoEditar = productoDAO.listarId(idProducto);

                    request.setAttribute("producto", productoEditar);

                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

                    break;

                case "Actualizar":

                    String nombreProductoActualizar = request.getParameter("txtNombreProducto");

                    String precioProductoActualizar = request.getParameter("txtPrecioProducto");

                    String stockProductoActualizar = request.getParameter("txtStockProducto");

                    String estadoProductoActualizar = request.getParameter("txtEstadoProducto");

                    producto.setNombreProducto(nombreProductoActualizar);

                    producto.setPrecioProducto(precioProductoActualizar);

                    producto.setStockProducto(stockProductoActualizar);

                    producto.setEstadoProducto(estadoProductoActualizar);

                    producto.setIdProducto(idProducto);

                    productoDAO.actualizar(producto);

                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

                    break;

                case "Eliminar":

                    idProducto = Integer.parseInt(request.getParameter("idProducto"));

                    productoDAO.eliminar(idProducto);

                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);

                    break;

                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }

        if (menu.equals("Cliente")) {

            switch (accion) {

                case "Listar":

                    List lista = clienteDAO.listar();

                    request.setAttribute("clientes", lista);

                    break;

                case "Agregar":

                    String dniCliente = request.getParameter("txtDniCliente");

                    String nombreCliente = request.getParameter("txtNombresCliente");

                    String direccionCliente = request.getParameter("txtDireccionCliente");

                    String estadoProducto = request.getParameter("txtEstadoCiente");

                    cliente.setDniCliente(dniCliente);

                    cliente.setNombresCliente(nombreCliente);

                    cliente.setDireccionCliente(direccionCliente);

                    cliente.setEstadoCliente(estadoProducto);

                    clienteDAO.agregar(cliente);

                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);

                    break;

                case "Editar":

                    idCliente = Integer.parseInt(request.getParameter("idCliente"));

                    ClienteDTO clienteEditar = clienteDAO.listarId(idCliente);

                    request.setAttribute("cliente", clienteEditar);

                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);

                    break;

                case "Actualizar":

                    String dniClienteActualizar = request.getParameter("txtDniCliente");

                    String nombreClienteActualizar = request.getParameter("txtNombresCliente");

                    String direccionClienteActualizar = request.getParameter("txtDireccionCliente");

                    String estadoClienteActualizar = request.getParameter("txtEstadoCliente");

                    cliente.setDniCliente(dniClienteActualizar);

                    cliente.setNombresCliente(nombreClienteActualizar);

                    cliente.setDireccionCliente(direccionClienteActualizar);

                    cliente.setEstadoCliente(estadoClienteActualizar);

                    cliente.setIdCliente(idCliente);

                    clienteDAO.actualizar(cliente);

                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);

                    break;

                case "Eliminar":

                    idCliente = Integer.parseInt(request.getParameter("idCliente"));

                    clienteDAO.eliminar(idCliente);

                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);

                    break;

                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }

        if (menu.equals("NuevaVenta")) {

            switch (accion) {

                case "BuscarCliente":

                    String dniCliente = request.getParameter("txtDniCliente");

                    cliente.setDniCliente(dniCliente);
                    cliente = clienteDAO.buscar(dniCliente);

                    request.setAttribute("clienteBuscar", cliente);

                    break;

                case "BuscarProducto":

                    int id = Integer.parseInt(request.getParameter("txtCodigoProducto"));

                    producto = productoDAO.listarId(id);
                    request.setAttribute("clienteBuscar", cliente);
                    request.setAttribute("productoBuscar", producto);

                    request.setAttribute("lista", lista);
                    request.setAttribute("totalPagar", totalPagar);

                    break;

                case "Agregar":
                    request.setAttribute("clienteBuscar", cliente);
                    totalPagar = 0.0;

                    item = item + 1;

                    codigoProducto = producto.getIdProducto();

                    descripcionProducto = request.getParameter("txtNombreProducto");

                    precio = Double.parseDouble(request.getParameter("txtPrecioProducto"));

                    cantidad = Integer.parseInt(request.getParameter("txtCantidadProducto"));

                    subtotal = precio * cantidad;

                    venta = new Venta();

                    venta.setItem(item);

                    venta.setIdProducto(codigoProducto);

                    venta.setDescricionProducto(descripcionProducto);

                    venta.setPrecioProducto(precio);

                    venta.setCantidad(cantidad);

                    venta.setSubtotal(subtotal);

                    lista.add(venta);

                    for (int i = 0; i < lista.size(); i++) {

                        totalPagar = totalPagar + lista.get(i).getSubtotal();
                    }

                    request.setAttribute("totalPagar", totalPagar);

                    request.setAttribute("lista", lista);

                    break;
                case "GenerarVenta":
                    venta.setIdCliente(cliente.getIdCliente());
                    venta.setIdEmpleado(1);
                    venta.setNumeroSerie(numeroserie);
                    venta.setFechaVenta("2024-10-20");
                    venta.setMontoVenta(totalPagar);
                    venta.setEstadoVenta("1");
                    vdao.guardarVenta(venta);
                     int idv=Integer.parseInt(vdao.IDVentas());
                    for (int i=0; i< lista.size();i++) {
                        
                        venta=new Venta();
                        venta.setId(idv);
                        venta.setIdProducto(lista.get(i).getIdProducto());
                        venta.setCantidad(lista.get(i).getCantidad());
                        venta.setPrecioProducto(lista.get(i).getPrecioProducto());
                        vdao.guardarDetalleventas(venta);
                    }
                default:
                    venta=new Venta();
                    lista=new ArrayList<>();
                    item=0;
                    totalPagar=0.0;
                    numeroserie = vdao.GenerarSerie();
                    if (numeroserie == null) {
                        numeroserie = "00000001";
                        request.setAttribute("nserie", numeroserie);
                    } else {
                        int incrementar = Integer.parseInt(numeroserie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroserie = gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }
                    request.getRequestDispatcher("RegistrarVentas.jsp").forward(request, response);

            }

            request.getRequestDispatcher("RegistrarVentas.jsp").forward(request, response);
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
