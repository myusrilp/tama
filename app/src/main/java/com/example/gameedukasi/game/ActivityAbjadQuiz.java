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

    private Button btnVoice;
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
        abjads.add(new ModelAbjad("alex", R.drawable.zalex, R.raw.a));
        abjads.add(new ModelAbjad("aminah", R.drawable.zaminah, R.raw.b));
        abjads.add(new ModelAbjad("angga", R.drawable.zangga, R.raw.c));
        abjads.add(new ModelAbjad("andi", R.drawable.zandi, R.raw.d));
        abjads.add(new ModelAbjad("bela", R.drawable.zbela, R.raw.e));
        abjads.add(new ModelAbjad("bintang", R.drawable.zbintang, R.raw.f));
        abjads.add(new ModelAbjad("budi", R.drawable.zbudi, R.raw.g));
        abjads.add(new ModelAbjad("caca", R.drawable.zcaca, R.raw.h));
        abjads.add(new ModelAbjad("cahaya", R.drawable.zcahaya, R.raw.i));
        abjads.add(new ModelAbjad("danang", R.drawable.zdanang, R.raw.j));
        abjads.add(new ModelAbjad("dani", R.drawable.zdani, R.raw.k));
        abjads.add(new ModelAbjad("dedi", R.drawable.zdedi, R.raw.l));
        abjads.add(new ModelAbjad("eko", R.drawable.zeko, R.raw.m));
        abjads.add(new ModelAbjad("ferdi", R.drawable.zferdi, R.raw.n));
        abjads.add(new ModelAbjad("galang", R.drawable.zgalang, R.raw.o));
        abjads.add(new ModelAbjad("gilang", R.drawable.zgilang, R.raw.p));
        abjads.add(new ModelAbjad("haris", R.drawable.zharis, R.raw.q));
        abjads.add(new ModelAbjad("harum", R.drawable.zharum, R.raw.r));
        abjads.add(new ModelAbjad("mawar", R.drawable.zmawar, R.raw.s));
        abjads.add(new ModelAbjad("rizky", R.drawable.zrizky, R.raw.t));
        abjads.add(new ModelAbjad("wahyu", R.drawable.zwahyu, R.raw.u));
        abjads.add(new ModelAbjad("wanda", R.drawable.zwanda, R.raw.v));
        abjads.add(new ModelAbjad("yakup", R.drawable.zyakup, R.raw.w));
        abjads.add(new ModelAbjad("yunus", R.drawable.zyunus, R.raw.x));
        abjads.add(new ModelAbjad("zahra", R.drawable.zzahra, R.raw.y));
        //        generateRandomImage();

        scoreInt.setText(String.valueOf(nilai));
        number = (int) (Math.random() * (abjads.size()));
        imgvRand.setImageResource(abjads.get(number).getIcon());

// mic voice
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
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), " not found", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

    }

    //mic voice
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RESULT_SPEECH:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txtJawaban.setText(text.get(0));
                }
                break;
        }
    }

    private void generateRandomImage() {
        String jawaban = String.valueOf(txtJawaban.getText());
        System.out.println("jawaban : " + jawaban);
        System.out.println("jawaban2 : " + abjads.get(number).getNama());
        if (jawaban.equalsIgnoreCase(abjads.get(number).getNama())) {
            nilai = nilai + 10;
            System.out.println(nilai);
            scoreInt.setText(String.valueOf(nilai));
            number = (int) (Math.random() * (abjads.size()));
            imgvRand.setImageResource(abjads.get(number).getIcon());
            Toast.makeText(ActivityAbjadQuiz.this, "Jawaban benar!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(ActivityAbjadQuiz.this, "Jawaban salah!", Toast.LENGTH_SHORT).show();
            System.out.println("masuk else");
        }
    }
}