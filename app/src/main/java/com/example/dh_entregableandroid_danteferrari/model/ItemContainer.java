package com.example.dh_entregableandroid_danteferrari.model;

import com.example.dh_entregableandroid_danteferrari.model.Item;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ItemContainer implements Serializable {
    /**
     *"site_id": "MLA",
     *  "query"
     * "results"
     */
    @SerializedName("site_id")
    private String siteId;
    private String query;
    private List<Item> results;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<Item> getResults() {
        return results;
    }

    public void setResults(List<Item> results) {
        this.results = results;
    }
}
