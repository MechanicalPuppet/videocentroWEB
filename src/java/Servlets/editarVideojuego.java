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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jbran
 */
@WebServlet(name = "editarVideojuego", urlPatterns = {"/editarVideojuego"})
public class editarVideojuego extends HttpServlet {

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
            
            Videojuegos videojuego = new Videojuegos(request.getParameter("numCatalogo"),
                    request.getParameter("titulo"),
                    request.getParameter("genero"),
                    request.getParameter("clasificacion"),
                    request.getParameter("consola"),
                    request.getParameter("fabricante"),
                    Integer.parseInt(request.getParameter("version")));
            
            crud.actualizarVideojuego(videojuego);
            
            out.println("<!DOCTYPE html>"
                    + "<link href=\"estilos/estilosIndex.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Editar Videojuego</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<header>");
            out.println("¡Lo lograste!");
            out.println("</header>");
            out.println("<nav>");
            out.println("<a href=\"Bienvenido_JSP.jsp#\"><button type=\"button\"></button></a>");
            out.println("</nav>");
            out.println("<article>");
            out.println("<h1> ¡Genial! </h1>");
            out.println("<h2> Videojuego actualizado </h2>");
            out.println("<img src='https://ar.zoetis.com/_locale-assets/mcm-portal-assets/publishingimages/especie/caninos_perro_img.png'>");
            out.println("</article>");
            out.println("<footer>");
            out.println(" ¡Regresa para continuar operando!");
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
