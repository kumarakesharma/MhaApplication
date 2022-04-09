package com.mha.learningConcept.retrofitConcept.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CartsResponse {
    @SerializedName("id")
    private int id;

    @SerializedName("userId")
    private int userId;

    @SerializedName("date")
    private String date;

    @SerializedName("products")
    private ArrayList<CartProductQuantity> productQuantityArrayList;

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getDate() {
        return date;
    }

    public ArrayList<CartProductQuantity> getProductQuantityArrayList() {
        return productQuantityArrayList;
    }
}
