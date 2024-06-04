<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% HttpSession obj = request.getSession();
if(obj != null && obj.getAttribute("usuario")!=null){

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Principal</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <title>Principal</title>
        <style>
            body {
                display: flex;
                flex-direction: column;
                min-height: 100vh;
                background-color: #1e1e1e;
            }

            footer {
                background-color: #1e1e1e;
                color: #fff;
            }

            .navbar-custom {
                background-color: #b19cd9;
            }

            .content {
                flex: 1 0 auto;
            }
            
            .footer {
                flex-shrink: 0;
                background-color: #f8f9fa;
                padding: 20px 0;
                text-align: center;
                width: 100%;
            }
        </style>
    </head>
    <body>
        <div class="content">
            <nav class="navbar navbar-expand-lg navbar-light navbar-custom">
                <div class="container-fluid">
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Inicio" target="MyFrame">Inicio</a>
                            </li>
                            <li class="nav-item">
                                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Producto&accion=Listar" target="MyFrame">Producto</a>
                            </li>
                            <li class="nav-item">
                                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Empleado&accion=Listar" target="MyFrame" >Empleado</a>
                            </li>
                            <li class="nav-item">
                                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=Cliente&accion=Listar" target="MyFrame" >Clientes</a>
                            </li>
                            <li class="nav-item">
                                <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="Controlador?menu=NuevaVenta&accion=default" target="MyFrame" >Nueva venta</a>
                            </li>
                        </ul>
                        <div class="dropdown">
                            <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                                ${usuario.getNombre()}
                            </button>
                            <ul class="dropdown-menu text-center">
                                <li>
                                    <a class="dropdown-item" href="#">
                                        <img src="IMAGENES/Logo_ServicioWeb-removebg.png" alt="Imagen de perfil" style="width: 50px; height: 50px"/>
                                    </a>
                                </li>
                                <li><a class="dropdown-item" href="#">${usuario.getUser()}</a></li>
                                <li><a class="dropdown-item" href="#">${usuario.getUser()}${usuario.getIdEmpleado()}@correo.com</a></li>
                                <form action="Validar" method="POST">
                                    <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
                                </form>
                            </ul>
                        </div>
                    </div>
                </div>
            </nav>
        </div>
        <div class="m-4 " style="height: 500px; overflow: hidden;">
            <iframe name="MyFrame" style="height: 100%; width: 100% ; border: none" src="Inicio.jsp"></iframe>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
        <footer>
            <p>
                &copy; 2024 Fabian Caro y Cristian Barrera. Todos los derechos reservados.
            </p>     
        </footer>
    </body>
</html>
<% }else{
                request.getRequestDispatcher("error.html").forward(request, response);

} %>
