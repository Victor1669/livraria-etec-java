package com.victor1669.models;

public class LivroModel {

    protected int id;
    protected String nome;
    protected String autor;

    public LivroModel(int id, String titulo, String author) {
        this.id = id;
        this.nome = titulo;
        this.autor = author;
    }

    public LivroModel() {
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
