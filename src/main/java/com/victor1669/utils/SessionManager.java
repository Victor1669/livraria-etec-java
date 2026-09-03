package com.victor1669.utils;

import com.victor1669.dtos.UsuarioDTO;
import com.victor1669.services.UsuarioService;

public class SessionManager {

    public static UsuarioDTO User;

    public static void buscarDadosUser() {
        // Busca dos dados do usuário logado
        UsuarioService us = new UsuarioService();
        Long userId = SessionManager.getUserIdLogado();
        UsuarioDTO user = us.getUserDTO((int) userId.longValue());
        SessionManager.User = user;
    }

    public static boolean isLogado() {
        String token = getToken();
        return token != null && JwtUtils.isTokenValido(token);
    }

    public static Long getUserIdLogado() {
        String token = LocalStorage.get("token");
        return JwtUtils.getUserId(token);
    }

    public static String getToken() {
        return LocalStorage.get("token");
    }

    public static void logout() {
        LocalStorage.delete("token");
    }

    public static boolean verificarSessao() {
        if (isLogado()) {
            return true;
        }

        String token = getToken();

        if (token != null) {
            logout();
        }

        return false;
    }
}
