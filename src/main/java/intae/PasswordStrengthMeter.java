package intae;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String password) {
        if (password == null || password.isEmpty()) return PasswordStrength.INVALID;

        boolean lengthEnough = password.length() >= 8;
        boolean containUpp = meetsContainingUppercaseCriteria(password);
        boolean containsNum = meetsContainingNumberCriteria(password);

        if (lengthEnough && !containUpp && !containsNum) return PasswordStrength.WEAK;
        if (!lengthEnough && !containUpp && containsNum) return PasswordStrength.WEAK;

        if (!lengthEnough) return PasswordStrength.NORMAL;
        if (!containUpp) return PasswordStrength.NORMAL;
        if (!containsNum) return PasswordStrength.NORMAL;

        return PasswordStrength.STRONG;
    }

    private boolean meetsContainingNumberCriteria(String password) {
        for (char ch : password.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }

        return false;
    }

    private boolean meetsContainingUppercaseCriteria(String password) {
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }

        return false;
    }
}
