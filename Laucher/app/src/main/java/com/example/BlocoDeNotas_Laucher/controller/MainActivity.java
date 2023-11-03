package com.example.BlocoDeNotas_Laucher.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.example.laucher.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
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
