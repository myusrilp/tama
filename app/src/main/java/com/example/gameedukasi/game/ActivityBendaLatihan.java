package com.example.gameedukasi.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gameedukasi.R;
import com.example.gameedukasi.adapter.AdapterBendaList;
import com.example.gameedukasi.model.ModelBenda;

import java.util.ArrayList;
import java.util.List;

public class ActivityBendaLatihan extends AppCompatActivity {

    private Context context = ActivityBendaLatihan.this;
    List<ModelBenda> bendas;
    AdapterBendaList adapterBendaList;

    private RecyclerView rvBendaList;
    private Button back;
    MediaPlayer player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benda_latihan);

        rvBendaList = (RecyclerView) findViewById(R.id.rvBendaList);
        back = (Button) findViewById(R.id.back);

        bendas = new ArrayList<>();
        bendas.add(new ModelBenda("jam", R.drawable.ajam, R.raw.jam));
        bendas.add(new ModelBenda("buku", R.drawable.abuku,R.raw.buku));
        bendas.add(new ModelBenda("tas", R.drawable.atas,R.raw.tas));
        bendas.add(new ModelBenda("kipasangin", R.drawable.akipasangin,R.raw.kipasangin));
        bendas.add(new ModelBenda("kotak pensil", R.drawable.akotakpensil,R.raw.kotakpensil));
        bendas.add(new ModelBenda("kotak sampah", R.drawable.akotaksampah,R.raw.kotaksampah));
        bendas.add(new ModelBenda("meja", R.drawable.ameja,R.raw.meja));
        bendas.add(new ModelBenda("pena", R.drawable.apulpen,R.raw.pena));
        bendas.add(new ModelBenda("penggaris", R.drawable.apenggaris,R.raw.penggaris));
        bendas.add(new ModelBenda("pensil", R.drawable.apensil,R.raw.pensil));
        bendas.add(new ModelBenda("sapu", R.drawable.asapu,R.raw.sapu));
        bendas.add(new ModelBenda("sepatu", R.drawable.asepatu,R.raw.sepatu));
        bendas.add(new ModelBenda("televisi", R.drawable.atelevisi,R.raw.s));
        bendas.add(new ModelBenda("kursi", R.drawable.akursi,R.raw.kursi));
        bendas.add(new ModelBenda("penghapus", R.drawable.apenghapus,R.raw.p));

        initiateRecyclerView();

        player = new MediaPlayer();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                adapterBendaList.stopSound();
            }
        });
    }

    private void initiateRecyclerView(){
        adapterBendaList = new AdapterBendaList(context, bendas);
        rvBendaList.setLayoutManager(new GridLayoutManager(context, 3));
        rvBendaList.setAdapter(adapterBendaList);
    }
}