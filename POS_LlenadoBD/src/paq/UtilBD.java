/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/**
 *
 * @author fmlaq
 */
public class UtilBD {

    public void cargarGeneros() throws ClassNotFoundException, ParseException, java.text.ParseException {
        List<String> generos = ClienteOMDBApi.obtenerGeneros();
        Set<String> conjuntoGeneros = new HashSet<String>(generos);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/recomendacion",
                    "root",
                    "root");

            if (conn != null) {
                System.out.println("UtilBD.cargarGeneros ====> Conectado a la base de datos");
                Statement st = conn.createStatement();
                for (String cadaGen : conjuntoGeneros) {
                    String query = "INSERT INTO generosfav (nombre) VALUES('"+ cadaGen + "')";
                    st.executeUpdate(query);
                    System.out.println("\t---> " + cadaGen);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(UtilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarPeliculas() throws ClassNotFoundException, ParseException, java.text.ParseException {
        List<String> peliculas = ClienteOMDBApi.obtenerPeliculas();
        Set<String> conjuntoPeliculas = new HashSet<String>(peliculas);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/recomendacion",
                    "root",
                    "root");

            if (conn != null) {
                System.out.println("UtilBD.cargarPeliculas ====> Conectado a la base de datos");
                Statement st = conn.createStatement();
                for (String cadaPeli : conjuntoPeliculas) {
                    String query = "INSERT INTO peliculasfav (nombre) VALUES('"+ cadaPeli + "')";
                    st.executeUpdate(query);
                    System.out.println("\t---> " + cadaPeli);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(UtilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarActores() throws ClassNotFoundException, ParseException, java.text.ParseException {
        List<String> actores = ClienteOMDBApi.obtenerActores();
        Set<String> conjuntoActores = new HashSet<String>(actores);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/recomendacion",
                    "root",
                    "root");

            if (conn != null) {
                System.out.println("UtilBD.cargarActores ====> Conectado a la base de datos");
                Statement st = conn.createStatement();
                for (String cadaActor : conjuntoActores) {
                    String query = "INSERT INTO actoresfav (nombre) VALUES('"+ cadaActor + "')";
                    st.executeUpdate(query);
                    System.out.println("\t---> " + cadaActor);
                }

            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(UtilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarDirectores() throws ClassNotFoundException, ParseException, java.text.ParseException {
        List<String> directores = ClienteOMDBApi.obtenerDirectores();
        Set<String> conjuntoDirectores = new HashSet<String>(directores);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/recomendacion",
                    "root",
                    "root");

            if (conn != null) {
                System.out.println("UtilBD.cargarDirectores ====> Conectado a la base de datos");
                Statement st = conn.createStatement();
                for (String cadaDirector : conjuntoDirectores) {
                    String query = "INSERT INTO directoresfav (nombre) VALUES('"+ cadaDirector + "')";
                    st.executeUpdate(query);
                    System.out.println("\t---> " + cadaDirector);
                }

            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(UtilBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
