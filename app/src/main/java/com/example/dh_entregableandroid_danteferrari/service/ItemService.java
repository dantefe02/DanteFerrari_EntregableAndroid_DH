package com.example.dh_entregableandroid_danteferrari.service;

import com.example.dh_entregableandroid_danteferrari.model.ItemContainer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ItemService {

    @GET("sites/MLA/search?")
    Call<ItemContainer> getItems(
            @Query("q") String search);

}
