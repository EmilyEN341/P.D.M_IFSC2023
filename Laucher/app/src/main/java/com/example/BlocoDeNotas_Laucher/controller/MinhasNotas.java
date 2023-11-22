package com.example.BlocoDeNotas_Laucher.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laucher.R;

public class MinhasNotas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minhas_notas);

        Intent it = getIntent();
    }
    public void voltarTelaMain(View view) {
        this.finish();
    }

}
