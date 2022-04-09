package com.mha.learningConcept.retrofitConcept;

import com.mha.learningConcept.retrofitConcept.response.CartsResponse;
import com.mha.learningConcept.retrofitConcept.response.ProductResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FakeStoreEndPoints {
    @GET("products")
    Call<List<ProductResponse>> getProductResponse();

    @GET("carts")
    Call<List<CartsResponse>> getCarts();



}
