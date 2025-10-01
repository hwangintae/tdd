package chapter02;

import intae.chapter02.PasswordStrength;
import intae.chapter02.PasswordStrengthMeter;
import org.junit.jupiter.api.Test;

import static intae.chapter02.PasswordStrength.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PasswordStrengthMeterTest {

    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    @Test
    void meetsAllCriteria_Then_Strong() {
        assertStrength("ab12!@AB", STRONG);
    }

    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
        assertStrength("ab12!@A", NORMAL);

        assertStrength("Ab12!c", NORMAL);
    }

    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal2() {
        assertStrength("ab!@ABqwer", NORMAL);
    }

    @Test
    void nullInput_Then_Invalid() {
        assertStrength(null, INVALID);
    }

    @Test
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal() {
        assertStrength("ab12!@df", NORMAL);
    }

    @Test
    void meetsOnlyLengthCriteria_Then_Weak() {
        assertStrength("abdefghi", WEAK);
    }

    @Test
    void meetsOnlyNumCriteria_Then_Weak() {
        assertStrength("12345", WEAK);
    }

    @Test
    void meetsOnlyUpperCriteria_Then_Weak() {
        assertStrength("ABZEF", PasswordStrength.WEAK);
    }

    @Test
    void meetsNoCriteria_Then_Weak() {
        assertStrength("abc", WEAK);
    }

    private void assertStrength(String password, PasswordStrength expStr) {
        PasswordStrength result = meter.meter(password);

        assertThat(result).isEqualTo(expStr);
    }
}
