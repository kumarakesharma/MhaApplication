package com.mha.learningConcept.retrofitConcept;

import okio.GzipSink;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    final static String BASE_URL = "https://fakestoreapi.com/";

    public static  <S> S getInstance(Class<S> serviceName){

           Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofit.create(serviceName);
    }
}
