package lesson20230623;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorsExamples {


    static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " doing task");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class CallableTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName() + " doing task");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Result of working " + Thread.currentThread().getName();
        }
    }

    public static void main(String[] args) {
//        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() / 2);
//        ExecutorService executor = Executors.newCachedThreadPool();

//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        executor.execute(new Task());
//        executor.execute(new Task());
//        executor.execute(new Task());
//
//
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        executor.execute(new Task());
//        executor.execute(new Task());
//        executor.execute(new Task());
//        executor.execute(new Task());
//        executor.execute(new Task());

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<String> future1 = executor.submit(new CallableTask());
        Future<String> future2 = executor.submit(new CallableTask());
        Future<String> future3 = executor.submit(new CallableTask());
        List<Future<String>> futures = Arrays.asList(future1, future2, future3);

        System.out.println("Other logic in main...");

        for (Future<String> f : futures) {
            try {
                System.out.println("Waiting for the result...");
                System.out.println(f.get());
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();

    }



}
