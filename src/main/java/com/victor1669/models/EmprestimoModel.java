package com.victor1669.models;

public class EmprestimoModel {

    protected int id;
    protected int id_usuario;
    protected String nome_livro;

    public EmprestimoModel(int id, int id_usuario, String nome_livro) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.nome_livro = nome_livro;
    }

    public EmprestimoModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_livro() {
        return nome_livro;
    }

    public void setNome_livro(String nome_livro) {
        this.nome_livro = nome_livro;
    }

}
