package lesson14122022.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringBuilderFunctionsTest {

    @Test
    void testGenerateReversedString() {
        new StringBuilderFunctions().genarateReversedString("abc", "cde");
        // some code to test
    }

}