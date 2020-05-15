package org.kilocraft.kilocord;

import io.github.cdimascio.dotenv.Dotenv;

public class envHandler {
    private static final Dotenv dotenv = Dotenv.load();

    public static String get(String envKey) {
        return dotenv.get(envKey.toUpperCase());
    }
}
