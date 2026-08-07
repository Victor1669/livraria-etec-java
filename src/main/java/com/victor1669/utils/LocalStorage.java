package com.victor1669.utils;

import java.util.prefs.Preferences;

public class LocalStorage {

    public static void save(String chave, String valor) {
        Preferences prefs = Preferences.userNodeForPackage(LocalStorage.class);

        prefs.put(chave, valor);
    }

    public static String get(String chave) {
        Preferences prefs = Preferences.userNodeForPackage(LocalStorage.class);

        String value = prefs.get(chave, "");

        return value;
    }

    public static void delete(String chave) {
        Preferences prefs = Preferences.userNodeForPackage(LocalStorage.class);

        prefs.remove(chave);
    }
}
