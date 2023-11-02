package com.example.BlocoDeNotas_Laucher.modelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.BlocoDeNotas_Laucher.modelo.Nota;

import java.util.List;

public class NotaAdapter extends ArrayAdapter<Nota> {
    public NotaAdapter(Context context, List<Nota> Notas) {
        super(context, 0, Notas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        // Obtém o objeto da posição atual
        Nota objeto = getItem(position);

        if (objeto != null) {
            // Obtém o TextView no layout simple_list_item_1
            TextView textView = convertView.findViewById(android.R.id.text1);

            // Define o texto do TextView como a propriedade "nome" do objeto
            textView.setText(objeto.getTexto());
        }

        return convertView;
    }
}
