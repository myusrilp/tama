package com.example.gameedukasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity11 extends AppCompatActivity {
    private ImageButton button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12,button13,button14,button15,button16,button17,button18,button19,button20;
    private ImageButton next;
    private Context context = MainActivity11.this;
    private MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        mp = MediaPlayer.create(context, R.raw.kuda);
        button1 = (ImageButton) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.kuda);
                    } mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button2 = (ImageButton) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.kudanil);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button3 = (ImageButton) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.kurakura);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button4 = (ImageButton) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.landak);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button5 = (ImageButton) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.lohan);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button6 = (ImageButton) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.monyet);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button7 = (ImageButton) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.panda);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button8 = (ImageButton) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.paus);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button9 = (ImageButton) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.piranha);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button10 = (ImageButton) findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.rakun);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button11 = (ImageButton) findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.rusa);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button12 = (ImageButton) findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.serigala);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button13 = (ImageButton) findViewById(R.id.button13);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.singa);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button14 = (ImageButton) findViewById(R.id.button14);
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.tapir);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button15 = (ImageButton) findViewById(R.id.button15);
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.flamingo);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button16 = (ImageButton) findViewById(R.id.button16);
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.tikus);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button17 = (ImageButton) findViewById(R.id.button17);
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.ular);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button18 = (ImageButton) findViewById(R.id.button18);
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.ulat);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button19 = (ImageButton) findViewById(R.id.button19);
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.unta);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button20 = (ImageButton) findViewById(R.id.button20);
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.zebra);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
    }
}