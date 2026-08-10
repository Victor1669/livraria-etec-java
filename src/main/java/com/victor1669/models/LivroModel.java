package com.victor1669.models;

public class LivroModel {

    protected int id;
    protected String nome;
    protected String autor;
    protected int quantidade;

    public LivroModel(int id, String nome, String autor, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.quantidade = quantidade;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
