package lesson20230112.dynamicprogramming;

public class Fibonacci {

    public static void main(String[] args) {

        // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ... fibonacci sequence
        // fibonacci(1) 0
        // fibonacci(2) 1
        // fibonacci(3) 1
        // fibonacci(4) 2
        // fibonacci(5) 3

        // Recursive solution
        long start = System.currentTimeMillis();
        System.out.println(fibonacciRecursive(45));
        System.out.println("Time spent, ms: " + (System.currentTimeMillis() - start));

        // Recursion with memoization
        start = System.currentTimeMillis();
        System.out.println(fibonacciMemo(45));
        System.out.println("Time spent, ms: " + (System.currentTimeMillis() - start));

        // Tabulation approach
        start = System.currentTimeMillis();
        System.out.println(fibonacciTab(45));
        System.out.println("Time spent, ms: " + (System.currentTimeMillis() - start));

        // Tabulation approach optimized
        start = System.currentTimeMillis();
        System.out.println(fibonacciTabOptimized(45));
        System.out.println("Time spent, ms: " + (System.currentTimeMillis() - start));

        //  Task 1. Вычислить n-й член последовательности, заданной формулами:
        //      a(2n) = a(n) + a(n-1),
        //      a(2n+1) = a(n) — a(n-1),
        //      a(0) = a(1) = 1.
        //
        //      a(0) = 1
        //      a(1) = 1
        //      a(2) = 2
        //      a(3) = 0
        //      ...
        System.out.println("ver1: " + task1(0) + " ver2: " + task1Circle(0));
        System.out.println("ver1: " + task1(1) + " ver2: " + task1Circle(1));
        System.out.println("ver1: " + task1(2) + " ver2: " + task1Circle(2));
        System.out.println("ver1: " + task1(3) + " ver2: " + task1Circle(3));
        System.out.println("ver1: " + task1(4) + " ver2: " + task1Circle(4));
        System.out.println("ver1: " + task1(5) + " ver2: " + task1Circle(5));
        System.out.println("ver1: " + task1(6) + " ver2: " + task1Circle(6));
        System.out.println("ver1: " + task1(7) + " ver2: " + task1Circle(7));
        System.out.println("ver1: " + task1(8) + " ver2: " + task1Circle(8));
        System.out.println("ver1: " + task1(9) + " ver2: " + task1Circle(9));

    }

    static int[] cache = new int[100];
    private static int task1Circle(int n) {
        cache[0] = 1;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                cache[i] = cache[i / 2] + cache[i / 2 - 1];
            } else {
                cache[i] = cache[i / 2] - cache[i / 2 - 1];
            }
        }
        return cache[n];
    }

    private static int task1(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n % 2 == 0) return task1(n/2) + task1(n/2 - 1);
        return task1(n/2) - task1(n/2 - 1);
    }


    private static long fibonacciTabOptimized(int n) {
        long cache1 = 0;
        long cache2 = 1;
        long cache3 = 1;
        if (n == 1) return 0;
        if (n == 2) return 1;
        for (int i = 3; i <= n; i++) {
            cache3 = cache1 + cache2;
            cache1 = cache2;
            cache2 = cache3;
        }
        return cache3;
    }


    static long[] valuesTab = new long[100];
    private static long fibonacciTab(int n) {
        valuesTab[0] = 0;
        valuesTab[1] = 1;
        for (int i = 2; i < n; i++) {
            valuesTab[i] = valuesTab[i - 1] + valuesTab[i - 2];
        }
        return valuesTab[n - 1];
    }

    static long[] values = new long[100];
    private static long fibonacciMemo(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (values[n] != 0) return values[n];
        long nextValue = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);
        values[n] = nextValue;
        return nextValue;

    }

    private static long fibonacciRecursive(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;

        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }


}
