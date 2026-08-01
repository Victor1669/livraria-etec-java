package com.victor1669.services;

import com.victor1669.classes.Bibliotecario;
import com.victor1669.classes.Gerente;
import com.victor1669.models.FuncionarioModel;

/**
 *
 * @author Victor1669
 */
public class FuncionarioService {

    public FuncionarioModel criarFuncionario(String nome, String salarioStr, String tipo) {
        if (nome == null || nome.isBlank() || salarioStr == null || tipo.isBlank()) {
            return null;
        }

        try {
            double salario = Double.parseDouble(salarioStr);
            String tipoLimpo = tipo.toLowerCase();

            return tipoLimpo.equals("gerente")
                    ? new Gerente(nome, salario)
                    : new Bibliotecario(nome, salario);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
