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
import com.example.gameedukasi.model.ModelBenda;

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
        alatmusiks.add(new ModelAlatMusik("angklung", R.drawable.qqangklung, R.raw.angklung));
        alatmusiks.add(new ModelAlatMusik("aramba", R.drawable.qqaramba, R.raw.aramba));
        alatmusiks.add(new ModelAlatMusik("bende", R.drawable.qbende, R.raw.bende));
        alatmusiks.add(new ModelAlatMusik("burdah", R.drawable.qburdah, R.raw.burdah));
        alatmusiks.add(new ModelAlatMusik("cangor", R.drawable.qcangor, R.raw.cangor));
        alatmusiks.add(new ModelAlatMusik("demung", R.drawable.qdemung, R.raw.demung));
        alatmusiks.add(new ModelAlatMusik("dolidoli", R.drawable.qdolidoli, R.raw.dolidoli));
        alatmusiks.add(new ModelAlatMusik("ganda", R.drawable.qganda, R.raw.ganda));
        alatmusiks.add(new ModelAlatMusik("gendang", R.drawable.qgendang, R.raw.gendang));
        alatmusiks.add(new ModelAlatMusik("gesogeso", R.drawable.qgesogeso, R.raw.gesogeso));
        alatmusiks.add(new ModelAlatMusik("gong", R.drawable.qgong, R.raw.gong));
        alatmusiks.add(new ModelAlatMusik("gurinding", R.drawable.qguriding, R.raw.gurinding));
        alatmusiks.add(new ModelAlatMusik("kecapi", R.drawable.qkecapi, R.raw.kecapi));
        alatmusiks.add(new ModelAlatMusik("kecrek", R.drawable.qkecrek, R.raw.kecrek));
        alatmusiks.add(new ModelAlatMusik("kolintang", R.drawable.qkolintang, R.raw.kolintang));
        alatmusiks.add(new ModelAlatMusik("lalove", R.drawable.qlalove, R.raw.lalove));
        alatmusiks.add(new ModelAlatMusik("pupuik", R.drawable.qpupuik, R.raw.pupuik));
        alatmusiks.add(new ModelAlatMusik("rebab", R.drawable.qrebab, R.raw.rebab));
        alatmusiks.add(new ModelAlatMusik("sape", R.drawable.qsape, R.raw.sape));
        alatmusiks.add(new ModelAlatMusik("sasando", R.drawable.qsasando, R.raw.sasando));
        alatmusiks.add(new ModelAlatMusik("siter", R.drawable.qsiter, R.raw.siter));
        alatmusiks.add(new ModelAlatMusik("suling", R.drawable.qsuling, R.raw.suling));
        alatmusiks.add(new ModelAlatMusik("talindo", R.drawable.qtalindo, R.raw.talindo));

//        generateRandomImage();

        scoreInt.setText(String.valueOf(nilai));
        number = (int) (Math.random()*(alatmusiks.size()));
        imgvRand.setImageResource(alatmusiks.get(number).getIcon());

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
        System.out.println("jawaban2 : " + alatmusiks.get(number).getNama());
        if (jawaban.equalsIgnoreCase(alatmusiks.get(number).getNama())){
            nilai = nilai + 10;
            soal = soal + 1;
            System.out.println(nilai);
            scoreInt.setText(String.valueOf(nilai));
            number = (int) (Math.random()*(alatmusiks.size()));
            imgvRand.setImageResource(alatmusiks.get(number).getIcon());
            txtJawaban.setText("");
            Toast.makeText(ActivityAlatMusikQuiz.this, "Jawaban benar!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(ActivityAlatMusikQuiz.this, "Jawaban salah!", Toast.LENGTH_SHORT).show();
            soal = soal + 1;
            scoreInt.setText(String.valueOf(nilai));
            number = (int) (Math.random()*(alatmusiks.size()));
            imgvRand.setImageResource(alatmusiks.get(number).getIcon());
            txtJawaban.setText("");
            System.out.println("masuk else");
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