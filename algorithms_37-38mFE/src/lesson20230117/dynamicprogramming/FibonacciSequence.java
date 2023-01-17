package lesson20230117.dynamicprogramming;

public class FibonacciSequence {

    public static void main(String[] args) {

        // Числа Фибоначчи 0 1 1 2 3 5 8 13
        // f(0) = 0
        // f(1) = 1
        // f(2) = 1
        // f(3) = 2

        long start = System.currentTimeMillis();
        System.out.println(fibonacchi(40));
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        System.out.println(fibonacchiMemo(40));
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        System.out.println(fibonacciTab(40));
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        System.out.println(fibonacciTabOptimized(40));
        System.out.println(System.currentTimeMillis() - start);

        // 1. Вычислить n-й член последовательности, заданной формулами:
        // a(2n) = a(n) + a(n-1),
        //a(2n+1) = a(n) — a(n-1),
        //a(0) = a(1) = 1.
        //
        //0 --- 1
        //1 --- 1
        //2 --- 2
        //3 --- 0
        //4 --- 3
        //5 --- 1
        // a(m) = a(m/2) +/- a(m/2 - 1)
        System.out.println(sequence(0));
        System.out.println(sequence(1));
        System.out.println(sequence(2));
        System.out.println(sequence(3));
        System.out.println(sequence(4));
        System.out.println(sequence(5));
        System.out.println(sequence(6));
        System.out.println(sequence(7));
        System.out.println(sequence(8));
        System.out.println(sequence(9));
        System.out.println(sequence(10));






    }

    private static long fibonacchi(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacchi(n - 1) + fibonacchi(n - 2);
    }

    static long[] cache = new long[100];
    static {
        cache[0] = 0;
        cache[1] = 1;
    }
    private static long fibonacchiMemo(int n) {
        if (n < 2) return cache[n];
        if (cache[n] == 0) {
            cache[n] = fibonacchiMemo(n - 1) + fibonacchiMemo(n - 2);
        }
        return cache[n];
    }

    private static long fibonacciTab(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        long[] cache = new long[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }

    private static long fibonacciTabOptimized(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        long cache1 = 0;
        long cache2 = 1;
        long cache3 = 1;

        for (int i = 2; i <= n; i++) {
            cache3 = cache1 + cache2;
            cache1 = cache2;
            cache2 = cache3;
        }
        return cache3;
    }

    private static int sequence(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        int[] cache = new int[n + 1];
        if (cache[n] == 0) {
            if (n % 2 == 0) {
                cache[n] = sequence(n / 2) + sequence(n / 2 - 1);
            } else {
                cache[n] = sequence(n / 2) - sequence(n / 2 - 1);
            }
        }
        return cache[n];
    }













}
