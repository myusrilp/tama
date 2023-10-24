package com.example.gameedukasi.game;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gameedukasi.R;

public class ActivityTebakGambarQuiz extends AppCompatActivity {

    private Context context = ActivityTebakGambarQuiz.this;
    MediaPlayer player;

    private ImageButton imgHewan;
    private ImageButton imgInstrumen;
    private ImageButton imgBenda;
    private ImageButton imgBuah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tebak_gambar);

        player = new MediaPlayer();

        imgInstrumen = (ImageButton) findViewById(R.id.imgInstrumen);
        imgHewan = (ImageButton) findViewById(R.id.imgHewan);
        imgBuah = (ImageButton) findViewById(R.id.imgBuah);

        imgHewan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player = MediaPlayer.create(context, R.raw.hewan);
                player.start();
                Intent i = new Intent(context, ActivityHewanQuiz.class);
                startActivity(i);
            }
        });

        imgBuah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player = MediaPlayer.create(context, R.raw.buahbuahan);
                player.start();
                Intent i = new Intent(context, ActivityBuahQuiz.class);
                startActivity(i);
            }
        });
        imgInstrumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player = MediaPlayer.create(context, R.raw.alatmusik);
                player.start();
                Intent i = new Intent(context, ActivityAlatMusikQuiz.class);
                startActivity(i);
            }
        });
    }
}