package com.example.BlocoDeNotas_Laucher.modelo;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NotaDAO {
    SQLiteDatabase db;

    public NotaDAO(Context c) {

        this.db = c.openOrCreateDatabase("notas.db", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas (id Integer PRIMARY KEY AUTOINCREMENT, " +
                "texto varchar);");

    }

    public void update(Nota n) {
        ContentValues cv = new ContentValues();
        cv.put("texto", n.getTexto());
        db.insert("notas", null, cv);
    }

    public ArrayList<Nota> getAllNotes() {
        ArrayList<Nota> notes = new ArrayList<>();

        // Execute o comando SQL para selecionar todas as notas
        String sql = "SELECT * FROM notas";
        Cursor cursor = db.rawQuery(sql, null);


        if (cursor.getCount()<=0){
            return notes;
        }
        // Percorra todos os registros do cursor
        while (cursor.moveToNext()) {
            // Recupere o ID, título e texto da nota atual
            @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
            @SuppressLint("Range") String text = cursor.getString(cursor.getColumnIndex("texto"));

            // Crie um novo objeto Nota com os dados recuperados
            Nota note = new Nota(id, text);

            // Adicione o objeto Nota à lista de notas
            notes.add(note);


        }
        // Feche o cursor para evitar vazamentos de recursos
        cursor.close();

        // Retorne a lista de notas
        return notes;
    }

    public Nota getInserirNota(Nota n) {
        ContentValues cv = new ContentValues();
        cv.put("texto", n.getTexto());
        Integer i = (int) db.insert("notas", null, cv);
        n.setId(i);
        return n;

    }

    public Nota listarNotas(int id) {
        // Execute o comando SQL para selecionar a nota com o ID específico
        String sql = "SELECT * FROM notas WHERE id = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(id)});

        if (cursor.moveToFirst()) {
            // Recupere o ID e o texto da nota
            @SuppressLint("Range") int noteId = cursor.getInt(cursor.getColumnIndex("id"));
            @SuppressLint("Range") String text = cursor.getString(cursor.getColumnIndex("texto"));

            // Crie um novo objeto Nota com os dados recuperados
            Nota note = new Nota(noteId, text);

            // Feche o cursor para evitar vazamentos de recursos
            cursor.close();

            // Retorne a nota encontrada
            return note;
        } else {
            // Se não houver nota com o ID especificado, retorne null
            return null;
        }
    }

    public void excluirNota(int id) {
        // Exclua a nota com o ID específico do banco de dados
        db.delete("notas", "id = ?", new String[]{String.valueOf(id)});
    }
}

