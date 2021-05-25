<%-- 
    Document   : Login_JSP
    Created on : 30/11/2020, 10:59:37 PM
    Author     : R2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <style>
        article{
            background-image: url("https://assets.eleconomista.com.mx/__export/1581119523386/sites/eleconomista/img/2020/02/07/que-son-esports.jpg_554688468.jpg");
            background-size: 100% 100%;
            background-repeat: no-repeat;

        }
    </style>
    <head>
        <link href="estilos/estilosIndex.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <meta name="google-signin-client_id" content="29501203247-abuvvboofsv6k8smmhpcoq29bnobt5un.apps.googleusercontent.com">


        <title>Login</title>
    </head>
    <body>
        <header>
            <h1>LOGIN</h1>
        </header>


        <nav>
            <!-- 
        <form action="Login_Servlet">
            <ul>
                <li>Ingresa usuario: <input type="text" name="usuario"></li>
            <li>Ingresa contraseña: <input type="password" name="contra"></li>
            <input type="submit"/>
            </ul>
        </form>
            -->
            <div class ="g-signin2" data-onsuccess="onSignIn" id="miDiv"></div>
            <div id ="miDiv"></div>
            <img id="miImg"/>
            <p id="nombre"></p>
                         
           
            <button onclick="onSignOff">Log out</button>
        </nav>

        <script>

            function onSignIn(googleUser) {
                var profile = googleUser.getBasicProfile();
                var imagen = profile.getImageUrl();
                var name = profile.getName();
                var email = profile.getEmail();
                document.getElementById("miImg").src = imagen;
                document.getElementById("nombre").innerHTML = name;
                window.location.href = "Bienvenido_JSP.jsp";
                
            }

        </script>
        
    <script>
             function onSignOff(){
               gapi.auth2.getAuthInstance().disconnect();
                location.reload();
                window.location.href = "Login_JSP.jsp";
                
            }
        
    </script>

        <article>
            
            
        </article>
        <footer>
            
            Pst pst pst gatitos pst pst pst
            
        </footer>
    </body>
</html>
