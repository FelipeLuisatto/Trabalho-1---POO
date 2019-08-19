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
 * @author Natália
 */
@WebServlet(urlPatterns = {"/resul_simples.html"})
public class Resul_Simples extends HttpServlet {

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
            out.println("<title>Servlet Resul_Simples</title>");     
            
            /*CSS*/
            
            out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
           
            out.println("<style>");
            
            out.println("body{background-color: cyan}");
            out.println("margin-top:20px; text-align:center;font-family:arial;}");
            out.println("a{font-size:30px;}");
            
            out.println("</style>");
            
            /*CSS*/
            
            out.println("</head>");
            out.println("<body>");
            
            try {
            
            /*Pegando parametros do Servlet anterior*/
            double c = Double.parseDouble(request.getParameter("c"));
            double i = Double.parseDouble(request.getParameter("i"));
            double t = Double.parseDouble(request.getParameter("t"));
            
            /*Formula do juros simples e do montante*/
            double j = (c * i * t);
            double m = j + c;

            out.println("<h1 class='titulo'>O juros é: " + j + "</h1><br>");
            out.println("<h1 class='titulo'>O montante é: " + m +"</h1>");
            
            out.println("<a href='home.html'><center>Retornar a Home</center></a>");
            
            /*Tratamento de Exceção*/
            }catch(NumberFormatException ex)
            {
            out.println("<h1>Parâmetro(s) inválido(s)!</h1>");
            out.println("<br>");
            out.println("<a href='juros_simples.html'>Retornar</a>");
            }
        
            
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
