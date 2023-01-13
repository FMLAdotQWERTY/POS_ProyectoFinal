/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

public class UtilBD {

    public static int idUsuario;

    // Método que lee la tabla de usuarios (devuelven una lista o JSONArray)
    public static List<Usuario> cargaListaUsuarios() throws ClassNotFoundException {
        List<Usuario> lista = new ArrayList<Usuario>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/recomendacion",
                    "root",
                    "root");
            
            if (conn != null) {
                System.out.println("\nUtilBD.cargaListaUsuarios ====> Conectado a la base de datos");
                Statement st = conn.createStatement();

                String query = "SELECT * FROM usuarios;";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    int id = Integer.parseInt(rs.getString("id"));
                    String nombre_usuario = rs.getString("nombre_usuario");
                    String contrasena_usuario = rs.getString("contrasena_usuario");
                    String nombre_completo = rs.getString("nombre_completo");
                    int edad = Integer.parseInt(rs.getString("edad"));
                    String genero = rs.getString("genero");
                    String correo = rs.getString("correo");
                    Usuario alu = new Usuario(id, nombre_usuario, contrasena_usuario, nombre_completo, edad, genero, correo);
                    lista.add(alu);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(UtilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public static int cargarIdUsuario(String nombre_usuario) throws ClassNotFoundException {
        int idUser = 0;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/recomendacion",
                    "root",
                    "root");
            
            if (conn != null) {
                System.out.println("\nUtilBD.cargarIdUsuario ====> Conectado a la base de datos");
                Statement st = conn.createStatement();

                String query = "SELECT id FROM usuarios WHERE nombre_usuario = " + idUser + ";";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    idUser = Integer.parseInt(rs.getString("id"));
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(UtilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idUser;
    }
    
    public static JSONArray cargarJSONUsuarios() throws ClassNotFoundException {
        JSONArray jsonArray = new JSONArray();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/recomendacion",
                    "root",
                    "root");

            if (conn != null) {
                System.out.println("\nUtilBD.cargarJSONUsuarios ====> Conectado a la base de datos");
                Statement st = conn.createStatement();

                String query = "SELECT * FROM usuarios;";
                ResultSet rs = st.executeQuery(query);

                Integer i = 0;
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                while (rs.next()) {
                    JSONObject jsonObject = new JSONObject();
                    for (int ii = 1; ii < columnCount + 1; ii++) {
                        String alias = rsmd.getColumnLabel(ii);
                        jsonObject.put(alias, rs.getObject(alias));
                    }
                    jsonArray.put(i, jsonObject);
                    i++;
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(UtilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jsonArray;
    }

    
    // Método que registra un usuario en la BD
    public void registrarUsuario(Usuario user) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/recomendacion",
                    "root",
                    "root");

            if (conn != null) {
                System.out.println("\nUtilBD.registrarUsuario ====> Conectado a la base de datos");
                Statement st = conn.createStatement();

                String query = "INSERT INTO usuarios (nombre_usuario, contrasena_usuario, nombre_completo, edad, genero, correo) VALUES('"
                        + user.getNombre_usuario() + "', '"
                        + user.getContrasena_usuario() + "', '"
                        + user.getNombre_completo() + "', "
                        + user.getEdad() + ", '"
                        + user.getGenero() + "', '"
                        + user.getCorreo() + "');";
                st.executeUpdate(query);
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(UtilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // Métodos que leen los valores de las tablas que contiene las posibles preferencias
    public static List<Pelicula> cargaListaPeliculas() throws ClassNotFoundException {
        List<Pelicula> lista = new ArrayList<Pelicula>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/recomendacion",
                    "root",
                    "root");
            
            if (conn != null) {
                System.out.println("\nUtilBD.cargaListaPeliculas ====> Conectado a la base de datos");
                Statement st = conn.createStatement();

                String query = "SELECT * FROM peliculasFav;";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    int id = Integer.parseInt(rs.getString("id"));
                    String nombre_pel = rs.getString("nombre");
                    Pelicula pel = new Pelicula(id, nombre_pel);
                    lista.add(pel);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(UtilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public static List<Genero> cargaListaGeneros() throws ClassNotFoundException {
        List<Genero> lista = new ArrayList<Genero>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/recomendacion",
                    "root",
                    "root");
            
            if (conn != null) {
                System.out.println("\nUtilBD.cargaListaGeneros ====> Conectado a la base de datos");
                Statement st = conn.createStatement();

                String query = "SELECT * FROM generosFav;";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    int id = Integer.parseInt(rs.getString("id"));
                    String nombre_gen = rs.getString("nombre");
                    Genero gen = new Genero(id, nombre_gen);
                    lista.add(gen);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(UtilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public static List<Director> cargaListaDirectores() throws ClassNotFoundException {
        List<Director> lista = new ArrayList<Director>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/recomendacion",
                    "root",
                    "root");
            
            if (conn != null) {
                System.out.println("\nUtilBD.cargaListaDirectores ====> Conectado a la base de datos");
                Statement st = conn.createStatement();

                String query = "SELECT * FROM directoresFav;";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    int id = Integer.parseInt(rs.getString("id"));
                    String nombre_dir = rs.getString("nombre");
                    Director dir = new Director(id, nombre_dir);
                    lista.add(dir);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(UtilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public static List<Actor> cargaListaActores() throws ClassNotFoundException {
        List<Actor> lista = new ArrayList<Actor>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/recomendacion",
                    "root",
                    "root");
            
            if (conn != null) {
                System.out.println("\nUtilBD.cargaListaActores ====> Conectado a la base de datos");
                Statement st = conn.createStatement();

                String query = "SELECT * FROM actoresFav;";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    int id = Integer.parseInt(rs.getString("id"));
                    String nombre_act = rs.getString("nombre");
                    Actor act = new Actor(id, nombre_act);
                    lista.add(act);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(UtilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    
    // Métodos que inserta valores en las tablas "usuario_preferencias"
    public static void agregarGenero(int idGenero) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/recomendacion",
                    "root",
                    "root");

            if (conn != null) {
                System.out.println("\nUtilBD.registrarUsuario ====> Conectado a la base de datos");
                Statement st = conn.createStatement();

                String query = "INSERT INTO usuarios_generosfav (id_usuario, id_genero) VALUES("
                        + idUsuario + ", "
                        + idGenero + ")";
                st.executeUpdate(query);
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(UtilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void agregarDirectores(int idDirectores) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/recomendacion",
                    "root",
                    "root");

            if (conn != null) {
                System.out.println("\nUtilBD.registrarUsuario ====> Conectado a la base de datos");
                Statement st = conn.createStatement();

                String query = "INSERT INTO usuarios_directoresfav (id_usuario, id_director) VALUES("
                        + idUsuario + ", "
                        + idDirectores + ")";
                st.executeUpdate(query);
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(UtilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void agregarActor(int idActor) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/recomendacion",
                    "root",
                    "root");

            if (conn != null) {
                System.out.println("\nUtilBD.registrarUsuario ====> Conectado a la base de datos");
                Statement st = conn.createStatement();

                String query = "INSERT INTO usuarios_actoresfav (id_usuario, id_actor) VALUES("
                        + idUsuario + ", "
                        + idActor + ")";
                st.executeUpdate(query);
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(UtilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void agregarPelicula(int idPelicula) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/recomendacion",
                    "root",
                    "root");

            if (conn != null) {
                System.out.println("\nUtilBD.registrarUsuario ====> Conectado a la base de datos");
                Statement st = conn.createStatement();

                String query = "INSERT INTO usuarios_peliculasfav (id_usuario, id_pelicula) VALUES("
                        + idUsuario + ", "
                        + idPelicula + ")";
                st.executeUpdate(query);
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(UtilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    
    // Métodos que recupera el nombre del genero, actor, etc... en la BD mediante el id seleccionado en pagina recomendacion
    public static String recuperaGeneroPorID(int idGenero) throws ClassNotFoundException{
        String nombre_gen = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/recomendacion",
                    "root",
                    "root");
            
            if (conn != null) {
                System.out.println("\nUtilBD.recuperaGeneroPorID ====> Conectado a la base de datos");
                Statement st = conn.createStatement();

                String query = "SELECT nombre FROM generosFav WHERE id = " + idGenero + ";";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                     nombre_gen = rs.getString("nombre");
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(UtilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombre_gen;
    }
       
    public static String recuperaActorPorID(int idActor) throws ClassNotFoundException{
        String nombre_gen = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/recomendacion",
                    "root",
                    "root");
            
            if (conn != null) {
                System.out.println("\nUtilBD.recuperaActorPorID ====> Conectado a la base de datos");
                Statement st = conn.createStatement();

                String query = "SELECT nombre FROM actoresfav WHERE id = " + idActor + ";";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                     nombre_gen = rs.getString("nombre");                   
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(UtilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombre_gen;
    }
    
    public static String recuperaDirectorPorID(int idDirector) throws ClassNotFoundException{
        String nombre_Dire = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/recomendacion",
                    "root",
                    "root");
            
            if (conn != null) {
                System.out.println("\nUtilBD.recuperaDirectorPorID ====> Conectado a la base de datos");
                Statement st = conn.createStatement();

                String query = "SELECT nombre FROM directoresfav WHERE id = " + idDirector + ";";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                     nombre_Dire = rs.getString("nombre");                   
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(UtilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombre_Dire;
    }
    
    public static String recuperaTituloPorID(int idPelicula) throws ClassNotFoundException{
        String nombreTitulo = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/recomendacion",
                    "root",
                    "root");
            
            if (conn != null) {
                System.out.println("\nUtilBD.recuperaTitutloPorID ====> Conectado a la base de datos");
                Statement st = conn.createStatement();

                String query = "SELECT nombre FROM peliculasfav WHERE id = " + idPelicula + ";";
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                     nombreTitulo = rs.getString("nombre");                   
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(UtilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombreTitulo;
    }
    
    
    // Métodos que lean las preferencias del usuario
    public static List<Integer> obtenerPeliculaPorUsuario(int idUsuario) throws ClassNotFoundException {
        List<Integer> lista = new ArrayList<Integer>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/recomendacion",
                    "root",
                    "root");

            if (conn != null) {
                System.out.println("\nUtilBD.registrarUsuario ====> Conectado a la base de datos");
                Statement st = conn.createStatement();

                String query = "SELECT id_pelicula FROM usuarios_generosfav WHERE id_usuario = " + idUsuario + ";";
                st.executeUpdate(query);
                
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                     int idPel = Integer.parseInt(rs.getString("id_pelicula"));
                     lista.add(idPel);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(UtilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public static List<Integer> obtenerGenerosPorUsuario(int idUsuario) throws ClassNotFoundException {
        List<Integer> lista = new ArrayList<Integer>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/recomendacion",
                    "root",
                    "root");

            if (conn != null) {
                System.out.println("\nUtilBD.registrarUsuario ====> Conectado a la base de datos");
                Statement st = conn.createStatement();

                String query = "SELECT id_genero FROM usuarios_generosfav WHERE id_usuario = " + idUsuario + ";";
                st.executeUpdate(query);
                
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                     int idGen = Integer.parseInt(rs.getString("id_genero"));
                     lista.add(idGen);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(UtilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public static List<Integer> obtenerDirectoresPorUsuario(int idUsuario) throws ClassNotFoundException {
        List<Integer> lista = new ArrayList<Integer>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/recomendacion",
                    "root",
                    "root");

            if (conn != null) {
                System.out.println("\nUtilBD.registrarUsuario ====> Conectado a la base de datos");
                Statement st = conn.createStatement();

                String query = "SELECT id_director FROM usuarios_directoresfav WHERE id_usuario = " + idUsuario + ";";
                st.executeUpdate(query);
                
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                     int idDir = Integer.parseInt(rs.getString("id_director"));
                     lista.add(idDir);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(UtilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public static List<Integer> obtenerActoresPorUsuario(int idUsuario) throws ClassNotFoundException {
        List<Integer> lista = new ArrayList<Integer>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/recomendacion",
                    "root",
                    "root");

            if (conn != null) {
                System.out.println("\nUtilBD.registrarUsuario ====> Conectado a la base de datos");
                Statement st = conn.createStatement();

                String query = "SELECT id_actor FROM usuarios_actoresfav WHERE id_usuario = " + idUsuario + ";";
                st.executeUpdate(query);
                
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                     int idAct = Integer.parseInt(rs.getString("id_actor"));
                     lista.add(idAct);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(UtilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
}
