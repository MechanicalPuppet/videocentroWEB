<%-- 
    Document   : Bienvenido
    Created on : 1/12/2020, 02:03:09 AM
    Author     : R2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="estilos/estilosIndex.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="estilos/estilosIndex.css" rel="stylesheet" type="text/css"/>
        <title>VIDEOCENTRO ARTURO Y BRANDON</title>
    </head>
    <body>
        <%
            if(session.getAttribute("elUsuario")==null){
            response.sendRedirect("Login_JSP.jsp");
            }
        %>
        
        <header>
            <h2> Videocentro "Silent Games" </h2> <h3><em> José Brandon Hernández y Arturo Mendoza</em> </h3>
            
        </header>
        
        <nav>
            <ul>
                
                <li><a href="clientes.html">Clientes</a></li>
                <li><a href="videojuegos.html">Videojuegos</a></li>
                <li><a href="rentas.html">Rentas</a></li>
                <li><a href="inventario.html">Inventario</a></li>
                
            </ul>
            
        </nav>
         <article>
            
             <h1>¡Bienvenido al videocentro <em>Silent Games</em></h1>
            <h2>Selecciona una opción de nuestro menú de navegación a la izquierda para empezar.</h2>
            <h3>¡No te vas a perder!</h3>
            <h3><----</h3>
            <h4>(Creo)</h4>
            <img src="https://media2.giphy.com/media/xUA7aO0PLIyJffDln2/giphy.gif" width="150px">
        </article>
        
        
        <footer>
           <h5>Todos los derechos reservados.</h5>
            <h6>Podría interesarte: <a href="https://ideasnuevas.net/wp-content/uploads/2016/08/Wallpapersxl-Perritos-Bonitos-Seguro-Que-Estabas-Esperando-Otro-Fondo-De-Perros-Pues-Ya-No-Tienes-276709-1440x1080.jpg">Contenido vital que todos deben ver.</a></h6>
            
            
        </footer>
        
    </body>
</html>
