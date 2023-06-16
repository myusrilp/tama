package com.example.gameedukasi.game;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
import com.example.gameedukasi.model.ModelBenda;

import java.util.ArrayList;
import java.util.List;

public class ActivityBendaQuiz extends AppCompatActivity {

    private Context context = ActivityBendaQuiz.this;
    List<ModelBenda> bendas;
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
        setContentView(R.layout.activity_benda_quiz);

        btnAnswer = (Button) findViewById(R.id.btnAnswer);
        imgvRand = (ImageView) findViewById(R.id.imgvRand);
        scoreInt = (TextView) findViewById(R.id.scoreInt);
        txtJawaban = (EditText) findViewById(R.id.txtJawaban);
        btnVoice = (Button) findViewById(R.id.btnVoice);

        bendas = new ArrayList<>();
        bendas.add(new ModelBenda("jam", R.drawable.ajam, R.raw.jam));
        bendas.add(new ModelBenda("buku", R.drawable.abuku,R.raw.buku));
        bendas.add(new ModelBenda("tas", R.drawable.atas,R.raw.tas));
        bendas.add(new ModelBenda("kipasangin", R.drawable.akipasangin,R.raw.kipasangin));
        bendas.add(new ModelBenda("kotak pensil", R.drawable.akotakpensil,R.raw.kotakpensil));
        bendas.add(new ModelBenda("kotak sampah", R.drawable.akotaksampah,R.raw.kotaksampah));
        bendas.add(new ModelBenda("meja", R.drawable.ameja,R.raw.meja));
        bendas.add(new ModelBenda("pena", R.drawable.apulpen,R.raw.pena));
        bendas.add(new ModelBenda("penggaris", R.drawable.apenggaris,R.raw.penggaris));
        bendas.add(new ModelBenda("pensil", R.drawable.apensil,R.raw.pensil));
        bendas.add(new ModelBenda("sapu", R.drawable.asapu,R.raw.sapu));
        bendas.add(new ModelBenda("sepatu", R.drawable.asepatu,R.raw.sepatu));
        bendas.add(new ModelBenda("televisi", R.drawable.atelevisi,R.raw.s));
        bendas.add(new ModelBenda("kursi", R.drawable.akursi,R.raw.kursi));
        bendas.add(new ModelBenda("penghapus", R.drawable.apenghapus,R.raw.p));

//        generateRandomImage();

        scoreInt.setText(String.valueOf(nilai));
        number = (int) (Math.random()*(bendas.size()));
        imgvRand.setImageResource(bendas.get(number).getIcon());

        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (soal == 10){
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
        System.out.println("jawaban2 : " + bendas.get(number).getNama());
        if (jawaban.equalsIgnoreCase(bendas.get(number).getNama())){
            nilai = nilai + 10;
            soal = soal + 1;
            System.out.println(nilai);
            scoreInt.setText(String.valueOf(nilai));
            number = (int) (Math.random()*(bendas.size()));
            imgvRand.setImageResource(bendas.get(number).getIcon());
            txtJawaban.setText("");
            Toast.makeText(ActivityBendaQuiz.this, "Jawaban benar!", Toast.LENGTH_SHORT).show();
        }else{
            System.out.println("masuk else");
            soal = soal + 1;
            scoreInt.setText(String.valueOf(nilai));
            number = (int) (Math.random()*(bendas.size()));
            imgvRand.setImageResource(bendas.get(number).getIcon());
            txtJawaban.setText("");
            Toast.makeText(ActivityBendaQuiz.this, "Jawaban salah!", Toast.LENGTH_SHORT).show();
        }
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