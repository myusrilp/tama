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
        bendas.add(new ModelBenda("jam", R.drawable.jam, R.raw.jam));
        bendas.add(new ModelBenda("papantulis", R.drawable.papantulis, R.raw.papantulis));
        bendas.add(new ModelBenda("buku", R.drawable.buku,R.raw.buku));
        bendas.add(new ModelBenda("tas", R.drawable.tas,R.raw.tas));
        bendas.add(new ModelBenda("kapur", R.drawable.kapur,R.raw.kapur));
        bendas.add(new ModelBenda("kipasangin", R.drawable.kipasangin,R.raw.kipasangin));
        bendas.add(new ModelBenda("kotak pensil", R.drawable.kotakpensil,R.raw.kotakpensil));
        bendas.add(new ModelBenda("kotak sampah", R.drawable.kotaksampah,R.raw.kotaksampah));
        bendas.add(new ModelBenda("lampu", R.drawable.lampu,R.raw.lampu));
        bendas.add(new ModelBenda("lemari", R.drawable.lemari,R.raw.lemari));
        bendas.add(new ModelBenda("meja", R.drawable.meja,R.raw.meja));
        bendas.add(new ModelBenda("pena", R.drawable.pena,R.raw.pena));
        bendas.add(new ModelBenda("penggaris", R.drawable.penggaris,R.raw.penggaris));
        bendas.add(new ModelBenda("penghapuspensil", R.drawable.penghapuspensil,R.raw.penghapuspensil));
        bendas.add(new ModelBenda("pensil", R.drawable.pensil,R.raw.pensil));
        bendas.add(new ModelBenda("pensilwarna", R.drawable.pensilwarna,R.raw.pensilwarna));
        bendas.add(new ModelBenda("pintu", R.drawable.pintu,R.raw.pintu));
        bendas.add(new ModelBenda("rakbuku", R.drawable.rakbuku,R.raw.rakbuku));
        bendas.add(new ModelBenda("raksepatu", R.drawable.raksepatu,R.raw.raksepatu));
        bendas.add(new ModelBenda("sapu", R.drawable.sapu,R.raw.sapu));
        bendas.add(new ModelBenda("sepatu", R.drawable.sepatu,R.raw.sepatu));
        bendas.add(new ModelBenda("serutanpensil", R.drawable.serutanpensil,R.raw.serutanpensil));
        bendas.add(new ModelBenda("spidol", R.drawable.spidol,R.raw.spidol));

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