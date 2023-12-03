package com.example.tts;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private TextToSpeech tts;
    private boolean ttsLoaded = false;
    private EditText edFala;
    String fala;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tts = new TextToSpeech(this, this);
        edFala = findViewById(R.id.campoFala);
    }

    @Override
    public void onInit(int status) {
        if(status == TextToSpeech.SUCCESS){
            tts.setLanguage(Locale.getDefault());
            ttsLoaded = true;
        }
    }

    public void falar(View view){
        fala = edFala.getText().toString();
        if(ttsLoaded){
            tts.speak(fala, TextToSpeech.QUEUE_FLUSH, null, null);
        }
    }
}