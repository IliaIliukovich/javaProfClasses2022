package lesson20230710;

public class FindIfSumIsPresent {

    public static void main(String[] args) {
        int[] input = new int[] {1, 2, 5, 5, 9, 10};
        System.out.println(findIfSumIsPresent(input, 3));
    }

    public static boolean findIfSumIsPresent(int[] input, int sumToTest) {
        int i = 0;
        int j = input.length - 1;

        while (i < j){
            if (input[i] + input[j] < sumToTest){
                i++;
            } else if ((input[i] + input[j] > sumToTest)) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }


}
