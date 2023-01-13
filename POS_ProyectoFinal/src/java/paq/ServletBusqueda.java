/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package paq;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.parser.ParseException;

/**
 *
 * @author fmlaq
 */
public class ServletBusqueda extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        
        String search = request.getParameter("titulo");
        System.out.println("\nSearch: " + search);
        List<Pelicula> peliculas = ClienteOMDBApi.peliculaPorSearch(search);
        
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Proyecto Final: busqueda pt.2</title>");
            out.println("<link rel=\"stylesheet\" href=\"styles/estilo_buscador.css\" type=\"text/css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<ul>\n" +
                            "<li class=\"active\"><a href=\"buscador.html\">Buscador</a></li>\n" +
                        "</ul>");
            out.println("<div id=\"content\">");
                out.println("<br />");
                out.println("<br />");
                out.println("<br />");
                out.println("<h1>Busqueda de Películas</h1>");
                out.println("<br />");
                out.println("<p id=\"descrip\"><b>Descripción: </b>en la parte de abajo se muestran los resultados, "
                                + "donde se pueden obtener la película que busca.</p>");
                out.println("<br />");
                out.println("<div id=\"cajaBuscador\">");
                    out.println("<form action=\"ServletInfo\">");
                        out.println("<label>Selecciona una película: </label>");
                        out.println("<br />");
                        out.println("<select name=\"tituloPel\">");
                            for(Pelicula cadaPel: peliculas){
                                out.println("<option value=\"" + cadaPel.getNombre() + "\">" + cadaPel.getNombre() + "</option>");   
                            }
                        out.println("</select>");
                        out.println("<br />");
                        out.println("<br />");
                        out.println("<input type=\"submit\" value=\"Seleccionar\"/>");
                out.println("</div>");
                out.println("<hr />");
                out.println("<div class=\"grid\">");
                    for(Pelicula cadaPel: peliculas){
                        out.println("<div class=\"card\">");
                            out.println("<div class=\"texto\"><img src=\"" + cadaPel.getPoster() + " style=\"width:100%\" /></div>");
                            out.println("<br />");
                            out.println("<div class=\"texto\"><b>Titulo: " + cadaPel.getNombre() + "</b></div>");
                            out.println("<br />");
                            out.println("<div class=\"texto\"><b>Año:</b> " + cadaPel.getAnio() + "</div>");
                            out.println("<br />");
                            out.println("<div class=\"texto\"><b>Tipo:</b> " + cadaPel.getTipo() + "</div>");
                            out.println("<br />");
                        out.println("</div>");
                    }
                out.println("</div>");
            out.println("</div>");
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ServletBusqueda.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ServletBusqueda.class.getName()).log(Level.SEVERE, null, ex);
        }
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
