package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class TelMaisInf extends AppCompatActivity {

    private TextView txtImcResultado, txtTaxa;
    private Double imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tel_mais_inf);

        txtTaxa = findViewById(R.id.txtTaxaIMC);

        Intent it = getIntent();
        imc = it.getDoubleExtra("p_imc", 0);
        txtImcResultado = findViewById(R.id.txtIMCREs);
        DecimalFormat df = new DecimalFormat("#.##");
        String imcFormatted = df.format(imc);
        txtImcResultado.setText(String.valueOf(imcFormatted));
        calcularTaxaIMC();
    }

    public void calcularTaxaIMC() {
        if (imc < 18.5) {
            txtTaxa.setText("Abaixo do peso");
        } else if (imc >= 18.5 && imc < 24.9) {
            txtTaxa.setText("Peso normal");
        } else if (imc >= 25 && imc < 29.9) {
            txtTaxa.setText("Sobrepeso");
        } else if (imc >= 30 && imc < 34.9) {
            txtTaxa.setText("Obesidade Grau I");
        } else if (imc >= 35 && imc < 39.9) {
            txtTaxa.setText("Obesidade Grau II");
        } else {
            txtTaxa.setText("Obesidade Grau III");
        }
    }

    public void voltarTelaMain(View view) {
        this.finish();
    }
}