package lesson20230710;

public class FindIfSumIsPresent {

// Дан отсортированный массив arr (отсортированный в порядке возрастания), содержащий n целых чисел,
// найти, существует ли какая-либо пара элементов (arr[i], arr[j]), сумма которых равна X.

    public static void main(String[] args) {
        int[] input = new int[] {1, 2, 5, 5, 9, 10};
        System.out.println(findIfSumIsPresent(input, 14));
    }

    public static boolean findIfSumIsPresent(int[] input, int sumToTest) {
        int i = 0;
        int j = input.length - 1;

        while (i < j) {
            if (input[i] + input[j] < sumToTest) i++;
            else if ((input[i] + input[j] > sumToTest)) j--;
            else return true;
        }
        return false;
    }


}
