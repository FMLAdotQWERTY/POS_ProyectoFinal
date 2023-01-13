/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq;

/**
 *
 * @author fmlaq
 */
public class Usuario {
    private int id;
    private String nombre_usuario;
    private String contrasena_usuario;
    private String nombre_completo;
    private int edad;
    private String genero;
    private String correo;

    public Usuario(int id, String nombre_usuario, String contrasena_usuario, String nombre_completo, int edad, String genero, String correo) {
        this.id = id;
        this.nombre_usuario = nombre_usuario;
        this.contrasena_usuario = contrasena_usuario;
        this.nombre_completo = nombre_completo;
        this.edad = edad;
        this.genero = genero;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasena_usuario() {
        return contrasena_usuario;
    }

    public void setContrasena_usuario(String contrasena_usuario) {
        this.contrasena_usuario = contrasena_usuario;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre_usuario=" + nombre_usuario + ", contrasena_usuario=" + contrasena_usuario + ", nombre_completo=" + nombre_completo + ", edad=" + edad + ", genero=" + genero + ", correo=" + correo + '}';
    }
    
}
