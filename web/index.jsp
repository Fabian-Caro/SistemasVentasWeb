<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es-CO">
    <head>
        <meta charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Inicio de sesión</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">       
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
            <div class="container mt-4 col-lg-4">
                <div class="card col-sm-10">
                    <div class="card-body">
                        <form class="form-sign" action="Validar" method="POST">
                            <div class="form-group text-center">
                                <h3>Login</h3>
                                <img src="IMAGENES/Logo_ServicioWeb-removebg.png" alt="" style="height: 180px"/>
                                <label>Bienvenidos al sistema</label>
                            </div>
                            <div class="form-group">
                                <label>Usuario:</label>
                                <input type="text" name="txtuser" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Password:</label>
                                <input type="password" name="txtpass" class="form-control">
                            </div>
                            <input type="submit" name="accion" value="Ingresar" class="btn btn-primary btn-block">
                        </form>
                    </div>
                </div>
            </div>
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