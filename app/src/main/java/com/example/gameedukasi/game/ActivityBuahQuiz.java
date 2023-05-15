package com.example.gameedukasi.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gameedukasi.R;
import com.example.gameedukasi.model.ModelBenda;
import com.example.gameedukasi.model.ModelBuah;

import java.util.ArrayList;
import java.util.List;

public class ActivityBuahQuiz extends AppCompatActivity {

    private Context context = ActivityBuahQuiz.this;
    List<ModelBuah> buahs;
    int nilai = 0;
    int number;

    private Button btnAnswer;
    private ImageView imgvRand;
    private TextView scoreInt;
    private EditText txtJawaban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buah_quiz);

        btnAnswer = (Button) findViewById(R.id.btnAnswer);
        imgvRand = (ImageView) findViewById(R.id.imgvRand);
        scoreInt = (TextView) findViewById(R.id.scoreInt);
        txtJawaban = (EditText) findViewById(R.id.txtJawaban);

        buahs = new ArrayList<>();
        buahs.add(new ModelBuah("alpukat", R.drawable.alpukat, R.raw.alpukat));
        buahs.add(new ModelBuah("apel", R.drawable.apel, R.raw.apel));
        buahs.add(new ModelBuah("anggur", R.drawable.anggur, R.raw.anggur));
        buahs.add(new ModelBuah("belimbing", R.drawable.belimbing, R.raw.belimbing));
        buahs.add(new ModelBuah("bengkuang", R.drawable.bengkuang, R.raw.bengkuang));
        buahs.add(new ModelBuah("blueberry", R.drawable.blueberry, R.raw.blueberry));
        buahs.add(new ModelBuah("buahnaga", R.drawable.buahnaga, R.raw.buahnaga));
        buahs.add(new ModelBuah("ceri", R.drawable.ceri, R.raw.ceri));
        buahs.add(new ModelBuah("delima", R.drawable.delima, R.raw.delima));
        buahs.add(new ModelBuah("durian", R.drawable.durian, R.raw.durian));
        buahs.add(new ModelBuah("jambu", R.drawable.jambu, R.raw.jambu));
        buahs.add(new ModelBuah("jeruk", R.drawable.jeruk, R.raw.jeruk));
        buahs.add(new ModelBuah("jeruknipis", R.drawable.jeruknipis, R.raw.jeruknipis));
        buahs.add(new ModelBuah("kelapa", R.drawable.kelapa, R.raw.kelapa));
        buahs.add(new ModelBuah("kelengkeng", R.drawable.kelengkeng, R.raw.kelengkeng));
        buahs.add(new ModelBuah("kiwi", R.drawable.kiwi, R.raw.kiwi));
        buahs.add(new ModelBuah("kurma", R.drawable.kurma, R.raw.kurma));
        buahs.add(new ModelBuah("labu", R.drawable.labu, R.raw.labu));
        buahs.add(new ModelBuah("leci", R.drawable.leci, R.raw.leci));
        buahs.add(new ModelBuah("lemon", R.drawable.lemon, R.raw.lemon));
        buahs.add(new ModelBuah("mangga", R.drawable.mangga, R.raw.mangga));
        buahs.add(new ModelBuah("manggis", R.drawable.manggis, R.raw.manggis));
        buahs.add(new ModelBuah("melon", R.drawable.melon, R.raw.melon));
        buahs.add(new ModelBuah("nanas", R.drawable.nanas, R.raw.nanas));
        buahs.add(new ModelBuah("nangka", R.drawable.nangka, R.raw.nangka));
        buahs.add(new ModelBuah("pepaya", R.drawable.pepaya, R.raw.pepaya));
        buahs.add(new ModelBuah("pir", R.drawable.pir, R.raw.pir));
        buahs.add(new ModelBuah("pisang", R.drawable.pisang, R.raw.pisang));
        buahs.add(new ModelBuah("rambutan", R.drawable.rambutan, R.raw.rambutan));
        buahs.add(new ModelBuah("sawo", R.drawable.sawo, R.raw.sawo));
        buahs.add(new ModelBuah("semangka", R.drawable.semangka, R.raw.semangka));
        buahs.add(new ModelBuah("sirsak", R.drawable.sirsak, R.raw.sirsak));
        buahs.add(new ModelBuah("srikaya", R.drawable.srikaya, R.raw.srikaya));
        buahs.add(new ModelBuah("strawberry", R.drawable.strawberry, R.raw.strawberry));

//        generateRandomImage();

        scoreInt.setText(String.valueOf(nilai));
        number = (int) (Math.random()*(buahs.size()));
        imgvRand.setImageResource(buahs.get(number).getIcon());

        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateRandomImage();
            }
        });

    }

    private void generateRandomImage(){
        String jawaban = String.valueOf(txtJawaban.getText());
        System.out.println("jawaban : " + jawaban);
        System.out.println("jawaban2 : " + buahs.get(number).getNama());
        if (jawaban.equalsIgnoreCase(buahs.get(number).getNama())){
            nilai = nilai + 10;
            System.out.println(nilai);
            scoreInt.setText(String.valueOf(nilai));
            number = (int) (Math.random()*(buahs.size()));
            imgvRand.setImageResource(buahs.get(number).getIcon());
        }else{
            System.out.println("masuk else");
        }
    }

}