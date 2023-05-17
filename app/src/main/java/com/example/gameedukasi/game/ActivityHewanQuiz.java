package com.example.gameedukasi.game;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
        setContentView(R.layout.activity_hewan_quiz);

        btnAnswer = (Button) findViewById(R.id.btnAnswer);
        imgvRand = (ImageView) findViewById(R.id.imgvRand);
        scoreInt = (TextView) findViewById(R.id.scoreInt);
        txtJawaban = (EditText) findViewById(R.id.txtJawaban);
        btnVoice = (Button) findViewById(R.id.btnVoice);

        hewanList = new ArrayList<>();
        hewanList.add(new ModelHewan("angsa", R.drawable.angsa, R.raw.angsa));
        hewanList.add(new ModelHewan("ayam", R.drawable.ayam, R.raw.ayam));
        hewanList.add(new ModelHewan("anjing", R.drawable.anjing, R.raw.anjing));
        hewanList.add(new ModelHewan("badak", R.drawable.badak, R.raw.badak));
        hewanList.add(new ModelHewan("babi", R.drawable.babi, R.raw.babi));
        hewanList.add(new ModelHewan("buaya", R.drawable.buaya, R.raw.buaya));
        hewanList.add(new ModelHewan("banteng", R.drawable.banteng, R.raw.banteng));
        hewanList.add(new ModelHewan("bangau", R.drawable.bangau, R.raw.bangau));
        hewanList.add(new ModelHewan("bebek", R.drawable.bebek, R.raw.bebek));
        hewanList.add(new ModelHewan("beruang", R.drawable.beruang, R.raw.beruang));
        hewanList.add(new ModelHewan("belalang", R.drawable.belalang, R.raw.belalang));
        hewanList.add(new ModelHewan("burung hantu", R.drawable.burunghantu, R.raw.burunghantu));
        hewanList.add(new ModelHewan("burung cendrawasih", R.drawable.burungcendrawasih, R.raw.burungcendrawasih));
        hewanList.add(new ModelHewan("bunglon", R.drawable.bunglon, R.raw.bunglon));
        hewanList.add(new ModelHewan("burung dara", R.drawable.burungdara, R.raw.burungdara));
        hewanList.add(new ModelHewan("burung elang", R.drawable.burungelang, R.raw.burungelang));
        hewanList.add(new ModelHewan("cicak", R.drawable.cicak, R.raw.cicak));
        hewanList.add(new ModelHewan("cheetah", R.drawable.cheetah, R.raw.cheetah));
        hewanList.add(new ModelHewan("gajah", R.drawable.gajah, R.raw.gajah));
        hewanList.add(new ModelHewan("harimau", R.drawable.harimau, R.raw.harimau));
        hewanList.add(new ModelHewan("dinosaurus", R.drawable.dinosaurus, R.raw.dinosaurus));
        hewanList.add(new ModelHewan("hiu", R.drawable.hiu, R.raw.hiu));
        hewanList.add(new ModelHewan("jerapah", R.drawable.jerapah, R.raw.jerapah));
        hewanList.add(new ModelHewan("kambing", R.drawable.kambing, R.raw.kambing));
        hewanList.add(new ModelHewan("kangguru", R.drawable.kangguru, R.raw.kangguru));
        hewanList.add(new ModelHewan("kelinci", R.drawable.kelinci, R.raw.kelinci));
        hewanList.add(new ModelHewan("kerbau", R.drawable.kerbau, R.raw.kerbau));
        hewanList.add(new ModelHewan("kucing", R.drawable.kucing, R.raw.kucing));

//        generateRandomImage();

        scoreInt.setText(String.valueOf(nilai));
        number = (int) (Math.random()*(hewanList.size()));
        imgvRand.setImageResource(hewanList.get(number).getIcon());

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
        System.out.println("jawaban2 : " + hewanList.get(number).getNama());
        if (jawaban.equalsIgnoreCase(hewanList.get(number).getNama())){
            nilai = nilai + 10;
            System.out.println(nilai);
            scoreInt.setText(String.valueOf(nilai));
            number = (int) (Math.random()*(hewanList.size()));
            imgvRand.setImageResource(hewanList.get(number).getIcon());
        }else{
            System.out.println("masuk else");
        }
    }

}