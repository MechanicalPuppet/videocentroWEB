<%-- 
    Document   : capturaClaveVideojuegoInventarear
    Created on : 6/12/2020, 01:21:56 PM
    Author     : R2
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
        <title>INVENTARIO</title>
    </head>
    <body>
        <header>INVENTARIAR INVENTARIO</header>


        <nav>
            <button type="button" name="back" onclick="history.back()"></button>
            <ul>

                <li><a href="control?tarea=inventarear">Inventarear</a></li>
                <li><a href="control?tarea=desinventarear">Desinventarear</a></li>
                <li><a href="control?tarea=consultarInventario">Consultar inventario de videojuego</a></li>

            </ul>

        </nav>

        <article>
            
            <h1> ¡Ingresa la clave de tu videojuego al cual deseas inventariar su inventario!</h1>
            <form action="obtenVideojuegoInventarear">
                <ul>
                    <li><input type="number" name="numCatalogo" placeholder="Num. Catálogo" min="1" max="9999999999" required/></li>
                    <li><input type="submit" value ="Capturar id" />
                </ul>
            </form>

            <%
                PersistenciaBD crud = new PersistenciaBD();

                List lista = crud.consultarVideojuegos();

                Videojuegos v;
                out.println("<table border=1>");

                out.println("<tr>"
                            + "<td>" + "Núm.Catalago"+ "</td>"
                            + "<td>" + "Título" + "</td>"
                            + "<td>" + "Genero" + "</td>"
                            + "<td>" + "Consola" + "</td>"
                            + "<td>" + "Fabricante" + "</td>"
                            + "<td>" + "Version" + "</td>" + "</tr>");
                
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

                <footer>
                    <h5>Todos los derechos reservados.</h5>
                    <h6>Podría interesarte: <a href="https://ideasnuevas.net/wp-content/uploads/2016/08/Wallpapersxl-Perritos-Bonitos-Seguro-Que-Estabas-Esperando-Otro-Fondo-De-Perros-Pues-Ya-No-Tienes-276709-1440x1080.jpg">Contenido vital que todos deben ver.</a></h6>

                </footer>
    </body>
</html>
