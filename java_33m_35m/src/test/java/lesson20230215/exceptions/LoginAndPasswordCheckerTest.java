package lesson20230215.exceptions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


public class LoginAndPasswordCheckerTest {

    private static LoginAndPasswordChecker checker;

    @BeforeAll
    public static void init() {
        checker = new LoginAndPasswordChecker();
    }

    @Test
    public void testLogin() {
        assertTrue(checker.checkLoginAndPassword("123", "123", "123"));
        assertTrue(checker.checkLoginAndPassword("qwe", "123", "123"));
        assertTrue(checker.checkLoginAndPassword("qweQQQ123_", "123", "123"));
        assertFalse(checker.checkLoginAndPassword("123@", "123", "123"));
        assertFalse(checker.checkLoginAndPassword("12311111111111111111", "123", "123"));
        assertFalse(checker.checkLoginAndPassword("", "123", "123"));
        assertThrows(NullPointerException.class, () -> checker.checkLoginAndPassword(null, "123", "123"));
    }

    @Test
    @Disabled
    public void testPassword() {
        assertTrue(checker.checkLoginAndPassword("test", "test", "test"));
        assertTrue(checker.checkLoginAndPassword("test", "123", "123"));
        assertTrue(checker.checkLoginAndPassword("test", "test_TT123", "test_TT123"));
        assertFalse(checker.checkLoginAndPassword("test", "-", "-"));
        assertFalse(checker.checkLoginAndPassword("test", "qqqqqqqqqqqqqqqqqqqq", "qqqqqqqqqqqqqqqqqqqq"));
        assertFalse(checker.checkLoginAndPassword("test", "test", "test1"));
        assertFalse(checker.checkLoginAndPassword("test", "", ""));
        assertThrows(NullPointerException.class, () -> checker.checkLoginAndPassword("test", null, "test1"));
        assertThrows(NullPointerException.class, () -> checker.checkLoginAndPassword("test", "123", null));
        assertThrows(NullPointerException.class, () -> checker.checkLoginAndPassword("test", null, null));
        assertThrows(NullPointerException.class, () -> checker.checkLoginAndPassword(null, null, null));

        assertTimeout(Duration.ofNanos(1), () -> checker.checkLoginAndPassword("123", "123", "123"));

    }

}