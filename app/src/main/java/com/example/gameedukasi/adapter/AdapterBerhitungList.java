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
import com.example.gameedukasi.model.ModelBerhitung;

import java.util.List;

public class AdapterBerhitungList extends RecyclerView.Adapter<AdapterBerhitungList.ViewHolder> {

    private Context context;
    private List<ModelBerhitung> list;
    private MediaPlayer player;

    public AdapterBerhitungList(Context context, List<ModelBerhitung> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterBerhitungList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.card_list_item, parent, false);
        return new AdapterBerhitungList.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBerhitungList.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
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
