package com.example.BlocoDeNotas_Laucher.controller;

import android.content.Context;

import com.example.BlocoDeNotas_Laucher.modelo.Nota;
import com.example.BlocoDeNotas_Laucher.modelo.NotaDAO;

import java.util.ArrayList;

public class NotaController {

    NotaDAO notaDAO;

    public NotaController(Context c){
        notaDAO = new NotaDAO(c);
    }

    public void cadastrarNota(Nota nota){
        if (nota.getTitulo().length()>3){
            notaDAO.getInserirNota(nota);
        }
    }

    public Nota getNota(int idNota){
        return notaDAO.getAllNotes(idNota);
    }

    public void excluirNota(Nota nota){
        notaDAO.excluirNota(nota.getId());
    }

    public ArrayList<Nota> recuperaNotas(){
        return notaDAO.listarNotas(notaDAO.listarNotas());
    }

    public ArrayList<String> recuperaTituloNtas(){
        ArrayList<String> tituloNotas = new ArrayList<>();
        for(Nota n:this.recuperaNotas()){
            tituloNotas.add(n.getTitulo());
        }
        return tituloNotas;
    }
}