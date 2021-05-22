<%-- 
    Document   : capturaCredencialClienteEliminar
    Created on : 5/12/2020, 11:08:13 PM
    Author     : R2
--%>

<%@page import="Entidades.Clientes"%>
<%@page import="Fachadas.PersistenciaBD"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="estilos/estilosIndex.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CLIENTES</title>
    </head>
    <body>

        <header>ELIMINAR CLIENTES</header>

        <nav>
            <button type="button" name="back" onclick="history.back()"></button>
            <ul>

                <li><a href="control?tarea=agregarCliente">Agregar clientes</a></li>
                <li><a href="control?tarea=editarCliente">Editar clientes</a></li>
                <li><a href="control?tarea=eliminarCliente">Eliminar clientes</a></li>
                <li><a href="control?tarea=consultarCliente">Consultar clientes</a></li>

            </ul>

        </nav>

        <article>
            <h1> ¡Ingresa la clave del cliente a eliminar!</h1>
            <form action="obtenClienteEliminar">

                <ul>
                    <li><input type="number" name="numCredencial" placeholder="Num. Credencial" min="1" max="9999999999" required/></li>
                    <li><input type="submit" value ="Capturar id" />
                </ul>
            </form>
            <%
                PersistenciaBD crud = new PersistenciaBD();

                List listaClientes = crud.consultarClientes();
                Clientes c;
                out.println("<table border=1>");
                out.println("<tr>");
                out.println("<th> Numero credencial </th>");
                out.println("<th> Nombre </th>");
                out.println("<th> Direccion </th>");
                out.println("<th> Tarjeta de credito </th>");
                out.println("<th> Telefono </th>");
                out.println("</tr>");

                    for (int i = 0; i < listaClientes.size(); i++) {

                        c = (Clientes) listaClientes.get(i);

                        out.println("<tr>"
                                + "<td>" + c.getNumCredencial() + "</td>"
                                + "<td>" + c.getNombre() + "</td>"
                                + "<td>" + c.getDireccion() + "</td>"
                                + "<td>" + c.getNumeroTarjeta() + "</td>"
                                + "<td>" + c.getTelefono() + "</td>" + "</tr>");

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
