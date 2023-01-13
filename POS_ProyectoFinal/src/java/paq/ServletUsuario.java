/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package paq;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class ServletUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws org.json.simple.parser.ParseException
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, ParseException {
        
        // Obtención de los valores que se ingresan en el formulario (login)
        List<Usuario> listaRegistrada = UtilBD.cargaListaUsuarios();
        String  nombre_usuario = request.getParameter("nombre_usuario");
        String contrasena_usuario = request.getParameter("contrasena_usuario");
        //System.out.println("\tName-Parametro ---> " + nombre_usuario);
        
        // Bandera que indica si el usuario existe o no
        boolean bandera = false;
        
        /*int idUser = UtilBD.cargarIdUsuario(nombre_usuario);
        System.out.println("\tID desde la BD ---> " + idUser);
        
        //Obtención de las preferencias del usuario desde la BD
        List<Integer> listaIDPorGenero = new ArrayList<Integer>();
        List<Integer> listaIDPorActores = new ArrayList<Integer>();
        List<Integer> listaIDPorDirectores = new ArrayList<Integer>();
        List<Integer> listaIDPorTitulo = new ArrayList<Integer>();
        
        listaIDPorGenero.addAll(UtilBD.obtenerGenerosPorUsuario(idUser-1));
        listaIDPorActores = UtilBD.obtenerActoresPorUsuario(idUser-1);
        listaIDPorDirectores = UtilBD.obtenerDirectoresPorUsuario(idUser-1);
        listaIDPorTitulo = UtilBD.obtenerPeliculaPorUsuario(idUser-1);
        System.out.println("\n1.- listaIDPorGenero ===> " + listaIDPorGenero.toString());
        System.out.println("2.- listaIDPorActores ===> " + listaIDPorActores.toString());
        System.out.println("3.- listaIDPorDirectores ===> " + listaIDPorDirectores.toString());
        System.out.println("4.- listaIDPorTitulo ===> " + listaIDPorTitulo.toString());

        
        // Lista de peliculas basadas en la preferencias
        /*List<Pelicula> listaPeliculasPorGenero = new ArrayList();
        List<Pelicula> listaPeliculasPorActores = new ArrayList();
        List<Pelicula> listaPeliculasPorDirectores = new ArrayList();
        List<Pelicula> listaPeliculasPorTitulo = new ArrayList();

        // Llenado de las películas
        for(int i=0; i<=listaIDPorGenero.size()-1; i++) {
            String genero = UtilBD.recuperaGeneroPorID(listaIDPorGenero.get(i));
            listaPeliculasPorGenero = ClienteOMDBApi.obtenerPeliculasGenero(genero);
        }
        for(int i=0; i<=listaIDPorActores.size()-1; i++) {
            String actor = UtilBD.recuperaActorPorID(listaIDPorActores.get(i));
            listaPeliculasPorActores = ClienteOMDBApi.obtenerPeliculasActores(actor);
        }
        for(int i=0; i<=listaIDPorDirectores.size()-1; i++) {
            String director = UtilBD.recuperaGeneroPorID(listaIDPorDirectores.get(i));
            listaPeliculasPorDirectores = ClienteOMDBApi.obtenerPeliculasDirector(director);

        }
        for(int i=0; i<=listaIDPorTitulo.size()-1; i++) {
            String titulo = UtilBD.recuperaGeneroPorID(listaIDPorTitulo.get(i));
            listaPeliculasPorTitulo = ClienteOMDBApi.obtenerPeliculasTitulos(titulo);   
        }

        // Lista con la información completa de la películas
        List<Pelicula> listaFinal = new ArrayList();
        listaFinal.addAll(listaPeliculasPorGenero);
        listaFinal.addAll(listaPeliculasPorActores);
        listaFinal.addAll(listaPeliculasPorDirectores);
        listaFinal.addAll(listaPeliculasPorTitulo);

        System.out.println(listaFinal);
        */

        System.out.println("\t---> Parámetro (Username): " + nombre_usuario);
        System.out.println("\t---> Parámetro (Password): " + contrasena_usuario);
        
        System.out.println("\n===> Lista de Usuarios <===");
        for(int i=0; i<=listaRegistrada.size()-1; i++){
            
            System.out.println("\t---> Username[" + i  + "]: " + listaRegistrada.get(i).getNombre_usuario());
            System.out.println("\t---> Password[" + i  + "]: " + listaRegistrada.get(i).getContrasena_usuario() + "\n");
            
            // En caso de que se encuentre el usuario se muestra este HTML
            if( nombre_usuario.equals(listaRegistrada.get(i).getNombre_usuario()) && 
                contrasena_usuario.equals(listaRegistrada.get(i).getContrasena_usuario())) {
                bandera=true;
                UtilBD.idUsuario=listaRegistrada.get(i).getId();
                
                System.out.println("===> Auth: LOGIN AUTORIZADO");
                response.setContentType("text/html;charset=UTF-8");
                try ( PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Proyecto Final: servlet del perfil</title>");
                    out.println("<link rel=\"stylesheet\" href=\"styles/estilo_auth.css\" type=\"text/css\">");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<ul>");
                        out.println("<li class=\"active\"><a href=\"preferencias.jsp\">Preferencias</a></li>");
                        out.println("<li class=\"active\"><a href=\"index.html\">Logout</a></li>");
                    out.println("</ul>");
                    out.println("<div class=\"content\">");
                        out.println("<h1>Perfil del usuario: " + listaRegistrada.get(i).getNombre_usuario() + "</h1>");
                            out.println("<br />");
                            out.println("<p>Nombre Completo: " + listaRegistrada.get(i).getNombre_completo() + "</p>");
                            out.println("<p>Edad: " + listaRegistrada.get(i).getEdad() + "</p>");
                            out.println("<p>Genero: " + listaRegistrada.get(i).getGenero() + "</p>");
                            out.println("<p>Correo Electrónico: " + listaRegistrada.get(i).getCorreo() + "</p>");
                            out.println("<br />");
                    out.println("</div>");
                    /*out.print("<br />");
                    out.print("<div class=\"grid\">");
                        for(Pelicula cadaPel: listaFinal){
                            out.print("<div class=\"card\">");
                                out.println("<div class=\"texto\"><img src=\"" + cadaPel.getPoster() + "\" style=\"width:80%\" /></div>");
                                out.println("<br />");
                                out.println("<div class=\"texto\"><b>Titulo:</b>" + cadaPel.getNombre() + "</div>");
                                out.println("<br />");
                                out.println("<div class=\"texto\"><b>Año:</b>"  + cadaPel.getAnio() + "</div>");
                                out.println("<br />");
                                out.println("<div class=\"texto\"><b>Tipo:</b>" + cadaPel.getActores() + "</div>");
                                out.println("<br />");
                                out.println("<div class=\"texto\"><b>Tipo:</b>" + cadaPel.getDirector() + "</div>");
                                out.println("<br />");
                                out.println("<div class=\"texto\"><b>Tipo:</b>" + cadaPel.getGenero() + "</div>");
                                out.println("<br />");
                            out.println("</div>");
                        }*/
                    out.println("</body>");
                    out.println("</html>");
                }
                break;
            }
        }
        
        // En caso de que no encuentre el usuario se muestra este HTML
        if(bandera == false){
            System.out.println("===> AuthError: LOGIN NO AUTORIZADO");
            response.setContentType("text/html;charset=UTF-8");
            try ( PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ServletUsuario</title>");
                out.println("<link rel=\"stylesheet\" href=\"styles/estilo_auth.css\" type=\"text/css\">");
                out.println("</head>");
                out.println("<body>");
                out.println("<ul>\n" +
                                "<li class=\"active\"><a href=\"index.html\">Inicio</a></li>\n" +
                            "</ul>");
                out.println("<div class=\"content\">\n" +
                                "<h1>ERROR: Inicio de sesión erroneo...</h1>\n" +
                                "<br />" +
                                "<p>Favor de ingresar correctamente el nombre de usuario y la contraseña.</p>" +
                                "<br />\n" +
                            "</div>");
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
        try {
            try {
                processRequest(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
            try {
                processRequest(request, response);
            } catch (ParseException ex) {
                Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
