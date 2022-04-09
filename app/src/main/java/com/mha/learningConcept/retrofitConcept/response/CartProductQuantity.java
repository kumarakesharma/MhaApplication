package com.mha.learningConcept.retrofitConcept.response;

import com.google.gson.annotations.SerializedName;

public class CartProductQuantity {
    @SerializedName("productId")
    private int productId;

    @SerializedName("quantity")
    private int quantity;

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
