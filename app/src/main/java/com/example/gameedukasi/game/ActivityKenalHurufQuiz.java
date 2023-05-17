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

public class ActivityKenalHurufQuiz extends AppCompatActivity {

    private Context context = ActivityKenalHurufQuiz.this;
    private ImageButton imgHijaiyah;
    private ImageButton imgAbc;
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kenal_huruf_quiz);

        imgHijaiyah = (ImageButton) findViewById(R.id.imgHijaiyah);
        imgAbc = (ImageButton) findViewById(R.id.imgAbc);

        imgHijaiyah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player = MediaPlayer.create(context, R.raw.hijaiyah);
                player.start();
                Intent i = new Intent(context,ActivityHijaiyahQuiz.class);
                startActivity(i);
            }
        });
        imgAbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player = MediaPlayer.create(context, R.raw.abjad);
                player.start();
                Intent i = new Intent(context,ActivityAbjadQuiz.class);
                startActivity(i);
            }
        });
    }
}