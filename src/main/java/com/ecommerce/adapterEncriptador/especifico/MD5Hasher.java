package com.ecommerce.adapterEncriptador.especifico;
import com.ecommerce.adapterEncriptador.adapter.HashAdapter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Hasher implements HashAdapter {
    @Override
    public String hash(String input) {
        try {
            // Obtém uma instância do MessageDigest para MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");

            // Converte a string de entrada em bytes
            byte[] encodedhash = digest.digest(input.getBytes("UTF-8"));

            // Converte o hash em uma string hexadecimal
            return bytesToHex(encodedhash);
        } catch (NoSuchAlgorithmException | java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
