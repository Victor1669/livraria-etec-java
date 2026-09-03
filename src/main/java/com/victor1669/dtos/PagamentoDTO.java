package com.victor1669.dtos;

public class PagamentoDTO {

    private int id;
    private String nomeFuncionario;
    private double totalPago;
    private String dataTransacao;

    public PagamentoDTO(int id, String nomeFuncionario, double totalPago, String dataTransacao) {
        this.id = id;
        this.nomeFuncionario = nomeFuncionario;
        this.totalPago = totalPago;
        this.dataTransacao = dataTransacao;
    }

    public PagamentoDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public double getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(double totalPago) {
        this.totalPago = totalPago;
    }

    public String getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(String dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

}
