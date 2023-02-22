package lesson20230220.junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTaskTest {

    @Test
    void findCommon() {
        int[] a = new int[]{1, 2, 5, 5, 8, 9, 7, 10};
        int[] b = new int[]{1, 0, 6, 15, 6, 4, 7, 0};
        ArrayTask task = new ArrayTask();
        int[] common = task.findCommon(a, b);
//        assertTrue(Arrays.stream(common).anyMatch(value -> value == 1));
//        assertTrue(Arrays.stream(common).anyMatch(value -> value == 7));
        assertEquals(common[0], 1);
        assertEquals(common[1], 7);

    }
}