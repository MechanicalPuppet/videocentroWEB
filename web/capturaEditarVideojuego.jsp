<%-- 
    Document   : editarVideojuego
    Created on : 4/12/2020, 09:23:31 PM
    Author     : Jbran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="estilos/estilosIndex.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edita tu videojuego</title>
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
            <h1> ¡Edita tu videojuego!</h1>
            <form action="editarVideojuego">
                <ul>
                    <!-- USO REQUEST O SESSION AQUÍ? POR QUÉ SIEMPPRE ES NULL?-->
                    <label for="numCatalogo">No. Catalogo</label>
                    <li><input type="number" id="numCatalogo" name="numCatalogo" readonly="readonly" value="<%=session.getAttribute("numCatalogo")%>"/></li>
                    <label for="titulo"> Titulo</label>
                    <li><input type="text" id="titulo" name="titulo" maxlength="35" value="<%= session.getAttribute("titulo") %>" required/> </li>
                    <label for="genero"> Genero</label>
                    <li><input type="text" id="genero" name="genero" maxlength="20" value="<%=session.getAttribute("genero") %>" required/> </li>
                    <label for="clasif"> Clasificación</label>
                    <li><input type="text" id="clasif" name="clasificacion" maxlength="20" value="<%=session.getAttribute("clasificacion") %>" required/> </li>
                    <label for="consola"> Consola</label>
                    <li><input type="text" id="consola" name="consola" maxlength="20" value="<%=session.getAttribute("consola") %>" required/> </li>
                    <label for="fabricante"> Fabricante</label>
                    <li><input type="text" id="fabricante" name="fabricante" maxlength="35" value="<%=session.getAttribute("fabricante") %>" required/> </li>
                    <label for="version"> Versión</label>
                    <li><input type="number" id="version" name="version" max ="999999999" value="<%=session.getAttribute("version") %>" required/> </li>
                    <li><input type="submit" value ="Editar videojuego" />
                </ul>
                </form>
            
        </article>
                    
                    <footer>
            
            <h5>Todos los derechos reservados.</h5>
            <h6>Podría interesarte: <a href="https://ideasnuevas.net/wp-content/uploads/2016/08/Wallpapersxl-Perritos-Bonitos-Seguro-Que-Estabas-Esperando-Otro-Fondo-De-Perros-Pues-Ya-No-Tienes-276709-1440x1080.jpg">Contenido vital que todos deben ver.</a></h6>
            
            
        </footer>
    </body>
</html>
