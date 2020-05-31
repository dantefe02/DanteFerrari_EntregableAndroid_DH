package com.example.dh_entregableandroid_danteferrari;

import java.io.Serializable;

public class Producto implements Serializable {

    private String nombre;
    private Integer imagen;
    private Integer precio;

    public Producto(String nombre, Integer imagen, Integer precio) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getImagen() {
        return imagen;
    }

    public void setImagen(Integer imagen) {
        this.imagen = imagen;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
}
