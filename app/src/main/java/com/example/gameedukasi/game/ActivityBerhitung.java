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
import com.example.gameedukasi.adapter.AdapterBerhitungList;
import com.example.gameedukasi.model.ModelAbjad;
import com.example.gameedukasi.model.ModelBenda;
import com.example.gameedukasi.model.ModelBerhitung;

import java.util.ArrayList;
import java.util.List;

public class ActivityBerhitung extends AppCompatActivity {
    private Context context = ActivityBerhitung.this;
    List<ModelBerhitung> berhitungs;
    AdapterBerhitungList adapterBerhitungList;

    private RecyclerView rvBerhitungList;
    private Button back;
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berhitung);

        rvBerhitungList = (RecyclerView) findViewById(R.id.rvBerhitungList);
        back = (Button) findViewById(R.id.back);
        berhitungs = new ArrayList<>();
        berhitungs.add(new ModelBerhitung("1", R.drawable.a1, R.raw.satu));
        berhitungs.add(new ModelBerhitung("2", R.drawable.a2, R.raw.dua));
        berhitungs.add(new ModelBerhitung("3", R.drawable.a3, R.raw.tiga));
        berhitungs.add(new ModelBerhitung("4", R.drawable.a4, R.raw.empat));
        berhitungs.add(new ModelBerhitung("5", R.drawable.a5, R.raw.lima));
        berhitungs.add(new ModelBerhitung("6", R.drawable.a6, R.raw.enam));
        berhitungs.add(new ModelBerhitung("7", R.drawable.a7, R.raw.tujuh));
        berhitungs.add(new ModelBerhitung("8", R.drawable.a8, R.raw.delapan));
        berhitungs.add(new ModelBerhitung("9", R.drawable.a9, R.raw.sembilan));
        berhitungs.add(new ModelBerhitung("10", R.drawable.a10, R.raw.sepuluh));


        initiateRecyclerView();
        player = new MediaPlayer();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                adapterBerhitungList.stopSound();
            }
        });
    }

    private void initiateRecyclerView() {
        adapterBerhitungList = new AdapterBerhitungList(context, berhitungs);
        rvBerhitungList.setLayoutManager(new GridLayoutManager(context, 3));
        rvBerhitungList.setAdapter(adapterBerhitungList);
    }
}