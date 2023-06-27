package lesson20230626;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] array){
        int[] tmp = new int[array.length];
        int left = 0;
        int right = array.length - 1;
        sort(array, tmp, left, right);
    }

    private static void sort(int[] array, int[] tmp, int left, int right) {
        if (left == right) return;
        int middle = left + (right - left) / 2;
        sort(array, tmp, left, middle);
        sort(array, tmp, middle + 1, right);
        merge(array, tmp, left, middle, right);
    }

    private static void merge(int[] array, int[] tmp, int left, int middle, int right){
        for (int k = left; k <= right; k++) {
            tmp[k] = array[k];
        }

        int i = left;
        int j = middle + 1;

        for (int k = left; k <= right; k++) {
            if (i > middle) array[k] = tmp[j++];
            else if (j > right) array[k] = tmp[i++];
            else if (tmp[i] <= tmp[j]) array[k] = tmp[i++];
            else array[k] = tmp[j++];
        }

    }

    public static void main(String[] args) {
        int[] ints = {10, 2, 30, 4, 5, 600, 7};
        mergeSort(ints);
        System.out.println(Arrays.toString(ints));

    }


}
