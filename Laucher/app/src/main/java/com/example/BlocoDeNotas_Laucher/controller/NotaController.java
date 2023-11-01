package com.example.BlocoDeNotas_Laucher.controller;

import android.content.Context;

import com.example.BlocoDeNotas_Laucher.modelo.Nota;
import com.example.BlocoDeNotas_Laucher.modelo.NotaDAO;

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
