package com.example.sqliteteste;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listview;

    SQLiteDatabase sqlitebd;
    @SuppressLint({"Range", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listview);

        sqlitebd = openOrCreateDatabase("meub", MODE_PRIVATE, null);
        sqlitebd.execSQL("CREATE TABLE IF NOT EXISTS usr (id INTEGER PRIMARY KEY AUTOINCREMENT , " +
                "" + " nome VARCHAR)");

        ContentValues cv = new ContentValues();
        cv.put("nome", "João");
        sqlitebd.insert("usr", null, cv);

        //Resgatando informações                       //WHERE nome LIKE ? para determinar paramtros new String[]{}
        sqlitebd.rawQuery("SELECT id, nome FROM usr ", null);

        Cursor c = sqlitebd.rawQuery("SELECT * FROM usr", null);
        c.moveToFirst();
        ArrayList<String> ListaUsuario=new ArrayList<>();


        while (!c.isAfterLast()){
            ListaUsuario.add(c.getString(c.getColumnIndex("nome")));
            Log.d("tableusr",c.getString(c.getColumnIndex("id"))+
                                    c.getString(c.getColumnIndex("nome")));

            c.moveToNext();
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1, ListaUsuario

        );
        listview.setAdapter(arrayAdapter);
    }
}