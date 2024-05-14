<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Página de inicio</title>
        <style>
            body {
                background-color: #1e1e1e;
                color: #fff;
            }

            .welcome-message {
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                font-size: 2em;

                transition: opacity 1s ease-in-out;
            }

            .logo {
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%) translateY(100%);
                opacity: 0;
                transition: transform 1s ease-in-out, opacity 1s ease-in-out;
            }
        </style>
    </head>
    <body>
        <div class="welcome-message" id="welcomeMessage">
            <p>BIENVENIDO</p>
        </div>
        <div class="logo" id="logo">
            <img src="IMAGENES/Logo_ServicioWeb-removebg.png" alt="" style="height: 500px; width: 500px; "/>
            
        </div>
        <script>
            
            setTimeout(function () {
                
                var logo = document.getElementById("logo");

                
                welcomeMessage.style.opacity = 1;
                
                logo.style.opacity = 1;

                
                logo.style.transform = "translate(-50%, -50%) translateY(0)";
                
            }, 5000);
        </script>
    </body>
</html>
