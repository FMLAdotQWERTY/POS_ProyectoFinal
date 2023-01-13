/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author fmlaq
 */
public class ClienteOMDBApi {

    public static List<String> obtenerGeneros() throws ParseException, org.json.simple.parser.ParseException {
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

    public static List<String> obtenerPeliculas() throws ParseException, org.json.simple.parser.ParseException {
        List<String> peliculas = new ArrayList();
        String movieId = "";
        
        for (int i = 700; i < 800; i++) {
            movieId = "tt1570" + i;
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://www.omdbapi.com/")
                    .queryParam("i", movieId)
                    .queryParam("apikey", "62df9828");

            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.get();

            JSONParser parser = new JSONParser();
            JSONObject responseJSON = (JSONObject) parser.parse(response.readEntity(String.class));

            String cadaPeliculas = (String) responseJSON.get("Title");
            if (cadaPeliculas != null) {
                StringTokenizer tokens = new StringTokenizer(cadaPeliculas, ",");
                while (tokens.hasMoreTokens()) {
                    peliculas.add(tokens.nextToken().trim());
                }
            }
        }
        return peliculas;
    }

    public static List<String> obtenerActores() throws ParseException, org.json.simple.parser.ParseException {
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

    public static List<String> obtenerDirectores() throws ParseException, org.json.simple.parser.ParseException {
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
}
