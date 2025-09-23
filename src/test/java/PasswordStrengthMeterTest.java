import intae.PasswordStrength;
import intae.PasswordStrengthMeter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordStrengthMeterTest {

    @Test
    void meetsAllCriteria_Then_Strong() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@AB");

        assertThat(result).isEqualTo(PasswordStrength.STRONG);
    }

    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@A");

        assertThat(result).isEqualTo(PasswordStrength.NORMAL);

        PasswordStrength result2 = meter.meter("Ab12!c");
        assertThat(result2).isEqualTo(PasswordStrength.NORMAL);
    }

    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal2() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab!@ABqwer");

        assertThat(result).isEqualTo(PasswordStrength.NORMAL);
    }
}
