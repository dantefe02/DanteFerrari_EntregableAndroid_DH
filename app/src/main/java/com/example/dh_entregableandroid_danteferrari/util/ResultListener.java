package com.example.dh_entregableandroid_danteferrari.util;

public interface ResultListener<T> {
public void onFinish(T result);
public void onError (String mensaje);
}
