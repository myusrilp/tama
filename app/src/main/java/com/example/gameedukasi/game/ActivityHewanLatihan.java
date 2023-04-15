package com.example.gameedukasi.game;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.example.gameedukasi.R;
import com.example.gameedukasi.adapter.AdapterHewanList;
import com.example.gameedukasi.model.ModelHewan;

import java.util.ArrayList;
import java.util.List;

public class ActivityHewanLatihan extends AppCompatActivity {

    private Context context = ActivityHewanLatihan.this;
    List<ModelHewan> hewanList;
    private AdapterHewanList adapterHewanList;

    private RecyclerView rvHewanList;
    private Button back;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hewan_latihan);

        rvHewanList = (RecyclerView) findViewById(R.id.rvHewanList);
        back = (Button) findViewById(R.id.back);

        hewanList = new ArrayList<>();
        hewanList.add(new ModelHewan("angsa", R.drawable.angsa, R.raw.angsa));
        hewanList.add(new ModelHewan("ayam", R.drawable.ayam, R.raw.ayam));
        hewanList.add(new ModelHewan("anjing", R.drawable.anjing, R.raw.anjing));
        hewanList.add(new ModelHewan("badak", R.drawable.badak, R.raw.badak));
        hewanList.add(new ModelHewan("babi", R.drawable.babi, R.raw.babi));
        hewanList.add(new ModelHewan("buaya", R.drawable.buaya, R.raw.buaya));
        hewanList.add(new ModelHewan("banteng", R.drawable.banteng, R.raw.banteng));
        hewanList.add(new ModelHewan("bangau", R.drawable.bangau, R.raw.bangau));
        hewanList.add(new ModelHewan("bebek", R.drawable.bebek, R.raw.bebek));
        hewanList.add(new ModelHewan("beruang", R.drawable.beruang, R.raw.beruang));
        hewanList.add(new ModelHewan("belalang", R.drawable.belalang, R.raw.belalang));
        hewanList.add(new ModelHewan("burunghantu", R.drawable.burunghantu, R.raw.burunghantu));
        hewanList.add(new ModelHewan("burungcendrawasih", R.drawable.burungcendrawasih, R.raw.burungcendrawasih));
        hewanList.add(new ModelHewan("bunglon", R.drawable.bunglon, R.raw.bunglon));
        hewanList.add(new ModelHewan("burungdara", R.drawable.burungdara, R.raw.burungdara));
        hewanList.add(new ModelHewan("burungelang", R.drawable.burungelang, R.raw.burungelang));
        hewanList.add(new ModelHewan("cicak", R.drawable.cicak, R.raw.cicak));
        hewanList.add(new ModelHewan("cheetah", R.drawable.cheetah, R.raw.cheetah));
        hewanList.add(new ModelHewan("gajah", R.drawable.gajah, R.raw.gajah));
        hewanList.add(new ModelHewan("harimau", R.drawable.harimau, R.raw.harimau));
        hewanList.add(new ModelHewan("dinosaurus", R.drawable.dinosaurus, R.raw.dinosaurus));
        hewanList.add(new ModelHewan("hiu", R.drawable.hiu, R.raw.hiu));
        hewanList.add(new ModelHewan("jerapah", R.drawable.jerapah, R.raw.jerapah));
        hewanList.add(new ModelHewan("kambing", R.drawable.kambing, R.raw.kambing));
        hewanList.add(new ModelHewan("kangguru", R.drawable.kangguru, R.raw.kangguru));
        hewanList.add(new ModelHewan("kelinci", R.drawable.kelinci, R.raw.kelinci));
        hewanList.add(new ModelHewan("kerbau", R.drawable.kerbau, R.raw.kerbau));
        hewanList.add(new ModelHewan("kucing", R.drawable.kucing, R.raw.kucing));

        initiateRecyclerView();
        player = new MediaPlayer();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                adapterHewanList.stopSound();
            }
        });
    }

    private void initiateRecyclerView(){
        adapterHewanList = new AdapterHewanList(context, hewanList);
        rvHewanList.setLayoutManager(new GridLayoutManager(context, 3));
        rvHewanList.setAdapter(adapterHewanList);
    }

//    @Override
//    public void onBackPressed() {
//        finish();
//        super.onBackPressed();
//
//    }
}