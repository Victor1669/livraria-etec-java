package com.victor1669.utils;

public class SessionManager {

    public static boolean isLogado() {
        String token = LocalStorage.get("token");
        return token != null && JwtUtils.isTokenValido(token);
    }

    public static Long getUserIdLogado() {
        String token = LocalStorage.get("token");
        return JwtUtils.getUserId(token);
    }

    public static String getNomeLogado() {
        String token = LocalStorage.get("token");
        return JwtUtils.getNome(token);
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

        String token = LocalStorage.get("token");
        if (token != null) {
            logout();
        }

        return false;
    }
}
