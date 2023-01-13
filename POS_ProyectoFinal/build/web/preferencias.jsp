<%-- 
    Document   : recomencacion
    Created on : 9 ene. 2023, 00:03:59
    Author     : fmlaq
--%>

<%@page import="paq.Actor"%>
<%@page import="paq.Director"%>
<%@page import="paq.Genero"%>
<%@page import="paq.Pelicula"%>
<%@page import="java.util.List"%>
<%@page import="paq.UtilBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proyecto Final: preferencias</title>
        <link rel="stylesheet" href="styles/estilo_preferencias.css" type="text/css">
    </head>
    <body>
        <ul>
            <li class="active"><a href="ServletUsuario">Perfil de Usuario</a></li>
        </ul>
        <div class="content">
            <h1>Preferencias</h1>
            <br />
            <div id="cajaPreferencias">
                <fieldset>
                <legend>Posibles preferencias</legend>
                    <form method="POST" action="recomendacion.jsp">
                        <br />
                        <label>Películas: </label>
                        <select name="peliculas">
                            <option>Selecciona una opción...</option>
                            <%
                                List<Pelicula> peliculas = UtilBD.cargaListaPeliculas();
                                System.out.println("\t--->" + peliculas);
                                for(Pelicula cadaPel: peliculas){
                            %>
                                    <option value="<%=cadaPel.getId()%>"><%=cadaPel.getNombre()%></option>
                            <%
                                }
                            %>
                            </select>
                        <br />
                        <br />
                        <label>Generos: </label>
                        <select name="generos">
                            <option>Selecciona una opción...</option>
                            <%
                                List<Genero> generos = UtilBD.cargaListaGeneros();
                                System.out.println("\t--->" + generos);
                                for(Genero cadaGen: generos){
                            %>
                                    <option value="<%=cadaGen.getId()%>"><%=cadaGen.getNombre()%></option>
                            <%
                                }
                            %>
                            </select>
                        <br />
                        <br />
                        <label>Directores: </label>
                        <select name="directores">
                            <option>Selecciona una opción...</option>
                            <%
                                List<Director> directores = UtilBD.cargaListaDirectores();
                                System.out.println("\t--->" + directores);
                                for(Director cadaDir: directores){
                            %>
                                    <option value="<%=cadaDir.getId()%>"><%=cadaDir.getNombre()%></option>
                            <%
                                }
                            %>
                        </select>
                        <br />
                        <br />
                        <label>Actores: </label>
                        <select name="actores">
                            <option>Selecciona una opción...</option>
                            <%
                                List<Actor> actores = UtilBD.cargaListaActores();
                                System.out.println("\t--->" + actores);
                                for(Actor cadaAct: actores){
                            %>
                                    <option value="<%=cadaAct.getId()%>"><%=cadaAct.getNombre()%></option>
                            <%
                                }
                            %>
                        </select>
                        <br />
                        <br />
                        <input type="submit" value="Registrar"/>
                        <br />
                    </form>
                </fieldset>
            </div>
        </div>
    </body>
</html>
