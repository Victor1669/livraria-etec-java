package com.victor1669.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pagamentos")
public class PagamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_funcionario", nullable = false)
    private Integer idFuncionario;

    @Column(name = "totalPago", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double valorTotal;

    public PagamentoModel() {
    }

    public PagamentoModel(int id, int idFuncionario, Double valorTotal) {
        this.id = id;
        this.idFuncionario = idFuncionario;
        this.valorTotal = valorTotal;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
