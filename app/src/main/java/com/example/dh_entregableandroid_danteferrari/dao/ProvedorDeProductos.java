package com.example.dh_entregableandroid_danteferrari.dao;

import com.example.dh_entregableandroid_danteferrari.R;
import com.example.dh_entregableandroid_danteferrari.model.Producto;

import java.util.ArrayList;
import java.util.List;

public abstract class ProvedorDeProductos {

    public static List<Producto> getProductos() {

        List<Producto> listaDeProductos = new ArrayList<>();
        listaDeProductos.add(new Producto("Bolso de Boquita", R.drawable.bolsoboquita, 800));
        listaDeProductos.add(new Producto("Pancho Gourmet", R.drawable.panchogourmet, 1000));
        listaDeProductos.add(new Producto("Bolso Deportivo", R.drawable.bolsodeportivo, 500));
        listaDeProductos.add(new Producto("Coleccion de Cocas", R.drawable.colecciondecocas, 1200));
        listaDeProductos.add(new Producto("Peluches de Android", R.drawable.peluchesandroid, 200));
        listaDeProductos.add(new Producto("Taza para Programador", R.drawable.tazaweapon, 450));
        listaDeProductos.add(new Producto("Pizza de Anana", R.drawable.pizzaanana, 15));
        listaDeProductos.add(new Producto("Papas con Helado", R.drawable.papasconhelado,670));
        listaDeProductos.add(new Producto("Perfume Burger King", R.drawable.perfumehamburguesas,2000));
        listaDeProductos.add(new Producto("Barbijo Esqueleto", R.drawable.barbijoesqueleto, 790))   ;
        listaDeProductos.add(new Producto("Michelin de yeso", R.drawable.michelinyeso, 2300));
        listaDeProductos.add(new Producto("Diccionario", R.drawable.diccionario, 1300));


        return listaDeProductos;
    }
}
