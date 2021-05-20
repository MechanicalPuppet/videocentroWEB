<%-- 
    Document   : capturaInventarearVideojuego
    Created on : 6/12/2020, 01:31:15 PM
    Author     : R2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="estilos/estilosIndex.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INVENTARIO</title>
    </head>
    <body>
        <header><h1>INVENTARIAR INVENTARIO</h1></header>


        <nav>
            <button type="button" name="back" onclick="history.back()"></button>
            <ul>

                <li><a href="control?tarea=inventarear">Inventarear</a></li>
                <li><a href="control?tarea=desinventarear">Desinventarear</a></li>
                <li><a href="control?tarea=consultarInventario">Consultar inventario de videojuego</a></li>

            </ul>

        </nav>

        <article>
            
            <h1> ¡Ingresa la cantidad de existencia del videojuego!</h1>
            <form action="inventarear">
                <ul>
                    <label for="numCatalogo">No. Catalogo</label>
                    <li><input type="number" id="numCatalogo" name="numCatalogo" readonly="readonly" value="<%=session.getAttribute("numCatalogo")%>"/></li>
                    <label for="titulo"> Titulo</label>
                    <li><input type="text" id="titulo" name="titulo" readonly="readonly" value="<%= session.getAttribute("titulo") %>"/> </li>
                    <label for="genero"> Genero</label>
                    <li><input type="text" id="genero" name="genero" readonly="readonly" value="<%=session.getAttribute("genero") %>"/> </li>
                    <label for="clasif"> Clasificación</label>
                    <li><input type="text" id="clasif" name="clasificacion" readonly="readonly" value="<%=session.getAttribute("clasificacion") %>"/> </li>
                    <label for="consola"> Consola</label>
                    <li><input type="text" id="consola" name="consola" readonly="readonly" value="<%=session.getAttribute("consola") %>"/> </li>
                    <label for="fabricante"> Fabricante</label>
                    <li><input type="text" id="fabricante" name="fabricante" readonly="readonly" value="<%=session.getAttribute("fabricante") %>"/> </li>
                    <label for="version"> Versión</label>
                    <li><input type="number" id="version" name="version" readonly="readonly" value="<%=session.getAttribute("version") %>"/> </li>
                    <label for="existencia"> Existencia </label>
                    <li><input type="number" id="existencia" name="existencia" placeholder="Existencia" min="1" max="9999999999" required/> </li>
                    <br>
                    <input type="submit" value ="Inventarear videojuego" />
                </ul>
            </form>

        </article>

        <footer>

            <h5>Todos los derechos reservados.</h5>
            <h6>Podría interesarte: <a href="https://ideasnuevas.net/wp-content/uploads/2016/08/Wallpapersxl-Perritos-Bonitos-Seguro-Que-Estabas-Esperando-Otro-Fondo-De-Perros-Pues-Ya-No-Tienes-276709-1440x1080.jpg">Contenido vital que todos deben ver.</a></h6>


        </footer>
    </body>
</html>
