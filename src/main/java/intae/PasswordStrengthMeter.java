package intae;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String password) {
        int metCounts = 0;

        if (password == null || password.isEmpty()) return PasswordStrength.INVALID;

        boolean lengthEnough = password.length() >= 8;
        boolean containUpp = meetsContainingUppercaseCriteria(password);
        boolean containsNum = meetsContainingNumberCriteria(password);

        if (lengthEnough) metCounts++;
        if (containUpp) metCounts++;
        if (containsNum) metCounts++;

        if (metCounts == 1) return PasswordStrength.WEAK;
        if (metCounts == 2) return PasswordStrength.NORMAL;

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
