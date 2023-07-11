package lesson20230710;

public class FindMaxSubarray {

// Дан массив целых чисел размера n.
// Вычислить максимальную сумму «k» последовательных элементов в массиве.

    public static void main(String[] args) {
//        int[] input = new int[] {1, 45, 2, 10, 23, 3, 1, 0, 20};
        int[] input = new int[] {10, 20, 30, 40};

        findMaxSubarrayBruteForce(input, 2);
        findMaxSubarray(input, 2);

    }

    public static void findMaxSubarrayBruteForce(int[] input, int k) {
        int max = 0;
        for (int j = 0; j < k; j++) {
            max = max + input[j];
        }

        for (int i = 1; i < input.length + 1 - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum = sum + input[j];
            }
            max = Math.max(max, sum);
        }

        System.out.println("Brute force result: " + max);
    }

    public static void findMaxSubarray(int[] input, int k) {
        int max = 0;
        for (int j = 0; j < k; j++) {
            max = max + input[j];
        }
        int sum = max;

        for (int i = 1; i < input.length + 1 - k; i++) {
            sum = sum - input[i - 1] + input[i + k - 1];
            max = Math.max(max, sum);
        }

        System.out.println("Window approach result: " + max);
    }


}
