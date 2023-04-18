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
import com.example.gameedukasi.adapter.AdapterAbjadList;
import com.example.gameedukasi.adapter.AdapterBendaList;
import com.example.gameedukasi.model.ModelAbjad;
import com.example.gameedukasi.model.ModelBenda;

import java.util.ArrayList;
import java.util.List;

public class ActivityAbjadLatihan extends AppCompatActivity {
    private Context context = ActivityAbjadLatihan.this;
    List<ModelAbjad> abjads;
    AdapterAbjadList adapterAbjadList;

    private RecyclerView rvAbjadList;
    private Button back;
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abjad_latihan);

        rvAbjadList = (RecyclerView) findViewById(R.id.rvAbjadList);
        back = (Button) findViewById(R.id.back);
        abjads = new ArrayList<>();
        abjads.add(new ModelAbjad("a", R.drawable.a, R.raw.a));
        abjads.add(new ModelAbjad("b", R.drawable.b, R.raw.b));
        abjads.add(new ModelAbjad("c", R.drawable.c, R.raw.c));
        abjads.add(new ModelAbjad("d", R.drawable.d, R.raw.d));
        abjads.add(new ModelAbjad("e", R.drawable.e, R.raw.e));
        abjads.add(new ModelAbjad("f", R.drawable.f, R.raw.f));
        abjads.add(new ModelAbjad("g", R.drawable.g, R.raw.g));
        abjads.add(new ModelAbjad("h", R.drawable.h, R.raw.h));
        abjads.add(new ModelAbjad("i", R.drawable.i, R.raw.i));
        abjads.add(new ModelAbjad("j", R.drawable.j, R.raw.j));
        abjads.add(new ModelAbjad("k", R.drawable.k, R.raw.k));
        abjads.add(new ModelAbjad("l", R.drawable.l, R.raw.l));
        abjads.add(new ModelAbjad("m", R.drawable.m, R.raw.m));
        abjads.add(new ModelAbjad("n", R.drawable.n, R.raw.n));
        abjads.add(new ModelAbjad("o", R.drawable.o, R.raw.o));
        abjads.add(new ModelAbjad("p", R.drawable.p, R.raw.p));
        abjads.add(new ModelAbjad("q", R.drawable.q, R.raw.q));
        abjads.add(new ModelAbjad("r", R.drawable.r, R.raw.r));
        abjads.add(new ModelAbjad("s", R.drawable.s, R.raw.s));
        abjads.add(new ModelAbjad("t", R.drawable.t, R.raw.t));
        abjads.add(new ModelAbjad("u", R.drawable.u, R.raw.u));
        abjads.add(new ModelAbjad("v", R.drawable.v, R.raw.v));
        abjads.add(new ModelAbjad("w", R.drawable.w, R.raw.w));
        abjads.add(new ModelAbjad("x", R.drawable.x, R.raw.x));
        abjads.add(new ModelAbjad("y", R.drawable.y, R.raw.y));
        abjads.add(new ModelAbjad("z", R.drawable.z, R.raw.z));

        initiateRecyclerView();
        player = new MediaPlayer();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                adapterAbjadList.stopSound();
            }
        });
    }

    private void initiateRecyclerView() {
        adapterAbjadList = new AdapterAbjadList(context, abjads);
        rvAbjadList.setLayoutManager(new GridLayoutManager(context, 3));
        rvAbjadList.setAdapter(adapterAbjadList);
    }
}