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
@WebServlet(name = "obtenClienteActualizar", urlPatterns = {"/obtenClienteActualizar"})
public class obtenClienteActualizar extends HttpServlet {

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
            
            List<Clientes> clientes = crud.consultarClientes();
            
            Clientes cliente = new Clientes(request.getParameter("numCredencial"));
            
            for (Clientes clientei : clientes) {
                
                if (clientei.getNumCredencial().equalsIgnoreCase(cliente.getNumCredencial())) {
                    request.getSession().setAttribute("nombre", clientei.getNombre());
                    request.getSession().setAttribute("direccion", clientei.getDireccion());
                    request.getSession().setAttribute("telefono", clientei.getTelefono());
                    request.getSession().setAttribute("numCredencial", clientei.getNumCredencial());
                    request.getSession().setAttribute("numTarjeta", clientei.getNumeroTarjeta());
                    response.sendRedirect("capturaEditarCliente.jsp");
                }
                
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lo lamento</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> El cliente que has introducido no existe :( </h1>");
            out.print("<br><a href=\"Bienvenido_JSP.jsp#\"><button type=\"button\">Regresar</button></a>");
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
