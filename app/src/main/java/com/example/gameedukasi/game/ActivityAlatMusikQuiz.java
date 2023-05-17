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
import com.example.gameedukasi.model.ModelAlatMusik;
import com.example.gameedukasi.model.ModelBenda;

import java.util.ArrayList;
import java.util.List;

public class ActivityAlatMusikQuiz extends AppCompatActivity {

    private Context context = ActivityAlatMusikQuiz.this;

    List<ModelAlatMusik> alatmusiks;
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

        alatmusiks = new ArrayList<>();
        alatmusiks.add(new ModelAlatMusik("angklung", R.drawable.angklung, R.raw.angklung));
        alatmusiks.add(new ModelAlatMusik("aramba", R.drawable.aramba, R.raw.aramba));
        alatmusiks.add(new ModelAlatMusik("bende", R.drawable.bende, R.raw.bende));
        alatmusiks.add(new ModelAlatMusik("burdah", R.drawable.burdah, R.raw.burdah));
        alatmusiks.add(new ModelAlatMusik("cangor", R.drawable.cangor, R.raw.cangor));
        alatmusiks.add(new ModelAlatMusik("demung", R.drawable.demung, R.raw.demung));
        alatmusiks.add(new ModelAlatMusik("dolidoli", R.drawable.dolidoli, R.raw.dolidoli));
        alatmusiks.add(new ModelAlatMusik("ganda", R.drawable.ganda, R.raw.ganda));
        alatmusiks.add(new ModelAlatMusik("gendang", R.drawable.gendang, R.raw.gendang));
        alatmusiks.add(new ModelAlatMusik("gesogeso", R.drawable.gesogeso, R.raw.gesogeso));
        alatmusiks.add(new ModelAlatMusik("gong", R.drawable.gong, R.raw.gong));
        alatmusiks.add(new ModelAlatMusik("gurinding", R.drawable.guriding, R.raw.gurinding));
        alatmusiks.add(new ModelAlatMusik("kecapi", R.drawable.kecapi, R.raw.kecapi));
        alatmusiks.add(new ModelAlatMusik("kecrek", R.drawable.kecrek, R.raw.kecrek));
        alatmusiks.add(new ModelAlatMusik("kolintang", R.drawable.kolintang, R.raw.kolintang));
        alatmusiks.add(new ModelAlatMusik("lalove", R.drawable.lalove, R.raw.lalove));
        alatmusiks.add(new ModelAlatMusik("pupuik", R.drawable.pupuik, R.raw.pupuik));
        alatmusiks.add(new ModelAlatMusik("rebab", R.drawable.rebab, R.raw.rebab));
        alatmusiks.add(new ModelAlatMusik("sape", R.drawable.sape, R.raw.sape));
        alatmusiks.add(new ModelAlatMusik("sasando", R.drawable.sasando, R.raw.sasando));
        alatmusiks.add(new ModelAlatMusik("siter", R.drawable.siter, R.raw.siter));
        alatmusiks.add(new ModelAlatMusik("suling", R.drawable.suling, R.raw.suling));
        alatmusiks.add(new ModelAlatMusik("talindo", R.drawable.talindo, R.raw.talindo));

//        generateRandomImage();

        scoreInt.setText(String.valueOf(nilai));
        number = (int) (Math.random()*(alatmusiks.size()));
        imgvRand.setImageResource(alatmusiks.get(number).getIcon());

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
        System.out.println("jawaban2 : " + alatmusiks.get(number).getNama());
        if (jawaban.equalsIgnoreCase(alatmusiks.get(number).getNama())){
            nilai = nilai + 10;
            System.out.println(nilai);
            scoreInt.setText(String.valueOf(nilai));
            number = (int) (Math.random()*(alatmusiks.size()));
            imgvRand.setImageResource(alatmusiks.get(number).getIcon());
        }else{
            System.out.println("masuk else");
        }
    }

}