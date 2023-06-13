package com.example.gameedukasi.option;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.gameedukasi.R;
import com.example.gameedukasi.game.ActivityBerhitung;
import com.example.gameedukasi.game.ActivityBerhitungQuiz;
import com.example.gameedukasi.game.ActivityKenalHuruf;
import com.example.gameedukasi.game.ActivityKenalHurufQuiz;
import com.example.gameedukasi.game.ActivityTebakGambar;
import com.example.gameedukasi.game.ActivityTebakGambarQuiz;

public class ActivityGameOption extends AppCompatActivity {

    private Context context = ActivityGameOption.this;
    private MediaPlayer player;

    private ImageButton imgTebakGambar;
    private ImageButton imgBerhitung;
    private ImageButton imgKenalHuruf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_option);

        imgBerhitung = (ImageButton) findViewById(R.id.imgBerhitung);
        imgTebakGambar = (ImageButton) findViewById(R.id.imgTebakGambar);
        imgKenalHuruf = (ImageButton) findViewById(R.id.imgKenalHuruf);

        imgBerhitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSound("berhitung.mp3");
                option("berhitung");
            }
        });

        imgTebakGambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSound("tebakgambar.mp3");
                option("tebakgambar");
            }
        });

        imgKenalHuruf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSound("bbb.mp3");
                option("huruf");
            }
        });
    }

    public void option(String kategori){
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_pilih);
        dialog.setCancelable(true);

        ImageView quiz = (ImageView) dialog.findViewById(R.id.quiz);
        ImageView latihan = (ImageView) dialog.findViewById(R.id.latihan);

        latihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                player = MediaPlayer.create(context, R.raw.latihan);
                player.start();
                if (kategori.equalsIgnoreCase("tebakgambar")){
                    Intent i = new Intent(context, ActivityTebakGambar.class);
                    startActivity(i);
                }else if (kategori.equalsIgnoreCase("berhitung")){
                    Intent i = new Intent(context, ActivityBerhitung.class);
                    startActivity(i);
                }else if (kategori.equalsIgnoreCase("huruf")){
                    Intent i = new Intent(context, ActivityKenalHuruf.class);
                    startActivity(i);
                }

            }
        });
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                player = MediaPlayer.create(context, R.raw.quiz);
                player.start();
                if (kategori.equalsIgnoreCase("tebakgambar")) {
                    Intent i = new Intent(context, ActivityTebakGambarQuiz.class);
                    startActivity(i);
                } else if (kategori.equalsIgnoreCase("huruf")) {
                    Intent i = new Intent(context, ActivityKenalHurufQuiz.class);
                    startActivity(i);
                }else if (kategori.equalsIgnoreCase("berhitung")){
                    Intent i = new Intent(context, ActivityBerhitungQuiz.class);
                    startActivity(i);
                }
            }
        });
        dialog.show();

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