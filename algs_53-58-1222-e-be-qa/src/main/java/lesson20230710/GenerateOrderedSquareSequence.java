package lesson20230710;

import java.util.Arrays;

public class GenerateOrderedSquareSequence {

// Возвести в квадрат отсортированный массив.
// Результирующий массив тоже должен быть отсортирован

    public static void main(String[] args) {
        int[] input = new int[] {-5, -1, 0, 1, 3, 6, 8};
        generateOrderedSquareSequence(input);
    }

    public static void generateOrderedSquareSequence(int[] input) {
        int[] output = new int[input.length];
        int left = 0;
        int right = input.length - 1;
        int k = input.length - 1;

        while (left <= right){
            if (input[left] * input[left] >= input[right] * input[right]){
                output[k] = input[left] * input[left];
                left++;
            } else {
                output[k] = input[right] * input[right];
                right--;
            }
            k--;
        }

        System.out.println(Arrays.toString(output));
    }

}
