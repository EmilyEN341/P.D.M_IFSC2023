package com.example.atualizandolistagem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] objects;
    ListView listView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);

        objects = new String[]{"Livro", "Bola"};
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                objects
            );

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(),
                        "Blabla"+ Integer.toString(i),
                        Toast.LENGTH_LONG).show();
            }
        });

    }

}

