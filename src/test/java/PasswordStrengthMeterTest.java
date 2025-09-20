import intae.PasswordStrength;
import intae.PasswordStrengthMeter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordStrengthMeterTest {

    @Test
    void meetsAllCriteria_Then_Strong() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@AB");

        assertThat(result).isEqualTo(PasswordStrength.STRONG);
    }
}
