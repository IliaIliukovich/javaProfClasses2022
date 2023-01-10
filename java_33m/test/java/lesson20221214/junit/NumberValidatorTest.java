package lesson20221214.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberValidatorTest {

    @Test
    public void isValidAccountNumber() {

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

    @Test
    public void isValidAccountNumber2() {

        NumberValidator validator = new NumberValidator();
        assertFalse(validator.regexIsValidAccountNumber(null));
        assertFalse(validator.regexIsValidAccountNumber(""));
        assertFalse(validator.regexIsValidAccountNumber("   "));
        assertFalse(validator.regexIsValidAccountNumber("123qwe"));
        assertFalse(validator.regexIsValidAccountNumber("qqq"));
        assertFalse(validator.regexIsValidAccountNumber("1234567891234q"));
        assertFalse(validator.regexIsValidAccountNumber("1234567891234-"));
        assertFalse(validator.regexIsValidAccountNumber("12345@67891234"));
        assertFalse(validator.regexIsValidAccountNumber("00000000000000"));
        assertTrue(validator.regexIsValidAccountNumber("00000000000001"));
        assertTrue(validator.regexIsValidAccountNumber("12340000000001"));

    }
}