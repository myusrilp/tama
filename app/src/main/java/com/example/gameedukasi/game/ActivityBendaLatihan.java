package com.example.gameedukasi.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benda_latihan);

        rvBendaList = (RecyclerView) findViewById(R.id.rvBendaList);
        back = (Button) findViewById(R.id.back);

        bendas = new ArrayList<>();
        bendas.add(new ModelBenda("jam", R.drawable.jam));
        bendas.add(new ModelBenda("papantulis", R.drawable.papantulis));
        bendas.add(new ModelBenda("buku", R.drawable.buku));
        bendas.add(new ModelBenda("tas", R.drawable.tas));

        initiateRecyclerView();
    }

    private void initiateRecyclerView(){
        adapterBendaList = new AdapterBendaList(context, bendas);
        rvBendaList.setLayoutManager(new GridLayoutManager(context, 3));
        rvBendaList.setAdapter(adapterBendaList);
    }
}