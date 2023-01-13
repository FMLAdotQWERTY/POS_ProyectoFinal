/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package paq;

import java.io.IOException;
import java.io.PrintWriter;
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
public class ServletInfo extends HttpServlet {

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
        
        String titulo = request.getParameter("tituloPel");
        System.out.println("\nTitulo: " + titulo);
        Pelicula pelicula = ClienteOMDBApi.peliculaPorTitulo(titulo);
        
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Proyecto Final: busqueda pt.3</title>");
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
                out.println("<h1 id=\"infoPel\">Película Seleccionada</h1>");
                out.println("<br />");
                out.println("<p id=\"descrip\"><b>Descripción:</b> a continuación se muestra la película buscada junto con su información.");
                out.println("<br />");
                out.println("<div class=\"contenedor\">");
                    out.println("<div class=\"texto\"><img src=\"" + pelicula.getPoster() + " style=\"width:100%\" /></div>");
                    out.println("<br />");
                    out.println("<div class=\"texto\"><b>Titulo: " + pelicula.getNombre() + "</b></div>");
                    out.println("<br />");
                    out.println("<div class=\"texto\"><b>Año:</b> " + pelicula.getAnio() + "</div>");
                    out.println("<br />");
                    out.println("<div class=\"texto\"><b>Clasificación:</b> " + pelicula.getClasificacion() + "</div>");
                    out.println("<br />");
                    out.println("<div class=\"texto\"><b>Fecha de Estreno:</b> " + pelicula.getFechaEstreno() + "</div>");
                    out.println("<br />");
                    out.println("<div class=\"texto\"><b>Duración:</b> " + pelicula.getDuracion() + "</div>");
                    out.println("<br />");
                    out.println("<div class=\"texto\"><b>Genero:</b> " + pelicula.getGenero() + "</div>");
                    out.println("<br />");
                    out.println("<div class=\"texto\"><b>Director:</b> " + pelicula.getDirector() + "</div>");
                    out.println("<br />");
                    out.println("<div class=\"texto\"><b>Escritor:</b> " + pelicula.getEscritor() + "</div>");
                    out.println("<br />");
                    out.println("<div class=\"texto\"><b>Actores:</b> " + pelicula.getActores() + "</div>");
                    out.println("<br />");
                    out.println("<p class=\"texto\"><b>Sinopsis:</b> " + pelicula.getSinopsis() + "</p>");
                    out.println("<br />");
                    out.println("<div class=\"texto\"><b>Idioma:</b> " + pelicula.getIdioma() + "</div>");
                    out.println("<br />");
                    out.println("<div class=\"texto\"><b>País:</b> " + pelicula.getPais() + "</div>");
                    out.println("<br />");
                    out.println("<div class=\"texto\"><b>Premios:</b> " + pelicula.getPremios() + "</div>");
                    out.println("<br />");
                    out.println("<div class=\"texto\"><b>Tipo:</b> " + pelicula.getTipo() + "</div>");
                    out.println("<br />");
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
            Logger.getLogger(ServletInfo.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletInfo.class.getName()).log(Level.SEVERE, null, ex);
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
