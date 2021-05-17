package com.example.catapi;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catapi.models.Datos;
import com.example.catapi.webservice.WebServiceClient;

import java.util.Collections;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RazasAdapter adapter;
    private LinearLayoutManager layoutManager;
    private WebServiceClient webServiceClient;
    private List<Datos> todasRazas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupView();
        initRetrofit();
        lanzarPeticion();
    }

    private void setupView() {

        recyclerView =  findViewById(R.id.listaRazas);
        adapter = new RazasAdapter(this);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }


    private void initRetrofit() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WebServiceClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();
        webServiceClient = retrofit.create(WebServiceClient.class);
    }


    private void lanzarPeticion(){
        Call<Datos>razasCall = webServiceClient.getAllBreeds();
        razasCall.enqueue(new Callback<Datos>() {
            @Override
            public void onResponse(Call<Datos> call, Response<Datos> response) {
                if (response.isSuccessful()) {
                    int code = response.code();

                    Datos misDatos = response.body();
                    todasRazas = String.valueOf(misDatos.getName());
                    adapter.setLista(todasRazas);
                } else {
                    showErrorMessage();
                }
            }

            private void showErrorMessage() {
                Toast.makeText(MainActivity.this, "Ha ocurrido un error desconocido. Por favor, vuelve a intentarlo más tarde.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Datos> call, Throwable t) {

            }
        });
    }
}