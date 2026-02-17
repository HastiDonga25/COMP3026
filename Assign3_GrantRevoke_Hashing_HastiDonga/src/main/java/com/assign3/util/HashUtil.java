package com.assign3.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class HashUtil {

    // algo = "SHA-256" or "SHA-512"
    public static String hash(String input, String algo) {
        try {
            MessageDigest md = MessageDigest.getInstance(algo);
            byte[] hashed = md.digest(input.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            for (byte b : hashed) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString(); // hex string
        } catch (Exception e) {
            throw new RuntimeException("Hashing failed: " + e.getMessage(), e);
        }
    }
}
