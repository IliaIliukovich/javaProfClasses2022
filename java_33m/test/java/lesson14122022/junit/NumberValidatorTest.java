package lesson14122022.junit;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberValidatorTest {

    @Test
    void isValidAccountNumber() {

        NumberValidator validator = new NumberValidator();
        assertFalse(validator.isValidAccountNumber(null));
        assertFalse(validator.isValidAccountNumber(""));
        assertFalse(validator.isValidAccountNumber("   "));
        assertFalse(validator.isValidAccountNumber("123qwe"));
        assertFalse(validator.isValidAccountNumber("qqq"));
        assertFalse(validator.isValidAccountNumber("1234567891234q"));
        assertFalse(validator.isValidAccountNumber("1234567891234-"));
        assertFalse(validator.isValidAccountNumber("12345@67891234"));
        assertFalse(validator.isValidAccountNumber("00000000000000"));
        assertTrue(validator.isValidAccountNumber("00000000000001"));
        assertTrue(validator.isValidAccountNumber("12340000000001"));

//        Assumptions.assumeTrue(validator.isValidAccountNumber(null));

    }
}