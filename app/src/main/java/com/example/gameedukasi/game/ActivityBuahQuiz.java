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
import com.example.gameedukasi.model.ModelBuah;

import java.util.ArrayList;
import java.util.List;

public class ActivityBuahQuiz extends AppCompatActivity {

    private Context context = ActivityBuahQuiz.this;
    List<ModelBuah> buahs;
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
        setContentView(R.layout.activity_buah_quiz);

        btnAnswer = (Button) findViewById(R.id.btnAnswer);
        imgvRand = (ImageView) findViewById(R.id.imgvRand);
        scoreInt = (TextView) findViewById(R.id.scoreInt);
        txtJawaban = (EditText) findViewById(R.id.txtJawaban);
        btnVoice = (Button) findViewById(R.id.btnVoice);

        buahs = new ArrayList<>();
        buahs.add(new ModelBuah("alpukat", R.drawable.xxalpukat, R.raw.alpukat));
        buahs.add(new ModelBuah("apel", R.drawable.xxapel, R.raw.apel));
        buahs.add(new ModelBuah("anggur", R.drawable.xxanggur, R.raw.anggur));
        buahs.add(new ModelBuah("belimbing", R.drawable.xxbelimbing, R.raw.belimbing));
        buahs.add(new ModelBuah("durian", R.drawable.xxdurian, R.raw.durian));
        buahs.add(new ModelBuah("jambu", R.drawable.xxjambu, R.raw.jambu));
        buahs.add(new ModelBuah("jeruk", R.drawable.xxjeruk, R.raw.jeruk));
        buahs.add(new ModelBuah("kelengkeng", R.drawable.xxkelengkeng, R.raw.kelengkeng));
        buahs.add(new ModelBuah("kiwi", R.drawable.xxkiwi, R.raw.kiwi));
        buahs.add(new ModelBuah("mangga", R.drawable.xxmangga, R.raw.mangga));
        buahs.add(new ModelBuah("melon", R.drawable.xxmelon, R.raw.melon));
        buahs.add(new ModelBuah("nanas", R.drawable.xxnanas, R.raw.nanas));
        buahs.add(new ModelBuah("pepaya", R.drawable.xxpepaya, R.raw.pepaya));
        buahs.add(new ModelBuah("pir", R.drawable.xxpir, R.raw.pir));
        buahs.add(new ModelBuah("semangka", R.drawable.xxsemangka, R.raw.semangka));

//        generateRandomImage();

        scoreInt.setText(String.valueOf(nilai));
        number = (int) (Math.random()*(buahs.size()));
        imgvRand.setImageResource(buahs.get(number).getIcon());

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
        System.out.println("jawaban2 : " + buahs.get(number).getNama());

        if (jawaban.equalsIgnoreCase(buahs.get(number).getNama())) {
            nilai = nilai + 10;
            Toast.makeText(ActivityBuahQuiz.this, "Jawaban benar!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(ActivityBuahQuiz.this, "Jawaban salah!", Toast.LENGTH_SHORT).show();
        }

        soal = soal + 1;

        if (soal == 11) {
            showResult(String.valueOf(nilai));
        } else {
            scoreInt.setText(String.valueOf(nilai));
            number = (int) (Math.random() * buahs.size());
            imgvRand.setImageResource(buahs.get(number).getIcon());
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