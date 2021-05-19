package com.example.catapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.catapi.models.Datos;
import com.example.catapi.webservice.WebServiceClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

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
    private SwipeRefreshLayout swipeRefreshLayout;
    private FloatingActionButton fab_listaVotos;




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

        swipeRefreshLayout = findViewById(R.id.refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                lanzarPeticion();
            }
        });

        fab_listaVotos = findViewById(R.id.fab_listaVotos);
        fab_listaVotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListaVotos.class);
                startActivity(intent);
            }
        });
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
        Call<List<Datos>> todosLosGatos = webServiceClient.getAllBreeds();

        todosLosGatos.enqueue(new Callback<List<Datos>>() {
            //ssss
            @Override
            public void onResponse(Call<List<Datos>> call, Response<List<Datos>> response) {
                if (swipeRefreshLayout.isRefreshing()){
                    swipeRefreshLayout.setRefreshing(false);
                }
                if (response.isSuccessful()) {
                    int code = response.code();

                    adapter.setLista(response.body());
                    //adapter.setLista(todasRazas);
                } else {
                    showErrorMessage();
                }
            }

            @Override
            public void onFailure(Call<List<Datos>> call, Throwable t) {
                showErrorMessage();
            }
        });
    }
    private void showErrorMessage() {
        Toast.makeText(MainActivity.this, "Ha ocurrido un error desconocido. Por favor, vuelve a intentarlo más tarde.", Toast.LENGTH_SHORT).show();
    }


}