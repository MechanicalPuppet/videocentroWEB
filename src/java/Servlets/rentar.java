/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entidades.Clientes;
import Entidades.Rentasvideojuegos;
import Entidades.Videojuegos;
import Fachadas.PersistenciaBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jbran
 */
@WebServlet(name = "rentar", urlPatterns = {"/rentar"})
public class rentar extends HttpServlet {

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
            List<Clientes> listaClientes = crud.consultarClientes();
                            //Aún sin implementar 20/05/2021 - Brandon
            List<Videojuegos> listaVideojuegos = crud.consultarVideojuegos(); //Esto es incorrecto porque deben ser sólo los disponibles. Implementar logica de existencia
            Rentasvideojuegos renta = new Rentasvideojuegos();

            for (Videojuegos listaVideojuego : listaVideojuegos) {
                if (listaVideojuego.getNumCatalogo().equalsIgnoreCase(request.getParameter("numCatalogo"))) {
                    renta.setVideojuegos(listaVideojuego);
                }
            }

            for (Clientes listaCliente : listaClientes) {
                if (listaCliente.getNumCredencial().equalsIgnoreCase(request.getParameter("numCredencial"))) {
                    renta.setClientes(listaCliente);
                }

            }

            Date fecha = new Date();
            renta.setFechaRenta(fecha);

            renta.setTiempoRenta(Integer.parseInt(request.getParameter("tiempoRenta")));

            try {
                crud.registrarRenta(renta); // ¿Quizás?
                
                out.println("<!DOCTYPE html>"
                        + "<link href=\"estilos/estilosIndex.css\" rel=\"stylesheet\" type=\"text/css\"/>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Rentar</title>");
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
                out.println("<h2> Renta finalizada con exito </h2>");
                out.println("<img src='https://t2.ea.ltmcdn.com/es/images/1/3/2/como_hacer_feliz_a_tu_perro_24231_orig.jpg' height=300px width=500px>");
                out.println("</article>");
                out.println("<footer>");
                out.println(" ¡Regresa para continuar operando!");
                out.println("</footer>");
                out.println("</body>");
                out.println("</html>");
                
            } catch (Exception e) {
                out.println("<!DOCTYPE html>"
                        + "<link href=\"estilos/estilosIndex.css\" rel=\"stylesheet\" type=\"text/css\"/>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Rentar</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<header>");
                out.println("¡OH NOOOO!");
                out.println("</header>");
                out.println("<nav>");
                out.println("<a href=\"Bienvenido_JSP.jsp#\"><button type=\"button\"></button></a>");
                out.println("</nav>");
                out.println("<article>");
                out.println("<h1> Upss... </h1>");
                out.println("<h2> Parece que ya rentaste este articulo </h2>");
                out.println("</article>");
                out.println("<footer>");
                out.println(" ¡Regresa para continuar operando!");
                out.println("</footer>");
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
