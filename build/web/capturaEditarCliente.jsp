<%-- 
    Document   : capturaEditarCliente
    Created on : 5/12/2020, 08:45:04 PM
    Author     : R2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="estilos/estilosIndex.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CLIENTES</title>
    </head>
    <body>
        <header>EDITAR CLIENTES</header>
        
        
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
            <h1> ¡Edita al cliente!</h1>
            <form action="editarCliente">
                <ul>

                    <label for="uno">Num Credencial</label>
                    <li><input type="number" id="uno"name="numCredencial" readonly value="<%=session.getAttribute("numCredencial")%>"/></li>
                    <label for="dos">Nombre</label>
                    <li><input type="text" id="dos" name="nombre" pattern="[a-zA-Z ]{3,35}" maxlength="35" required value="<%= session.getAttribute("nombre")%>"/> </li>
                    <label for="tres">Dirección</label>
                    <li><input type="text" id="tres" name="direccion" maxlength="35" required value="<%=session.getAttribute("direccion")%>"/> </li>
                    <label for="tresymedio">Tarjeta de credito</label>
                    <li><input type="text" name="numTarjeta" placeholder="Tarjeta de credito" maxlength="16" pattern="^[0-9]+" required value="<%=session.getAttribute("numTarjeta")%>"/></li>
                    <label for="cuatro">Telefono</label>
                    <li><input type="text" id="cuatro" name="telefono" maxlength="15" pattern="^[0-9]+" value="<%=session.getAttribute("telefono")%>"/> </li>

                    <li><input type="submit" value ="Editar cliente" />
                </ul>
            </form>

        </article>

        <footer>
            <h5>Todos los derechos reservados.</h5>
            <h6>Podría interesarte: <a href="https://ideasnuevas.net/wp-content/uploads/2016/08/Wallpapersxl-Perritos-Bonitos-Seguro-Que-Estabas-Esperando-Otro-Fondo-De-Perros-Pues-Ya-No-Tienes-276709-1440x1080.jpg">Contenido vital que todos deben ver.</a></h6>

        </footer>
    </body>
</html>
