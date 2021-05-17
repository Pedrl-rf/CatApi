package com.example.catapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catapi.models.Datos;

import java.util.ArrayList;
import java.util.List;

public class RazasAdapter extends RecyclerView.Adapter<RazasAdapter.RazasHolder> {
    private List<Datos> razas;
    private final Context context;

    public RazasAdapter(Context context) {
        this.context = context;
        this.razas = new ArrayList<>();
    }

    @NonNull
    @Override
    public RazasHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listarazas, parent, false);
        return new RazasHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull RazasAdapter.RazasHolder holder, int position) {
        Datos raza = razas.get(position);
        holder.tvRaza.setText(raza.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CatDetail.class);
                intent.putExtra("data", (Parcelable) razas);
                context.startActivity(intent);

            }
        });
    }


    @Override
    public int getItemCount() {
        return razas.size();
    }

    public void setLista(List<Datos> listadoDeRazas) {
        this.razas = listadoDeRazas;
        notifyDataSetChanged();
    }

    public class RazasHolder extends RecyclerView.ViewHolder {

        private final TextView tvRaza;

        public RazasHolder(@NonNull View r) {
            super(r);
            tvRaza = r.findViewById(R.id.nombreRaza);
        }
    }
}
