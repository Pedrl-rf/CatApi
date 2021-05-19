package com.example.catapi;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.catapi.models.Datos;
import com.example.catapi.models.Image;
import com.example.catapi.models.Weight;
import com.example.catapi.webservice.WebServiceClient;
import com.squareup.picasso.Picasso;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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
//        initRetrofit();



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


        imgGato = gato.getImage();
        Picasso.get().load(imgGato.getUrl()).into(imgagenGato);

        pesoGato = gato.getWeight();
        peso.setText(pesoGato.getMetric()+" KG");
        caracter.setText(gato.getTemperament());
        origen.setText(gato.getOrigin());




    }

    private void initRetrofit() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WebServiceClient.BASE_URL+"images")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();
        webServiceClient = retrofit.create(WebServiceClient.class);
    }
}
