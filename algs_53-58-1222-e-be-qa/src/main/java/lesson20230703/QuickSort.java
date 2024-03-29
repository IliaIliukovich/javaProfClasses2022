package lesson20230703;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void quickSort(Comparable[] array){
        shuffle(array);
        sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, int start, int end) {
        if (start >= end) return;
        int j = split(array, start, end);
        sort(array, start, j - 1);
        sort(array, j + 1, end);
    }

    private static int split(Comparable[] array, int start, int end) {
        Comparable base = array[start];
        int i = start;
        int j = end + 1;
        while (true){
            while (array[++i].compareTo(base) < 0) {
                if (i == end) break;
            }

            while (array[--j].compareTo(base) > 0) {
                if (j == start) break;
            }

            if (i >= j) break;
            Comparable tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }

        Comparable tmp = array[j];
        array[j] = array[start];
        array[start] = tmp;
        return j;
    }


    private static void shuffle(Comparable[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int j = random.nextInt(i + 1);
            Comparable tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Integer[] ints = {5, 2, 0, 4, 5};
//        quickSort(ints);
//        System.out.println(Arrays.toString(ints));
        System.out.println(findSmallestBruteForce(ints, 4));
        System.out.println(findSmallest(ints, 4));
    }


    public static Comparable findSmallestBruteForce(Comparable[] array, int k){
        quickSort(array);
        return array[k];
    }

    public static Comparable findSmallest(Comparable[] array, int k){
        shuffle(array);
        return findSmallest(array, 0, array.length - 1, k);
    }

    private static Comparable findSmallest(Comparable[] array, int start, int end, int k) {
        if (start >= end) return array[start];

        int j = split(array, start, end);
        if (j == k) return array[k];
        else if (k < j) return findSmallest(array, start, j - 1, k);
        else return findSmallest(array, j + 1, end, k);
    }






}
