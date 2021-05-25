/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;


import Entidades.Clientes;
import Fachadas.PersistenciaBD;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.TimeoutException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.SerializationUtils;


/**
 *
 * @author R2
 */
@WebServlet(name = "consultarClientes", urlPatterns = {"/consultarClientes"})
public class consultarClientes extends HttpServlet {
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

            
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("guest"); 
        try{
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
       System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
            
                    Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                    AMQP.BasicProperties properties, byte[] body) throws IOException{
                    Object object = SerializationUtils.deserialize(body);
                    System.out.println("[x] Recieved '" + object + "'");
                    crud.registrarCliente((Clientes) object);
            }
        };
        channel.basicConsume(QUEUE_NAME,true, consumer);
            
        } catch (IOException | TimeoutException x){
            System.out.println(x.getMessage());
        }
            
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
