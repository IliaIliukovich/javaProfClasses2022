package lesson20230123.multithreading;

import java.util.Vector;

public class NumberTask2 {

    static Vector<Integer> primes = new Vector<>();

    public static void main(String[] args) {

        // Последовательное решение
//        long start = System.currentTimeMillis();
//        countPrimes();
//        System.out.println("Time elapsed " + (System.currentTimeMillis() - start));

        // Параллельное решение
        long start = System.currentTimeMillis();
        countPrimesParallel();
        System.out.println("Time elapsed " + (System.currentTimeMillis() - start));



    }

    static class Task implements Runnable {

        int start;
        int end;
        int count = 0;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {

            for (int i = start; i < end; i++) {
                boolean isPrime = true;

                for (int j=2; j < i; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    count++;
                    primes.add(i);
                }
            }
            System.out.println("Total numbers of primes for Thread: " + Thread.currentThread().getName() + " " + count);

        }
    }


    private static void countPrimesParallel() {

        Task task1 = new Task(2, 1_000);
        Task task2 = new Task(1_000, 2_000);
        Task task3 = new Task(2_000, 3_000);
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        Thread t3 = new Thread(task3);
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            System.out.println(task1.count + task2.count + task3.count);
            primes.forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void countPrimes() {

        int count = 0;

        for (int i = 2; i < 300_000; i++) {
            boolean isPrime = true;

            for (int j=2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime)
                count++;
        }

        System.out.println("Total numbers of prime: " + count);
    }


}
