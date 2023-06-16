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
        alatmusiks.add(new ModelAlatMusik("angklung", R.drawable.zangklung, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("biola", R.drawable.zbiola, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("drum", R.drawable.zdrum, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("gamelan", R.drawable.zgamelan, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("gendang", R.drawable.zgendang, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("gitar", R.drawable.zgitar, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("harmonika", R.drawable.zharmonika, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("harpa", R.drawable.zharpa, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("kecrek", R.drawable.zkecrek, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("pianika", R.drawable.zpianika, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("piano", R.drawable.zpiano, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("simbal", R.drawable.zsimbal, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("suling", R.drawable.zsuling, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("terompet", R.drawable.zterompet, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("ukulele", R.drawable.zukulele, R.raw.a));


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