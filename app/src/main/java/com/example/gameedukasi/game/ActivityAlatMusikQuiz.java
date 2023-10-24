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
import com.example.gameedukasi.model.ModelAlatMusik;

import java.util.ArrayList;
import java.util.List;

public class ActivityAlatMusikQuiz extends AppCompatActivity {

    private Context context = ActivityAlatMusikQuiz.this;

    List<ModelAlatMusik> alatmusiks;
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

        alatmusiks = new ArrayList<>();
        alatmusiks.add(new ModelAlatMusik("angklung", R.drawable.zangklung, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("biola", R.drawable.zbiola, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("drum", R.drawable.zdrum, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("gamelan", R.drawable.zgamelan, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("gendang", R.drawable.zgendang, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("gitar", R.drawable.zgitar, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("harmonika", R.drawable.zharmonika, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("harpa", R.drawable.zharpa, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("kecrek", R.drawable.zkecrek, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("pianika", R.drawable.zpianika, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("piano", R.drawable.zpiano, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("simbal", R.drawable.zsimbal, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("suling", R.drawable.zsuling, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("terompet", R.drawable.zterompet, R.raw.a));
        alatmusiks.add(new ModelAlatMusik("ukulele", R.drawable.zukulele, R.raw.a));

//        generateRandomImage();

        scoreInt.setText(String.valueOf(nilai));
        number = (int) (Math.random()*(alatmusiks.size()));
        imgvRand.setImageResource(alatmusiks.get(number).getIcon());

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
        System.out.println("jawaban2 : " + alatmusiks.get(number).getNama());

        if (jawaban.equalsIgnoreCase(alatmusiks.get(number).getNama())) {
            nilai = nilai + 10;
            Toast.makeText(ActivityAlatMusikQuiz.this, "Jawaban benar!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(ActivityAlatMusikQuiz.this, "Jawaban salah!", Toast.LENGTH_SHORT).show();
        }

        soal = soal + 1;

        if (soal == 11) {
            showResult(String.valueOf(nilai));
        } else {
            scoreInt.setText(String.valueOf(nilai));
            number = (int) (Math.random() * alatmusiks.size());
            imgvRand.setImageResource(alatmusiks.get(number).getIcon());
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