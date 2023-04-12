package com.example.gameedukasi.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.os.ConditionVariable;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hewan_latihan);

        rvHewanList = (RecyclerView) findViewById(R.id.rvHewanList);

        hewanList = new ArrayList<>();
        hewanList.add(new ModelHewan("angsa", R.drawable.angsa));
        hewanList.add(new ModelHewan("ayam", R.drawable.ayam));
        hewanList.add(new ModelHewan("anjing", R.drawable.anjing));
        hewanList.add(new ModelHewan("badak", R.drawable.badak));
        hewanList.add(new ModelHewan("babi", R.drawable.babi));
        hewanList.add(new ModelHewan("buaya", R.drawable.buaya));
        hewanList.add(new ModelHewan("banteng", R.drawable.banteng));
        hewanList.add(new ModelHewan("bangau", R.drawable.bangau));
        hewanList.add(new ModelHewan("bebek", R.drawable.bebek));
        hewanList.add(new ModelHewan("beruang", R.drawable.beruang));
        hewanList.add(new ModelHewan("belalang", R.drawable.belalang));
        hewanList.add(new ModelHewan("burunghantu", R.drawable.burunghantu));
        hewanList.add(new ModelHewan("burungcendrawasih", R.drawable.burungcendrawasih));
        hewanList.add(new ModelHewan("bunglon", R.drawable.bunglon));
        hewanList.add(new ModelHewan("burungdara", R.drawable.burungdara));
        hewanList.add(new ModelHewan("burungelang", R.drawable.burungelang));
        hewanList.add(new ModelHewan("cicak", R.drawable.cicak));
        hewanList.add(new ModelHewan("cheetah", R.drawable.cheetah));
        hewanList.add(new ModelHewan("gajah", R.drawable.gajah));
        hewanList.add(new ModelHewan("harimau", R.drawable.harimau));
        hewanList.add(new ModelHewan("dinosaurus", R.drawable.dinosaurus));
        hewanList.add(new ModelHewan("hiu", R.drawable.hiu));
        hewanList.add(new ModelHewan("jerapah", R.drawable.jerapah));
        hewanList.add(new ModelHewan("kambing", R.drawable.kambing));
        hewanList.add(new ModelHewan("kangguru", R.drawable.kangguru));
        hewanList.add(new ModelHewan("kelinci", R.drawable.kelinci));
        hewanList.add(new ModelHewan("kerbau", R.drawable.kerbau));
        hewanList.add(new ModelHewan("kucing", R.drawable.kucing));

        initiateRecyclerView();
    }

    private void initiateRecyclerView(){
        adapterHewanList = new AdapterHewanList(context, hewanList);
        rvHewanList.setLayoutManager(new GridLayoutManager(context, 3));
        rvHewanList.setAdapter(adapterHewanList);
    }
}