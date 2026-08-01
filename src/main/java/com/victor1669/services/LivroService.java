package com.victor1669.services;

import com.victor1669.models.LivroModel;

/**
 *
 * @author Victor1669
 */
public class LivroService {

    public LivroModel criarLivro(String nome, String autor) {
        if (nome == null || nome.isBlank() || autor == null || autor.isBlank()) {
            return null;
        }

        return new LivroModel(nome, autor);
    }
}
