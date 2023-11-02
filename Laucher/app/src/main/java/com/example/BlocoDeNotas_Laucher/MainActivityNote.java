package com.example.BlocoDeNotas_Laucher;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.BlocoDeNotas_Laucher.modelo.Nota;
import com.example.BlocoDeNotas_Laucher.modelo.NotaAdapter;
import com.example.BlocoDeNotas_Laucher.modelo.NotaDAO;
import com.example.laucher.R;

import java.util.ArrayList;

public class MainActivityNote extends AppCompatActivity {

    ArrayList<Nota> notas = new ArrayList<>();
    ListView list;
    EditText nota;
    Button button;
    NotaDAO banco;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notas);

        banco = new NotaDAO(getBaseContext());
        list = findViewById(R.id.listview_notes);
        nota = findViewById(R.id.editNote);
        button = findViewById(R.id.addButton);
        button.setOnClickListener(this::addNote);

        ArrayAdapter<Nota> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                notas
        );
        //NotaAdapter adapter = new NotaAdapter(getApplicationContext(), notas);

        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NotaAdapter adapter = (NotaAdapter) adapterView.getAdapter();
                // Usa o adaptador para obter o objeto na posição clicada
                Nota objetoClicado = adapter.getItem(i);
                EditNote(objetoClicado);
            }
        });
        showNotes();
    }

    public void EditNote(Nota nota){

    }

    public void addNote(View v){
        if(!nota.getText().toString().isEmpty()) {
            String notaInserida = nota.getText().toString();
            //Teste de inserção
            Nota novaNota = new Nota(1, notaInserida);
            banco.getInserirNota(novaNota);
            nota.setText("");

            showNotes();
        }  else {
            AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
            alert.setTitle("Você se esqueceu de uma coisinha 📝");
            alert.setMessage("Para uma nota ser adicionada é preciso conter alguma coisa no campo de inserir nota.");
            alert.setPositiveButton("Ok", null);
            alert.create();
            alert.show();
        }
    }

    public void showNotes() {

        int i =0;
        notas.clear();
        notas = banco.getAllNotes();
        NotaAdapter adapter = new NotaAdapter(getApplicationContext(), notas);

//        ArrayAdapter<Nota> adapter = new ArrayAdapter<Nota> (
//                getApplicationContext(),
//                android.R.layout.simple_list_item_1,
//                android.R.id.text1,
//                notas);
        list.setAdapter(adapter);
    }
}