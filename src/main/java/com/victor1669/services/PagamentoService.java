package com.victor1669.services;

import com.victor1669.services.results.ValidationResult;
import com.victor1669.conexoes.ConexaoJPA;
import com.victor1669.models.PagamentoModel;
import java.util.List;

public class PagamentoService extends GenericService<PagamentoModel, Integer> {

    public PagamentoService() {
        super(PagamentoModel.class);
    }

    public ValidationResult cadastrar(PagamentoModel pagamento) {
        if (pagamento.getIdFuncionario() == null || pagamento.getIdFuncionario() <= 0
                || pagamento.getValorTotal() == null || pagamento.getValorTotal() < 0) {
            return ValidationResult.INVALID_FIELDS;
        }

        super.create(pagamento);
        return ValidationResult.SUCCESS;
    }

    public List<PagamentoModel> listarPorFuncionario(Integer idFuncionario) {
        return ConexaoJPA.getInstancia().execute(em
                -> em.createQuery(
                        "SELECT p FROM PagamentoModel p WHERE p.idFuncionario = :idFuncionario",
                        PagamentoModel.class)
                        .setParameter("idFuncionario", idFuncionario)
                        .getResultList()
        );
    }
}
