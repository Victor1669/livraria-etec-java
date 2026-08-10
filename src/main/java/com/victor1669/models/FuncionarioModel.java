package com.victor1669.models;

import com.victor1669.interfaces.IPagamento;
import jakarta.persistence.*;

@Entity
@Table(name = "funcionarios")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "tipoFuncionario",
        discriminatorType = DiscriminatorType.STRING,
        columnDefinition = "enum('bibliotecario','gerente')"
)
public abstract class FuncionarioModel implements IPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(nullable = false, length = 150)
    protected String nome;

    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
    protected Double salario;

    @Column(name = "tipoFuncionario", insertable = false, updatable = false)
    protected String tipoFuncionario;

    public FuncionarioModel() {
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(String tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    @Override
    public String toString() {
        return "["
                + "id=\"" + id
                + "\", nome=\"" + nome
                + "\", salario=\"" + salario
                + "\", tipoFuncionario=\"" + tipoFuncionario
                + "\"]";
    }
}
