import intae.PasswordStrength;
import intae.PasswordStrengthMeter;
import org.junit.jupiter.api.Test;

import static intae.PasswordStrength.*;
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

    private void assertStrength(String password, PasswordStrength expStr) {
        PasswordStrength result = meter.meter(password);

        assertThat(result).isEqualTo(expStr);
    }
}
