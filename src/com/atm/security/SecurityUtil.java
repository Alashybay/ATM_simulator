package com.atm.security;

import java.security.MessageDigest;
import java.util.Base64;

public class SecurityUtil {
    public static String hashPin(String pin) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(pin.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            throw new RuntimeException("Error hashing PIN", e);
        }
    }

    public static boolean verifyPin(String pin, String pinHash) {
        String hashedInput = hashPin(pin);
        return hashedInput.equals(pinHash);
    }
}