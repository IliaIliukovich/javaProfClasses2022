package lesson20230609;

public class Primes {

    public static void main(String[] args) throws InterruptedException {

        long start = System.nanoTime();
        countPrimesSequentially();
        long end = System.nanoTime();
        System.out.println("Time: " + (end - start));

        start = System.nanoTime();
        Task task1 = new Task(2, 80_000);
        Task task2 = new Task(80_000, 150_000);
        Task task3 = new Task(150_000, 200_000);
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        int result = task1.result + task2.result + task3.result;
        end = System.nanoTime();
        System.out.println("Total numbers of primes: " + result);
        System.out.println("Time: " + (end - start));
    }

    private static void countPrimesSequentially() {
        int count = 0;

        for (int i = 2; i < 200_000; i++) {
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

    static class Task implements Runnable {
        int start;
        int end;
        int result = 0;

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

                if (isPrime)
                    result++;
            }
            System.out.println(Thread.currentThread().getName() + " result: " + result);
        }
    }


}
