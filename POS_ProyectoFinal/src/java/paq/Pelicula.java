/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paq;

/**
 *
 * @author fmlaq
 */
public class Pelicula {
    private int id;
    private String nombre;
    private String anio;
    private String clasificacion;
    private String fechaEstreno;
    private String duracion;
    private String genero;
    private String director;
    private String escritor;
    private String actores;
    private String sinopsis;
    private String idioma;
    private String pais;
    private String premios;
    private String tipo;
    private String poster;
    
    public Pelicula(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Pelicula(String nombre, String anio, String tipo, String poster) {
        this.nombre = nombre;
        this.anio = anio;
        this.tipo = tipo;
        this.poster = poster;
    }

    public Pelicula(String nombre, String anio, String clasificacion, String fechaEstreno, String duracion, String genero, String director, String escritor, String actores, String sinopsis, String idioma, String pais, String premios, String tipo, String poster) {
        this.nombre = nombre;
        this.anio = anio;
        this.clasificacion = clasificacion;
        this.fechaEstreno = fechaEstreno;
        this.duracion = duracion;
        this.genero = genero;
        this.director = director;
        this.escritor = escritor;
        this.actores = actores;
        this.sinopsis = sinopsis;
        this.idioma = idioma;
        this.pais = pais;
        this.premios = premios;
        this.tipo = tipo;
        this.poster = poster;
    }
    
    public Pelicula(int id, String nombre, String anio, String clasificacion, String fechaEstreno, String duracion, String genero, String director, String escritor, String actores, String sinopsis, String idioma, String pais, String premios, String tipo, String poster) {
        this.id = id;
        this.nombre = nombre;
        this.anio = anio;
        this.clasificacion = clasificacion;
        this.fechaEstreno = fechaEstreno;
        this.duracion = duracion;
        this.genero = genero;
        this.director = director;
        this.escritor = escritor;
        this.actores = actores;
        this.sinopsis = sinopsis;
        this.idioma = idioma;
        this.pais = pais;
        this.premios = premios;
        this.tipo = tipo;
        this.poster = poster;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPremios() {
        return premios;
    }

    public void setPremios(String premios) {
        this.premios = premios;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
}
