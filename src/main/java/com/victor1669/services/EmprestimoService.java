package com.victor1669.services;

import com.victor1669.services.results.ValidationResult;
import com.victor1669.conexoes.ConexaoJPA;
import com.victor1669.dtos.EmprestimoFormatado;
import com.victor1669.models.EmprestimoModel;
import java.util.List;

public class EmprestimoService extends GenericService<EmprestimoModel, Integer> {

    public EmprestimoService() {
        super(EmprestimoModel.class);
    }

    public ValidationResult cadastrar(EmprestimoModel emprestimo) {
        Integer idUsuario = emprestimo.getIdUsuario();
        Integer idLivro = emprestimo.getIdLivro();

        if (idUsuario == null || idUsuario <= 0 || idLivro == null || idLivro <= 0) {
            return ValidationResult.INVALID_FIELDS;
        }

        LivroService livroService = new LivroService();
        ValidationResult resultadoEmprestimo = livroService.emprestarLivro(idLivro);

        if (resultadoEmprestimo == ValidationResult.INVALID_FIELDS) {
            return ValidationResult.INVALID_FIELDS;
        }

        try {
            super.create(emprestimo);
            return ValidationResult.SUCCESS;
        } catch (Exception e) {
            livroService.devolverLivro(idLivro);
            throw new RuntimeException("Erro ao criar empréstimo", e);
        }
    }

    @Override
    public void delete(Integer id) {
        EmprestimoModel emprestimo = getById(id);
        if (emprestimo == null) {
            return;
        }

        Integer idLivro = emprestimo.getIdLivro();
        super.delete(id);
        new LivroService().devolverLivro(idLivro);
    }

    public List<EmprestimoFormatado> getAllEmprestimos(String nome) {
        return ConexaoJPA.getInstancia().execute(em -> {
            String jpql = """
                            SELECT NEW com.victor1669.dtos.EmprestimoFormatado(
                                e.id,
                                u.nome,
                                l.nome,
                                CAST(e.dataEmprestimo AS string)
                            )
                            FROM EmprestimoModel e
                            JOIN UsuarioModel u ON e.idUsuario = u.id
                            JOIN LivroModel l ON e.idLivro = l.id
                            WHERE (:nome IS NULL OR :nome = '' OR u.nome = :nome)
                            """;

            return em.createQuery(jpql, EmprestimoFormatado.class)
                    .setParameter("nome", nome)
                    .getResultList();
        });
    }
}
