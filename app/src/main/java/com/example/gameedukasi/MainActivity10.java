package com.example.gameedukasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity10 extends AppCompatActivity {
    private ImageButton button1,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12,button13,button14,button15,button16,button17,button18,button19,button20;
    private ImageButton button21,button22,button23,button24,button25,button26,button27,button28;
    private ImageButton next;

    private Context context = MainActivity10.this;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        next = (ImageButton) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mp != null) {
                    mp.pause();
                    mp.seekTo(0);
                }
                Intent intent = new Intent(context,MainActivity11.class);
                startActivity(intent);
            }
        });
        mp = MediaPlayer.create(context, R.raw.angsa);
        button1 = (ImageButton) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.angsa);
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
                        mp = MediaPlayer.create(context,R.raw.ayam);
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
                        mp = MediaPlayer.create(context,R.raw.badak);
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
                        mp = MediaPlayer.create(context,R.raw.anjing);
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
                        mp = MediaPlayer.create(context,R.raw.babi);
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
                        mp = MediaPlayer.create(context,R.raw.bangau);
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
                        mp = MediaPlayer.create(context,R.raw.banteng);
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
                        mp = MediaPlayer.create(context,R.raw.buaya);
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
                        mp = MediaPlayer.create(context,R.raw.bebek);
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
                        mp = MediaPlayer.create(context,R.raw.beruang);
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
                        mp = MediaPlayer.create(context,R.raw.belalang);
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
                        mp = MediaPlayer.create(context,R.raw.burunghantu);
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
                        mp = MediaPlayer.create(context,R.raw.bunglon);
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
                        mp = MediaPlayer.create(context,R.raw.cheetah);
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
                        mp = MediaPlayer.create(context,R.raw.burungcendrawasih);
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
                        mp = MediaPlayer.create(context,R.raw.harimau);
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
                        mp = MediaPlayer.create(context,R.raw.burungdara);
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
                        mp = MediaPlayer.create(context,R.raw.burungelang);
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
                        mp = MediaPlayer.create(context,R.raw.cicak);
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
                        mp = MediaPlayer.create(context,R.raw.gajah);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button21 = (ImageButton) findViewById(R.id.button21);
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.dinosaurus);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button22 = (ImageButton) findViewById(R.id.button22);
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.hiu);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button23 = (ImageButton) findViewById(R.id.button23);
        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.jerapah);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button24 = (ImageButton) findViewById(R.id.button24);
        button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.kambing);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button25 = (ImageButton) findViewById(R.id.button25);
        button25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.kangguru);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button26 = (ImageButton) findViewById(R.id.button26);
        button26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.kelinci);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button27 = (ImageButton) findViewById(R.id.button27);
        button27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.kerbau);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
        button28 = (ImageButton) findViewById(R.id.button28);
        button28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (mp.isPlaying()){
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(context,R.raw.kucing);
                    }mp.start();
                }catch (Exception e) {e.printStackTrace();}
            }
        });
    }
}