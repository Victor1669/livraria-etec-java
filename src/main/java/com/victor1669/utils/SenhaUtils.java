package com.victor1669.utils;

import org.mindrot.jbcrypt.BCrypt;

public class SenhaUtils {

    public static String criptografar(String senhaPura) {
        return BCrypt.hashpw(senhaPura, BCrypt.gensalt());
    }

    public static boolean verificar(String senhaPura, String senhaCriptografada) {
        return BCrypt.checkpw(senhaPura, senhaCriptografada);
    }
}
