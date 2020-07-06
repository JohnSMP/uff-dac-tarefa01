/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JohnSMP
 */
public class Resultado extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private int i = 1;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            int inicio = Integer.parseInt(request.getParameter("inicial"));
            int fim = Integer.parseInt(request.getParameter("final"));

            String operador = request.getParameter("operacao");
            float operacao = 0;

            if (operador.equalsIgnoreCase("Somar")) {
                operacao = inicio + fim;
            } else if (operador.equalsIgnoreCase("Subtrair")) {
                operacao = inicio - fim;
            } else if (operador.equalsIgnoreCase("Multiplicar")) {
                operacao = inicio * fim;
            }

            out.println("<html><head>");
            out.println("<title>Servlet Resultado da Operacao</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<P>O resultado da operação é " + operacao + "</P><br/>");
            out.println("</body></html>");

            String value = String.valueOf(i);

            Cookie cookie = new Cookie("cookieName", value);
            cookie.setMaxAge(3600);
            response.addCookie(cookie);

            Cookie[] cookies = request.getCookies();

            if (cookie.getName() == "cookieName") {
                out.println("Você visitou essa página (" + i + ") vezes");
                i++;
            }

            out.println("<br /> <br />");
            out.println("<a href=\"Operacao\">Voltar</a>");

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
