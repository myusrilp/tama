package com.example.gameedukasi.game;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.view.Window;
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
    int soal = 1;
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
        hijaiyahs.add(new ModelHijaiyah("alif", R.drawable.valif, R.raw.alif));
        hijaiyahs.add(new ModelHijaiyah("ba", R.drawable.vba, R.raw.ba));
        hijaiyahs.add(new ModelHijaiyah("ta", R.drawable.vta, R.raw.ta));
        hijaiyahs.add(new ModelHijaiyah("tsa", R.drawable.vtsa, R.raw.tsa));
        hijaiyahs.add(new ModelHijaiyah("jim", R.drawable.vjim, R.raw.jim));
        hijaiyahs.add(new ModelHijaiyah("ha", R.drawable.vha, R.raw.ha));
        hijaiyahs.add(new ModelHijaiyah("kha", R.drawable.vkha, R.raw.kha));
        hijaiyahs.add(new ModelHijaiyah("dal", R.drawable.vdal, R.raw.dal));
        hijaiyahs.add(new ModelHijaiyah("dzal", R.drawable.vdzal, R.raw.dzal));
        hijaiyahs.add(new ModelHijaiyah("ra", R.drawable.vra, R.raw.ra));
        hijaiyahs.add(new ModelHijaiyah("za", R.drawable.vza, R.raw.za));
        hijaiyahs.add(new ModelHijaiyah("sin", R.drawable.vsin, R.raw.sin));
        hijaiyahs.add(new ModelHijaiyah("syin", R.drawable.vsyin, R.raw.syin));
        hijaiyahs.add(new ModelHijaiyah("shad", R.drawable.vshad, R.raw.shad));
        hijaiyahs.add(new ModelHijaiyah("dha", R.drawable.vdha, R.raw.dha));
        hijaiyahs.add(new ModelHijaiyah("tha", R.drawable.vtha, R.raw.tha));
        hijaiyahs.add(new ModelHijaiyah("zha", R.drawable.vzha, R.raw.zha));
        hijaiyahs.add(new ModelHijaiyah("ain", R.drawable.vain, R.raw.ain));
        hijaiyahs.add(new ModelHijaiyah("ghain", R.drawable.vghain, R.raw.ghain));
        hijaiyahs.add(new ModelHijaiyah("fa", R.drawable.vfa, R.raw.fa));
        hijaiyahs.add(new ModelHijaiyah("qaf", R.drawable.vqaf, R.raw.qaf));
        hijaiyahs.add(new ModelHijaiyah("kaf", R.drawable.vkaf, R.raw.kaf));
        hijaiyahs.add(new ModelHijaiyah("lam", R.drawable.vlam, R.raw.lam));
        hijaiyahs.add(new ModelHijaiyah("mim", R.drawable.vmim, R.raw.mim));
        hijaiyahs.add(new ModelHijaiyah("nun", R.drawable.vnun, R.raw.nun));
        hijaiyahs.add(new ModelHijaiyah("wau", R.drawable.vwau, R.raw.wau));
        hijaiyahs.add(new ModelHijaiyah("haa", R.drawable.vhaa, R.raw.haa));
        hijaiyahs.add(new ModelHijaiyah("lamalif", R.drawable.vlamalif, R.raw.lamalif));
        hijaiyahs.add(new ModelHijaiyah("hamzah", R.drawable.vhamzah, R.raw.hamzah));
        hijaiyahs.add(new ModelHijaiyah("ya", R.drawable.vya, R.raw.ya));
        //        generateRandomImage();

        scoreInt.setText(String.valueOf(nilai));
        number = (int) (Math.random()*(hijaiyahs.size()));
        imgvRand.setImageResource(hijaiyahs.get(number).getIcon());

        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (soal == 11){
                    showResult(String.valueOf(nilai));
                }else {
                    generateRandomImage();
                }
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

        if (jawaban.equalsIgnoreCase(hijaiyahs.get(number).getNama())) {
            nilai = nilai + 10;
            Toast.makeText(ActivityHijaiyahQuiz.this, "Jawaban benar!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(ActivityHijaiyahQuiz.this, "Jawaban salah!", Toast.LENGTH_SHORT).show();
        }

        soal = soal + 1;

        if (soal == 11) {
            showResult(String.valueOf(nilai));
        } else {
            scoreInt.setText(String.valueOf(nilai));
            number = (int) (Math.random() * hijaiyahs.size());
            imgvRand.setImageResource(hijaiyahs.get(number).getIcon());
            txtJawaban.setText("");
        }
        System.out.println("masuk else");
    }
    private void showResult(String hasil) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.popup_hasil);
        dialog.setCancelable(false);

        TextView skorhasil = (TextView) dialog.findViewById(R.id.skorhasil);
        Button ok = (Button) dialog.findViewById(R.id.ok);

        skorhasil.setText(hasil);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                finish();
            }
        });

        dialog.show();
    }
}