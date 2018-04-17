package com.crechelessons.retrofitsample.rest;

import com.crechelessons.retrofitsample.model.ModelClass;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("iss-now.json")
    Call<ModelClass> getData();

}
