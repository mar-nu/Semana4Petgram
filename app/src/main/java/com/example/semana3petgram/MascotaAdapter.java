package com.example.semana3petgram;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>{

    private ArrayList<Mascota> mascotas;
    AppCompatActivity activity;

    public MascotaAdapter(ArrayList<Mascota> mascotas, AppCompatActivity activity) {
        this.mascotas = mascotas;
        this.activity=activity;
    }



    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MascotaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.mascotas_cardview, parent, false));
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvLike.setText(mascota.getLikes());

        holder.btnLike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Toast.makeText(activity, mascota.getNombre() + " tiene " + mascota.getLikes() + " likes", Toast.LENGTH_LONG).show(); }
        }
        );

       holder.btnRate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Toast.makeText(activity, "Diste like a " + mascota.getNombre(), Toast.LENGTH_LONG).show(); }
        }
        );


    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    class MascotaViewHolder extends RecyclerView.ViewHolder{

        ImageView imgFoto;
        TextView tvNombre;
        TextView tvLike;
       private ImageButton btnRate;
        private ImageButton btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvLike = (TextView) itemView.findViewById(R.id.tvLike);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
            btnRate = (ImageButton) itemView.findViewById(R.id.btnRate);
        }
    }
}