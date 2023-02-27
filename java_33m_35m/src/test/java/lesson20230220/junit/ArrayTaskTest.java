package lesson20230220.junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTaskTest {

    @Test
    void findCommon() {
        Integer[] a = new Integer[]{1, 2, 5, 5, 8, 9, 7, 10};
        Integer[] b = new Integer[]{1, 0, 6, 15, 6, 4, 7, 0};
        ArrayTask task = new ArrayTask();
        Integer[] common = task.findCommon(a, b);
//        assertTrue(Arrays.stream(common).anyMatch(value -> value == 1));
//        assertTrue(Arrays.stream(common).anyMatch(value -> value == 7));
        assertEquals(1, common[0]);
        assertEquals(7, common[1]);

        a = new Integer[]{1, 1, 1, 1, 1};
        b = new Integer[]{0, 0, 2};
        common = task.findCommon(a, b);
        assertEquals(0, common.length);

        a = null;
        b = new Integer[]{0, 0, 2};
        common = task.findCommon(a, b);
        assertEquals(0, common.length);

    }
}