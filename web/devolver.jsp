<%-- 
    Document   : devolver
    Created on : 6/12/2020, 10:34:12 PM
    Author     : Jbran
--%>

<%@page import="Entidades.Rentasvideojuegos"%>
<%@page import="Fachadas.PersistenciaBD"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="estilos/estilosIndex.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Devolver</title>
    </head>
    <body>
        <header><h1>¡Estás a punto de devolver algo!</h1></header>
            <nav>
                 <a href="Bienvenido_JSP.jsp"><button type="button"></button></a>
                <ul>
                <li><a href="control?tarea=rentar">¡Rentar un videojuego!</a></li>
                <li><a href="control?tarea=devolver">¡Devolver un videojuego!</a></li>
                </ul>
    
        </nav>
         <article>
        <%
             PersistenciaBD crud = new PersistenciaBD();
  
                 List<Rentasvideojuegos> lista = crud.consultarRentas();
                 out.println("<table border=1>");
                 out.println("<tr>");
                 out.println("<th> Renta </th>");
                 out.println("<th> Credencial </th>");
                 out.println("<th> Articulo </th>");
                 out.println("<th> Fecha </th>");
                 out.println("<th> Tiempo </th>");
                 out.println("</tr>");
                 for (int i = 0; i < lista.size(); i++) {
                     out.println("<td>" + (i + 1) + "</td>"
                             + "<td>" + lista.get(i).getClientes().getNumCredencial() + "</td>"
                             + "<td>" + lista.get(i).getVideojuegos().getNumCatalogo() + "</td>"
                             + "<td>" + lista.get(i).getFechaRenta() + "</td>"
                             + "<td>" + lista.get(i).getTiempoRenta() + "</td> </tr>");
                 }
                 out.println("</table>");
               
        
        %>
        
        
        
                   
                       <form action="devolver">
                <ul>
                    <li><input type="number" name="numRenta" placeholder="Num. Renta" style="width :200px" required min="1" max="<%=crud.consultarRentas().size() %>"/></li>
                    <li><input type="submit" value="Realizar devolución"> </li>
                </ul> 
                
            </form> 
                        
                    </article>
                    
                    <footer>
                       <h5>Todos los derechos reservados.</h5>
            <h6>Podría interesarte: <a href="https://ideasnuevas.net/wp-content/uploads/2016/08/Wallpapersxl-Perritos-Bonitos-Seguro-Que-Estabas-Esperando-Otro-Fondo-De-Perros-Pues-Ya-No-Tienes-276709-1440x1080.jpg">Contenido vital que todos deben ver.</a></h6> 
                        
                    </footer>
        
        
    </body>
</html>
