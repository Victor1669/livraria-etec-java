package com.victor1669.classes;

import com.victor1669.interfaces.IPagamento;

/**
 * 
 * @author Victor1669
 * 
 * Regra de negócio:
 * 
 * - Cada funcionário deve ter nome, salário e seu tipo;
 * - O bônus salarial deve ser relativo ao salário, tendo a variável FATOR_BONUS para calcular ele
 * - Esta classe deve implementar IPagamento para a realização do pagamento com o bônus
 * 
 */
public abstract class Funcionario implements IPagamento {

    protected String nome;
    protected double salario;
    protected String tipoFuncionario;
    
    protected double bonus;
    protected double FATOR_BONUS = 0;

    public double calcularBonus() {
        bonus = getSalario() * FATOR_BONUS;

        return bonus;
    }

    // ==================== GETTERS E SETTERS ====================
    public void setFATOR_BONUS(double FATOR_BONUS) {
        this.FATOR_BONUS = FATOR_BONUS;
    }

    public String getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(String tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
