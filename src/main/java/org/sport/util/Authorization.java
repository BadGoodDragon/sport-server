package org.sport.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.SecureRandom;
import java.util.Base64;


public class Authorization {

    public static String generateToken(int length) {
        // Создаем массив байт для хранения случайных данных
        byte[] randomBytes = new byte[length];
        // Используем SecureRandom для генерации случайных байтов
        new SecureRandom().nextBytes(randomBytes);
        // Кодируем полученные байты в строку Base64
        return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
    }

    public static String parseBasicUsername(String data) {

        String base64Credentials = data.substring("Basic ".length()).trim();
        String credentials = new String(Base64.getDecoder().decode(base64Credentials));
        String[] values = credentials.split(":", 2);
        return values[0];
    }

    public static String parseBasicPassword(String data) {

        String base64Credentials = data.substring("Basic ".length()).trim();
        String credentials = new String(Base64.getDecoder().decode(base64Credentials));
        String[] values = credentials.split(":", 2);
        return values[1];
    }

    public static String parseBearer(String data) {

        return data.substring("Bearer ".length()).trim();
    }
}
