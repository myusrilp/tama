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
import com.example.gameedukasi.adapter.AdapterBuahList;
import com.example.gameedukasi.adapter.AdapterHewanList;
import com.example.gameedukasi.adapter.AdapterHijaiyahList;
import com.example.gameedukasi.model.ModelBuah;
import com.example.gameedukasi.model.ModelHewan;
import com.example.gameedukasi.model.ModelHijaiyah;

import java.util.ArrayList;
import java.util.List;

public class ActivityHijaiyahLatihan extends AppCompatActivity {

    private Context context = ActivityHijaiyahLatihan.this;
    List<ModelHijaiyah> hijaiyahs;
    AdapterHijaiyahList adapterHijaiyahList;
    private RecyclerView rvHijaiyahList;
    private Button back;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hijaiyah_latihan);

        rvHijaiyahList = (RecyclerView) findViewById(R.id.rvHijaiyahList);
        back = (Button) findViewById(R.id.back);
        hijaiyahs = new ArrayList<>();
        hijaiyahs.add(new ModelHijaiyah("alif", R.drawable.alif, R.raw.alif));
        hijaiyahs.add(new ModelHijaiyah("ba", R.drawable.ba, R.raw.ba));
        hijaiyahs.add(new ModelHijaiyah("ta", R.drawable.ta, R.raw.ta));
        hijaiyahs.add(new ModelHijaiyah("tsa", R.drawable.tsa, R.raw.tsa));
        hijaiyahs.add(new ModelHijaiyah("jim", R.drawable.jim, R.raw.jim));
        hijaiyahs.add(new ModelHijaiyah("ha", R.drawable.ha, R.raw.ha));
        hijaiyahs.add(new ModelHijaiyah("kha", R.drawable.kha, R.raw.kha));
        hijaiyahs.add(new ModelHijaiyah("dal", R.drawable.dal, R.raw.dal));
        hijaiyahs.add(new ModelHijaiyah("dzal", R.drawable.dzal, R.raw.dzal));
        hijaiyahs.add(new ModelHijaiyah("ra", R.drawable.ra, R.raw.ra));
        hijaiyahs.add(new ModelHijaiyah("za", R.drawable.za, R.raw.za));
        hijaiyahs.add(new ModelHijaiyah("sin", R.drawable.sin, R.raw.sin));
        hijaiyahs.add(new ModelHijaiyah("syin", R.drawable.syin, R.raw.syin));
        hijaiyahs.add(new ModelHijaiyah("shad", R.drawable.shad, R.raw.shad));
        hijaiyahs.add(new ModelHijaiyah("dha", R.drawable.dha, R.raw.dha));
        hijaiyahs.add(new ModelHijaiyah("tha", R.drawable.tha, R.raw.tha));
        hijaiyahs.add(new ModelHijaiyah("zha", R.drawable.zha, R.raw.zha));
        hijaiyahs.add(new ModelHijaiyah("ain", R.drawable.ain, R.raw.ain));
        hijaiyahs.add(new ModelHijaiyah("ghain", R.drawable.ghain, R.raw.ghain));
        hijaiyahs.add(new ModelHijaiyah("fa", R.drawable.fa, R.raw.fa));
        hijaiyahs.add(new ModelHijaiyah("qaf", R.drawable.qaf, R.raw.qaf));
        hijaiyahs.add(new ModelHijaiyah("kaf", R.drawable.kaf, R.raw.kaf));
        hijaiyahs.add(new ModelHijaiyah("lam", R.drawable.lam, R.raw.lam));
        hijaiyahs.add(new ModelHijaiyah("mim", R.drawable.mim, R.raw.mim));
        hijaiyahs.add(new ModelHijaiyah("nun", R.drawable.nun, R.raw.nun));
        hijaiyahs.add(new ModelHijaiyah("wau", R.drawable.wau, R.raw.wau));
        hijaiyahs.add(new ModelHijaiyah("haa", R.drawable.haa, R.raw.haa));
        hijaiyahs.add(new ModelHijaiyah("lamalif", R.drawable.lamalif, R.raw.lamalif));
        hijaiyahs.add(new ModelHijaiyah("hamzah", R.drawable.hamzah, R.raw.hamzah));
        hijaiyahs.add(new ModelHijaiyah("ya", R.drawable.ya, R.raw.ya));

        initiateRecyclerView();
        player = new MediaPlayer();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                adapterHijaiyahList.stopSound();
            }
        });
    }

    private void initiateRecyclerView() {
        adapterHijaiyahList = new AdapterHijaiyahList(context, hijaiyahs);
        rvHijaiyahList.setLayoutManager(new GridLayoutManager(context, 3));
        rvHijaiyahList.setAdapter(adapterHijaiyahList);
    }
}