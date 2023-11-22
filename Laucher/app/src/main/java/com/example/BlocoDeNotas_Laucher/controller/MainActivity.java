package com.example.BlocoDeNotas_Laucher.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laucher.R;

public class MainActivity extends AppCompatActivity {

    private Button btnMinhasNotas;
    private Button btnNovaNota;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        btnNovaNota = findViewById(R.id.btnMinhasNotas);
        btnMinhasNotas = findViewById(R.id.btnNovaNota);

    }

    public void irTelaNovaNota(View view) {
        Intent intent = new Intent(this, NovaNota.class);
        startActivity(intent);
    }

    public void irTelaMinhasNotas(View view) {
        Intent intent = new Intent(this, MinhasNotas.class);
        startActivity(intent);
    }
}
