package com.example.gameedukasi.game;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gameedukasi.R;
import com.example.gameedukasi.model.ModelAbjad;
import com.example.gameedukasi.model.ModelBuah;
import com.example.gameedukasi.model.ModelHijaiyah;

import java.util.ArrayList;
import java.util.List;

public class ActivityAbjadQuiz extends AppCompatActivity {

    private Context context = ActivityAbjadQuiz.this;

    List<ModelAbjad> abjads;
    int nilai = 0;
    int number;

    private Button btnAnswer;
    private ImageView imgvRand;
    private TextView scoreInt;
    private EditText txtJawaban;

    private  Button btnVoice;
    private String ID_BahasaIndonesia = "id";
    protected static final int RESULT_SPEECH = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_abjad_quiz);
        btnAnswer = (Button) findViewById(R.id.btnAnswer);
        imgvRand = (ImageView) findViewById(R.id.imgvRand);
        scoreInt = (TextView) findViewById(R.id.scoreInt);
        txtJawaban = (EditText) findViewById(R.id.txtJawaban);
        btnVoice = (Button) findViewById(R.id.btnVoice);

        abjads = new ArrayList<>();
        abjads.add(new ModelAbjad("a", R.drawable.a, R.raw.a));
        abjads.add(new ModelAbjad("b", R.drawable.b, R.raw.b));
        abjads.add(new ModelAbjad("c", R.drawable.c, R.raw.c));
        abjads.add(new ModelAbjad("d", R.drawable.d, R.raw.d));
        abjads.add(new ModelAbjad("e", R.drawable.e, R.raw.e));
        abjads.add(new ModelAbjad("f", R.drawable.f, R.raw.f));
        abjads.add(new ModelAbjad("g", R.drawable.g, R.raw.g));
        abjads.add(new ModelAbjad("h", R.drawable.h, R.raw.h));
        abjads.add(new ModelAbjad("i", R.drawable.i, R.raw.i));
        abjads.add(new ModelAbjad("j", R.drawable.j, R.raw.j));
        abjads.add(new ModelAbjad("k", R.drawable.k, R.raw.k));
        abjads.add(new ModelAbjad("l", R.drawable.l, R.raw.l));
        abjads.add(new ModelAbjad("m", R.drawable.m, R.raw.m));
        abjads.add(new ModelAbjad("n", R.drawable.n, R.raw.n));
        abjads.add(new ModelAbjad("o", R.drawable.o, R.raw.o));
        abjads.add(new ModelAbjad("p", R.drawable.p, R.raw.p));
        abjads.add(new ModelAbjad("q", R.drawable.q, R.raw.q));
        abjads.add(new ModelAbjad("r", R.drawable.r, R.raw.r));
        abjads.add(new ModelAbjad("s", R.drawable.s, R.raw.s));
        abjads.add(new ModelAbjad("t", R.drawable.t, R.raw.t));
        abjads.add(new ModelAbjad("u", R.drawable.u, R.raw.u));
        abjads.add(new ModelAbjad("v", R.drawable.v, R.raw.v));
        abjads.add(new ModelAbjad("w", R.drawable.w, R.raw.w));
        abjads.add(new ModelAbjad("x", R.drawable.x, R.raw.x));
        abjads.add(new ModelAbjad("y", R.drawable.y, R.raw.y));
        abjads.add(new ModelAbjad("z", R.drawable.z, R.raw.z));
        //        generateRandomImage();

        scoreInt.setText(String.valueOf(nilai));
        number = (int) (Math.random()*(abjads.size()));
        imgvRand.setImageResource(abjads.get(number).getIcon());


        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateRandomImage();
            }
        });
        btnVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mic_google = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                mic_google.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                mic_google.putExtra(RecognizerIntent.EXTRA_LANGUAGE, ID_BahasaIndonesia);

                try {
                    startActivityForResult(mic_google, RESULT_SPEECH);
                    txtJawaban.setText("");
                }catch (ActivityNotFoundException e){
                    Toast.makeText(getApplicationContext()," not found", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case RESULT_SPEECH:
                if (resultCode == RESULT_OK && data !=null){
                    ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txtJawaban.setText(text.get(0));
            }
                break;
        }
    }

    private void generateRandomImage(){
        String jawaban = String.valueOf(txtJawaban.getText());
        System.out.println("jawaban : " + jawaban);
        System.out.println("jawaban2 : " + abjads.get(number).getNama());
        if (jawaban.equalsIgnoreCase(abjads.get(number).getNama())){
            nilai = nilai + 10;
            System.out.println(nilai);
            scoreInt.setText(String.valueOf(nilai));
            number = (int) (Math.random()*(abjads.size()));
            imgvRand.setImageResource(abjads.get(number).getIcon());
        }else{
            System.out.println("masuk else");
        }
    }

}