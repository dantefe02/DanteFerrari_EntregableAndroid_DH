package com.example.dh_entregableandroid_danteferrari.model;

import java.util.List;

public class UsuarioME {

    //Atributos

    private String nombre;
    private String apellido;
    private String email;
    private List<Item> listaFavoritos;

    public UsuarioME() {
    }

    public UsuarioME(String nombre, String apellido, String email, List<Item> listaFavoritos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.listaFavoritos = listaFavoritos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Item> getListaFavoritos() {
        return listaFavoritos;
    }

    public void setListaFavoritos(List<Item> listaFavoritos) {
        this.listaFavoritos = listaFavoritos;
    }
}

