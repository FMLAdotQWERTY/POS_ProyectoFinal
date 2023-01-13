<%-- 
    Document   : recomendaciones
    Created on : 12 ene. 2023, 14:12:01
    Author     : fmlaq
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="paq.Pelicula"%>
<%@page import="paq.UtilBD"%>
<%@page import="paq.ClienteOMDBApi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proyecto Final: recomendaciones</title>
        <link rel="stylesheet" href="styles/estilo_recomendacion.css" type="text/css">
    </head>
    <body>
        <ul>
            <li class="active"><a href="ServletUsuario">Perfil de Usuario</a></li>
        </ul>
            <div id="content">
                <br />
                <br />
                <br />
                <h1>Recomendaciones</h1>
                <br />
                <hr />
                <br />
                <div class="grid">
                    <%
                        // Se agrega la nueva preferencia del usuario a la BD
                        int idPelicula = Integer.parseInt(request.getParameter("peliculas"));
                        int idGenero =Integer.parseInt(request.getParameter("generos"));
                        int idDirectores =Integer.parseInt(request.getParameter("directores"));
                        int idActor =Integer.parseInt(request.getParameter("actores"));

                        UtilBD.agregarPelicula(idPelicula);
                        UtilBD.agregarGenero(idGenero);
                        UtilBD.agregarDirectores(idDirectores);
                        UtilBD.agregarActor(idActor);
                        
                        
                        // Se lee toda la lista de preferencias del usuario
                        List<Pelicula> listaFinal = new ArrayList();
                        
                        List<Pelicula> listaPeliculasPorGenero = new ArrayList();
                        List<Pelicula> listaPeliculasPorActores = new ArrayList();
                        List<Pelicula> listaPeliculasPorDirectores = new ArrayList();
                        List<Pelicula> listaPeliculasPorTitulo = new ArrayList();
                       
                        // Se recupera el nombre de genero,dicrector,actor, pelicula, a partir del id del formulario.
                        String genero = UtilBD.recuperaGeneroPorID(idGenero);
                        String actor = UtilBD.recuperaActorPorID(idActor);
                        String directorABuscar = UtilBD.recuperaDirectorPorID(idDirectores);
                        String titulosABuscar = UtilBD.recuperaTituloPorID(idPelicula);
                        
                        // Se obtiene las listas por cada tipo de busqueda
                        listaPeliculasPorGenero = ClienteOMDBApi.obtenerPeliculasGenero(genero);
                        listaPeliculasPorActores = ClienteOMDBApi.obtenerPeliculasActores(actor);
                        listaPeliculasPorDirectores = ClienteOMDBApi.obtenerPeliculasDirector(directorABuscar);
                        listaPeliculasPorTitulo = ClienteOMDBApi.obtenerPeliculasTitulos(titulosABuscar);

                        // Unión de las listas de las 4 busquedas
                        listaFinal.addAll(listaPeliculasPorGenero);
                        listaFinal.addAll(listaPeliculasPorActores);
                        listaFinal.addAll(listaPeliculasPorDirectores);
                        listaFinal.addAll(listaPeliculasPorTitulo);

                        for(Pelicula cadaPel: listaFinal){
                    %>
                        <div class="card">
                        <div class="texto"><img src="<%=cadaPel.getPoster()%>" style="width:80%" /></div>
                        <br />
                        <div class="texto"><b>Titulo:</b> <%=cadaPel.getNombre()%></div>
                        <br />
                        <div class="texto"><b>Año:</b> <%=cadaPel.getAnio()%></div>
                        <br />
                        <div class="texto"><b>Actores:</b> <%=cadaPel.getActores()%></div>
                        <br />
                        <div class="texto"><b>Director:</b> <%=cadaPel.getDirector()%></div>
                        <br />
                        <div class="texto"><b>Genero:</b> <%=cadaPel.getGenero()%></div>
                        <br />
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>
    </body>
</html>
