package com.victor1669.services;

import com.victor1669.services.results.LoginResult;
import com.victor1669.services.results.ValidationResult;
import com.victor1669.conexoes.ConexaoJPA;
import com.victor1669.models.UsuarioModel;
import com.victor1669.utils.LocalStorage;
import jakarta.persistence.NoResultException;

public class UsuarioService extends GenericService<UsuarioModel, Integer> {

    public UsuarioService() {
        super(UsuarioModel.class);
    }

    public ValidationResult cadastrar(UsuarioModel usuario) {
        if (usuario.getNome() == null || usuario.getNome().isBlank()
                || usuario.getSenha() == null || usuario.getSenha().isBlank()) {
            return ValidationResult.INVALID_FIELDS;
        }

        super.create(usuario);
        return ValidationResult.SUCCESS;
    }

    public LoginResult login(String nome, String senha) {
        if (nome == null || nome.isBlank() || senha == null || senha.isBlank()) {
            return LoginResult.INVALID_FIELDS;
        }

        UsuarioModel user = getByNome(nome);

        if (user == null) {
            return LoginResult.USER_NOT_FOUND;
        }

        if (!user.getSenha().equals(senha)) {
            return LoginResult.WRONG_PASSWORD;
        }

        LocalStorage.delete("userName");
        LocalStorage.delete("userId");
        LocalStorage.save("userName", user.getNome());
        LocalStorage.save("userId", String.valueOf(user.getId()));

        return LoginResult.SUCCESS;
    }

    public UsuarioModel getByNome(String nome) {
        try {
            return ConexaoJPA.getInstancia().execute(em
                    -> em.createQuery(
                            "SELECT u FROM UsuarioModel u WHERE u.nome = :nome",
                            UsuarioModel.class)
                            .setParameter("nome", nome)
                            .getSingleResult()
            );
        } catch (NoResultException e) {
            return null;
        }
    }

}
