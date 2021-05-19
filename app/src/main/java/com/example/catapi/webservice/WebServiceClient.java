package com.example.catapi.webservice;

import com.example.catapi.models.Datos;
import com.example.catapi.models.ResponseVote;
import com.example.catapi.models.SendVote;
import com.example.catapi.models.Vote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface WebServiceClient {
    public static final String BASE_URL = "https://api.thecatapi.com/v1/";
    public static final String TOKEN = "x-api-key: d2eadb3c-2886-46fb-9874-5d61db4fa5b6";

    @Headers(TOKEN)
    @GET("breeds")
    Call<List<Datos>> getAllBreeds();

    @Headers({TOKEN, "Content-Type: application/json"})
    @POST("votes")
    Call<ResponseVote> enviarVoto(@Body SendVote.Category sendVote);

    @Headers(TOKEN)
    @GET("votes")
    Call<List<Vote>> getAllVotes();

}
