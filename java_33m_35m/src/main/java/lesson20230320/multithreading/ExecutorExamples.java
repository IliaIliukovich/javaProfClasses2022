package lesson20230320.multithreading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorExamples {


    static class Task implements Runnable {

        static int i = 1;

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " started task " + i++);
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finished task " + i);
        }
    }


    static class CallableTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName() + " started CallableTask ");
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " finished CallableTask ");
            return "return result of CallableTask";
        }
    }


    public static void main(String[] args) throws Exception {

        // Самописный экзекутер, выполняет каждое задание в отдельном потоке
        Executor executor = new Executor() {
            @Override
            public void execute(Runnable command) {
//                command.run(); // выполнит задания в потоке main
                new Thread(command).start();
            }
        };


        executor.execute(() -> System.out.println(Thread.currentThread().getName() + " executes task1"));
        executor.execute(() -> System.out.println(Thread.currentThread().getName() + " executes task2"));
        executor.execute(() -> System.out.println(Thread.currentThread().getName() + " executes task3"));

        // 1 поток
//        ExecutorService service = Executors.newSingleThreadExecutor();
        // n потоков
//        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() / 2);
        // кеш потоков
        ExecutorService service = Executors.newCachedThreadPool();

        // передача заданий
        service.submit(() -> System.out.println(Thread.currentThread().getName() + " executes special task"));
        Future<?> future = service.submit(new CallableTask());
        System.out.println(future.isDone());
        service.submit(new Task());
        service.submit(new Task());

        // ожидание результата
        System.out.println(future.get());
        System.out.println(future.isDone());

        // передача списка заданий
        List<Future<String>> futureList = service.invokeAll(Arrays.asList(new CallableTask(), new CallableTask(),
                new CallableTask()));


        futureList.forEach(stringFuture -> {
                try {
                    // ожидание результата
                    System.out.println(stringFuture.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });


        service.shutdown();
    }

}
