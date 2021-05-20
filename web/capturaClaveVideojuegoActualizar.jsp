<%-- 
    Document   : editarVideojuego
    Created on : 4/12/2020, 07:37:50 PM
    Author     : Jbran
--%>

<%@page import="Entidades.Videojuegos"%>
<%@page import="Fachadas.PersistenciaBD"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="estilos/estilosIndex.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Videojuego</title>
    </head>
    
    
    <body>
        <header>
            
            <h2> Videocentro "Silent Games" </h2> <h3><em> José Brandon Hernández y Arturo Mendoza</em> </h3>
        </header>
        
        <nav>
            <button type="button" name="back" onclick="history.back()"></button>
            <ul>
                
                <li><a href="control?tarea=agregarVideojuego">¡Agregar videojuego!</a></li>
                <li><a href="control?tarea=editarVideojuego">¡Editar videojuego!</a></li>
                <li><a href="control?tarea=eliminarVideojuego">¡Eliminar videojuego!</a></li>
                <li><a href="control?tarea=consultarVideojuegos">¡Consultar videojuegos!</a></li>
                 <li><a href="control?tarea=consultarVideojuegosTitulo">¡Consultar videojuegos por titulo!</a></li>
                 <li><a href="control?tarea=consultarVideojuegosGenero">¡Consultar videojuegos por genero!</a></li>
            </ul>
            
        </nav>
        
        <article>
            
            <% 
            PersistenciaBD crud = new PersistenciaBD();

            List lista = crud.consultarVideojuegos();

            Videojuegos v;
            
            %>
            <h1> ¡Ingresa la clave de tu videojuego a editar!</h1>
            <form action="obtenVideojuegoActualizar">
                <ul>
                    <li><input type="number" name="numCatalogo" placeholder="Num. Catálogo" required min="1" style="width: 200px" max="9999999999"/></li>
                    <li><input type="submit" value ="Capturar id" />
                </ul>
            </form>

                    <%
                        out.println("<table border=1>");
            out.println("<tr>"
                        + "<th> No. Catalogo </th>"
                        + "<th> Titulo </th>"
                        + "<th> Genero </th>"
                        + "<th> Consola </th>"
                        + "<th> Fabricante </th>"
                        + "<th> Version </th>"
                        + "</tr>");
            for (int i = 0; i < lista.size(); i++) {

                v = (Videojuegos) lista.get(i);

                
                out.println("<tr>"
                        + "<td>" + v.getNumCatalogo() + "</td>"
                        + "<td>" + v.getTitulo() + "</td>"
                        + "<td>" + v.getGenero() + "</td>"
                        + "<td>" + v.getConsola() + "</td>"
                        + "<td>" + v.getFabricante() + "</td>"
                        + "<td>" + v.getVersion() + "</td>" + "</tr>");

            }
            out.println("</table>");
            
                        %>





        </article>

    </body>

    <footer>

        <h5>Todos los derechos reservados.</h5>
        <h6>Podría interesarte: <a href="https://ideasnuevas.net/wp-content/uploads/2016/08/Wallpapersxl-Perritos-Bonitos-Seguro-Que-Estabas-Esperando-Otro-Fondo-De-Perros-Pues-Ya-No-Tienes-276709-1440x1080.jpg">Contenido vital que todos deben ver.</a></h6>


    </footer>
                    
</html>
