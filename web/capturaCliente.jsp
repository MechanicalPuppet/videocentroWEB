<%-- 
    Document   : capturaCliente
    Created on : 7/12/2020, 12:05:24 AM
    Author     : Jbran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>CLIENTES</title>
        <meta charset="UTF-8">
        <link href="estilos/estilosIndex.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        <header><h1>CLIENTES</h1></header>
        
         <nav>
             <button type="button" name="back" onclick="history.back()"></button>
            <ul>
                
                <li><a href="control?tarea=agregarCliente">Agregar cliente</a></li>
                <li><a href="control?tarea=editarCliente">Editar cliente</a></li>
                <li><a href="control?tarea=eliminarCliente">Eliminar cliente</a></li>
                <li><a href="control?tarea=consultarCliente">Consultar cliente</a></li>
                
            </ul>
            
        </nav>
        
        <article>
            <h1> ¡AGREGAR CLIENTE!</h1>
            <h4>Solamente se permiten letras</h4>
            <form action="agregaCliente">
                <ul>
                    <li><input type="number" name="numCredencial" placeholder="Núm. credencial"  min="1" max="9999999999" required/> </li>
                    <li><input type="text" name="nombre" placeholder="Nombre" pattern="[a-zA-Z ]{3,35}" maxlength="35" required/> </li>
                    <li><input type="text" name="direccion" placeholder="Dirección"  maxlength="35" required/> </li>
                    <li><input type="text" name="numTarjeta" placeholder="Tarjeta de credito" maxlength="16" pattern="^[0-9]+" required/></li>
                    <li><input type="text" name="telefono" placeholder="Teléfono" maxlength="15" pattern="^[0-9]+"/> </li>
                    <li><input type="submit" value="Agregar cliente"/> </li>
                </ul>
            </form>

        </article>
        <footer>
            <h5>Todos los derechos reservados.</h5>
            <h6>Podría interesarte: <a href="https://ideasnuevas.net/wp-content/uploads/2016/08/Wallpapersxl-Perritos-Bonitos-Seguro-Que-Estabas-Esperando-Otro-Fondo-De-Perros-Pues-Ya-No-Tienes-276709-1440x1080.jpg">Contenido vital que todos deben ver.</a></h6>


        </footer>
    </body>
</html>
