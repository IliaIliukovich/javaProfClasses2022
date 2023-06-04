package lesson20230602;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyClassTest {

    private static MyClass myClass;

    @BeforeAll
    public static void init(){
        myClass = new MyClass();
        myClass.setData("test data");
    }

    @Test
    public void myFunctionTest(){
        String result = myClass.myFunction(10);
        assertEquals("Result for test data = 10", result);
        assertThrows(ArithmeticException.class, () -> myClass.myFunction(0));
    }

    @Test
    public void myStreamFunctionTestFilters(){
        List<String> result = myClass.myStreamFunction(Arrays.asList("Jane", "Mary", "Tom"));
        assertEquals(1, result.size());
        assertEquals("Mary", result.get(0));
    }

    @Test
    public void myStreamFunctionTestNullCases() {
        List<String> result = myClass.myStreamFunction(null);
        assertTrue(result.isEmpty());

        assertThrows(NullPointerException.class, () -> myClass.myStreamFunction(Arrays.asList(null)));

        result = myClass.myStreamFunction(Arrays.asList("Jane"));
        assertTrue(result.isEmpty());
        result = myClass.myStreamFunction(Arrays.asList(""));
        assertTrue(result.isEmpty());
        result = myClass.myStreamFunction(Collections.emptyList());
        assertTrue(result.isEmpty());
    }

}
