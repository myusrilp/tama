package com.example.gameedukasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity6 extends AppCompatActivity {
    private ImageButton button1;
    private ImageButton button2;
    private ImageButton button3;
    private ImageButton button4;
    private Context context = MainActivity6.this;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        button1 = (ImageButton) findViewById(R.id.button1);
        button2 = (ImageButton) findViewById(R.id.button2);
        button3 = (ImageButton) findViewById(R.id.button3);
        button4 = (ImageButton) findViewById(R.id.button4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp = MediaPlayer.create(context,R.raw.hewan);
                mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        try {
                            if (mp.isPlaying()) {
                                mp.stop();
                                mp.release();
                            }
                            mp.start();
                        } catch (Exception e) {e.printStackTrace();}
                    }
                });
                Intent intent = new Intent(context,MainActivity10.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp = MediaPlayer.create(context,R.raw.benda);
                mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        try {
                            if (mp.isPlaying()) {
                                mp.stop();
                                mp.release();
                            }
                            mp.start();
                        } catch (Exception e) {e.printStackTrace();}
                    }
                });
                Intent intent = new Intent(context,MainActivity18.class);
                startActivity(intent);
            }
        });
    }
}