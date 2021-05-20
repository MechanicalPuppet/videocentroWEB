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
@WebServlet(name = "agregaVideojuego", urlPatterns = {"/agregaVideojuego"})
public class agregaVideojuego extends HttpServlet {

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

            String numCatalogo = request.getParameter("numCatalogo");
            String titulo = request.getParameter("titulo");
            String genero = request.getParameter("genero");
            String clasificacion = request.getParameter("clasificacion");
            String consola = request.getParameter("consola");
            String fabricante = request.getParameter("fabricante");
            Integer version = Integer.parseInt(request.getParameter("version"));

            Videojuegos juegoNuevo = new Videojuegos(numCatalogo, titulo, genero, clasificacion, consola, fabricante, version);

            try {
                crud.registrarVideojuego(juegoNuevo);

                out.println("<!DOCTYPE html>"
                        + "<link href=\"estilos/estilosIndex.css\" rel=\"stylesheet\" type=\"text/css\"/>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Agregar Videojuego</title>");
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
                out.println("<h2> Videojuego agregado </h2>");
                out.println("<img src='https://t2.ea.ltmcdn.com/es/images/1/3/2/como_hacer_feliz_a_tu_perro_24231_orig.jpg' height=300px width=500px>");
                out.println("</article>");
                out.println("<footer>");
                out.println(" ¡Regresa para continuar operando!");
                out.println("</footer>");
                out.println("</body>");
                out.println("</html>");
            } catch (Exception e) {
                response.sendRedirect("errorYaExiste.html");
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
