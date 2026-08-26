package com.victor1669.utils;

import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtils {

    private static final String SECRET = Dotenv.load().get("JWT_SECRET");
    private static final SecretKey KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    private static final long EXPIRATION_MS = 8 * 60 * 60 * 1000;

    public static String gerarToken(Long userId, String nome) {
        Date agora = new Date();
        Date expiracao = new Date(agora.getTime() + EXPIRATION_MS);

        return Jwts.builder()
                .subject(String.valueOf(userId))
                .claim("nome", nome)
                .issuedAt(agora)
                .expiration(expiracao)
                .signWith(KEY)
                .compact();
    }

    public static Claims validarToken(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(KEY)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (JwtException | IllegalArgumentException e) {
            return null;
        }
    }

    public static boolean isTokenValido(String token) {
        return validarToken(token) != null;
    }

    public static Long getUserId(String token) {
        Claims claims = validarToken(token);
        return claims != null ? Long.valueOf(claims.getSubject()) : null;
    }

    public static String getNome(String token) {
        Claims claims = validarToken(token);
        return claims != null ? claims.get("nome", String.class) : null;
    }
}