package com.example.catapi.webservice;

import com.example.catapi.models.Datos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface WebServiceClient {
    public static final String BASE_URL = "https://api.thecatapi.com/v1/";
    public static final String TOKEN = "x-api-key: d2eadb3c-2886-46fb-9874-5d61db4fa5b6";

    @Headers(TOKEN)
    @GET("breeds")
    Call<Datos> getAllBreeds();
}
