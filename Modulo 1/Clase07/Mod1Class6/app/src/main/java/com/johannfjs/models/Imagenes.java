package com.johannfjs.models;

/**
 * Created by johannfjs on 05/10/15.
 */
public class Imagenes {
    private int id;
    private String urlImagen, titulo, contenido, fecha;

    public Imagenes(int id, String urlImagen, String titulo, String contenido, String fecha) {
        this.id = id;
        this.urlImagen = urlImagen;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
