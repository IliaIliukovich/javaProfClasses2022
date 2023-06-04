package lesson20230602;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountCheckerTest {

    @Test
    public void isValidAccountNumber() {
        AccountChecker checker = new AccountChecker();
        assertTrue(checker.isValidAccountNumber("11111111111111"));
        assertFalse(checker.isValidAccountNumber("1111111111111"));
        assertFalse(checker.isValidAccountNumber("111111111111111"));
    }

}