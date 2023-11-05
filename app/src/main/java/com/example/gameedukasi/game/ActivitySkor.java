package com.example.gameedukasi.game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.example.gameedukasi.R;
import com.example.gameedukasi.database.Handler;
import com.example.gameedukasi.model.ModelSkor;

import java.util.List;

public class ActivitySkor extends AppCompatActivity {

    private TextView skBerhitung;
    private TextView skTebakGambarHewan;
    private TextView skTebakGambarBenda;
    private TextView skBerhitungNama;
    private TextView skBendaNama;
    private TextView skHewanNama;

    private Context context = ActivitySkor.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skor);

        skTebakGambarHewan = (TextView) findViewById(R.id.skTebakGambarHewan);
        skHewanNama = (TextView) findViewById(R.id.skHewanNama);

        isiData();
    }

    private void isiData(){
        Handler databaseHandler = new Handler(context);
        databaseHandler.open();

        //UNTUK AMBIL SKOR, SILAHKAN MASUKKAN ID DARI MASING MASING KATEGORI YANG SUDAH DITENTUKAN
        //BERIKUT CONTOH UNTUK MENAMPILKAN SKOR UNTUK KATEGORI TEBAK GAMBAR HEWAN
        //CONTOH INI MENGGUNAKAN ID = 1, UNTUK SELANJUTNYA SILAHKAN GANTI ID SESUAI DENGAN KATEGORI YANG DIINGINKAN
        ModelSkor modelSkor = databaseHandler.getModelSkorById(1);

        if(modelSkor != null) {
            int id = modelSkor.getId();
            int skor = modelSkor.getSkor();
            String skorType = modelSkor.getSkorType();
            String name = modelSkor.getName();

            skHewanNama.setText(name);
            skTebakGambarHewan.setText(String.valueOf(skor));

            System.out.println("nama dan skor : " + name + skor);

        }
        //PROSES AMBIL DATA UNTUK KATEGORI GAMBAR HEWAN SELESAI DISINI.

        //UNTUK PENGAMBILAN SELANJUTNYA SILAHKAN MASUKKAN DISINI
        //PENTING : JANGAN MASUKKAN CODE DIBAWAN databaseHandler.close()

        databaseHandler.close();
    }
}