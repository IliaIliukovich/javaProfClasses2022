package lesson20230508;

public class FibonacciSequence {

    public static void main(String[] args) {

        // fibonacci sequence
        // 0 1 1 2 3 5 8 13 21
        // fibonacci(n)
        // fibonacci(0) = 0
        // fibonacci(1) = 1
        // fibonacci(2) = 1
        // fibonacci(3) = 2
        // fibonacci(4) = 3

        int n = 30;

        long start = System.nanoTime();
        long result = fibonacci(n);
        long end = System.nanoTime();
        System.out.println("Time: " + (end - start) + " Result: " + result);

        start = System.nanoTime();
        result = fibonacciMemo(n);
        end = System.nanoTime();
        System.out.println("Time: " + (end - start) + " Result Memo: " + result);

        start = System.nanoTime();
        result = fibonacciTabulation(n);
        end = System.nanoTime();
        System.out.println("Time: " + (end - start) + " Result Tab: " + result);


        // 1. Вычислить n-й член последовательности, заданной формулами:
        //a(2n) = a(n) + a(n-1),
        //a(2n+1) = a(n) — a(n-1),
        //a(0) = a(1) = 1.
        System.out.println(sequence(0));
        System.out.println(sequence(1));
        System.out.println(sequence(2));
        System.out.println(sequence(3));
        System.out.println(sequence(4));
        System.out.println(sequence(5));
        System.out.println(sequence(6));
    }

    public static long fibonacci(long n) {
        if (n == 0) return 0; // base condition
        if (n == 1) return 1; // base condition
        return fibonacci(n - 2) + fibonacci(n - 1);
    }


    public static long fibonacciMemo(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        long[] values = new long[n + 1];
        values[0] = 0;
        values[1] = 1;

        return fibonacciMemoRecursion(values, n);
    }

    private static long fibonacciMemoRecursion(long[] values, int current) {
        if (current == 0) return 0;
        if (current == 1) return 1;
        if (values[current] == 0){
            values[current] = fibonacciMemoRecursion(values, current - 2) + fibonacciMemoRecursion(values,current - 1);
        }
        long result = values[current];
        return result;
    }

    private static long fibonacciTabulation(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;
        long a = 0;
        long b = 1;
        long c = 1;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static int sequence(int n){
        if (n == 0) return 1;
        if (n == 1) return 1;

        if (n % 2 == 0){
            return sequence(n/2) + sequence(n/2 - 1);
        } else {
            return sequence(n/2) - sequence(n/2 - 1);
        }
    }


}
