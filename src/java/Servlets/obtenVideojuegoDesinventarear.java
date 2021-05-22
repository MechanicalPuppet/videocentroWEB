/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entidades.Videojuegos;
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
@WebServlet(name = "obtenVideojuegoDesinventarear", urlPatterns = {"/obtenVideojuegoDesinventarear"})
public class obtenVideojuegoDesinventarear extends HttpServlet {

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
            
            List<Videojuegos> lista = crud.consultarVideojuegos();
            Videojuegos videojuego = new Videojuegos(request.getParameter("numCatalogo"));
            
            
            for (Videojuegos juego : lista) {
             
                if(juego.getNumCatalogo().equalsIgnoreCase(videojuego.getNumCatalogo())){
                   request.getSession().setAttribute("numCatalogo", juego.getNumCatalogo());
                   request.getSession().setAttribute("clasificacion", juego.getClasificacion());
                   request.getSession().setAttribute("consola", juego.getConsola());
                   request.getSession().setAttribute("titulo",juego.getTitulo());
                   request.getSession().setAttribute("fabricante", juego.getFabricante());
                   request.getSession().setAttribute("genero",juego.getGenero());
                  request.getSession().setAttribute("version", juego.getVersion());
                
                   response.sendRedirect("capturaDesinventarearVideojuego.jsp");
                
                }
                
            }
            out.println("<!DOCTYPE html>"
                        + "<link href=\"estilos/estilosIndex.css\" rel=\"stylesheet\" type=\"text/css\"/>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Lo lamento</title>");
                out.println("</head>");
                out.println("<header>¡Oh no!</header>");
                out.println("<nav>");
                out.println("<a href=\"Bienvenido_JSP.jsp\"><button type=\"button\"></button></a>");
                out.println("</nav>");
                out.println("<body>");
                out.println("<article>");
                out.println("<h1>El articulo que has introducido no existe :c<h1>");
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
