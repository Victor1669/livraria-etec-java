package com.victor1669.services;

import com.victor1669.services.results.ValidationResult;
import com.victor1669.conexoes.ConexaoJPA;
import com.victor1669.dtos.PagamentoFormatado;
import com.victor1669.models.PagamentoModel;
import java.time.LocalDateTime;
import java.util.List;

public class PagamentoService extends GenericService<PagamentoModel, Integer> {

    public PagamentoService() {
        super(PagamentoModel.class);
    }

    public ValidationResult cadastrar(PagamentoModel pagamento) {
        if (pagamento.getIdFuncionario() == null || pagamento.getIdFuncionario() <= 0
                || pagamento.getTotalPago() == null || pagamento.getTotalPago() < 0) {
            return ValidationResult.INVALID_FIELDS;
        }

        if (pagamento.getDataTransacao() == null) {
            pagamento.setDataTransacao(LocalDateTime.now());
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

    public List<PagamentoFormatado> getAllPagamentos() {
        return ConexaoJPA.getInstancia().execute(em -> {
            String jpql = """
                            SELECT NEW com.victor1669.dtos.PagamentoFormatado(
                                p.id,
                                f.nome,
                                p.totalPago,
                                CAST(p.dataTransacao AS string)
                            )
                            FROM PagamentoModel p
                            JOIN FuncionarioModel f ON p.idFuncionario = f.id
                            """;

            return em.createQuery(jpql, PagamentoFormatado.class)
                    .getResultList();
        });
    }
}
