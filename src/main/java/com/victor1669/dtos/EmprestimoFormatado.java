package com.victor1669.dtos;

public class EmprestimoFormatado {

    private int id;
    private String nomeUsuario;
    private String nomeLivro;
    private String dataEmprestimo;

    public EmprestimoFormatado() {
    }

    public EmprestimoFormatado(int id, String nomeUsuario, String nomeLivro, String dataEmprestimo) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.nomeLivro = nomeLivro;
        this.dataEmprestimo = dataEmprestimo;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
}
