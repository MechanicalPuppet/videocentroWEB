/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;


import Entidades.Clientes;
import Fachadas.PersistenciaBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author R2
 */
@WebServlet(name = "consultarClientes", urlPatterns = {"/consultarClientes"})
public class consultarClientes extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            PersistenciaBD crud = new PersistenciaBD();

            List lista = crud.consultarClientes();

            if (!lista.isEmpty()) {
                Clientes c;

                out.println("<!DOCTYPE html>"
                        + "<link href=\"estilos/estilosIndex.css\" rel=\"stylesheet\" type=\"text/css\"/>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Consulta todos los clientes</title>");
                out.println("</head>");
                out.println("<header>Consulta todos los clientes </header>");
                out.println("<nav>");
                out.println("<a href=\"Bienvenido_JSP.jsp\"><button type=\"button\"></button></a>");
                out.println("</nav>");
                out.println("<body>");
                out.println("<article>");
                out.println("<table border=1>");

                out.println("<tr> <th> Num. Credencial </th>"
                        + "<th> Nombre </th>"
                        + "<th> Direccion </th>"
                        + "<th> Telefono </th> </tr>");
                for (int i = 0; i < lista.size(); i++) {

                    c = (Clientes) lista.get(i);

                    out.println("<tr>"
                            + "<td>" + c.getNumCredencial() + "</td>"
                            + "<td>" + c.getNombre() + "</td>"
                            + "<td>" + c.getDireccion() + "</td>"
                            + "<td>" + c.getTelefono() + "</td>" + "</tr>");

                }

                out.println("</table>");
                out.println("</article>");
                out.println("<footer> <h5>Todos los derechos reservados.</h5>\n"
                        + "            <h6>Podría interesarte: <a href=\"https://ideasnuevas.net/wp"
                        + "-content/uploads/2016/08/Wallpapersxl-Perritos-Bonitos-"
                        + "Seguro-Que-Estabas-Esperando-Otro-Fondo-De-Perros-Pues-Ya"
                        + "-No-Tienes-276709-1440x1080.jpg\">Contenido vital que todos d"
                        + "eben ver.</a></h6> </footer>");
                out.println("</body>");
                out.println("</html>");
            } else {
                
                out.println("<!DOCTYPE html>"
                        + "<link href=\"estilos/estilosIndex.css\" rel=\"stylesheet\" type=\"text/css\"/>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Consulta todos los videojuegos</title>");
                out.println("</head>");
                out.println("<header>Consulta todos los videojuegos </header>");
                out.println("<nav>");
                out.println("<a href=\"Bienvenido_JSP.jsp\"><button type=\"button\"></button></a>");
                out.println("</nav>");
                out.println("<body>");
                out.println("<article>");
                out.println("<h1>No se encontro ningun cliente<h1>");
                out.println("</article>");
                out.println("<footer> <h5>Todos los derechos reservados.</h5>\n"
                        + "            <h6>Podría interesarte: <a href=\"https://ideasnuevas.net/wp"
                        + "-content/uploads/2016/08/Wallpapersxl-Perritos-Bonitos-"
                        + "Seguro-Que-Estabas-Esperando-Otro-Fondo-De-Perros-Pues-Ya"
                        + "-No-Tienes-276709-1440x1080.jpg\">Contenido vital que todos d"
                        + "eben ver.</a></h6> </footer>");
                out.println("</body>");
                out.println("</html>");
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
