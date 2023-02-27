package lesson20230227.multithreading;

public class CountPrimes {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        countPrimesSequentially();
        System.out.println("Time elapsed: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        countPrimesParallel();
        System.out.println("Time elapsed: " + (System.currentTimeMillis() - start));
    }

    private static void countPrimesParallel() {

        Task task1 = new Task(2, 250_000);
        Task task2 = new Task(250_000, 400_000);
        Task task3 = new Task(400_000, 500_000);
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            System.out.println("Total numbers of primes: " + (task1.count + task2.count + task3.count));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Task implements Runnable {
        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int start;
        int end;
        int count = 0;

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                boolean isPrime = true;

                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) count++;
            }

            System.out.println("Numbers of primes: " + count);
        }
    }


    private static void countPrimesSequentially() {
        int count = 0;

        for (int i = 2; i < 500_000; i++) {
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

        System.out.println("Total numbers of primes: " + count);
    }


}
