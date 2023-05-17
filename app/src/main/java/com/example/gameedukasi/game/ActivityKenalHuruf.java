package com.example.gameedukasi.game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.gameedukasi.R;

public class ActivityKenalHuruf extends AppCompatActivity {
    private Context context = ActivityKenalHuruf.this;
    private ImageButton imgHijaiyah;
    private ImageButton imgAbc;
    MediaPlayer player;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kenal_huruf);

        imgHijaiyah = (ImageButton) findViewById(R.id.imgHijaiyah);
        imgAbc = (ImageButton) findViewById(R.id.imgAbc);

        imgHijaiyah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player = MediaPlayer.create(context, R.raw.hijaiyah);
                player.start();
                Intent i = new Intent(context,ActivityHijaiyahLatihan.class);
                startActivity(i);
            }
        });
        imgAbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player = MediaPlayer.create(context, R.raw.abjad);
                player.start();
                Intent i = new Intent(context,ActivityAbjadLatihan.class);
                startActivity(i);
            }
        });
    }
}