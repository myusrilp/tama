package com.example.gameedukasi.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.gameedukasi.R;

public class ActivityTebakGambar extends AppCompatActivity {

    private Context context = ActivityTebakGambar.this;

    private ImageButton imgHewan;
    private ImageButton imgInstrumen;
    private ImageButton imgBenda;
    private ImageButton imgBuah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tebak_gambar);

        imgInstrumen = (ImageButton) findViewById(R.id.imgInstrumen);
        imgHewan = (ImageButton) findViewById(R.id.imgHewan);
        imgBenda = (ImageButton) findViewById(R.id.imgBenda);
        imgBuah = (ImageButton) findViewById(R.id.imgBuah);

        imgHewan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ActivityHewanLatihan.class);
                startActivity(i);
            }
        });
    }
}