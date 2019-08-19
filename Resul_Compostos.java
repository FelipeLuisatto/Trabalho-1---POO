
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luisatto
 */
@WebServlet(urlPatterns = {"/resul_compostos.html"})
public class Resul_Compostos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ResultadoCompostoServlet</title>");     
            
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
            
            try{
                
            /*Classe para formatação de valores*/
            DecimalFormat df = new DecimalFormat();
            df.applyPattern("R$ #,##0.00");
            
            /*Pegando parametros do Servlet anterior*/
            String Scapital = request.getParameter("capital");
            String Staxa = request.getParameter("taxa");
            String Stempo = request.getParameter("tempo");
            
            /*convertando Strings para tipos mais apropriados*/
            double capital = Double.parseDouble(Scapital);
            double taxa = Double.parseDouble(Staxa);
            int tempo = Integer.parseInt(Stempo);
            
            /*Formula para o Montante: M = C * (1 + i/100) ^ t */
            double montante = capital * Math.pow((1 + taxa/100), tempo);
            
            /*Formula para J Composto: J = M - C */
            double Jcomposto = montante - capital;
            
            /*Quantidade de Linhas na Tabela*/
            int QntLinhas = 1;
            
            out.println("<h1>Resultado - Juros Composto</h1>");
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<th>Meses</th>");
            out.println("<th>Montante Acumulado</th>");
            out.println("</tr>");
            
            /*Laço para Gerar as Linhas e Colunas dos Resultados*/
            for(int i = tempo; i > 0; i--){
            out.println("<tr>");
            out.println("<td>" + QntLinhas + "</td>");
            out.println("<td>" + df.format(capital * Math.pow((1 + taxa/100), QntLinhas)) + "</td>");
            out.println("</tr>");
            QntLinhas = QntLinhas + 1;
             }
            
            /*Linha final contendo o Juros Composto*/
            out.println("<tr>");
            out.println("<th>Juros Composto:</th>");
            out.println("<td>" + df.format(Jcomposto) + "</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<br>");
            out.println("<a href='home.html'>Retornar</a>");
            }
            
            /*Tratamento de Exceção*/
            catch(Exception ex)
            {
            out.println("<h1>Parâmetro(s) inválido(s)!</h1>");
            out.println("<br>");
            out.println("<a href='juros_compostos.html'>Retornar</a>");
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
