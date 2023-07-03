package lesson20230703;

import java.util.Arrays;
import java.util.Collections;

public class SortExamples {

    public static void main(String[] args) {
        Collections.sort(Arrays.asList(1, 3, 2)); // merge sort - stable

        Arrays.sort(new int[]{1, 3, 3}); // quick sort - unstable

        Arrays.sort(new String[]{"A", "C", "B"}); // merge sort - stable
    }


}
