package com.example.gameedukasi.game;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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
    int soal = 1;
    int number;

    private Button btnAnswer;
    private ImageView imgvRand;
    private TextView scoreInt;
    private EditText txtJawaban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hewan_quiz);

        btnAnswer = (Button) findViewById(R.id.btnAnswer);
        imgvRand = (ImageView) findViewById(R.id.imgvRand);
        scoreInt = (TextView) findViewById(R.id.scoreInt);
        txtJawaban = (EditText) findViewById(R.id.txtJawaban);

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
                if (soal == 10){
                    showResult(String.valueOf(nilai));
                }else{
                    generateRandomImage();
                }

            }
        });

    }
    private void generateRandomImage(){
        String jawaban = String.valueOf(txtJawaban.getText());
        System.out.println("jawaban : " + jawaban);
        System.out.println("jawaban2 : " + hewanList.get(number).getNama());
        if (jawaban.equalsIgnoreCase(hewanList.get(number).getNama())){
            nilai = nilai + 10;
            soal = soal + 1;
            System.out.println(nilai);
            scoreInt.setText(String.valueOf(nilai));
            number = (int) (Math.random()*(hewanList.size()));
            imgvRand.setImageResource(hewanList.get(number).getIcon());
            txtJawaban.setText("");
        }else{
            soal = soal + 1;
            scoreInt.setText(String.valueOf(nilai));
            number = (int) (Math.random()*(hewanList.size()));
            imgvRand.setImageResource(hewanList.get(number).getIcon());
            txtJawaban.setText("");
            System.out.println("masuk else");
        }
    }

    private void showResult(String hasil){
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