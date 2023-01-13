/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package paq;

import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author fmlaq
 */
@Path("usuarios")
public class UsuariosResource {

    @Context
    private UriInfo context;
    
    private static int idUsuario;
    int contador = 1;
    private static Map<Integer, Usuario> listaUsuarios = new ConcurrentHashMap<Integer, Usuario>();
    JSONArray jsonArray;
    UtilBD util = new UtilBD();

    /**
     * Creates a new instance of UsuariosResource
     */
    public UsuariosResource() {
    }

    /**
     * Retrieves representation of an instance of paq.UsuariosResource
     * @return an instance of java.lang.String
     */
    // HTTP - GET 01: genera un JSONArray de todos los usuarios
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUsers() throws ClassNotFoundException {
        jsonArray = util.cargarJSONUsuarios();
        if(jsonArray == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return jsonArray.toString();
    }
    
    // HTTP - GET 02: genera un JSONObject de un usuario mediante su ID
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserbyID(@PathParam("id") int id) throws ClassNotFoundException {
        jsonArray = util.cargarJSONUsuarios();
        JSONObject jsonObject = jsonArray.getJSONObject(id-1);
        if (jsonObject == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return jsonObject.toString();
    }

    // HTTP - POST: inserta un alumno
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response postUser( 
        @FormParam("nombre_usuario") String nombre_usuario, 
        @FormParam("contrasena_usuario") String contrasena_usuario, 
        @FormParam("nombre_completo") String nombre_completo, 
        @FormParam("edad") int edad, 
        @FormParam("genero") String genero, 
        @FormParam("correo") String correo) throws ClassNotFoundException {
        
        Usuario user = new Usuario(
            contador,
            nombre_usuario,
            contrasena_usuario,
            nombre_completo,
            edad, 
            genero,
            correo
        );
        
        idUsuario = contador;
        listaUsuarios.put(idUsuario, user);
        util.registrarUsuario(user);
        contador++;
        
        System.out.println("\t---> Usuario creado: " + user.toString());
        return Response.created(URI.create("/usuarios/" + user.getId())).build();
    }
    
    /**
     * PUT method for updating or creating an instance of UsuariosResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putUser(String content) {
    }
}
