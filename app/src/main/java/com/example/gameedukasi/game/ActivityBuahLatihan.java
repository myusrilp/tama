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
import com.example.gameedukasi.model.ModelBuah;

import java.util.ArrayList;
import java.util.List;

public class ActivityBuahLatihan extends AppCompatActivity {
    private Context context = ActivityBuahLatihan.this;
    List<ModelBuah> buahs;
    AdapterBuahList adapterBuahList;
    private RecyclerView rvBuahList;
    private Button back;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buah_latihan);

        rvBuahList = (RecyclerView) findViewById(R.id.rvBuahList);
        back = (Button) findViewById(R.id.back);

        buahs = new ArrayList<>();
        buahs.add(new ModelBuah("alpukat", R.drawable.xxalpukat, R.raw.xxalpukat));
        buahs.add(new ModelBuah("apel", R.drawable.xxapel, R.raw.xxapel));
        buahs.add(new ModelBuah("anggur", R.drawable.xxanggur, R.raw.xxanggur));
        buahs.add(new ModelBuah("belimbing", R.drawable.xxbelimbing, R.raw.xxbelimbing));
        buahs.add(new ModelBuah("durian", R.drawable.xxdurian, R.raw.xxdurian));
        buahs.add(new ModelBuah("jambu", R.drawable.xxjambu, R.raw.xxjambu));
        buahs.add(new ModelBuah("jeruk", R.drawable.xxjeruk, R.raw.xxjeruk));
        buahs.add(new ModelBuah("kelengkeng", R.drawable.xxkelengkeng, R.raw.xxkelengkeng));
        buahs.add(new ModelBuah("kiwi", R.drawable.xxkiwi, R.raw.xxkiwi));
        buahs.add(new ModelBuah("mangga", R.drawable.xxmangga, R.raw.xxmangga));
        buahs.add(new ModelBuah("melon", R.drawable.xxmelon, R.raw.xxmelon));
        buahs.add(new ModelBuah("nanas", R.drawable.xxnanas, R.raw.xxnanas));
        buahs.add(new ModelBuah("pepaya", R.drawable.xxpepaya, R.raw.xxpepaya));
        buahs.add(new ModelBuah("pir", R.drawable.xxpir, R.raw.xxpir));
        buahs.add(new ModelBuah("semangka", R.drawable.xxsemangka, R.raw.xxsemangka));

        initiateRecyclerView();
        player = new MediaPlayer();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                adapterBuahList.stopSound();
            }
        });
    }

    private void initiateRecyclerView() {
        adapterBuahList = new AdapterBuahList(context, buahs);
        rvBuahList.setLayoutManager(new GridLayoutManager(context, 3));
        rvBuahList.setAdapter(adapterBuahList);
    }
}