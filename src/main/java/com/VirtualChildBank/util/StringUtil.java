package com.VirtualChildBank.util;

public class StringUtil {
    public static boolean PasswordisValid(String password) {
        // Check the length of the password
        if (password == null || password.length() < 5 || password.length() > 9) {
            return false;
        }

        // Check for only letters and digits
        if (!password.matches("[a-zA-Z0-9]+")) {
            return false;
        }

        // Check for at least one letter and one digit
        boolean hasLetter = false;
        boolean hasDigit = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isLetter(c)) {
                hasLetter = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if (hasLetter && hasDigit) {
                return true;
            }
        }

        return false;
    }

    public static boolean accountIdisValid(String accountId) {
        if (accountId == null || accountId.length() != 16) {
            return false;
        }
        return true;
    }
}
