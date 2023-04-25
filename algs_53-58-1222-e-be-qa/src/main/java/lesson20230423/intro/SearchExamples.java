package lesson20230423.intro;

import java.util.Arrays;

public class SearchExamples {

    public static void main(String[] args) {

        int[] ints = new int[]{1, 2, 4, 7, 1, 8, 4, 0};

        int key = 7;
        int index = searchSequentially(ints, key);
        System.out.println("Index = " + index);

        index = binarySearch(ints, key);
        System.out.println("Index = " + index);
        System.out.println("Sorted array: " + Arrays.toString(ints));
    }

    private static int binarySearch(int[] ints, int key) {
        Arrays.sort(ints); // we can use binarySearch only with ordered array
        int start = 0;
        int end = ints.length - 1;
        int current = end / 2;

        while (start <= end){
            if (ints[current] == key) return current;
            if (ints[current] > key) end = current - 1;
            if (ints[current] < key) start = current + 1;
            current = start + (end - start) / 2;
        }

        return -1;
    }

    private static int searchSequentially(int[] ints, int key) {
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == key) return i;
        }
        return -1;
    }

}
