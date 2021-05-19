package com.example.catapi;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.catapi.models.Datos;
import com.example.catapi.models.Image;
import com.example.catapi.models.ResponseVote;
import com.example.catapi.models.SendVote;
import com.example.catapi.models.Weight;
import com.example.catapi.webservice.WebServiceClient;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CatDetail extends AppCompatActivity {

    private Datos gato;
    private Image imgGato;
    private Weight pesoGato;
    private WebServiceClient webServiceClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.catdetail);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey("data")) {
            gato = bundle.getParcelable("data");
        }

        setupView();
        initRetrofit();



        setTitle(gato.getName());
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }



    }

    private void setupView() {
        TextView peso = findViewById(R.id.peso);
        TextView caracter = findViewById(R.id.temperamento);
        TextView origen = findViewById(R.id.origen);
        ImageView imgagenGato = findViewById(R.id.imagenGato);
        FloatingActionButton fab_votar = findViewById(R.id.fab_votar);


        imgGato = gato.getImage();
        Picasso.get().load(imgGato.getUrl()).into(imgagenGato);

        pesoGato = gato.getWeight();
        peso.setText(pesoGato.getMetric()+" KG");
        caracter.setText(gato.getTemperament());
        origen.setText(gato.getOrigin());



        fab_votar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                votoGato(1);
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

    private void votoGato(int voto){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WebServiceClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();
        webServiceClient = retrofit.create(WebServiceClient.class);

        Image image = gato.getImage();
        String id = image.getId();

        SendVote.Category sendVote = new SendVote.Category(id,"pedro",voto);

        Call<ResponseVote> call = webServiceClient.enviarVoto(sendVote);
        call.enqueue(new Callback<ResponseVote>() {
            @Override
            public void onResponse(Call<ResponseVote> call, Response<ResponseVote> response) {
                ResponseVote responseVote = response.body();
                String  msg = responseVote.getMessage();
                Toast.makeText(CatDetail.this, msg,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseVote> call, Throwable t) {

            }
        });
    }



}
