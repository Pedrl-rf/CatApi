package com.example.catapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catapi.models.Vote;

import java.util.List;

public class AdapterListaVotos extends RecyclerView.Adapter<AdapterListaVotos.VotosHolder> {

    private List<Vote>listaVotos;
    private final Context context;


    public AdapterListaVotos(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public AdapterListaVotos.VotosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listarazas,parent,false);
        return new VotosHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListaVotos.VotosHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class VotosHolder extends RecyclerView.ViewHolder {
        public VotosHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
