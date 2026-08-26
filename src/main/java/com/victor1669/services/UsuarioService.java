package com.victor1669.services;

import com.victor1669.services.results.LoginResult;
import com.victor1669.services.results.ValidationResult;
import com.victor1669.conexoes.ConexaoJPA;
import com.victor1669.models.UsuarioModel;
import com.victor1669.utils.JwtUtils;
import com.victor1669.utils.LocalStorage;
import com.victor1669.utils.SenhaUtils;
import jakarta.persistence.NoResultException;

public class UsuarioService extends GenericService<UsuarioModel, Integer> {

    public UsuarioService() {
        super(UsuarioModel.class);
    }

    public ValidationResult cadastrar(String nome, String senha) {

        if (nome == null || nome.isBlank()
                || senha == null || senha.isBlank()) {
            return ValidationResult.INVALID_FIELDS;
        }

        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(nome);

        String cryptedPassword = SenhaUtils.criptografar(senha);

        usuario.setSenha(cryptedPassword);

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

        if (!SenhaUtils.verificar(senha, user.getSenha())) {
            return LoginResult.WRONG_PASSWORD;
        }

        String token = JwtUtils.gerarToken(Long.valueOf(user.getId()), user.getNome());

        LocalStorage.delete("token");
        LocalStorage.save("token", token);

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
