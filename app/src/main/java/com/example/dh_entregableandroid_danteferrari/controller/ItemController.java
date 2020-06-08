package com.example.dh_entregableandroid_danteferrari.controller;

import com.example.dh_entregableandroid_danteferrari.dao.ItemDao;
import com.example.dh_entregableandroid_danteferrari.model.ItemContainer;
import com.example.dh_entregableandroid_danteferrari.util.ResultListener;

public class ItemController {

    private ItemDao itemDao;

    public ItemController() {
        this.itemDao = new ItemDao();
    }

    public void getItemContainer(String search, final ResultListener<ItemContainer> itemResultListenerFromView) {
        this.itemDao.getItems(search, new ResultListener<ItemContainer>() {
            @Override
            public void onFinish(ItemContainer result) {
                itemResultListenerFromView.onFinish(result);
            }

        });
    }
}
