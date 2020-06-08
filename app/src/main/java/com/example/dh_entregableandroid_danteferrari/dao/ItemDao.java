package com.example.dh_entregableandroid_danteferrari.dao;

import com.example.dh_entregableandroid_danteferrari.model.ItemContainer;
import com.example.dh_entregableandroid_danteferrari.service.ItemService;
import com.example.dh_entregableandroid_danteferrari.util.ResultListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ItemDao {

    /**
     * Retrofit retrofit = new Retrofit.Builder()
     * .baseUrl("https://api.github.com/")
     * .build();
     */

    private static String BASE_URL = "https://api.mercadolibre.com/";
    private Retrofit retrofit;
    private ItemService itemService;

    public ItemDao() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.itemService = retrofit.create(ItemService.class);
    }

    public void getItems(String search, final ResultListener<ItemContainer> itemResultListenerFromController) {

        Call<ItemContainer> call = itemService.getItems(search);

        call.enqueue(new Callback<ItemContainer>() {

            @Override
            public void onResponse(Call<ItemContainer> call, Response<ItemContainer> response) {
                if (response.isSuccessful()) {
                    ItemContainer body = response.body();
                    itemResultListenerFromController.onFinish(body);
                } else {
                    System.out.println("SOUTSOOUT");
                    response.errorBody();
                }

            }

            @Override
            public void onFailure(Call<ItemContainer> call, Throwable t) {
                t.printStackTrace();
            }

        });

        System.out.println("SOUTSOUT");
    }

}
