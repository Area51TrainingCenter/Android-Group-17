package com.jcodee.models;

/**
 * Created by johannfjs on 07/12/2015.
 */
public class Distrito {
    private String distrito, descripcion, objectId;

    public Distrito(String distrito, String descripcion, String objectId) {
        this.distrito = distrito;
        this.descripcion = descripcion;
        this.objectId = objectId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
