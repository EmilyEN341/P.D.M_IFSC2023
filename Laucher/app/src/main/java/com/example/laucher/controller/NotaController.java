package com.example.laucher.controller;

import android.content.Context;

import com.example.laucher.modelo.Nota;
import com.example.laucher.modelo.NotaDAO;

public class NotaController {
    Context nContext;
    NotaDAO notaDao;
    public NotaController(Context c) {
        nContext =c;
        notaDao = new NotaDAO(c);
    }

    public Nota cadastrarNovaNota(Nota n){
        return notaDao.getInserirNota(n);
    }

}
