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
import com.example.gameedukasi.model.ModelBuah;
import com.example.gameedukasi.model.ModelHijaiyah;

import java.util.ArrayList;
import java.util.List;

public class ActivityHijaiyahQuiz extends AppCompatActivity {

    private Context context = ActivityHijaiyahQuiz.this;
    List<ModelHijaiyah> hijaiyahs;
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

        setContentView(R.layout.activity_hijaiyah_quiz);
        btnAnswer = (Button) findViewById(R.id.btnAnswer);
        imgvRand = (ImageView) findViewById(R.id.imgvRand);
        scoreInt = (TextView) findViewById(R.id.scoreInt);
        txtJawaban = (EditText) findViewById(R.id.txtJawaban);
        btnVoice = (Button) findViewById(R.id.btnVoice);

        hijaiyahs = new ArrayList<>();
        hijaiyahs.add(new ModelHijaiyah("alif", R.drawable.alif, R.raw.alif));
        hijaiyahs.add(new ModelHijaiyah("ba", R.drawable.ba, R.raw.ba));
        hijaiyahs.add(new ModelHijaiyah("ta", R.drawable.ta, R.raw.ta));
        hijaiyahs.add(new ModelHijaiyah("tsa", R.drawable.tsa, R.raw.tsa));
        hijaiyahs.add(new ModelHijaiyah("jim", R.drawable.jim, R.raw.jim));
        hijaiyahs.add(new ModelHijaiyah("ha", R.drawable.ha, R.raw.ha));
        hijaiyahs.add(new ModelHijaiyah("kha", R.drawable.kha, R.raw.kha));
        hijaiyahs.add(new ModelHijaiyah("dal", R.drawable.dal, R.raw.dal));
        hijaiyahs.add(new ModelHijaiyah("dzal", R.drawable.dzal, R.raw.dzal));
        hijaiyahs.add(new ModelHijaiyah("ra", R.drawable.ra, R.raw.ra));
        hijaiyahs.add(new ModelHijaiyah("za", R.drawable.za, R.raw.za));
        hijaiyahs.add(new ModelHijaiyah("sin", R.drawable.sin, R.raw.sin));
        hijaiyahs.add(new ModelHijaiyah("syin", R.drawable.syin, R.raw.syin));
        hijaiyahs.add(new ModelHijaiyah("shad", R.drawable.shad, R.raw.shad));
        hijaiyahs.add(new ModelHijaiyah("dha", R.drawable.dha, R.raw.dha));
        hijaiyahs.add(new ModelHijaiyah("tha", R.drawable.tha, R.raw.tha));
        hijaiyahs.add(new ModelHijaiyah("zha", R.drawable.zha, R.raw.zha));
        hijaiyahs.add(new ModelHijaiyah("ain", R.drawable.ain, R.raw.ain));
        hijaiyahs.add(new ModelHijaiyah("ghain", R.drawable.ghain, R.raw.ghain));
        hijaiyahs.add(new ModelHijaiyah("fa", R.drawable.fa, R.raw.fa));
        hijaiyahs.add(new ModelHijaiyah("qaf", R.drawable.qaf, R.raw.qaf));
        hijaiyahs.add(new ModelHijaiyah("kaf", R.drawable.kaf, R.raw.kaf));
        hijaiyahs.add(new ModelHijaiyah("lam", R.drawable.lam, R.raw.lam));
        hijaiyahs.add(new ModelHijaiyah("mim", R.drawable.mim, R.raw.mim));
        hijaiyahs.add(new ModelHijaiyah("nun", R.drawable.nun, R.raw.nun));
        hijaiyahs.add(new ModelHijaiyah("wau", R.drawable.wau, R.raw.wau));
        hijaiyahs.add(new ModelHijaiyah("haa", R.drawable.haa, R.raw.haa));
        hijaiyahs.add(new ModelHijaiyah("lamalif", R.drawable.lamalif, R.raw.lamalif));
        hijaiyahs.add(new ModelHijaiyah("hamzah", R.drawable.hamzah, R.raw.hamzah));
        hijaiyahs.add(new ModelHijaiyah("ya", R.drawable.ya, R.raw.ya));
        //        generateRandomImage();

        scoreInt.setText(String.valueOf(nilai));
        number = (int) (Math.random()*(hijaiyahs.size()));
        imgvRand.setImageResource(hijaiyahs.get(number).getIcon());

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
        System.out.println("jawaban2 : " + hijaiyahs.get(number).getNama());
        if (jawaban.equalsIgnoreCase(hijaiyahs.get(number).getNama())){
            nilai = nilai + 10;
            System.out.println(nilai);
            scoreInt.setText(String.valueOf(nilai));
            number = (int) (Math.random()*(hijaiyahs.size()));
            imgvRand.setImageResource(hijaiyahs.get(number).getIcon());
        }else{
            System.out.println("masuk else");
        }
    }

}