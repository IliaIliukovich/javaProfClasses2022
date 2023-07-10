package lesson20230710;

public class FindIfSumIsPresent {

    public static void main(String[] args) {
        int[] input = new int[] {1, 2, 5, 5, 9, 10};
        System.out.println(findIfSumIsPresent(input, 3));
    }

    private static boolean findIfSumIsPresent(int[] input, int k) {
        int i = 0;
        int j = input.length - 1;

        while (i < j){
            if (input[i] + input[j] < k){
                i++;
            } else if ((input[i] + input[j] > k)) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }


}
