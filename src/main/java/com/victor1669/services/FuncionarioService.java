package com.victor1669.services;

import com.victor1669.services.results.ValidationResult;
import com.victor1669.conexoes.ConexaoJPA;
import com.victor1669.models.FuncionarioModel;
import java.util.List;

public class FuncionarioService extends GenericService<FuncionarioModel, Integer> {

    public FuncionarioService() {
        super(FuncionarioModel.class);
    }

    public ValidationResult cadastrar(FuncionarioModel funcionario) {
        String nome = funcionario.getNome();
        Double salario = funcionario.getSalario();

        if (nome == null || nome.isBlank() || salario == null || salario <= 0) {
            return ValidationResult.INVALID_FIELDS;
        }

        super.create(funcionario);
        return ValidationResult.SUCCESS;
    }

    public List<FuncionarioModel> listarPorTipo(String tipo) {
        return ConexaoJPA.getInstancia().execute(em
                -> em.createQuery(
                        "SELECT f FROM FuncionarioModel f WHERE TYPE(f) = :tipo",
                        FuncionarioModel.class)
                        .setParameter("tipo", tipo)
                        .getResultList()
        );
    }
}
