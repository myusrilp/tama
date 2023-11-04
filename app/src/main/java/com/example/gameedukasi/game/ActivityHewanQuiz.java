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
import com.example.gameedukasi.database.Handler;
import com.example.gameedukasi.model.ModelHewan;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ActivityHewanQuiz extends AppCompatActivity {

    private Context context = ActivityHewanQuiz.this;
    List<ModelHewan> hewanList;
    int nilai = 0;
    int soal = 1;
    int number;

    private Button btnAnswer;
    private ImageView imgvRand;
    private TextView scoreInt;
    private EditText txtJawaban;
    private Button btnVoice;
    private String ID_BahasaIndonesia = "id";
    protected static final int RESULT_SPEECH = 1;
    private EditText namaSkor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hewan_quiz);

        btnAnswer = (Button) findViewById(R.id.btnAnswer);
        imgvRand = (ImageView) findViewById(R.id.imgvRand);
        scoreInt = (TextView) findViewById(R.id.scoreInt);
        txtJawaban = (EditText) findViewById(R.id.txtJawaban);
        btnVoice = (Button) findViewById(R.id.btnVoice);
        namaSkor = (EditText) findViewById(R.id.namaSkor);

        hewanList = new ArrayList<>();
        hewanList.add(new ModelHewan("angsa", R.drawable.bangsa, R.raw.angsa));
        hewanList.add(new ModelHewan("ayam", R.drawable.bayam, R.raw.ayam));
        hewanList.add(new ModelHewan("anjing", R.drawable.banjing, R.raw.anjing));
        hewanList.add(new ModelHewan("badak", R.drawable.bbadak, R.raw.badak));
        hewanList.add(new ModelHewan("babi", R.drawable.bbabi, R.raw.babi));
        hewanList.add(new ModelHewan("buaya", R.drawable.bbuaya, R.raw.buaya));
        hewanList.add(new ModelHewan("banteng", R.drawable.bbanteng, R.raw.banteng));
        hewanList.add(new ModelHewan("bebek", R.drawable.bbebek, R.raw.bebek));
        hewanList.add(new ModelHewan("beruang", R.drawable.bberuang, R.raw.beruang));
        hewanList.add(new ModelHewan("gajah", R.drawable.bgajah, R.raw.gajah));
        hewanList.add(new ModelHewan("harimau", R.drawable.bharimau, R.raw.harimau));
        hewanList.add(new ModelHewan("kelinci", R.drawable.bkelinci, R.raw.kelinci));
        hewanList.add(new ModelHewan("kucing", R.drawable.bkucing, R.raw.kucing));
        hewanList.add(new ModelHewan("sapi", R.drawable.bsapi, R.raw.s));
        hewanList.add(new ModelHewan("singa", R.drawable.bsinga, R.raw.singa));

//        generateRandomImage();

        scoreInt.setText(String.valueOf(nilai));
        number = (int) (Math.random()*(hewanList.size()));
        imgvRand.setImageResource(hewanList.get(number).getIcon());
        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (soal == 11){
                    showResult(String.valueOf(nilai));
                }else{
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
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), " not found", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

    }
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
        System.out.println("jawaban2 : " + hewanList.get(number).getNama());

        if (jawaban.equalsIgnoreCase(hewanList.get(number).getNama())) {
            nilai = nilai + 10;
            Toast.makeText(ActivityHewanQuiz.this, "Jawaban benar!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(ActivityHewanQuiz.this, "Jawaban salah!", Toast.LENGTH_SHORT).show();
        }

        soal = soal + 1;

        if (soal == 11) {
            showResult(String.valueOf(nilai));
        } else {
            scoreInt.setText(String.valueOf(nilai));
            number = (int) (Math.random() * hewanList.size());
            imgvRand.setImageResource(hewanList.get(number).getIcon());
            txtJawaban.setText("");
        }
        System.out.println("masuk else");
    }


    private void showResult(String hasil){
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.popup_hasil);
        dialog.setCancelable(false);

        TextView skorhasil = (TextView) dialog.findViewById(R.id.skorhasil);
        EditText namaSkor = (EditText) dialog.findViewById(R.id.namaSkor);
        Button ok = (Button) dialog.findViewById(R.id.ok);

        skorhasil.setText(hasil);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Handler databaseHandler = new Handler(context);
                databaseHandler.open();

                int id = 1;
                int skor = Integer.parseInt(hasil); // Your skor
                String skorType = "hewan"; // Your skorType
                String name = namaSkor.getText().toString();

                long result = databaseHandler.insertOrUpdateModelSkor(id, skor, skorType, name);
                if (result != -1) {
                    Toast.makeText(context, "Sukses input skor", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Gagal input skor", Toast.LENGTH_SHORT).show();
                }

                databaseHandler.close();
                finish();
            }
        });

        dialog.show();
    }



}