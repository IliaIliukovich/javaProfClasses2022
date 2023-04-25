package lesson20230423.intro;

public class RecursiveAlgorithmsExamples {

    public static void main(String[] args) {

        f(5);

        System.out.println("Sum = " + sumNumbersRecursive(5));

        System.out.println("Sum = " + sumNumbersInLoop(5));

        f1(10);

        // fibonacci sequence
        // 0 1 1 2 3 5 8 13 21
        // fibonacci(n)
        // fibonacci(1) = 0
        // fibonacci(2) = 1
        // fibonacci(3) = 1
        // fibonacci(4) = 2
        // fibonacci(5) = 3

        int n = 30;
        System.out.println("fibonacci(" + n + ") = " + fibonacci(n));
    }

    public static void f(int i){
        System.out.println(i++);
        if (i > 10) return; // base condition
        f(i);
    }

    public static int sumNumbersRecursive(int i) {
        if (i == 1) return 1; // base condition
        int result = i + sumNumbersRecursive(i - 1);
        return result;
    }

    public static int sumNumbersInLoop(int n) {
        int sum = 0;
        for (int j = 1; j <= n; j++) {
            sum = sum + j;
        }
        return sum;
    }

    private static void f1(int n) {
        System.out.println(n);
        f2(n);
    }

    private static void f2(int n) {
        n++;
        if (n > 20) return; // base condition
        f1(n);
    }

    public static long fibonacci(long n) {
        if (n == 1) return 0; // base condition
        if (n == 2) return 1; // base condition
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

}
