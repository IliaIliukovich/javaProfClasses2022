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

        int n = 10;

        long start = System.nanoTime();
        long result = fibonacci(n);
        long end = System.nanoTime();
        System.out.println("Time: " + (end - start) + " Result: " + result);

        start = System.nanoTime();
        result = fibonacciMemo(n);
        end = System.nanoTime();
        System.out.println("Time: " + (end - start) + " Result Memo: " + result);

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
        long result;
        if (values[current] == 0){
            values[current] = fibonacciMemoRecursion(values, current - 2) + fibonacciMemoRecursion(values,current - 1);
        }
        result = values[current];
        return result;
    }


}
