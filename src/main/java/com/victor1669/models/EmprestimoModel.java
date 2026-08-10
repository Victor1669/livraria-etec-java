package com.victor1669.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "emprestimos")
public class EmprestimoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "idUsuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "idLivro", nullable = false)
    private Integer idLivro;

    @Column(name = "dataEmprestimo", insertable = false, updatable = false)
    private java.time.LocalDateTime dataEmprestimo;

    public EmprestimoModel() {
    }

    public EmprestimoModel(int id, int idUsuario, int idLivro, String dataEmprestimo) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idLivro = idLivro;
        if (dataEmprestimo != null) {
            this.dataEmprestimo = LocalDateTime.parse(dataEmprestimo.replace(" ", "T"));
        }
    }

    public EmprestimoModel(Integer idUsuario, Integer idLivro) {
        this.idUsuario = idUsuario;
        this.idLivro = idLivro;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    @Override
    public String toString() {
        return "EmprestimoModel{id=" + id + ", idUsuario=" + idUsuario
                + ", idLivro=" + idLivro + ", dataEmprestimo=" + dataEmprestimo + '}';
    }
}
