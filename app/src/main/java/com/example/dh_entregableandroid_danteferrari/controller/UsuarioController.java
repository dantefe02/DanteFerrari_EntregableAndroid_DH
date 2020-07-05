package com.example.dh_entregableandroid_danteferrari.controller;

import com.example.dh_entregableandroid_danteferrari.dao.UsuarioMEDaoFirebase;
import com.example.dh_entregableandroid_danteferrari.model.Item;
import com.example.dh_entregableandroid_danteferrari.model.UsuarioME;
import com.example.dh_entregableandroid_danteferrari.util.ResultListener;

public class UsuarioController {

    //Atributos
    private UsuarioMEDaoFirebase usuarioMEDaoFirebase;

    //Constructor
    public UsuarioController() {
        this.usuarioMEDaoFirebase = new UsuarioMEDaoFirebase();
    }


    //Metodos
    public void agregarUsuario(UsuarioME usuarioME, final ResultListener<UsuarioME> resultListenerFromView) {
        usuarioMEDaoFirebase.agregarUsuario(usuarioME, new ResultListener<UsuarioME>() {
            @Override
            public void onFinish(UsuarioME result) {
                resultListenerFromView.onFinish(result);
            }

            @Override
            public void onError(String mensaje) {
                resultListenerFromView.onError(mensaje);
            }
        });
    }

    public void agregarItemFavoritos(Item item, final ResultListener<Item> resultListenerFromView) {
        usuarioMEDaoFirebase.agregarItemFavoritos(item, new ResultListener<Item>() {
            @Override
            public void onFinish(Item result) {
                resultListenerFromView.onFinish(result);
            }

            @Override
            public void onError(String mensaje) {
                resultListenerFromView.onError(mensaje);
            }
        });
    }

    public void getUsuarioME(final ResultListener<UsuarioME> resultListenerFromView) {
        usuarioMEDaoFirebase.getUsuarioME(new ResultListener<UsuarioME>() {

            @Override
            public void onFinish(UsuarioME result) {
                resultListenerFromView.onFinish(result);
            }

            @Override
            public void onError(String mensaje) {
                resultListenerFromView.onError(mensaje);
            }
        });
    }
}
