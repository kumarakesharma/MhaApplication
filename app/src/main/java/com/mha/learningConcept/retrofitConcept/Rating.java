package com.mha.learningConcept.retrofitConcept;

import com.google.gson.annotations.SerializedName;

public class Rating {
    @SerializedName("rate")
    private double rate;

    @SerializedName("count")
    private int count;

    public double getRate() {
        return rate;
    }

    public int getCount() {
        return count;
    }
}
