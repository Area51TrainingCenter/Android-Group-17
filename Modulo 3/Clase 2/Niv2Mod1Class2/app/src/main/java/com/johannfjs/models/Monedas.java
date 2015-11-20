package com.johannfjs.models;

/**
 * Created by johannfjs on 16/11/2015.
 */
public class Monedas {
    private String key;
    private String value;

    public Monedas(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
