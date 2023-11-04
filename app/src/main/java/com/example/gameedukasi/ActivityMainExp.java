package com.example.gameedukasi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.gameedukasi.game.ActivitySkor;
import com.example.gameedukasi.option.ActivityGameOption;

import java.io.IOException;

public class ActivityMainExp extends AppCompatActivity {

    private Context context = ActivityMainExp.this;
    private MediaPlayer player;
    private ImageButton btnStart;
    private ImageButton btnSkor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_exp);

        btnStart = (ImageButton) findViewById(R.id.btnStart);
        btnSkor = (ImageButton) findViewById(R.id.btnSkor);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSound("mulai.mp3");
                Intent intent = new Intent(context, ActivityGameOption.class);
                startActivity(intent);
            }
        });

        btnSkor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ActivitySkor.class);
                startActivity(intent);
            }
        });
    }

    public void startSound(String filename) {
        player = new MediaPlayer();
        try {
            if (player.isPlaying()) {
                player.stop();
                player.release();

            }

            AssetFileDescriptor descriptor = getAssets().openFd(filename);
            player.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            descriptor.close();

            player.prepare();
            player.setVolume(1f, 1f);
            player.setLooping(false);
            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}