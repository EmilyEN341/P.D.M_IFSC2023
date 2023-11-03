package com.example.BlocoDeNotas_Laucher.modelo;

public class Nota {
    private Integer id;
    private String titulo;
    private String texto;

    public Nota(Integer id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
