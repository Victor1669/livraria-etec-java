package com.victor1669.models;

/**
 *
 * @author Victor1669
 */
public class PagamentoModel {

    private int id;
    private int id_funcionario;
    private int valorTotal;

    public PagamentoModel(int id, int id_funcionario, int valorTotal) {
        this.id = id;
        this.id_funcionario = id_funcionario;
        this.valorTotal = valorTotal;
    }

    public PagamentoModel() {
    }

    // ==================== GETTERS E SETTERS ====================
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }
}
