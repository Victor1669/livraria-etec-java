package com.victor1669.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagamentos")
public class PagamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "idFuncionario", nullable = false)
    private Integer idFuncionario;

    @Column(name = "totalPago", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double totalPago;

    @Column(name = "dataTransacao")
    private LocalDateTime dataTransacao;

    public PagamentoModel() {
    }

    public PagamentoModel(int id, int idFuncionario, Double totalPago, LocalDateTime dataTransacao) {
        this.id = id;
        this.idFuncionario = idFuncionario;
        this.totalPago = totalPago;
        this.dataTransacao = dataTransacao;
    }

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

    public Double getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(Double totalPago) {
        this.totalPago = totalPago;
    }

    public LocalDateTime getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDateTime dataTransacao) {
        this.dataTransacao = dataTransacao;
    }
}
