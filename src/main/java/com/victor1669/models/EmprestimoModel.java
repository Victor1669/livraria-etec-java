package com.victor1669.models;

public class EmprestimoModel {

    protected int id;
    protected String nome_usuario;
    protected String nome_livro;
    protected String data_emprestimo;

    public EmprestimoModel(int id, String nome_usuario, String nome_livro, String data_emprestimo) {
        this.id = id;
        this.nome_usuario = nome_usuario;
        this.nome_livro = nome_livro;
        this.data_emprestimo = data_emprestimo;
    }

    public EmprestimoModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getNome_livro() {
        return nome_livro;
    }

    public void setNome_livro(String nome_livro) {
        this.nome_livro = nome_livro;
    }

    public String getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(String data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    @Override
    public String toString() {
        return "EmprestimoModel{" + "id=" + id + ", nome_usuario=" + nome_usuario + ", nome_livro=" + nome_livro + ", data_emprestimo=" + data_emprestimo + '}';
    }

}
