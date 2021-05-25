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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import org.apache.commons.lang3.SerializationUtils;


/**
 *
 * @author R2
 */
@WebServlet(name = "agregaCliente", urlPatterns = {"/agregaCliente"})
public class agregaCliente extends HttpServlet {
 private final static String QUEUE_NAME = "hello";
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
            String numCredencial = request.getParameter("numCredencial");
            String nombre = request.getParameter("nombre");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono")+"";
            String tarjeta = request.getParameter("numTarjeta");
            Clientes cliente = new Clientes(numCredencial, nombre, direccion, telefono, tarjeta);
     
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost"); //If we wanted to connect to a node on a different machine we'd simply specify its hostname or IP address here.
            factory.setUsername("guest");

            
           try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            
           //     Lapiz lapiz = new Lapiz("5", "Bic", "Yellow");
            
            byte[] data = SerializationUtils.serialize(cliente);
            
            channel.basicPublish("", QUEUE_NAME, null, data);
            
            
            System.out.println(" [x] Sent '" + cliente.toString() + "'");
//            channel.close();
//            connection.close();

            response.sendRedirect("capturaCliente.jsp");
        }
            }catch(Exception e){
                System.out.println("AQUÍ ESTÁ EL ERROR AYUDA");
                System.out.println(e.getMessage());
                response.sendRedirect("errorYaExiste.html");
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
