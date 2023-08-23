package com.example.auladois;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edmin, edmax;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Ciclo de Vida Activity", "onCreate ");
        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();

        edmin= findView(R.layout.activity_main);

    }

    public void Sortear (View v){
        int min, max;

        min=Integer.parseInt(edmin.getText().toString());
        ma=Integer.parseInt(edmax.getText().toString());

        //Math .random [0,1]
        int sorteado= min + (Math .random()*(max-min+1));

        textView.setText(sorteado);

        Random rand = new Random();

        sorteado=rand.nextInt (bound: (max-min)+1)+min;

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Ciclo de Vida Activity", "onStart ");
        Toast.makeText(this, "onStart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Ciclo de vida Activty ", "onResume");
        Toast.makeText(this, "onResume", Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Clico de vida Activity", "onPause");
        Toast.makeText(this, "onPause", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Clico de vida Activity", "onRestart");
        Toast.makeText(this, "onRestart", Toast.LENGTH_LONG).show();
    }
}