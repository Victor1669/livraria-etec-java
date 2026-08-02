package com.victor1669.ui;

/**
 *
 * @author Victor1669
 */
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
