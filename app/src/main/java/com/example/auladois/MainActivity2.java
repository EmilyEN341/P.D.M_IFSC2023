package com.example.auladois;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView textView2;
    Button button;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = findViewById(R.id.button);
        textView2 = findViewById(R.id.textView2);

        textView2.setText("blabla");



    }
    public void contagem (View v){
        i++;
    textView2.setText(Integer.toString(i));
    }
}