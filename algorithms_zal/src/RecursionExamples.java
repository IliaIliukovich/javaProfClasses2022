public class RecursionExamples {

    public static void main(String[] args) {

        // 1 + 2 + 3 + 4 + 5 + 6 ...
        System.out.println(sumN(5));
        System.out.println(recursiveSumN(5));

        // 1 * 2 * 3 * 4 * 5 * 6 ...
        System.out.println(factorial(10));

        // Indirect recursion example
        System.out.println(a(1));

        // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ... fibonacci sequence
        // fibonacci(1) 0
        // fibonacci(2) 1
        // fibonacci(3) 1
        // fibonacci(4) 2
        // fibonacci(5) 3

        // Recursive solution
        long time = System.currentTimeMillis();
        System.out.println(fibonacci(40));
        System.out.println("Time spent, ms: " + (System.currentTimeMillis() - time));

        // Recursion with memoization
        time = System.currentTimeMillis();
        System.out.println(fibonacciMemo(40));
        System.out.println("Time spent, ms: " + (System.currentTimeMillis() - time));

        // Tabulation approach
        time = System.currentTimeMillis();
        System.out.println(fibonacciTab(40));
        System.out.println("Time spent, ms: " + (System.currentTimeMillis() - time));

        // Tabulation approach optimized
        time = System.currentTimeMillis();
        System.out.println(fibonacciTabOptimized(40));
        System.out.println("Time spent, ms: " + (System.currentTimeMillis() - time));


        //  Sequence:
        //        a(2n) = a(n) + a(n-1),
        //        a(2n+1) = a(n) — a(n-1),
        //        a(0) = a(1) = 1.
        //
        //        a(0) = 1
        //        a(1) = 1
        //        a(2) = 2
        //        a(3) = 0
        //        ...

        System.out.println(seq(0));
        System.out.println(seq(1));
        System.out.println(seq(2));
        System.out.println(seq(3));
        System.out.println(seq(4));
        System.out.println(seq(5));
        System.out.println(seq(6));
        System.out.println(seq(7));
        System.out.println(seq(8));
    }

    private static int recursiveSumN(int n) {
        if (n == 1) return 1;
        return n + recursiveSumN(n - 1);
    }

    private static int sumN(int n) {
        int count = 0;
        for (int j = 1; j <= n; j++) {
            count = count + j;
        }
        return count;
    }

    private static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    private static int a(int i) {
        return b(i + 1);
    }

    private static int b(int i) {
        if (i > 5) return 5;
        return a(i + 1);
    }

    private static int fibonacci(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static int[] cache = new int[100];
    private static int fibonacciMemo(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (cache[n] == 0) cache[n] = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);
        return cache[n];
    }

    static int[] cacheTab = new int[100];
    static {
        cacheTab[1] = 0;
        cacheTab[2] = 1;
    }

    private static int fibonacciTab(int n) {
        for (int i = 3; i <= n; i++) {
            cacheTab[i] = cacheTab[i - 1] + cacheTab[i - 2];
        }
        return cacheTab[n];
    }

    private static int fibonacciTabOptimized(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        int cache1 = 0;
        int cache2 = 1;
        int cache3 = 1;

        for (int i = 3; i <= n; i++) {
            cache3 = cache1 + cache2;
            cache1 = cache2;
            cache2 = cache3;
        }
        return cache3;
    }

    private static int seq(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n % 2 == 0) {
            return seq(n/2) + seq(n/2 - 1);
        } else {
            return seq(n/2) - seq(n/2 - 1);
        }
    }

}
