package com.johannfjs.models;

/**
 * Created by johannfjs on 05/10/15.
 */
public class Cupon {
    private int id;
    private String rutaImagen, titulo, subtitulo, distancia, likes, precio1, precio2;

    public Cupon(int id, String rutaImagen, String titulo, String subtitulo, String distancia, String likes, String precio1, String precio2) {
        this.id = id;
        this.rutaImagen = rutaImagen;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.distancia = distancia;
        this.likes = likes;
        this.precio1 = precio1;
        this.precio2 = precio2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getPrecio1() {
        return precio1;
    }

    public void setPrecio1(String precio1) {
        this.precio1 = precio1;
    }

    public String getPrecio2() {
        return precio2;
    }

    public void setPrecio2(String precio2) {
        this.precio2 = precio2;
    }
}
