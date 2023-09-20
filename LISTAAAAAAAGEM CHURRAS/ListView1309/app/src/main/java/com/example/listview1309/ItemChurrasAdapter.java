package com.example.listview1309;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ItemChurrasAdapter extends ArrayAdapter<ItemChurrass> {

    Context mContext;
    int mResourse;

    //PRECISAVA DE UM CONTRUTOR QUE ASSIMILAVA AOS NOSSOS CONTRUTORES
    public ItemChurrasAdapter(@NonNull Context context, int resource, @NonNull List<ItemChurrass> objects) {
        super(context, resource, objects);
        mContext = context;
        mResourse = resource;
    }

    //Mais uns construtor com o getview
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //inflar Layout
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView=inflater.inflate(mResourse, parent, false);


        TextView txtNome = convertView.findViewById(R.id.nome);
        TextView txtId = convertView.findViewById(R.id.id);
        ImageView txtImagem = convertView.findViewById(R.id.imageView);

        txtNome.setText(getItem(position).nome);
        txtId.setText(getItem(position).id);
        ImageView.setImageResource(String.valueOf(getItem(position).imagem));



        //return super.getView(position, convertView, parent);
        return convertView;
    }
}
