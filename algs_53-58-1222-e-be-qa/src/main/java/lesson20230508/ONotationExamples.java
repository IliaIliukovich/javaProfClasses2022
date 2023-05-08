package lesson20230508;

public class ONotationExamples {

    // best case - ? worst case - ?

    public static void task1(int n) {
        if (n < 1000) {
            System.out.println("number < 1000");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.println(i + " ");
            }
        }
    }

    public static void task2(int n) {
        for (int i = 0; i <= n / 3; i++){
            for (int j = 1; j <= n; j = j + 4){
                System.out.println("I study Big O notation");
            }
        }
    }

    public static void task3(int n) {
        if (n==1) return;
        for (int i=1; i<=n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.println("*");
                break;
            }
        }
    }

    private static void sortBruteForce(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[i] > ints[j]){
                    int tmp = ints[i];
                    ints[i] = ints[j];
                    ints[j] = tmp;
                }
            }
        }
    }
}