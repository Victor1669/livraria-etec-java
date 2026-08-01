package com.victor1669.models;

import com.victor1669.interfaces.IPagamento;
import java.util.Objects;

/**
 *
 * @author Victor1669
 *
 * Regra de negócio:
 *
 * - Cada funcionário deve ter nome, salário e seu tipo; - O bônus salarial deve
 * ser relativo ao salário, tendo a variável FATOR_BONUS para calcular ele -
 * Esta classe deve implementar IPagamento para a realização do pagamento com o
 * bônus
 *
 */
public abstract class FuncionarioModel implements IPagamento {

    protected int id;

    protected String nome;
    protected double salario;
    protected String tipoFuncionario;

    protected double bonus;
    protected double FATOR_BONUS = 0;

    public double calcularBonus() {
        bonus = getSalario() * FATOR_BONUS;

        return bonus;
    }

    @Override
    public String toString() {
        return "["
                + "id=\"" + id
                + "\", nome=\"" + nome
                + "\", salario=\"" + salario
                + "\", tipoFuncionario=\"" + tipoFuncionario
                + "\", bonus=\"" + bonus
                + "\", FATOR_BONUS=\"" + FATOR_BONUS
                + "\"]";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FuncionarioModel other = (FuncionarioModel) obj;
        if (Double.doubleToLongBits(this.salario) != Double.doubleToLongBits(other.salario)) {
            return false;
        }
        if (Double.doubleToLongBits(this.bonus) != Double.doubleToLongBits(other.bonus)) {
            return false;
        }
        if (Double.doubleToLongBits(this.FATOR_BONUS) != Double.doubleToLongBits(other.FATOR_BONUS)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.tipoFuncionario, other.tipoFuncionario);
    }

    // ==================== GETTERS E SETTERS ====================
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
