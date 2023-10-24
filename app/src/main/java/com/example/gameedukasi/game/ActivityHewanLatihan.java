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
        hewanList.add(new ModelHewan("angsa", R.drawable.bangsa, R.raw.angsa));
        hewanList.add(new ModelHewan("ayam", R.drawable.bayam, R.raw.ayam));
        hewanList.add(new ModelHewan("anjing", R.drawable.banjing, R.raw.anjing));
        hewanList.add(new ModelHewan("badak", R.drawable.bbadak, R.raw.badak));
        hewanList.add(new ModelHewan("babi", R.drawable.bbabi, R.raw.babi));
        hewanList.add(new ModelHewan("buaya", R.drawable.bbuaya, R.raw.buaya));
        hewanList.add(new ModelHewan("banteng", R.drawable.bbanteng, R.raw.banteng));
        hewanList.add(new ModelHewan("bebek", R.drawable.bbebek, R.raw.bebek));
        hewanList.add(new ModelHewan("beruang", R.drawable.bberuang, R.raw.beruang));
        hewanList.add(new ModelHewan("gajah", R.drawable.bgajah, R.raw.gajah));
        hewanList.add(new ModelHewan("harimau", R.drawable.bharimau, R.raw.harimau));
        hewanList.add(new ModelHewan("kelinci", R.drawable.bkelinci, R.raw.kelinci));
        hewanList.add(new ModelHewan("kucing", R.drawable.bkucing, R.raw.kucing));
        hewanList.add(new ModelHewan("sapi", R.drawable.bsapi, R.raw.sapi));
        hewanList.add(new ModelHewan("singa", R.drawable.bsinga, R.raw.singa));

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