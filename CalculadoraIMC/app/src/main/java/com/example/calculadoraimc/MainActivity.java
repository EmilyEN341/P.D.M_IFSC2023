package com.example.calculadoraimc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button btnCalcular;
    private EditText editTextPeso, editTextAltura;
    private TextView textViewResultado;
    private Double peso, altura, imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = findViewById(R.id.btnCalcular);
        editTextPeso = findViewById(R.id.editTextPeso);
        editTextAltura = findViewById(R.id.editTextAltura);
        textViewResultado = findViewById(R.id.textViewResultado);


    }

    public void calcularIMC(View view) {

        if(!editTextPeso.getText().toString().isEmpty() && !editTextAltura.getText().toString().isEmpty()) {
            peso = Double.parseDouble(editTextPeso.getText().toString());
            altura = Double.parseDouble(editTextAltura.getText().toString());
            imc = peso / (altura * altura);
            DecimalFormat df = new DecimalFormat("#.##");
            String imcFormatted = df.format(imc);
            textViewResultado.setText(imcFormatted);
        } else {
            AlertDialog.Builder alert =  new AlertDialog.Builder(view.getContext());
            alert.setTitle("Informação!");
            alert.setMessage("Insira um valor válido em peso/altura");
            alert.setPositiveButton("Ok", null);
            alert.create();
            alert.show();
            textViewResultado.setText("");
        }
    }

    public void irTelaMaisInfo(View view) {
        Intent itTelaMaisInfo = new Intent(this, TelaMaisInfo.class);
        itTelaMaisInfo.putExtra("p_imc", imc);
        startActivity(itTelaMaisInfo);
    }
}