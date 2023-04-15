package com.example.gameedukasi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gameedukasi.R;
import com.example.gameedukasi.model.ModelBenda;

import java.util.List;

public class AdapterBendaList extends RecyclerView.Adapter<AdapterBendaList.ViewHolder> {

    private Context context;
    private List<ModelBenda> list;

    public AdapterBendaList(Context context, List<ModelBenda> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterBendaList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.card_list_item, parent, false);
        return new AdapterBendaList.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBendaList.ViewHolder holder, int position) {
        holder.imgSelectHewan.setImageResource(list.get(position).getIcon());
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
}
