package com.example.gameedukasi.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gameedukasi.R;
import com.example.gameedukasi.adapter.AdapterAlatMusikList;
import com.example.gameedukasi.adapter.AdapterBendaList;
import com.example.gameedukasi.model.ModelAlatMusik;
import com.example.gameedukasi.model.ModelBenda;

import java.util.ArrayList;
import java.util.List;

public class ActivityAlatMusikLatihan extends AppCompatActivity {
    private Context context = ActivityAlatMusikLatihan.this;
    List<ModelAlatMusik> alatmusiks;
    AdapterAlatMusikList adapterAlatMusikList;

    private RecyclerView rvAlatMusikList;
    private Button back;
    MediaPlayer player;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alat_musik_latihan);

        rvAlatMusikList = (RecyclerView) findViewById(R.id.rvAlatMusikList);
        back = (Button) findViewById(R.id.back);

        alatmusiks = new ArrayList<>();
        alatmusiks.add(new ModelAlatMusik("angklung", R.drawable.angklung, R.raw.angklung));
        alatmusiks.add(new ModelAlatMusik("aramba", R.drawable.aramba, R.raw.aramba));
        alatmusiks.add(new ModelAlatMusik("bende", R.drawable.bende, R.raw.bende));
        alatmusiks.add(new ModelAlatMusik("burdah", R.drawable.burdah, R.raw.burdah));
        alatmusiks.add(new ModelAlatMusik("cangor", R.drawable.cangor, R.raw.cangor));
        alatmusiks.add(new ModelAlatMusik("demung", R.drawable.demung, R.raw.demung));
        alatmusiks.add(new ModelAlatMusik("dolidoli", R.drawable.dolidoli, R.raw.dolidoli));
        alatmusiks.add(new ModelAlatMusik("ganda", R.drawable.ganda, R.raw.ganda));
        alatmusiks.add(new ModelAlatMusik("gendang", R.drawable.gendang, R.raw.gendang));
        alatmusiks.add(new ModelAlatMusik("gesogeso", R.drawable.gesogeso, R.raw.gesogeso));
        alatmusiks.add(new ModelAlatMusik("gong", R.drawable.gong, R.raw.gong));
        alatmusiks.add(new ModelAlatMusik("gurinding", R.drawable.guriding, R.raw.gurinding));
        alatmusiks.add(new ModelAlatMusik("kecapi", R.drawable.kecapi, R.raw.kecapi));
        alatmusiks.add(new ModelAlatMusik("kecrek", R.drawable.kecrek, R.raw.kecrek));
        alatmusiks.add(new ModelAlatMusik("kolintang", R.drawable.kolintang, R.raw.kolintang));
        alatmusiks.add(new ModelAlatMusik("lalove", R.drawable.lalove, R.raw.lalove));
        alatmusiks.add(new ModelAlatMusik("pupuik", R.drawable.pupuik, R.raw.pupuik));
        alatmusiks.add(new ModelAlatMusik("rebab", R.drawable.rebab, R.raw.rebab));
        alatmusiks.add(new ModelAlatMusik("sape", R.drawable.sape, R.raw.sape));
        alatmusiks.add(new ModelAlatMusik("sasando", R.drawable.sasando, R.raw.sasando));
        alatmusiks.add(new ModelAlatMusik("siter", R.drawable.siter, R.raw.siter));
        alatmusiks.add(new ModelAlatMusik("suling", R.drawable.suling, R.raw.suling));
        alatmusiks.add(new ModelAlatMusik("talindo", R.drawable.talindo, R.raw.talindo));

        initiateRecyclerView();
        player = new MediaPlayer();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                adapterAlatMusikList.stopSound();
            }
        });
    }

        private void initiateRecyclerView(){
            adapterAlatMusikList = new AdapterAlatMusikList(context, alatmusiks);
            rvAlatMusikList.setLayoutManager(new GridLayoutManager(context, 3));
            rvAlatMusikList.setAdapter(adapterAlatMusikList);

    }
}