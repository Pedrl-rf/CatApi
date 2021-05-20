package com.example.catapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catapi.models.Vote;

import java.util.ArrayList;
import java.util.List;

public class AdapterListaVotos extends RecyclerView.Adapter<AdapterListaVotos.VotosHolder> {

    private List<Vote>listaVotos;
    private final Context context;


    public AdapterListaVotos(Context context) {
        this.context = context;
        this.listaVotos = new ArrayList<>();
    }


    @NonNull
    @Override
    public AdapterListaVotos.VotosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listarazas,parent,false);
        return new VotosHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListaVotos.VotosHolder holder, int position) {
        Vote vote = listaVotos.get(position);
        holder.tvVoto.setText(String.valueOf(vote.getId()));

    }

    @Override
    public int getItemCount() {
        return listaVotos.size();
    }

    public void setLista(List<Vote> body) {
        this.listaVotos = body;
        notifyDataSetChanged();
    }

    public class VotosHolder extends RecyclerView.ViewHolder {
        private TextView tvVoto;
        public VotosHolder(@NonNull View itemView) {
            super(itemView);
            tvVoto = itemView.findViewById(R.id.nombreRaza);
        }
    }
}
