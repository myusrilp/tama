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
import com.example.gameedukasi.model.ModelBenda;

import java.util.ArrayList;
import java.util.List;

public class ActivityBendaQuiz extends AppCompatActivity {

    private Context context = ActivityBendaQuiz.this;
    List<ModelBenda> bendas;
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
        setContentView(R.layout.activity_benda_quiz);

        btnAnswer = (Button) findViewById(R.id.btnAnswer);
        imgvRand = (ImageView) findViewById(R.id.imgvRand);
        scoreInt = (TextView) findViewById(R.id.scoreInt);
        txtJawaban = (EditText) findViewById(R.id.txtJawaban);
        btnVoice = (Button) findViewById(R.id.btnVoice);

        bendas = new ArrayList<>();
        bendas.add(new ModelBenda("jam", R.drawable.vjam, R.raw.jam));
        bendas.add(new ModelBenda("papan tulis", R.drawable.vpapantulis, R.raw.papantulis));
        bendas.add(new ModelBenda("buku", R.drawable.vbuku,R.raw.buku));
        bendas.add(new ModelBenda("tas", R.drawable.vtas,R.raw.tas));
        bendas.add(new ModelBenda("kapur", R.drawable.vkapur,R.raw.kapur));
        bendas.add(new ModelBenda("kipas angin", R.drawable.vkipasangin,R.raw.kipasangin));
        bendas.add(new ModelBenda("kotak pensil", R.drawable.vkotakpensil,R.raw.kotakpensil));
        bendas.add(new ModelBenda("kotak sampah", R.drawable.vkotaksampah,R.raw.kotaksampah));
        bendas.add(new ModelBenda("lampu", R.drawable.vlampu,R.raw.lampu));
        bendas.add(new ModelBenda("lemari", R.drawable.vlemari,R.raw.lemari));
        bendas.add(new ModelBenda("meja", R.drawable.vmeja,R.raw.meja));
        bendas.add(new ModelBenda("pena", R.drawable.vpena,R.raw.pena));
        bendas.add(new ModelBenda("penggaris", R.drawable.vpenggaris,R.raw.penggaris));
        bendas.add(new ModelBenda("penghapus pensil", R.drawable.vpenghapuspensil,R.raw.penghapuspensil));
        bendas.add(new ModelBenda("pensil", R.drawable.vpensil,R.raw.pensil));
        bendas.add(new ModelBenda("pensil warna", R.drawable.vpensilwarna,R.raw.pensilwarna));
        bendas.add(new ModelBenda("pintu", R.drawable.vpintu,R.raw.pintu));
        bendas.add(new ModelBenda("rakbuku", R.drawable.vrakbuku,R.raw.rakbuku));
        bendas.add(new ModelBenda("raksepatu", R.drawable.vraksepatu,R.raw.raksepatu));
        bendas.add(new ModelBenda("sapu", R.drawable.vsapu,R.raw.sapu));
        bendas.add(new ModelBenda("sepatu", R.drawable.vsepatu,R.raw.sepatu));
        bendas.add(new ModelBenda("serutan pensil", R.drawable.vserutanpensil,R.raw.serutanpensil));
        bendas.add(new ModelBenda("spidol", R.drawable.vspidol,R.raw.spidol));

//        generateRandomImage();

        scoreInt.setText(String.valueOf(nilai));
        number = (int) (Math.random()*(bendas.size()));
        imgvRand.setImageResource(bendas.get(number).getIcon());

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
        System.out.println("jawaban2 : " + bendas.get(number).getNama());
        if (jawaban.equalsIgnoreCase(bendas.get(number).getNama())){
            nilai = nilai + 10;
            System.out.println(nilai);
            scoreInt.setText(String.valueOf(nilai));
            number = (int) (Math.random()*(bendas.size()));
            imgvRand.setImageResource(bendas.get(number).getIcon());
            Toast.makeText(ActivityBendaQuiz.this, "Jawaban benar!", Toast.LENGTH_SHORT).show();
        }else{
            System.out.println("masuk else");
            Toast.makeText(ActivityBendaQuiz.this, "Jawaban salah!", Toast.LENGTH_SHORT).show();
        }
    }

}