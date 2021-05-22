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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jbran
 */
@WebServlet(name = "obtenVideojuegoActualizar", urlPatterns = {"/obtenVideojuegoActualizar"})
public class obtenVideojuegoActualizar extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            
            PersistenciaBD crud = new PersistenciaBD();
            
            List<Videojuegos> lista = crud.consultarVideojuegos();
            Videojuegos videojuego = new Videojuegos(request.getParameter("numCatalogo"));
            
            
     
            
            
            for (Videojuegos juego : lista) {
             
                if(juego.getNumCatalogo().equalsIgnoreCase(videojuego.getNumCatalogo())){
                   request.getSession().setAttribute("juego", juego);
                   request.getSession().setAttribute("numCatalogo", juego.getNumCatalogo());
                   request.getSession().setAttribute("clasificacion", juego.getClasificacion());
                   request.getSession().setAttribute("consola", juego.getConsola());
                   request.getSession().setAttribute("titulo",juego.getTitulo());
                   request.getSession().setAttribute("fabricante", juego.getFabricante());
                   request.getSession().setAttribute("genero",juego.getGenero());
                  request.getSession().setAttribute("version", juego.getVersion());
                
                   response.sendRedirect("capturaEditarVideojuego.jsp");
                
//                   RequestDispatcher rd = request.getRequestDispatcher("capturaEditarVideojuegoActualizar.jsp");
//                   rd.forward(request, response);
            
                }
                
            }
            
            out.println("<!DOCTYPE html>"
                    + "<link href=\"estilos/estilosIndex.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lo lamento</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<header>");
            out.println("¡Lo lamento!");
            out.println("</header>");
            out.println("<nav>");
            out.println("<a href=\"Bienvenido_JSP.jsp#\"><button type=\"button\"></button></a>");
            out.println("</nav>");
            out.println("<article>");
            out.println("<h1> Error </h1>");
            out.println("<h2> El videojuego que has introducido no existe :( </h2>");
            out.println("<img src='https://images.ctfassets.net/n44u7kn3xh7u/2oNeUrQWFauw6kkaWE6qG0/4c67fba90ff8235fab66d1a90d953381/perro-triste-p.jpg' height=200px width=300px>");
            out.println("</article>");
            out.println("<footer>");
            out.println(" ¡Te recomiendo regresar a la página y reintentarlo!");
            out.println("</footer>");
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
