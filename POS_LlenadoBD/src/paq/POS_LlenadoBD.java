/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package paq;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author fmlaq
 */
public class POS_LlenadoBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, org.json.simple.parser.ParseException, ParseException  {
        UtilBD util = new UtilBD();
        util.cargarGeneros();
        util.cargarDirectores();
        util.cargarActores();
        util.cargarPeliculas();
    }
    
}
