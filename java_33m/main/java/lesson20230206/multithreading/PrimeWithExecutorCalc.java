package lesson20230206.multithreading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class PrimeWithExecutorCalc {

    static class Task implements Callable<Integer> {

        int start;
        int end;
        int count = 0;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() {

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
                }
            }
            return count;
        }
    }


    public static void main(String[] args) {
        try (ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() / 2)) {
            long start = System.currentTimeMillis();
            try {
                List<Future<Integer>> futures = service.invokeAll(Arrays.asList(
                        new Task(2, 150_000),
                        new Task(150_000, 250_000),
                        new Task(250_000, 300_000)));
                int totalSum = futures.get(0).get() + futures.get(1).get() + futures.get(2).get();
                System.out.println("Elapsed: " + (System.currentTimeMillis() - start));
                System.out.println(totalSum);

            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

}
