package com.jcodee.models;

/**
 * Created by johannfjs on 09/12/2015.
 */
public class Ropa {
    private String descripcion, urlImagen;

    public Ropa(String descripcion, String urlImagen) {
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}
