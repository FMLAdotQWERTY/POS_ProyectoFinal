/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author fmlaq
 */
public class ClienteOMDBApi {
    // Busqueda de peliculas por palabra relacionada en la API OMDB
    public static List<Pelicula> peliculaPorSearch(String search) throws ParseException {
        List<Pelicula> listaPeliculas = new ArrayList();
        
        Client cliente = ClientBuilder.newClient();
        
        WebTarget target = cliente.target("http://www.omdbapi.com/")
                .queryParam("s", search)
                .queryParam("apikey", "62df9828");
        
        Invocation.Builder invocacion = target.request(MediaType.APPLICATION_JSON);
        Response response = invocacion.get();
        //System.out.println("ClienteOMDBApi.peliculaPorSearch ===> HTTP Code: " + response.getStatus());
        
        JSONParser parser = new JSONParser();
        JSONObject responseJSON = (JSONObject) parser.parse(response.readEntity(String.class));
        
        JSONArray peliculas = (JSONArray) responseJSON.get("Search");
        for(Iterator it = peliculas.iterator(); it.hasNext(); ){
            Object pelicula = it.next();    
            JSONObject cadaPelicula = (JSONObject) pelicula;
            
            String titulo = (String) cadaPelicula.get("Title");
            String anio = (String) cadaPelicula.get("Year");
            String tipo = (String) cadaPelicula.get("Type");
            String poster = (String) cadaPelicula.get("Poster");
            
            listaPeliculas.add(new Pelicula(titulo, anio, tipo, poster));
        }
        return listaPeliculas;
    }
    
    // Busqueda de peliculas por titulo en la API OMDB
    public static Pelicula peliculaPorTitulo(String titulo) throws ParseException {
        Client cliente = ClientBuilder.newClient();
        
        WebTarget target = cliente.target("http://www.omdbapi.com/")
                .queryParam("t", titulo)
                .queryParam("apikey", "62df9828");
        
        Invocation.Builder invocacion = target.request(MediaType.APPLICATION_JSON);
        Response response = invocacion.get();
        //System.out.println("ClienteOMDBApi.peliculaPorTitulo ===> HTTP Code: " + response.getStatus());
        
        JSONParser parser = new JSONParser();
        JSONObject responseJSON = (JSONObject) parser.parse(response.readEntity(String.class));
        
        JSONObject pelicula = (JSONObject) responseJSON;
            
        String tituloPel = (String) pelicula.get("Title");
        String anio = (String) pelicula.get("Year");
        String clasificacion = (String) pelicula.get("Rated");
        String fechaEstreno = (String) pelicula.get("Released");
        String duracion = (String) pelicula.get("Runtime");
        String genero = (String) pelicula.get("Genre");
        String director = (String) pelicula.get("Director");
        String escritor = (String) pelicula.get("Writer");
        String actores = (String) pelicula.get("Actors");
        String sinopsis = (String) pelicula.get("Plot");
        String idioma = (String) pelicula.get("Language");
        String pais = (String) pelicula.get("Country");
        String premios = (String) pelicula.get("Awards");
        String tipo = (String) pelicula.get("Type");
        String poster = (String) pelicula.get("Poster");
            
        Pelicula peliculaInfo = new Pelicula(tituloPel, anio, clasificacion, 
                                             fechaEstreno, duracion, genero, 
                                             director, escritor, actores, sinopsis, 
                                             idioma, pais, premios, tipo, poster);
        
        return peliculaInfo;
    }
    
    
    // Busquedas de preferencias en la API OMDB
    public static List<String> obtenerGeneros() throws ParseException {
        List<String> generos = new ArrayList();
        String movieId = "";
        
        for (int i = 700; i < 800; i++) {
            movieId = "tt1570" + i;
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://www.omdbapi.com/")
                    .queryParam("i", movieId)
                    .queryParam("apikey", "62df9828");

            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.get();
            //System.out.println("ClienteOMDBApi.obtenerGeneros ===> HTTP Code: " + response.getStatus());

            JSONParser parser = new JSONParser();
            JSONObject responseJSON = (JSONObject) parser.parse(response.readEntity(String.class));

            String genero = (String) responseJSON.get("Genre");
            if (genero != null) {
                StringTokenizer tokens = new StringTokenizer(genero, ",");
                while (tokens.hasMoreTokens()) {
                    generos.add(tokens.nextToken().trim());
                }
            }
        }
        return generos;
    }

    public static List<String> obtenerActores() throws ParseException {
        List<String> actores = new ArrayList();
        String movieId = "";
        
        for (int i = 700; i < 800; i++) {
            movieId = "tt1570" + i;
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://www.omdbapi.com/")
                    .queryParam("i", movieId)
                    .queryParam("apikey", "62df9828");

            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.get();
            //System.out.println("ClienteOMDBApi.obtenerActores ===> HTTP Code: " + response.getStatus());

            JSONParser parser = new JSONParser();
            JSONObject responseJSON = (JSONObject) parser.parse(response.readEntity(String.class));

            String cadaActor = (String) responseJSON.get("Actors");
            if (cadaActor != null) {
                StringTokenizer tokens = new StringTokenizer(cadaActor, ",");
                while (tokens.hasMoreTokens()) {
                    actores.add(tokens.nextToken().trim());
                }
            }
        }
        return actores;
    }

    public static List<String> obtenerDirectores() throws ParseException {
        List<String> directores = new ArrayList();
        String movieId = "";
        
        for (int i = 700; i < 800; i++) {
            movieId = "tt1570" + i;
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://www.omdbapi.com/")
                    .queryParam("i", movieId)
                    .queryParam("apikey", "62df9828");

            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.get();
            //System.out.println("ClienteOMDBApi.obtenerDirectores ===> HTTP Code: " + response.getStatus());

            JSONParser parser = new JSONParser();
            JSONObject responseJSON = (JSONObject) parser.parse(response.readEntity(String.class));

            String cadaDirector = (String) responseJSON.get("Director");
            if (cadaDirector != null) {

                StringTokenizer tokens = new StringTokenizer(cadaDirector, ",");
                while (tokens.hasMoreTokens()) {
                    directores.add(tokens.nextToken().trim());
                }
            }
        }
        return directores;
    }
    
    
    // Busqueda de preferencias por nombre en la API OMDB
    public static List<Pelicula> obtenerPeliculasGenero(String genero) throws ParseException {
        List<Pelicula> listaPeliculasPorGenero = new ArrayList();
        String movieId = "";
        
        for (int i=700; i<730; i++) {
            movieId = "tt1570" + i;
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://www.omdbapi.com/")
                    .queryParam("i", movieId)
                    .queryParam("apikey", "62df9828");

            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.get();
            //System.out.println("ClienteOMDBApi.obtenerPeliculasGenero ===> HTTP Code: " + response.getStatus());

            JSONParser parser = new JSONParser();
            JSONObject responseJSON = (JSONObject) parser.parse(response.readEntity(String.class));

            String generos = (String) responseJSON.get("Genre");

            // Se busca el genero específico en las películas de la API de OMDB 
            boolean generoCorrecto = generos.contains(genero);
            if (generoCorrecto) {
                String cadaTitulo = (String) responseJSON.get("Title");
                String cadaAnio = (String) responseJSON.get("Year");
                String cadaClasificacion = (String) responseJSON.get("Rated");
                String cadaFechaEstreno = (String) responseJSON.get("Released");
                String cadaDuracion = (String) responseJSON.get("Runtime");
                String cadaGenero = (String) responseJSON.get("Genre");
                String cadaDirector = (String) responseJSON.get("Director");
                String cadaEscritor = (String) responseJSON.get("Writer");
                String cadaActor = (String) responseJSON.get("Actors");
                String cadaSinopsis = (String) responseJSON.get("Plot");
                String cadaIdioma = (String) responseJSON.get("Language");
                String cadaPais = (String) responseJSON.get("Country");
                String cadaPremios = (String) responseJSON.get("Awards");
                String cadaTipo = (String) responseJSON.get("Type");
                String cadaPoster = (String) responseJSON.get("Poster");

                System.out.println("\t---> Título:" + cadaTitulo + 
                                   "\n\t     Genero:" + cadaGenero + 
                                   "\n\t     Director:" + cadaDirector + 
                                   "\n\t     Actores: " + cadaActor + "\n");
                
                listaPeliculasPorGenero.add(new Pelicula(
                    cadaTitulo, 
                    cadaAnio, 
                    cadaClasificacion, 
                    cadaFechaEstreno, 
                    cadaDuracion, 
                    cadaGenero,
                    cadaDirector, 
                    cadaEscritor, 
                    cadaActor, 
                    cadaSinopsis, 
                    cadaIdioma, 
                    cadaPais, 
                    cadaPremios, 
                    cadaTipo, 
                    cadaPoster)
                );  
            } 
        }
        return listaPeliculasPorGenero;
    }
    
    public static List<Pelicula> obtenerPeliculasActores(String actor) throws ParseException {
        List<Pelicula> listaPeliculasPorActor = new ArrayList();
        String movieId = "";
        
        for(int i=700; i<730; i++) {
            movieId = "tt1570" + i;
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://www.omdbapi.com/")
                    .queryParam("i", movieId)
                    .queryParam("apikey", "62df9828");

            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.get();

            JSONParser parser = new JSONParser();
            JSONObject responseJSON = (JSONObject) parser.parse(response.readEntity(String.class));
            //System.out.println("ClienteOMDBApi.obtenerPeliculasActores ===> HTTP Code: " + response.getStatus());

            String actores = (String) responseJSON.get("Actors");
            
            // Se busca el genero específico en las películas de la API de OMDB 
            boolean actorCorrecto = actores.contains(actor);
            if(actorCorrecto){
                String cadaTitulo = (String) responseJSON.get("Title");
                String cadaAnio = (String) responseJSON.get("Year");
                String cadaClasificacion = (String) responseJSON.get("Rated");
                String cadaFechaEstreno = (String) responseJSON.get("Released");
                String cadaDuracion = (String) responseJSON.get("Runtime");
                String cadaGenero = (String) responseJSON.get("Genre");
                String cadaDirector = (String) responseJSON.get("Director");
                String cadaEscritor = (String) responseJSON.get("Writer");
                String cadaActor = (String) responseJSON.get("Actors");
                String cadaSinopsis = (String) responseJSON.get("Plot");
                String cadaIdioma = (String) responseJSON.get("Language");
                String cadaPais = (String) responseJSON.get("Country");
                String cadaPremios = (String) responseJSON.get("Awards");
                String cadaTipo = (String) responseJSON.get("Type");
                String cadaPoster = (String) responseJSON.get("Poster");

                System.out.println("\t---> Título:" + cadaTitulo + 
                                   "\n\t     Genero:" + cadaGenero + 
                                   "\n\t     Director:" + cadaDirector + 
                                   "\n\t     Actores: " + cadaActor + "\n");

                listaPeliculasPorActor.add(new Pelicula(
                    cadaTitulo, 
                    cadaAnio, 
                    cadaClasificacion, 
                    cadaFechaEstreno, 
                    cadaDuracion, 
                    cadaGenero,
                    cadaDirector, 
                    cadaEscritor, 
                    cadaActor, 
                    cadaSinopsis, 
                    cadaIdioma, 
                    cadaPais, 
                    cadaPremios, 
                    cadaTipo, 
                    cadaPoster)
                );
            }
        }
        return listaPeliculasPorActor;
    }
    
    public static List<Pelicula> obtenerPeliculasDirector(String director) throws ParseException {
        List<Pelicula> listaPeliculasPorDirector = new ArrayList();
        String movieId = "";
        
        for(int i=700; i<730; i++){
            movieId = "tt1570" + i;
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://www.omdbapi.com/")
                    .queryParam("i", movieId)
                    .queryParam("apikey", "62df9828");
        
            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.get();

            JSONParser parser = new JSONParser();
            JSONObject responseJSON = (JSONObject) parser.parse(response.readEntity(String.class));
            //System.out.println("ClienteOMDBApi.obtenerPeliculasDirector ===> HTTP Code: " + response.getStatus());

            String directores = (String) responseJSON.get("Director");
            
            // Se busca el director específico en las películas de la API de OMDB 
            boolean directorCorrecto = directores.contains(director);
            if(directorCorrecto){
                String cadaTitulo = (String) responseJSON.get("Title");
                String cadaAnio = (String) responseJSON.get("Year");
                String cadaClasificacion = (String) responseJSON.get("Rated");
                String cadaFechaEstreno = (String) responseJSON.get("Released");
                String cadaDuracion = (String) responseJSON.get("Runtime");
                String cadaGenero = (String) responseJSON.get("Genre");
                String cadaDirector = (String) responseJSON.get("Director");
                String cadaEscritor = (String) responseJSON.get("Writer");
                String cadaActor = (String) responseJSON.get("Actors");
                String cadaSinopsis = (String) responseJSON.get("Plot");
                String cadaIdioma = (String) responseJSON.get("Language");
                String cadaPais = (String) responseJSON.get("Country");
                String cadaPremios = (String) responseJSON.get("Awards");
                String cadaTipo = (String) responseJSON.get("Type");
                String cadaPoster = (String) responseJSON.get("Poster");

                System.out.println("\t---> Título:" + cadaTitulo + 
                                   "\n\t     Genero:" + cadaGenero + 
                                   "\n\t     Director:" + cadaDirector + 
                                   "\n\t     Actores: " + cadaActor + "\n");

                listaPeliculasPorDirector.add(new Pelicula(
                    cadaTitulo, 
                    cadaAnio, 
                    cadaClasificacion, 
                    cadaFechaEstreno, 
                    cadaDuracion, 
                    cadaGenero,
                    cadaDirector, 
                    cadaEscritor, 
                    cadaActor, 
                    cadaSinopsis, 
                    cadaIdioma, 
                    cadaPais, 
                    cadaPremios, 
                    cadaTipo, 
                    cadaPoster)
                );
            }
        }
        return listaPeliculasPorDirector;
    }
    
    public static List<Pelicula> obtenerPeliculasTitulos(String titulo) throws ParseException {
        List<Pelicula> listaPeliculasPorTitulo = new ArrayList();
        String movieId = "";
        
        for(int i=700; i<730; i++) {
            movieId = "tt1570" + i;
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://www.omdbapi.com/")
                    .queryParam("i", movieId)
                    .queryParam("apikey", "62df9828");
            
            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.get();

            JSONParser parser = new JSONParser();
            JSONObject responseJSON = (JSONObject) parser.parse(response.readEntity(String.class));
            //System.out.println("ClienteOMDBApi.obtenerPeliculasTitulos ===> HTTP Code: " + response.getStatus());

            String titulos = (String) responseJSON.get("Title");
                
            // Se busca el titulo específico en las películas de la API de OMDB 
            boolean tituloCorrecto = titulos.contains(titulo);
            if(tituloCorrecto){
                String cadaTitulo = (String) responseJSON.get("Title");
                String cadaAnio = (String) responseJSON.get("Year");
                String cadaClasificacion = (String) responseJSON.get("Rated");
                String cadaFechaEstreno = (String) responseJSON.get("Released");
                String cadaDuracion = (String) responseJSON.get("Runtime");
                String cadaGenero = (String) responseJSON.get("Genre");
                String cadaDirector = (String) responseJSON.get("Director");
                String cadaEscritor = (String) responseJSON.get("Writer");
                String cadaActor = (String) responseJSON.get("Actors");
                String cadaSinopsis = (String) responseJSON.get("Plot");
                String cadaIdioma = (String) responseJSON.get("Language");
                String cadaPais = (String) responseJSON.get("Country");
                String cadaPremios = (String) responseJSON.get("Awards");
                String cadaTipo = (String) responseJSON.get("Type");
                String cadaPoster = (String) responseJSON.get("Poster");

                System.out.println("\t---> Título:" + cadaTitulo + 
                                   "\n\t     Genero:" + cadaGenero + 
                                   "\n\t     Director:" + cadaDirector + 
                                   "\n\t     Actores: " + cadaActor + "\n");

                listaPeliculasPorTitulo.add(new Pelicula(
                    cadaTitulo, 
                    cadaAnio, 
                    cadaClasificacion, 
                    cadaFechaEstreno, 
                    cadaDuracion, 
                    cadaGenero,
                    cadaDirector, 
                    cadaEscritor, 
                    cadaActor, 
                    cadaSinopsis, 
                    cadaIdioma, 
                    cadaPais, 
                    cadaPremios, 
                    cadaTipo, 
                    cadaPoster)
                );
            }
        }
        return listaPeliculasPorTitulo;
    }
    
}
