package intae;

public class PasswordStrengthMeter {

    public PasswordStrength meter(String password) {
        if (password.length() < 8) {
            return PasswordStrength.NORMAL;
        }

        boolean containsNum = false;
        for (char ch : password.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                containsNum = true;
                break;
            }
        }
        if (!containsNum) return PasswordStrength.NORMAL;

        return PasswordStrength.STRONG;
    }
}
