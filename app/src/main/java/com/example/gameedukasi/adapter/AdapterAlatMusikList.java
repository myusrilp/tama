package com.example.gameedukasi.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gameedukasi.R;
import com.example.gameedukasi.model.ModelAlatMusik;

import java.util.List;

public class AdapterAlatMusikList extends RecyclerView.Adapter<AdapterAlatMusikList.ViewHolder> {

    private Context context;
    private List<ModelAlatMusik> list;
    private MediaPlayer player;

    public AdapterAlatMusikList(Context context, List<ModelAlatMusik> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterAlatMusikList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.card_list_item, parent, false);
        return new AdapterAlatMusikList.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAlatMusikList.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imgSelectHewan.setImageResource(list.get(position).getIcon());
        player = new MediaPlayer();
        holder.imgSelectHewan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.stop();
                player.release();
                player = MediaPlayer.create(context, list.get(position).getSound());
                player.start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgSelectHewan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSelectHewan = (ImageView) itemView.findViewById(R.id.imgSelectHewan);
        }
    }
    public void stopSound(){
        player.stop();
        player.release();
    }
}
