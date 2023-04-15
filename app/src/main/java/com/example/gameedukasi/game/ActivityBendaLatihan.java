package com.example.gameedukasi.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

import com.example.gameedukasi.R;
import com.example.gameedukasi.model.ModelBenda;

import java.util.ArrayList;
import java.util.List;

public class ActivityBendaLatihan extends AppCompatActivity {

    private Context context = ActivityBendaLatihan.this;
    List<ModelBenda> bendas;

    private RecyclerView rvBendaList;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benda_latihan);

        bendas = new ArrayList<>();
        bendas.add(new ModelBenda(""));
    }
}