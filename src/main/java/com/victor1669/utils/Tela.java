package com.victor1669.utils;

public enum Tela {
    INICIAL("TELA_INICIAL"),
    EMPRESTIMO("EMPRESTIMO"),
    FUNCIONARIO("FUNCIONARIO"),
    LIVROS("LIVROS"),
    PAGAMENTO("PAGAMENTO"),
    CONSULTA("CONSULTA"),
    ENTRAR_SISTEMA("ENTRAR_SISTEMA");
    
    private final String nome;

    Tela(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}
