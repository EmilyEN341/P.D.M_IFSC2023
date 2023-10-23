package com.example.a18102023atualizandolista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.database.sqlite.SQLiteDatabaseKt;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    EditText editText;
    Button button;
    SQLiteDatabase sqlietbd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=findViewById(R.id.listview);
        editText=findViewById(R.id.editText);
        button=findViewById(R.id.button);

        sqlietbd=openOrCreateDatabase("meu", MODE_PRIVATE, null);
        sqlietbd.execSQL("CREATE TABLE IF NOT EXISTS tabelinha (id INTEGER PRIMARY KEY AUTOINCREMENT,txt varchar)");
    }
    public void inserirNota(){
        String nota = editText().toString();

        if(!nota.isEmpty()){
            sqlietbd.execSQL(insertQuery);

            editText.setText("");

            listarNota();
        }

    }
    public void listarNota(){
        Cursor cursor = sqlietbd.rawQuery("SELECT * FROM tabelinha", null);

        ArrayList<String> notas = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                String nota = cursor
            }
        }

    }
}