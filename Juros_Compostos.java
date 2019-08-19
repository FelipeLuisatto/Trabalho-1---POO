/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel
 */
@WebServlet(urlPatterns = {"/juros_compostos.html"})
public class Juros_Compostos extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Juros_Compostos</title>");   
            
            /*CSS*/
            
            out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
           
            out.println("<style>");
            
            out.println("body{background-color: cyan}");
            out.println(".titulo{margin-top:20px; text-align:center;font-family:arial;}");
            out.println("a{text-align:center;font-size:30px;}");
            
            out.println("</style>");
            
            
            /*CSS*/
            
            out.println("</head>");
            out.println("<body>");
            
            
            out.println("<form class='titulo' action='resul_compostos.html' method='POST'>");
                out.println("<h1 class='titulo'>Calculadora juros compostos</h1>");
                out.println("<label>Capital: </label><br>");
                out.println("<input type='text' name='capital' placeholder='Insira o Capital Inicial: '><br>");
                out.println("<label>Taxa mensal: </label><br>");
                out.println("<input type='text' name='taxa' placeholder='Insira a Taxa Mensal: '><br>");
                out.println("<label>Meses: </label><br>");
                out.println("<input type='text' name='tempo' placeholder='Insira o Tempo: (meses)'><br>");
                out.println("<input type='submit' value='calcular'>");
            out.println("</form>");
        
            out.println("<a href='home.html'><center>Retornar a Home</center></a>");
            
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
