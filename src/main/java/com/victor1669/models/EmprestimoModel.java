package com.victor1669.models;

public class EmprestimoModel {

    protected int id;
    protected int id_usuario;
    protected int id_livro;
    protected String data_emprestimo;

    public EmprestimoModel(int id, int id_usuario, int id_livro, String data_emprestimo) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.id_livro = id_livro;
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

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }

    public String getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(String data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    @Override
    public String toString() {
        return "EmprestimoModel{" + "id=" + id + ", id_usuario=" + id_usuario + ", id_livro=" + id_livro + ", data_emprestimo=" + data_emprestimo + '}';
    }

}
