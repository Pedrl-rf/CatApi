package com.example.catapi;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.catapi.models.Datos;
import com.example.catapi.models.Vote;
import com.example.catapi.webservice.WebServiceClient;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaVotos extends AppCompatActivity {
    private RecyclerView recyclerView;
    private  AdapterListaVotos adapterListaVotos;
    private LinearLayoutManager layoutManager;
    //private LinearLayoutManager linearLayoutManager;
    private WebServiceClient webServiceClient;
    private List<Vote>listaVotos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listavotos);
        setupView();
        initRetrofit();
        lanzarPeticion();
    }

    private void setupView(){
        recyclerView =  findViewById(R.id.rv_listaVotos);
        adapterListaVotos = new AdapterListaVotos(this);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterListaVotos);

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
        Call<List<Vote>> todosLosVotos = webServiceClient.getAllVotes();

        todosLosVotos.enqueue(new Callback<List<Vote>>() {

            @Override
            public void onResponse(Call<List<Vote>> call, Response<List<Vote>> response) {
                if (response.isSuccessful()) {
                    int code = response.code();

                    adapterListaVotos.setLista(response.body());
            }
        }

            @Override
            public void onFailure(Call<List<Vote>> call, Throwable t) {
                showErrorMessage();
            }
        });
    }

    private void showErrorMessage() {
        Toast.makeText(ListaVotos.this, "Ha ocurrido un error desconocido. Por favor, vuelve a intentarlo más tarde.", Toast.LENGTH_SHORT).show();

    }
}
