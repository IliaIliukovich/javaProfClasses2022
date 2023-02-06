package lesson20230206.multithreading;


import java.util.concurrent.*;

public class ExecutorExamples {

    static class RunnableTask implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " does something");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class CallableTask implements Callable<String> {
        @Override
        public String call() {
            System.out.println(Thread.currentThread().getName() + " does something and returns value");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "String from callable";
        }
    }

    public static void main(String[] args) {
        // Реализация собственного экзекутера
        Executor executor = new Executor() {
            @Override
            public void execute(Runnable command) {
                new Thread(command).start();
            }
        };

        executor.execute(new RunnableTask());
        executor.execute(new RunnableTask());

        // SingleThreadExecutor
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        executorService1.submit(new RunnableTask());
        executorService1.submit(new RunnableTask());
        executorService1.shutdown();

//        executorService = Executors.newFixedThreadPool(3);
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService2.submit(new RunnableTask());
        executorService2.submit(new RunnableTask());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService2.submit(new RunnableTask());
        executorService2.submit(new RunnableTask());
        executorService2.submit(new RunnableTask());
        executorService2.submit(new RunnableTask());
        executorService2.submit(new RunnableTask());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService2.submit(new RunnableTask());
        executorService2.shutdown();

        // при выходе из блока try executor завершит свою работу
        try (ExecutorService executorService3 = Executors.newSingleThreadExecutor()) {
            Future<String> future = executorService3.submit(new CallableTask());
            executorService3.submit(() -> "Some new callable");
            System.out.println("Some operations in main thread...");
            System.out.println(future.isDone());

            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

            System.out.println(future.isDone());
        }

    }

}
