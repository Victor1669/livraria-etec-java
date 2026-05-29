package com.victor1669.classes;

public class Livro {

    String titulo;
    String author;
    String editor;
    public static int totalLivrosEmprestados = 0;
    public static final int MAX_LIVROS_POR_USUARIO = 5;

    public Livro(String titulo, String author, String editor) {
        this.titulo = titulo;
        this.author = author;
        this.editor = editor;
    }

    public Livro() {
    }

    public void emprestar() {
        if (totalLivrosEmprestados < MAX_LIVROS_POR_USUARIO) {
            System.out.println("Livro emprestado!");
            totalLivrosEmprestados += 1;
        } else {
            System.out.println("Limite atingido!");
        }
    }

    public void devolver() {
        if (totalLivrosEmprestados > 0) {
            System.out.println("Livro devolvido!");
            totalLivrosEmprestados -= 1;
        } else {
            System.out.println("Livro Não devolvido");
        }
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

}
