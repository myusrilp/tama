package com.example.gameedukasi.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gameedukasi.R;
import com.example.gameedukasi.model.ModelHewan;

import java.util.List;

public class AdapterHewanList extends RecyclerView.Adapter<AdapterHewanList.ViewHolder>{

    private Context context;
    private List<ModelHewan> items;
    private MediaPlayer player;

    public AdapterHewanList(Context context, List<ModelHewan> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public AdapterHewanList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.card_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHewanList.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imgSelectHewan.setImageResource(items.get(position).getIcon());
        holder.imgSelectHewan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSound(items.get(position).getNama());
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgSelectHewan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgSelectHewan = (ImageView) itemView.findViewById(R.id.imgSelectHewan);
        }
    }

    public void startSound(String filename) {
        player = new MediaPlayer();
        try {
            if (player.isPlaying()) {
                player.stop();
                player.release();
            }

            AssetFileDescriptor descriptor = context.getAssets().openFd(filename+".mp3");
            player.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            descriptor.close();

            player.prepare();
            player.setVolume(1f, 1f);
            player.setLooping(false);
            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
