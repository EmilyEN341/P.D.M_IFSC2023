package com.example.listview1309;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<ItemChurrass> listaItensChurras = new ArrayList<ItemChurrass>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);

        listaItensChurras.add(new ItemChurrass(1, "Carne", R.drawable.carne));
        listaItensChurras.add(new ItemChurrass(2, "Frango", R.drawable.frango));
        listaItensChurras.add(new ItemChurrass(3, "Pão de Alho", R.drawable.pao_de_alho));
        listaItensChurras.add(new ItemChurrass(4, "Refrigerante", R.drawable.refrigerante));
        listaItensChurras.add(new ItemChurrass(5, "Linguiça", R.drawable.linguica));

        ItemChurrasAdapter adapter = new ItemChurrasAdapter(this, R.layout.item_churrasco,listaItensChurras);

        listView.setAdapter(adapter);


    }




}
