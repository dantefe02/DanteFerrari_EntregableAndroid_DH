package com.example.dh_entregableandroid_danteferrari.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Item implements Serializable {

    /**
     * "id": "MLA810645375",
     * "site_id": "MLA",
     * "title": "Motorola G6 Plus 64 Gb Nimbus"
     * "price": 17999
     * "thumbnail": "http://mla-s2-p.mlstatic.com/795558-MLA31003306206_062019-I.jpg"
     */

    private String id;
    @SerializedName("site_id")
    private String siteId;
    private String title;
    private Double price;
    private String thumbnail;
    private boolean accepts_mercadopago;

    public boolean isAccepts_mercadopago() {
        return accepts_mercadopago;
    }

    public void setAccepts_mercadopago(boolean accepts_mercadopago) {
        this.accepts_mercadopago = accepts_mercadopago;
    }

    public Item() {
    }

    public Item(String id, String siteId, String title, Double price, String thumbnail, boolean accepts_mercadopago) {
        this.id = id;
        this.siteId = siteId;
        this.title = title;
        this.price = price;
        this.thumbnail = thumbnail;
        this.accepts_mercadopago = accepts_mercadopago;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
